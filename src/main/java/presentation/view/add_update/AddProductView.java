package presentation.view.add_update;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * @Author: Calinescu Mirela
 * @Since: We just don't know...
 */
public class AddProductView extends JFrame {

    private JPanel contentPane;
    private JTextField productNameField;
    private JTextField quantityField;
    private JTextField priceField;
    private JButton addProductBackButton;
    private JButton addProductButton;

    public AddProductView() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 658, 513);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Add Product");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel.setBounds(238, 10, 157, 33);
        contentPane.add(lblNewLabel);

        addProductBackButton = new JButton("Back");
        addProductBackButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
        addProductBackButton.setBounds(488, 412, 121, 33);
        contentPane.add(addProductBackButton);

        addProductButton = new JButton("Add");
        addProductButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
        addProductButton.setBounds(216, 405, 200, 50);
        contentPane.add(addProductButton);

        JLabel lblNewLabel_1 = new JLabel("Product Name");
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel_1.setBounds(57, 116, 121, 27);
        contentPane.add(lblNewLabel_1);

        productNameField = new JTextField();
        productNameField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        productNameField.setBounds(212, 116, 282, 27);
        contentPane.add(productNameField);
        productNameField.setColumns(10);

        quantityField = new JTextField();
        quantityField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        quantityField.setColumns(10);
        quantityField.setBounds(212, 180, 282, 27);
        contentPane.add(quantityField);

        JLabel lblNewLabel_1_1 = new JLabel("Quantity");
        lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel_1_1.setBounds(57, 180, 121, 27);
        contentPane.add(lblNewLabel_1_1);

        priceField = new JTextField();
        priceField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        priceField.setColumns(10);
        priceField.setBounds(212, 249, 282, 27);
        contentPane.add(priceField);

        JLabel lblNewLabel_1_2 = new JLabel("Price");
        lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel_1_2.setBounds(57, 249, 121, 27);
        contentPane.add(lblNewLabel_1_2);
    }

    public String productNameField() {
        return productNameField.getText();
    }

    public String quantityField() {
        return quantityField.getText();
    }

    public String priceField() {
        return priceField.getText();
    }

    public void addProductBackButtonActionListener(ActionListener actionListener) {
        this.addProductBackButton.addActionListener(actionListener);
    }

    public void addProductButtonActionListener(ActionListener actionListener) {
        this.addProductButton.addActionListener(actionListener);
    }

    public void showResult(String result) {
        JOptionPane.showMessageDialog(this, result, "Result", JOptionPane.INFORMATION_MESSAGE);
    }
}
