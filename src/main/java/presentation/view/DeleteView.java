package presentation.view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * @Author: Calinescu Mirela
 * @Since: We just don't know...
 */
public class DeleteView extends JFrame{

    private JPanel contentPane;
    private JTextField deleteIdField;
    private JTextField deleteNameField;
    private JLabel deleteLabel;
    private JButton deleteBackButton;
    private JButton deleteButton;
    private JLabel lblNewLabel_1;

    public DeleteView() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 526, 404);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        deleteLabel = new JLabel("Delete");
        deleteLabel.setHorizontalAlignment(SwingConstants.CENTER);
        deleteLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
        deleteLabel.setBounds(195, 10, 120, 28);
        contentPane.add(deleteLabel);

        deleteBackButton = new JButton("Back");
        deleteBackButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
        deleteBackButton.setBounds(388, 321, 114, 28);
        contentPane.add(deleteBackButton);

        deleteButton = new JButton("Delete");
        deleteButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
        deleteButton.setBounds(164, 306, 191, 43);
        contentPane.add(deleteButton);

        JLabel lblNewLabel = new JLabel("ID");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblNewLabel.setBounds(37, 99, 105, 28);
        contentPane.add(lblNewLabel);

        lblNewLabel_1 = new JLabel("Name");
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNewLabel_1.setBounds(37, 187, 105, 28);
        contentPane.add(lblNewLabel_1);

        deleteIdField = new JTextField();
        deleteIdField.setFont(new Font("Tahoma", Font.PLAIN, 17));
        deleteIdField.setBounds(164, 99, 202, 28);
        contentPane.add(deleteIdField);
        deleteIdField.setColumns(10);

        deleteNameField = new JTextField();
        deleteNameField.setFont(new Font("Tahoma", Font.PLAIN, 17));
        deleteNameField.setColumns(10);
        deleteNameField.setBounds(164, 187, 202, 28);
        contentPane.add(deleteNameField);
    }

    public String deleteIdField() {
        return deleteIdField.getText();
    }

    public String deleteNameField() {
        return deleteNameField.getText();
    }

    public void deleteBackButtonActionListener(ActionListener actionListener) {
        this.deleteBackButton.addActionListener(actionListener);
    }

    public void deleteButtonActionListener(ActionListener actionListener) {
        this.deleteButton.addActionListener(actionListener);
    }

    public void setVisiblelblNewLabel_1(boolean ok) {
        lblNewLabel_1.setVisible(ok);
    }

    public void setVisibleDeleteNameField(boolean ok) {
        deleteNameField.setVisible(ok);
    }

    public void setDeleteLabel(String title) {
        deleteLabel.setText(title);
    }

    public void showResult(String result) {
        JOptionPane.showMessageDialog(this, result, "Result", JOptionPane.INFORMATION_MESSAGE);
    }
}
