package businessLogic.validators;

/**
 * @Author: Calinescu Mirela
 * @Since: We just don't know...
 */
public class ProductValidator {

    /**
     * used to determine if the name entered by the user has the length [2, 45]
     *
     * @param name the product name given by the user
     * @return the name given by the user if it's valid or null if it's not
     */
    public static String productNameValidator(String name) {
        if(name.length() >= 2 && name.length() <= 50) {
            return name;
        }
        return null;
    }

    /**
     * used to determine if the quantity entered by the user is of type int
     *
     * @param quantity the product quantity given by the user
     * @return the integer given by the user if it's valid or null if it's not
     */
    public static Integer quantityValidator(String quantity) {
        try {
            int n = Integer.parseInt(quantity);
            if(n < 0)
                return null;
            return n;
        } catch (NumberFormatException e) {
            return null;
        }
    }

    /**
     * used to determine if the price entered by the user is of type Double
     *
     * @param price the product price given by the user
     * @return the double given by the user if it's valid or null if it's not
     */
    public static Double priceValidator(String price) {
        try {
            Double n = Double.parseDouble(price);
            if(n < 0)
                return null;
            return n;
        } catch (NumberFormatException e) {
            return null;
        }
    }

    /**
     * used to determine if the product data entered by the user is valid before entering it in the database
     *
     * @param name the product name given by the user
     * @param quantity the product quantity given by the user
     * @param price the product price given by the user
     * @return whether the data is valid or not
     */
    public static boolean productValidator(String name, String quantity, String price) {
        if(productNameValidator(name) != null && quantityValidator(quantity) != null && priceValidator(price) != null)
            return true;
        return false;
    }
}
