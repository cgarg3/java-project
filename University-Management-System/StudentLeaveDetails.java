import javax.naming.spi.DirStateFactory.Result;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import net.proteanit.sql.DbUtils;

public class StudentLeaveDetails extends JFrame implements ActionListener {

    JButton search, print, add, update, back;
    Choice rollbar;
    JTable table;

    StudentLeaveDetails() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setSize(800, 500);
        setLocation(250, 30);

        JLabel searchBar = new JLabel("Search by Roll Number");
        searchBar.setBounds(20, 20, 150, 20);
        searchBar.setForeground(Color.BLACK);
        add(searchBar);

        rollbar = new Choice();
        rollbar.setBounds(180, 20, 150, 20);
        add(rollbar);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from student");
            while (rs.next()) {
                rollbar.add(rs.getString("rollNo"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        table = new JTable();
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from studentleave");
            table.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            e.printStackTrace();
        }

        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0, 100, 900, 600);
        add(jsp);

        // search button
        search = new JButton("Search");
        search.setBounds(20, 70, 80, 20);
        search.addActionListener(this);
        add(search);

        // print button
        print = new JButton("Print");
        print.setBounds(120, 70, 80, 20);
        print.addActionListener(this);
        add(print);

        // back button
        back = new JButton("Back");
        back.setBounds(220, 70, 80, 20);
        back.addActionListener(this);
        add(back);

        setVisible(true);

    }

    public static void main(String[] args) {
        new StudentLeaveDetails();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == search) {
            String query = "select * from studentleave where rollNo = '" + rollbar.getSelectedItem() + "'";
            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception ae) {
                ae.printStackTrace();
            }

        } else if (e.getSource() == print) {

            try {
                table.print();
            } catch (Exception ae) {
                ae.printStackTrace();
            }
        } else {
            setVisible(false);
            new project();
        }

    }
}