package businessLogic;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import dao.ClientDAO;
import dao.OrderDAO;
import model.Orders;
import model.Product;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

import static businessLogic.validators.ClientValidator.idValidator;
import static businessLogic.validators.OrderValidator.orderValidator;
import static businessLogic.validators.ProductValidator.quantityValidator;

/**
 * @Author: Calinescu Mirela
 * @Since: We just don't know...
 */
public class OrderBLL {

    private OrderDAO orderDAO;

    public OrderBLL() {
        this.orderDAO = new OrderDAO();
    }

    /**
     * displays all table entries in the GUI
     *
     * @return returns the list of orders
     */
    public List<Orders> display() {
        return orderDAO.findAll();
    }

    /**
     * verifies if data is valid and tries to insert it
     *
     * @param clientName client name
     * @param productName product name
     * @param quantity product quantity
     * @return returns a message for the user in the GUI
     */
    public String insert(String clientName, String productName, String quantity) {
        ProductBLL productBLL = new ProductBLL();
        Product p = productBLL.findByName(productName);
        ClientDAO clientDAO = new ClientDAO();
        if(clientDAO.findAll().stream().filter(client -> client.getName().equals(clientName)).count() == 0)
            return "Insert existing client.";
        if(orderValidator(p.getQuantity(), quantity) == null) {
            if(orderDAO.insert(new Orders(clientName, productName, Integer.parseInt(quantity))) == null) {
                productBLL.update(p.getProduct_name(), p.getProduct_name(), Integer.toString(p.getQuantity()), Integer.toString(p.getQuantity() - quantityValidator(quantity)), Double.toString(p.getPrice()), Double.toString(p.getPrice()));
                return "Order inserted.";
            }
        }
        return orderValidator(p.getQuantity(), quantity);
    }

    /**
     * verifies if data is valid and tries to delete it
     *
     * @param id order id
     * @return returns a message for the user in the GUI
     */
    public String deleteById(String id) {
        if(idValidator(id) == null)
            return "Wrong input.";
        if(orderDAO.findAll().stream().filter(orders -> orders.getId() == Integer.parseInt(id)).count() > 0)
        {
            Orders o = orderDAO.findById(Integer.parseInt(id));
            ProductBLL productBLL = new ProductBLL();
            Product p = productBLL.findByName(o.getProduct());
            if (orderDAO.deleteByID(id) == null) {
                productBLL.update(p.getProduct_name(), p.getProduct_name(), Integer.toString(p.getQuantity()), Integer.toString(p.getQuantity() + o.getQuantity()), Double.toString(p.getPrice()), Double.toString(p.getPrice()));
                return "Order deleted.";
            }
        }
        return "Order not found.";
    }

    /**
     * creates the PDF bill of an order
     *
     * @param orders target order for which we make the bill
     */
    public void createBill(Orders orders) throws FileNotFoundException, DocumentException {
        ProductBLL productBLL = new ProductBLL();
        Product p = productBLL.findByName(orders.getProduct());
        double totalPrice = orders.getQuantity() * p.getPrice();
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(orders.getClient() + "_" + orders.getProduct() + "_Bill.pdf"));
        document.open();
        Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);
        Chunk orderContent = new Chunk(" Client name: " + orders.getClient() + "\n Product name: " + orders.getProduct() + "\n Quantity: " + orders.getQuantity() + "\n Total price: " + totalPrice, font);
        Paragraph content = new Paragraph(orderContent);
        document.add(content);
        document.close();
    }
}
