import javax.naming.spi.DirStateFactory.Result;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import net.proteanit.sql.DbUtils;

public class StudentDetails extends JFrame implements ActionListener {

    JButton search, print, add, update, back;
    Choice rollbar;
    JTable table;

    StudentDetails() {
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
            ResultSet rs = c.s.executeQuery("select * from student");
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

        // add button
        add = new JButton("Add");
        add.setBounds(220, 70, 80, 20);
        add.addActionListener(this);
        add(add);

        // update button
        update = new JButton("Update");
        update.setBounds(320, 70, 80, 20);
        update.addActionListener(this);
        add(update);

        // back button
        back = new JButton("Back");
        back.setBounds(420, 70, 80, 20);
        back.addActionListener(this);
        add(back);

        setVisible(true);

    }

    public static void main(String[] args) {
        new StudentDetails();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == search) {
            String query = "select * from student where rollNo = '" + rollbar.getSelectedItem()+"'";
            try {
                    Conn c = new Conn();
                    ResultSet rs = c.s.executeQuery(query);                
                    table.setModel(DbUtils.resultSetToTableModel(rs));
                } catch (Exception ae) {
                ae.printStackTrace();
            }

        } else if  (e.getSource() == print){
            
        try {
            table.print()
        } catch (Exception ae) {
            ae.printStackTrace();
        }
    }
        else if (e.getSource() == add) {
            setVisible(false);
            new AddStudent();   
        }
        else if (e.getSource() == update) {
            setVisible(false);
            new UpdateStudent();
        }

        else {
            setVisible(false);
            new project();
        }

}
}