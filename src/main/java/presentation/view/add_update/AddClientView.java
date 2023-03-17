package presentation.view.add_update;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * @Author: Calinescu Mirela
 * @Since: We just don't know...
 */
public class AddClientView extends JFrame {
    private JPanel contentPane;
    private JTextField clientNameField;
    private JTextField passwordField;
    private JButton addClientBackButton;
    private JButton addClientButton;

    public AddClientView() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 638, 336);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Add Client");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(220, 16, 209, 40);
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Name");
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel_1.setBounds(32, 94, 98, 26);
        contentPane.add(lblNewLabel_1);

        JLabel lblNewLabel_1_1 = new JLabel("Password");
        lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel_1_1.setBounds(31, 153, 98, 26);
        contentPane.add(lblNewLabel_1_1);

        addClientBackButton = new JButton("Back");
        addClientBackButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
        addClientBackButton.setBounds(475, 233, 118, 31);
        contentPane.add(addClientBackButton);

        addClientButton = new JButton("Add");
        addClientButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
        addClientButton.setBounds(62, 229, 168, 40);
        contentPane.add(addClientButton);

        clientNameField = new JTextField();
        clientNameField.setFont(new Font("Tahoma", Font.PLAIN, 13));
        clientNameField.setBounds(180, 93, 303, 26);
        contentPane.add(clientNameField);
        clientNameField.setColumns(10);

        passwordField = new JTextField();
        passwordField.setFont(new Font("Tahoma", Font.PLAIN, 13));
        passwordField.setColumns(10);
        passwordField.setBounds(180, 153, 303, 26);
        contentPane.add(passwordField);
    }

    public void addClientBackButtonActionListener(ActionListener actionListener) {
        this.addClientBackButton.addActionListener(actionListener);
    }

    public void addClientButtonActionListener(ActionListener actionListener) {
        this.addClientButton.addActionListener(actionListener);
    }

    public String clientNameField() {
        return this.clientNameField.getText();
    }

    public String passwordField() {
        return this.passwordField.getText();
    }

    public void showResult(String result) {
        JOptionPane.showMessageDialog(this, result, "Result", JOptionPane.INFORMATION_MESSAGE);
    }
}
