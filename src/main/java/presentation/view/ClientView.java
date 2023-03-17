package presentation.view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * @Author: Calinescu Mirela
 * @Since: We just don't know...
 */
public class ClientView extends JFrame {

    private JPanel contentPane;
    private JButton addClientButton;
    private JButton updateClientButton;
    private JButton removeClientButton;
    private JButton showClientsButton;
    private JButton backClientsButton;

    public ClientView() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 701, 379);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        addClientButton = new JButton("Add");
        addClientButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
        addClientButton.setBounds(27, 129, 186, 37);
        contentPane.add(addClientButton);

        updateClientButton = new JButton("Update");
        updateClientButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
        updateClientButton.setBounds(243, 129, 186, 37);
        contentPane.add(updateClientButton);

        removeClientButton = new JButton("Remove");
        removeClientButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
        removeClientButton.setBounds(461, 129, 186, 37);
        contentPane.add(removeClientButton);

        showClientsButton = new JButton("Show All");
        showClientsButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
        showClientsButton.setBounds(132, 211, 186, 37);
        contentPane.add(showClientsButton);

        backClientsButton = new JButton("Back");
        backClientsButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
        backClientsButton.setBounds(356, 211, 186, 37);
        contentPane.add(backClientsButton);

        JLabel lblNewLabel = new JLabel("Clients");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(199, 36, 278, 40);
        contentPane.add(lblNewLabel);
    }

    public void addClientButtonActionListener(ActionListener actionListener) {
        this.addClientButton.addActionListener(actionListener);
    }

    public void updateClientButtonActionListener(ActionListener actionListener) {
        this.updateClientButton.addActionListener(actionListener);
    }

    public void removeClientButtonActionListener(ActionListener actionListener) {
        this.removeClientButton.addActionListener(actionListener);
    }

    public void showClientsButtonActionListener(ActionListener actionListener) {
        this.showClientsButton.addActionListener(actionListener);
    }

    public void backClientsButtonActionListener(ActionListener actionListener) {
        this.backClientsButton.addActionListener(actionListener);
    }

}
