package presentation.view.add_update;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * @Author: Calinescu Mirela
 * @Since: We just don't know...
 */
public class UpdateProductView extends JFrame {

    private JPanel contentPane;
    private JTextField productNameOldField;
    private JTextField quantityOldField;
    private JTextField quantityNewField;
    private JTextField productNameNewField;
    private JTextField priceOldField;
    private JTextField priceNewField;
    private JButton updateProductBackButton;
    private JButton updateProductButton;

    public UpdateProductView() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 959, 451);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Update Product");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(310, 10, 305, 34);
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Replace");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setBounds(169, 94, 183, 34);
        contentPane.add(lblNewLabel_1);

        JLabel lblNewLabel_1_1 = new JLabel("Replace With");
        lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNewLabel_1_1.setBounds(611, 94, 183, 34);
        contentPane.add(lblNewLabel_1_1);

        JLabel lblNewLabel_2 = new JLabel("Name");
        lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel_2.setBounds(39, 153, 134, 28);
        contentPane.add(lblNewLabel_2);

        productNameOldField = new JTextField();
        productNameOldField.setFont(new Font("Tahoma", Font.PLAIN, 13));
        productNameOldField.setBounds(183, 153, 229, 28);
        contentPane.add(productNameOldField);
        productNameOldField.setColumns(10);

        JLabel lblNewLabel_2_1 = new JLabel("Quantity");
        lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel_2_1.setBounds(39, 191, 134, 28);
        contentPane.add(lblNewLabel_2_1);

        quantityOldField = new JTextField();
        quantityOldField.setFont(new Font("Tahoma", Font.PLAIN, 13));
        quantityOldField.setColumns(10);
        quantityOldField.setBounds(183, 191, 229, 28);
        contentPane.add(quantityOldField);

        JLabel lblNewLabel_2_2 = new JLabel("Name");
        lblNewLabel_2_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel_2_2.setBounds(493, 153, 134, 28);
        contentPane.add(lblNewLabel_2_2);

        quantityNewField = new JTextField();
        quantityNewField.setFont(new Font("Tahoma", Font.PLAIN, 13));
        quantityNewField.setColumns(10);
        quantityNewField.setBounds(637, 191, 229, 28);
        contentPane.add(quantityNewField);

        JLabel lblNewLabel_2_1_1 = new JLabel("Quantity");
        lblNewLabel_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel_2_1_1.setBounds(493, 191, 134, 28);
        contentPane.add(lblNewLabel_2_1_1);

        productNameNewField = new JTextField();
        productNameNewField.setFont(new Font("Tahoma", Font.PLAIN, 13));
        productNameNewField.setColumns(10);
        productNameNewField.setBounds(637, 153, 229, 28);
        contentPane.add(productNameNewField);

        updateProductBackButton = new JButton("Back");
        updateProductBackButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
        updateProductBackButton.setBounds(736, 336, 151, 41);
        contentPane.add(updateProductBackButton);

        updateProductButton = new JButton("Update");
        updateProductButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
        updateProductButton.setBounds(340, 329, 254, 48);
        contentPane.add(updateProductButton);

        JLabel lblNewLabel_2_1_2 = new JLabel("Price");
        lblNewLabel_2_1_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel_2_1_2.setBounds(39, 229, 134, 28);
        contentPane.add(lblNewLabel_2_1_2);

        priceOldField = new JTextField();
        priceOldField.setFont(new Font("Tahoma", Font.PLAIN, 13));
        priceOldField.setColumns(10);
        priceOldField.setBounds(183, 229, 229, 28);
        contentPane.add(priceOldField);

        JLabel lblNewLabel_2_1_1_1 = new JLabel("Price");
        lblNewLabel_2_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel_2_1_1_1.setBounds(493, 229, 134, 28);
        contentPane.add(lblNewLabel_2_1_1_1);

        priceNewField = new JTextField();
        priceNewField.setFont(new Font("Tahoma", Font.PLAIN, 13));
        priceNewField.setColumns(10);
        priceNewField.setBounds(637, 229, 229, 28);
        contentPane.add(priceNewField);
    }

    public String productNameOldField() {
        return productNameOldField.getText();
    }

    public String quantityOldField() {
        return quantityOldField.getText();
    }

    public String quantityNewField() {
        return quantityNewField.getText();
    }

    public String productNameNewField() {
        return productNameNewField.getText();
    }

    public String priceOldField() {
        return priceOldField.getText();
    }

    public String priceNewField() {
        return priceNewField.getText();
    }

    public void updateProductBackButtonActionListener(ActionListener actionListener) {
        this.updateProductBackButton.addActionListener(actionListener);
    }

    public void updateProductButtonActionListener(ActionListener actionListener) {
        this.updateProductButton.addActionListener(actionListener);
    }

    public void showResult(String result) {
        JOptionPane.showMessageDialog(this, result, "Result", JOptionPane.INFORMATION_MESSAGE);
    }
}

