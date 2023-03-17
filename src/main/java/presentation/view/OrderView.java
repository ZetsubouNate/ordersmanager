package presentation.view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * @Author: Calinescu Mirela
 * @Since: We just don't know...
 */
public class OrderView extends JFrame {

    private JPanel contentPane;
    private JButton addOrderButton;
    private JButton removeOrderButton;
    private JButton showOrderButton;
    private JButton backOrderButton;

    public OrderView() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 701, 379);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        addOrderButton = new JButton("Add");
        addOrderButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
        addOrderButton.setBounds(27, 129, 186, 37);
        contentPane.add(addOrderButton);

        removeOrderButton = new JButton("Remove");
        removeOrderButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
        removeOrderButton.setBounds(461, 129, 186, 37);
        contentPane.add(removeOrderButton);

        showOrderButton = new JButton("Show All");
        showOrderButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
        showOrderButton.setBounds(132, 211, 186, 37);
        contentPane.add(showOrderButton);

        backOrderButton = new JButton("Back");
        backOrderButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
        backOrderButton.setBounds(356, 211, 186, 37);
        contentPane.add(backOrderButton);

        JLabel lblNewLabel = new JLabel("Orders");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(199, 36, 278, 40);
        contentPane.add(lblNewLabel);
    }

    public void addOrderButtonActionListener(ActionListener actionListener) {
        this.addOrderButton.addActionListener(actionListener);
    }

    public void removeOrderButtonActionListener(ActionListener actionListener) {
        this.removeOrderButton.addActionListener(actionListener);
    }

    public void showOrderButtonActionListener(ActionListener actionListener) {
        this.showOrderButton.addActionListener(actionListener);
    }

    public void backOrderButtonActionListener(ActionListener actionListener) {
        this.backOrderButton.addActionListener(actionListener);
    }
}
