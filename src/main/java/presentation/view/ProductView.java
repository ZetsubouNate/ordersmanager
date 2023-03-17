package presentation.view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * @Author: Calinescu Mirela
 * @Since: We just don't know...
 */
public class ProductView extends JFrame{
    private JPanel contentPane;
    private JButton addProductButton;
    private JButton updateProductButton;
    private JButton removeProductButton;
    private JButton showProductButton;
    private JButton backProductButton;

    public ProductView() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 701, 379);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        addProductButton = new JButton("Add");
        addProductButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
        addProductButton.setBounds(27, 129, 186, 37);
        contentPane.add(addProductButton);

        updateProductButton = new JButton("Update");
        updateProductButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
        updateProductButton.setBounds(243, 129, 186, 37);
        contentPane.add(updateProductButton);

        removeProductButton = new JButton("Remove");
        removeProductButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
        removeProductButton.setBounds(461, 129, 186, 37);
        contentPane.add(removeProductButton);

        showProductButton = new JButton("Show All");
        showProductButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
        showProductButton.setBounds(132, 211, 186, 37);
        contentPane.add(showProductButton);

        backProductButton = new JButton("Back");
        backProductButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
        backProductButton.setBounds(356, 211, 186, 37);
        contentPane.add(backProductButton);

        JLabel lblNewLabel = new JLabel("Products");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(199, 36, 278, 40);
        contentPane.add(lblNewLabel);
    }

    public void addProductButtonActionListener(ActionListener actionListener) {
        this.addProductButton.addActionListener(actionListener);
    }

    public void updateProductButtonActionListener(ActionListener actionListener) {
        this.updateProductButton.addActionListener(actionListener);
    }

    public void removeProductButtonActionListener(ActionListener actionListener) {
        this.removeProductButton.addActionListener(actionListener);
    }

    public void showProductButtonActionListener(ActionListener actionListener) {
        this.showProductButton.addActionListener(actionListener);
    }

    public void backProductButtonActionListener(ActionListener actionListener) {
        this.backProductButton.addActionListener(actionListener);
    }
}

