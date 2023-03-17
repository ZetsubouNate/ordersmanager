package presentation.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.List;

import static dao.AbstractDAO.getColumns;

/**
 * @Author: Calinescu Mirela
 * @Since: We just don't know...
 */
public class DisplayView<T> extends JFrame {

    private JPanel contentPane;
    private JTable table;
    private JLabel displayTitle;
    private String[] columns;
    private String[][] data;
    private JButton backDisplayButton;

    public DisplayView(List<T> list) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 931, 400);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        displayTitle = new JLabel("Display all");
        displayTitle.setFont(new Font("Tahoma", Font.BOLD, 18));
        displayTitle.setBounds(10, 10, 375, 40);
        contentPane.add(displayTitle);

        this.columns = getColumns(list.get(0)).toArray(new String[0]);
        int col = columns.length;
        int row = list.size();
        this.data = new String[row][col];
        for(int i = 0; i < row; i++) {
            String[] s = list.get(i).toString().split(", ");
            for(int j = 0; j < col; j++)
                this.data[i][j] = s[j];
        }

        table = new JTable(data, columns);
        table.setFont(new Font("Tahoma", Font.PLAIN, 12));
        table.setBounds(18, 50, 878, 300);
        contentPane.add(table);
        JScrollPane pane = new JScrollPane(table);
        pane.setBounds(18, 50, 878, 300);
        contentPane.add(pane);

        backDisplayButton = new JButton("Back");
        backDisplayButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
        backDisplayButton.setBounds(778, 16, 117, 25);
        contentPane.add(backDisplayButton);

        String className = list.get(0).getClass().getSimpleName();
        displayTitle.setText("Display All " + className + "s");
    }

    public void backDisplayButtonActionListener(ActionListener actionListener) {
        this.backDisplayButton.addActionListener(actionListener);
    }
}
