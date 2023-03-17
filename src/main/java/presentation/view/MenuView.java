package presentation.view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @Author: Calinescu Mirela
 * @Since: We just don't know...
 */
public class MenuView extends JFrame {

    private JPanel contentPane;
    private JButton clientButton;
    private JButton productButton;
    private JButton orderButton;

    public MenuView() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 607, 227);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Order Management");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
        lblNewLabel.setBounds(10, 10, 573, 44);
        contentPane.add(lblNewLabel);

        clientButton = new JButton("Clients");
        clientButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
        clientButton.setBounds(29, 94, 163, 40);
        contentPane.add(clientButton);

        productButton = new JButton("Products");
        productButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
        productButton.setBounds(214, 94, 163, 40);
        contentPane.add(productButton);

        orderButton = new JButton("Orders");
        orderButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
        orderButton.setBounds(402, 94, 163, 40);
        contentPane.add(orderButton);
    }

    public void clientButtonActionListener(ActionListener actionListener) {
        this.clientButton.addActionListener(actionListener);
    }

    public void orderButtonActionListener(ActionListener actionListener) {
        this.orderButton.addActionListener(actionListener);
    }

    public void productButtonActionListener(ActionListener actionListener) {
        this.productButton.addActionListener(actionListener);
    }
}
