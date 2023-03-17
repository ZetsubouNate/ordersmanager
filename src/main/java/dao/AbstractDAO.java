package dao;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import connection.ConnectionFactory;

/**
 * @Author: Calinescu Mirela
 * @Since: We just don't know...
 */

public class AbstractDAO<T> {
    protected static final Logger LOGGER = Logger.getLogger(AbstractDAO.class.getName());

    private final Class<T> type;

    @SuppressWarnings("unchecked")
    public AbstractDAO() {
        this.type = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    /**
     * used to retrieve a sql query used for selecting the content of the table
     *
     * @param field a column from the table
     * @param cond  a condition
     * @return returns a String containing the query
     */
    private String createSelectQuery(String field, String cond) {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT ");
        sb.append(" * ");
        sb.append(" FROM ");
        sb.append(type.getSimpleName());
        sb.append(" WHERE " + field + " = " + cond);
        return sb.toString();
    }

    /**
     * used to retrieve a sql query used for selecting ALL the content of the table
     *
     * @return returns a String containing the query
     */

    private String createFindAllQuery() {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT ");
        sb.append("*");
        sb.append(" FROM ");
        sb.append(type.getSimpleName());
        return sb.toString();
    }

    /**
     * executes a select * query on the T table
     *
     * @return the result of the query
     */
    public List<T> findAll() {

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query = createFindAllQuery();
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();
            return createObjects(resultSet);
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:findAll " + e.getMessage());
        } finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return null;
    }

    /**
     * executes a find by id query on the T table
     *
     * @param id the id which we should find
     * @return the result of the query
     */
    public T findById(int id) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query = createSelectQuery("id", Integer.toString(id));
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();

            return createObjects(resultSet).get(0);
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:findByID " + e.getMessage());
        } finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return null;
    }

    /**
     * executes a find by category query on the T table
     *
     * @param name the name which we should find
     * @param category the column name
     * @return the result of the query
     */
    public T findByCategory(String name, String category) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query = createSelectQuery(category,"'" + name + "'");
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();

            return createObjects(resultSet).get(0);
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:findByCategory " + e.getMessage());
        } finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return null;
    }

    private List<T> createObjects(ResultSet resultSet) {
        List<T> list = new ArrayList<T>();
        Constructor[] ctors = type.getDeclaredConstructors();
        Constructor ctor = null;
        for (int i = 0; i < ctors.length; i++) {
            ctor = ctors[i];
            if (ctor.getGenericParameterTypes().length == 0)
                break;
        }
        try {
            while (resultSet.next()) {
                ctor.setAccessible(true);
                T instance = (T)ctor.newInstance();
                for (Field field : type.getDeclaredFields()) {
                    String fieldName = field.getName();
                    Object value = resultSet.getObject(fieldName);
                    PropertyDescriptor propertyDescriptor = new PropertyDescriptor(fieldName, type);
                    Method method = propertyDescriptor.getWriteMethod();
                    method.invoke(instance, value);
                }
                list.add(instance);
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IntrospectionException e) {
            e.printStackTrace();
        }
        return list;

    }

    /**
     * used to retrieve a sql query used for inserting content in the table
     *
     * @param obj object to add in table
     * @return returns a String containing the query
     */
    private String createInsertQuery(T obj) {
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT ");
        sb.append("INTO ");
        sb.append(type.getSimpleName());
        sb.append(" VALUES (");
        sb.append(obj.toString());
        sb.append(")");
        return sb.toString();
    }

    /**
     * executes an insert query on the T table
     * @param t the object we insert in the T table
     * @return the result of the query
     */
    public T insert(T t) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query = createInsertQuery(t);
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:insert " + e.getMessage());
            return t;
        } finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return null;
    }

    /**
     * used to retrieve a sql query used for updating content in the table
     *
     * @param obj1 update
     * @param obj2 updated object
     * @param category the names of columns of the table
     * @return returns a String containing the query
     */
    private String createUpdateQuery(T obj1, T obj2, String category) {
        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE ");
        sb.append(type.getSimpleName());
        sb.append(" SET ");
        String[] columns = category.split(", ");
        String[] old = obj2.toString().split(", ");
        String[] updates = obj1.toString().split(", ");
        for(int i = 1; i <= columns.length - 1; i++) {
            sb.append(columns[i] + " = " + old[i]);
            if(i != columns.length - 1)
                sb.append(", ");
        }
        sb.append(" WHERE ");
        for(int i = 1; i <= columns.length - 1; i++) {
            sb.append(columns[i] + " = " + updates[i]);
            if(i != columns.length - 1)
                sb.append(" and ");
        }
        return sb.toString();
    }

    /**
     * executes an update query on the T table
     * @param t1 updated object
     * @param t2 update
     * @return the result of the query
     */
    public T update(T t1, T t2, String category) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query = createUpdateQuery(t1, t2, category);
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:update " + e.getMessage());
            return t1;
        } finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return null;
    }

    /**
     * used to retrieve a sql query used for deleting content in the table
     *
     * @param delete conditions to delete
     * @return returns a String containing the query
     */
    private String createDeleteQuery(String delete) {
        StringBuilder sb = new StringBuilder();
        sb.append("DELETE ");
        sb.append("FROM ");
        sb.append(type.getSimpleName());
        sb.append(" WHERE ");
        sb.append(delete);
        return sb.toString();
    }

    /**
     * executes a delete query on the T table
     * @param category for example, name or product_name
     * @param name criteria for deletion
     * @return the result of the query
     */
    public String deleteByName(String category, String name) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query = createDeleteQuery(category + " = '" + name + "'");
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:delete " + e.getMessage());
            return "Bad find.";
        } finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return null;
    }

    /**
     * executes a delete query on the T table, only this one uses directly the id
     * @param id self-explanatory
     * @return the result of the query
     */
    public String deleteByID(String id) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query = createDeleteQuery("id = " + id);
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:delete " + e.getMessage());
            return "Bad find.";
        } finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return null;
    }

    /**
     * creates the column names for the tables
     * @param obj object to get class of
     * @return the properties of class as an ArrayList
     */
    public static ArrayList<String> getColumns(Object obj) {
        ArrayList<String> columns = new ArrayList<>();
        for (Field f : obj.getClass().getDeclaredFields()) {
            f.setAccessible(true);
            columns.add(f.getName());
        }
        return columns;
    }
}
