package presentation.view.add_update;

import model.Product;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * @Author: Calinescu Mirela
 * @Since: We just don't know...
 */
public class AddOrderView extends JFrame {
    private JPanel contentPane;
    private JTextField orderClientField;
    private JTextField orderQuantityField;
    private JComboBox productComboBox;
    private JButton addOrderBackButton;
    private JButton addOrderButton;

    public AddOrderView(List<Product> products) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 613, 532);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Add Orders");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel.setBounds(225, 10, 170, 30);
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Client");
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNewLabel_1.setBounds(36, 100, 124, 30);
        contentPane.add(lblNewLabel_1);

        orderClientField = new JTextField();
        orderClientField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        orderClientField.setBounds(201, 100, 282, 30);
        contentPane.add(orderClientField);
        orderClientField.setColumns(10);

        JLabel lblNewLabel_1_1 = new JLabel("Product");
        lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNewLabel_1_1.setBounds(36, 186, 124, 30);
        contentPane.add(lblNewLabel_1_1);

        productComboBox = new JComboBox();
        productComboBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
        productComboBox.setBounds(201, 186, 282, 30);
        contentPane.add(productComboBox);
        for(int i = 0; i < products.size(); i++)
            productComboBox.addItem(products.get(i).getProduct_name());

        JLabel lblNewLabel_1_1_1 = new JLabel("Quantity");
        lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNewLabel_1_1_1.setBounds(36, 274, 124, 30);
        contentPane.add(lblNewLabel_1_1_1);

        orderQuantityField = new JTextField();
        orderQuantityField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        orderQuantityField.setColumns(10);
        orderQuantityField.setBounds(201, 274, 282, 30);
        contentPane.add(orderQuantityField);

        addOrderBackButton = new JButton("Back");
        addOrderBackButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
        addOrderBackButton.setBounds(451, 435, 124, 30);
        contentPane.add(addOrderBackButton);

        addOrderButton = new JButton("Add");
        addOrderButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
        addOrderButton.setBounds(225, 421, 194, 44);
        contentPane.add(addOrderButton);
    }

    public String orderClientField() {
        return orderClientField.getText();
    }

    public String orderQuantityField() {
        return orderQuantityField.getText();
    }

    public void addOrderBackButtonActionListener(ActionListener actionListener) {
        this.addOrderBackButton.addActionListener(actionListener);
    }

    public void addOrderButtonActionListener(ActionListener actionListener) {
        this.addOrderButton.addActionListener(actionListener);
    }

    public void showResult(String result) {
        JOptionPane.showMessageDialog(this, result, "Result", JOptionPane.INFORMATION_MESSAGE);
    }

    public String getProductComboBox() {
        return (String) productComboBox.getSelectedItem();
    }
}
