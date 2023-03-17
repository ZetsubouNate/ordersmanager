package businessLogic.validators;

import static businessLogic.validators.ProductValidator.quantityValidator;

/**
 * @Author: Calinescu Mirela
 * @Since: We just don't know...
 */
public class OrderValidator {

    /**
     * used to determine if the order data entered by the user is valid before entering it in the database
     *
     * @param productQ the product quantity taken from the database (product is already validated)
     * @param orderQ the order quantity given by the user
     * @return whether there is enough product in stock or not
     */
    public static String orderValidator(int productQ, String orderQ) {
        Integer quantity = quantityValidator(orderQ);
        if(quantity != null) {
            if(productQ == 0)
                return "Out of stock.";
            if(quantity > productQ)
                return "Not enough product in stock.";
            return null;
        }
        else
            return "Wrong input.";
    }
}
