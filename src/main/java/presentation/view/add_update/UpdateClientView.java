package presentation.view.add_update;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * @Author: Calinescu Mirela
 * @Since: We just don't know...
 */
public class UpdateClientView extends JFrame {

    private JPanel contentPane;
    private JTextField nameOldField;
    private JTextField passwordOldField;
    private JTextField passwordNewField;
    private JTextField nameNewField;
    private JButton updateClientBackButton;
    private JButton updateClientButton;

    public UpdateClientView() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 959, 451);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Update Client");
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

        nameOldField = new JTextField();
        nameOldField.setFont(new Font("Tahoma", Font.PLAIN, 13));
        nameOldField.setBounds(183, 153, 229, 28);
        contentPane.add(nameOldField);
        nameOldField.setColumns(10);

        JLabel lblNewLabel_2_1 = new JLabel("Password");
        lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel_2_1.setBounds(39, 227, 134, 28);
        contentPane.add(lblNewLabel_2_1);

        passwordOldField = new JTextField();
        passwordOldField.setFont(new Font("Tahoma", Font.PLAIN, 13));
        passwordOldField.setColumns(10);
        passwordOldField.setBounds(183, 227, 229, 28);
        contentPane.add(passwordOldField);

        JLabel lblNewLabel_2_2 = new JLabel("Name");
        lblNewLabel_2_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel_2_2.setBounds(493, 153, 134, 28);
        contentPane.add(lblNewLabel_2_2);

        passwordNewField = new JTextField();
        passwordNewField.setFont(new Font("Tahoma", Font.PLAIN, 13));
        passwordNewField.setColumns(10);
        passwordNewField.setBounds(637, 227, 229, 28);
        contentPane.add(passwordNewField);

        JLabel lblNewLabel_2_1_1 = new JLabel("Password");
        lblNewLabel_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel_2_1_1.setBounds(493, 227, 134, 28);
        contentPane.add(lblNewLabel_2_1_1);

        nameNewField = new JTextField();
        nameNewField.setFont(new Font("Tahoma", Font.PLAIN, 13));
        nameNewField.setColumns(10);
        nameNewField.setBounds(637, 153, 229, 28);
        contentPane.add(nameNewField);

        updateClientBackButton = new JButton("Back");
        updateClientBackButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
        updateClientBackButton.setBounds(736, 336, 151, 41);
        contentPane.add(updateClientBackButton);

        updateClientButton = new JButton("Update");
        updateClientButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
        updateClientButton.setBounds(340, 329, 254, 48);
        contentPane.add(updateClientButton);
    }

    public String oldNameField() {
        return nameOldField.getText();
    }

    public String newNameField() {
        return nameNewField.getText();
    }

    public String oldPasswordField() {
       return passwordOldField.getText();
    }

    public String newPasswordField() {
        return passwordNewField.getText();
    }

    public void updateClientBackButtonActionListener(ActionListener actionListener) {
        this.updateClientBackButton.addActionListener(actionListener);
    }

    public void updateClientButtonActionListener(ActionListener actionListener) {
        this.updateClientButton.addActionListener(actionListener);
    }

    public void showResult(String result) {
        JOptionPane.showMessageDialog(this, result, "Result", JOptionPane.INFORMATION_MESSAGE);
    }
}

