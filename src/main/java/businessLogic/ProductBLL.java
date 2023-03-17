package businessLogic;

import dao.ProductDAO;
import model.Product;

import java.util.List;

import static businessLogic.validators.ClientValidator.idValidator;
import static businessLogic.validators.ProductValidator.*;

/**
 * @Author: Calinescu Mirela
 * @Since: We just don't know...
 */
public class ProductBLL {

    private ProductDAO productDAO;

    public ProductBLL() {
        this.productDAO = new ProductDAO();
    }

    /**
     * displays all table entries in the GUI
     *
     * @return returns the list of products
     */
    public List<Product> display() {
        return productDAO.findAll();
    }

    /**
     * verifies if data is valid and tries to insert it
     *
     * @param productName product name
     * @param quantity product quantity
     * @param price product price
     * @return returns a message for the user in the GUI
     */
    public String insert(String productName, String quantity, String price) {
        if(productValidator(productName, quantity, price)) {
            if(productDAO.findAll().stream().filter(product -> product.getProduct_name().equals(productName)).count() == 0) {
                if (productDAO.insert(new Product(productName, Integer.parseInt(quantity), Double.parseDouble(price))) == null)
                    return "Product inserted.";
            }
            return "Product already existing. Try updating it instead.";
        }
        return "Wrong input.";
    }

    /**
     * verifies if data is valid and tries to delete it
     *
     * @param name product name
     * @return returns a message for the user in the GUI
     */
    public String deleteByName(String name) {
        if(productNameValidator(name) == null)
            return "Wrong input.";
        if(productDAO.findAll().stream().filter(product -> product.getProduct_name().equals(name)).count() > 0) {
            if (productDAO.deleteByName("product_name", name) == null)
                return "Product deleted.";
        }
        return "Product not found.";
    }

    /**
     * verifies if data is valid and tries to delete it
     *
     * @param id client id
     * @return returns a message for the user in the GUI
     */
    public String deleteById(String id) {
        if(idValidator(id) == null)
            return "Wrong input.";
        if(productDAO.findAll().stream().filter(product -> product.getId() == Integer.parseInt(id)).count() > 0) {
            if (productDAO.deleteByID(id) == null)
                return "Product deleted.";
        }
        return "Product not found.";
    }

    /**
     * verifies if data is valid and tries to update it
     *
     * @param name1 name to update
     * @param name2 updated name
     * @param q1 quantity to update
     * @param q2 updated quantity
     * @param p1 price to update
     * @param p2 updated price
     * @return returns a message for the user in the GUI
     */
    public String update(String name1, String name2, String q1, String q2, String p1, String p2) {
        if(productValidator(name1, q1, p1) && productValidator(name2, q2, p2)) {
            if(productDAO.findAll().stream().filter(product -> product.getProduct_name().equals(name1)).count() > 0) {
                Product product1 = new Product(name1, Integer.parseInt(q1), Double.parseDouble(p1));
                Product product2 = new Product(name2, Integer.parseInt(q2), Double.parseDouble(p2));
                if (productDAO.update(product1, product2, "id, product_name, quantity, price") == null)
                    return "Product updated.";
            }
            return "Product not found.";
        }
        return "Wrong input.";
    }

    public Product findByName(String name) {
        return productDAO.findByCategory(name, "product_name");
    }
}
