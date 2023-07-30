import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import net.proteanit.sql.DbUtils;

public class FeeStructure extends JFrame {

    FeeStructure() {
        setLayout(null);
        setSize(1000, 600);
        setLocation(150, 40);
        JLabel heading = new JLabel("Fee Structure");
        heading.setBounds(40, 30, 400, 50);
        heading.setForeground(Color.BLACK);
        heading.setFont(new Font("Tahoma", Font.BOLD, 30));
        add(heading);

        JTable table = new JTable();
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from fee");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }

        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0, 100, 1000, 600);
        add(jsp);

        setVisible(true);
    }

    public static void main(String[] args) {
        new FeeStructure();
    }
}
