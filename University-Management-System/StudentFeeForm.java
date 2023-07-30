import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.*;
import java.sql.ResultSet;

public class StudentFeeForm extends JFrame implements ActionListener {
    JButton update, payFee, back;
    JComboBox cbcourse, cbbranch, cbsemester;
    Choice rollbar;
    JLabel dueAmount;

    StudentFeeForm() {
        setSize(700, 450);
        setLocation(220, 100);
        setLayout(null);

        getContentPane().setBackground(Color.WHITE);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fee.jpg"));
        Image i2 = i1.getImage().getScaledInstance(380, 250, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(300, 50, 400, 250);
        add(image);

        JLabel rollNumber = new JLabel("Select Roll No");
        rollNumber.setBounds(30, 50, 100, 30);
        rollNumber.setForeground(Color.BLACK);
        add(rollNumber);

        rollbar = new Choice();
        rollbar.setBounds(140, 55, 150, 20);
        add(rollbar);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from student");
            while (rs.next()) {
                rollbar.add(rs.getString("rollno"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel name = new JLabel("Name");
        name.setBounds(30, 90, 100, 30);
        name.setForeground(Color.BLACK);
        add(name);

        JLabel tfName = new JLabel();
        tfName.setBounds(140, 90, 150, 30);
        add(tfName);

        JLabel fatherName = new JLabel("Father's Name");
        fatherName.setBounds(30, 130, 100, 30);
        fatherName.setForeground(Color.BLACK);
        add(fatherName);

        JLabel tffatherName = new JLabel();
        tffatherName.setBounds(140, 130, 150, 30);
        add(tffatherName);

        try {
            Conn c = new Conn();
            String query = "select * from student where rollno='" + rollbar.getSelectedItem() + "'";
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()) {
                tfName.setText(rs.getString("name"));
                tffatherName.setText(rs.getString("fname"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        rollbar.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {
                try {
                    Conn c = new Conn();
                    String query = "select * from student where rollno='" + rollbar.getSelectedItem() + "'";
                    ResultSet rs = c.s.executeQuery(query);
                    while (rs.next()) {
                        tfName.setText(rs.getString("name"));
                        tffatherName.setText(rs.getString("fname"));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        JLabel course = new JLabel("Course");
        course.setBounds(30, 170, 100, 30);
        course.setForeground(Color.BLACK);
        add(course);

        String courseArray[] = { "BTech", "TPS", "Medical", "Fire" };
        cbcourse = new JComboBox(courseArray);
        cbcourse.setBounds(140, 175, 150, 20);
        add(cbcourse);

        JLabel branch = new JLabel("Branch");
        branch.setBounds(30, 210, 100, 30);
        branch.setForeground(Color.BLACK);
        add(branch);

        String branchArray[] = { "Computer Science", "Electronics", "Mechanical", "Civil", "IT" };
        cbbranch = new JComboBox(branchArray);
        cbbranch.setBounds(140, 215, 120, 20);
        add(cbbranch);

        JLabel semester = new JLabel("Semester");
        semester.setBounds(30, 250, 100, 30);
        semester.setForeground(Color.BLACK);
        add(semester);

        String semesterArray[] = { "semester1", "semester2", "semester3", "semester4" };
        cbsemester = new JComboBox(semesterArray);
        cbsemester.setBounds(140, 255, 150, 20);
        add(cbsemester);

        JLabel totalPayable = new JLabel("Total Payable");
        totalPayable.setBounds(30, 290, 100, 30);
        totalPayable.setForeground(Color.BLACK);
        add(totalPayable);

        dueAmount = new JLabel();
        dueAmount.setBounds(140, 290, 100, 30);
        dueAmount.setForeground(Color.BLACK);
        add(dueAmount);

        // buttons
        // update button
        update = new JButton("Update");
        update.setBounds(50, 340, 80, 30);
        update.addActionListener(this);
        add(update);

        // payFee button
        payFee = new JButton("Pay Fee");
        payFee.setBounds(150, 340, 100, 30);
        payFee.addActionListener(this);
        add(payFee);

        // back button
        back = new JButton("Back");
        back.setBounds(270, 340, 100, 30);
        back.addActionListener(this);
        add(back);

        setVisible(true);
    }

    public static void main(String[] args) {
        new StudentFeeForm();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == update) {
            String course = (String) cbcourse.getSelectedItem();
            String semester = (String) cbsemester.getSelectedItem();

            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery("select * from fee where course = '" + course + "'");
                while (rs.next()) {
                    dueAmount.setText(rs.getString(semester));
                }
            } catch (Exception ae) {
                ae.printStackTrace();
            }
        } else if (e.getSource() == payFee) {
            String rollNumber = rollbar.getSelectedItem();
            String course = (String) cbcourse.getSelectedItem();
            String semester = (String) cbsemester.getSelectedItem();
            String branch = (String) cbbranch.getSelectedItem();
            String total = dueAmount.getText();

            try {

                Conn c = new Conn();
                String query = " insert into collegeFee values ('" + rollNumber + "', '" + course + "', '" + branch
                        + "', '" + semester + "', '" + total + "')";
                c.s.executeQuery(query);
                JOptionPane.showMessageDialog(null, "College Fee Submitted");
                setVisible(false);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else {
            setVisible(false);
            new project();
        }
    }
}
