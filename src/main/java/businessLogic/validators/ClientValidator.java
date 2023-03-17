package businessLogic.validators;

/**
 * @Author: Calinescu Mirela
 * @Since: We just don't know...
 */
public class ClientValidator {

    /**
     * used to determine if the name entered by the user has the length [2, 45]
     *
     * @param name the client name given by the user
     * @return the name given by the user if it's valid or null if it's not
     */
    public static String clientNameValidator(String name) {
        if(name.length() >= 2 && name.length() <= 45)
            return name;
        return null;
    }

    /**
     * used to determine if the id entered by the user is an integer (will also be used for product and order)
     *
     * @param id the client id given by the user
     * @return the String given by the user if it's valid or null if it's not
     */
    public static Integer idValidator(String id) {
        try {
            int n = Integer.parseInt(id);
            return n;
        } catch (NumberFormatException e) {
            return null;
        }
    }

    /**
     * used to determine if the password entered by the user has the length [2, 100]
     *
     * @param password the client password given by the user
     * @return the password given by the user if it's valid or null if it's not
     */
    public static String passValidator(String password) {
        if(password.length() >= 2 && password.length() <= 20)
            return password;
        return null;
    }

    /**
     * used to determine if the client data entered by the user is valid before entering it in the database
     *
     * @param name the client name given by the user
     * @param password the client password given by the user
     * @return whether the data is valid or not
     */
    public static boolean clientValidator(String name, String password) {
        if(clientNameValidator(name) != null && passValidator(password) != null)
            return true;
        return false;
    }
}
