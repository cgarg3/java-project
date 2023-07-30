import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.util.*;
import com.toedter.calendar.JDateChooser;

public class UpdateStudent extends JFrame implements ActionListener {
    JTextField tfaddress, tfemail, tfPhoneNo, cbbranch, cbcourse;
    JLabel lblrollNo;
    JButton submit, cancel;
    Choice rollbarForID;

    UpdateStudent() {
        setSize(820, 600);
        setLocation(250, 50);

        // Heading
        setLayout(null);
        JLabel heading = new JLabel("Update Student Details");
        heading.setBounds(75, 10, 200, 50);
        heading.setFont(new Font("serif", Font.BOLD, 20));
        add(heading);

        JLabel rollNo = new JLabel("Select Roll Number");
        rollNo.setBounds(60, 80, 150, 30);
        add(rollNo);

        rollbarForID = new Choice();
        rollbarForID.setBounds(220, 86, 110, 20);
        add(rollbarForID);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from student");
            while (rs.next()) {
                rollbarForID.add(rs.getString("rollNo"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        // ------------------------------------------------------------------
        // username hardcode
        JLabel studentName = new JLabel("Name");
        studentName.setBounds(50, 150, 100, 30);
        studentName.setFont(new Font("serif", Font.BOLD, 20));
        add(studentName);

        // enter username field
        JLabel tfstudentName = new JLabel();
        tfstudentName.setBounds(200, 150, 150, 30);
        add(tfstudentName);

        // -----------------------------------------------------------
        // roll number hardcode
        JLabel rollNumber = new JLabel("Roll No");
        rollNumber.setBounds(50, 200, 200, 30);
        rollNumber.setFont(new Font("serif", Font.BOLD, 20));
        add(rollNumber);

        lblrollNo = new JLabel();
        lblrollNo.setBounds(200, 200, 200, 30);
        lblrollNo.setFont(new Font("serif", Font.BOLD, 20));
        add(lblrollNo);

        // ------------------------------------------------------------------
        // address hardcode
        JLabel address = new JLabel("Address");
        address.setBounds(50, 250, 200, 30);
        address.setFont(new Font("serif", Font.BOLD, 20));
        add(address);

        // enter address field
        tfaddress = new JTextField();
        tfaddress.setBounds(200, 250, 150, 30);
        add(tfaddress);
        // ------------------------------------------------------------------

        // email hardcode
        JLabel emailID = new JLabel("Email ID");
        emailID.setBounds(50, 300, 200, 30);
        emailID.setFont(new Font("serif", Font.BOLD, 20));
        add(emailID);

        // enter email field
        tfemail = new JTextField();
        tfemail.setBounds(200, 300, 150, 30);
        add(tfemail);

        // ------------------------------------------------------------------
        // 12th percentage hardcode
        JLabel classPercentage = new JLabel("Class XII(%)");
        classPercentage.setBounds(50, 350, 200, 30);
        classPercentage.setFont(new Font("serif", Font.BOLD, 20));
        add(classPercentage);

        // enter 12th percentage field
        JLabel tfpercentage = new JLabel();
        tfpercentage.setBounds(200, 350, 150, 30);
        add(tfpercentage);

        // ------------------------------------------------------------------
        // course hardcode
        JLabel course = new JLabel("Course");
        course.setBounds(50, 400, 200, 30);
        course.setFont(new Font("serif", Font.BOLD, 20));
        add(course);

        cbcourse = new JTextField();
        cbcourse.setBounds(200, 400, 150, 30);
        add(cbcourse);
        // ------------------------------------------------------------------
        // father hardcode
        JLabel fatherName = new JLabel("Father's Name");
        fatherName.setBounds(400, 150, 200, 30);
        fatherName.setFont(new Font("serif", Font.BOLD, 20));
        add(fatherName);

        // enter father field
        JLabel tffatherName = new JLabel();
        tffatherName.setBounds(600, 150, 150, 30);
        add(tffatherName);

        // ------------------------------------------------------------------
        // date of birth hardcode
        JLabel dateOfBirth = new JLabel("Date of Birth");
        dateOfBirth.setBounds(400, 200, 200, 30);
        dateOfBirth.setFont(new Font("serif", Font.BOLD, 20));
        add(dateOfBirth);

        JLabel dcdob = new JLabel();
        dcdob.setBounds(600, 200, 150, 30);
        add(dcdob);

        // ------------------------------------------------------------------
        // phone number hardcode
        JLabel phoneNo = new JLabel("Phone");
        phoneNo.setBounds(400, 250, 200, 30);
        phoneNo.setFont(new Font("serif", Font.BOLD, 20));
        add(phoneNo);

        // enter father field
        tfPhoneNo = new JTextField();
        tfPhoneNo.setBounds(600, 250, 150, 30);
        add(tfPhoneNo);

        // ------------------------------------------------------------------
        // 10th percentage hardcode
        JLabel classXPercentage = new JLabel("Class X(%)");
        classXPercentage.setBounds(400, 300, 200, 30);
        classXPercentage.setFont(new Font("serif", Font.BOLD, 20));
        add(classXPercentage);

        // enter 12th percentage field
        JLabel tfXpercentage = new JLabel();
        tfXpercentage.setBounds(600, 300, 150, 30);
        add(tfXpercentage);

        // ------------------------------------------------------------------
        // aadhar number hardcode
        JLabel aadharNo = new JLabel("Aadhar No");
        aadharNo.setBounds(400, 350, 200, 30);
        aadharNo.setFont(new Font("serif", Font.BOLD, 20));
        add(aadharNo);

        // enter aadhar number field
        JLabel tfaadharNo = new JLabel();
        tfaadharNo.setBounds(600, 350, 150, 30);
        add(tfaadharNo);

        // ------------------------------------------------------------------
        // branch hardcode
        JLabel branch = new JLabel("Branch");
        branch.setBounds(400, 400, 200, 30);
        branch.setFont(new Font("serif", Font.BOLD, 20));
        add(branch);

        cbbranch = new JTextField();
        cbbranch.setBounds(600, 400, 150, 30);
        add(cbbranch);

        try {
            Conn c = new Conn();
            String query = "select * from student where rollNo='" + rollbarForID.getSelectedItem() + "'";
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()) {
                tfstudentName.setText(rs.getString("name"));
                tffatherName.setText(rs.getString("fname"));
                dcdob.setText(rs.getString("dob"));
                tfaddress.setText(rs.getString("address"));
                tfPhoneNo.setText(rs.getString("phone"));
                tfemail.setText(rs.getString("email"));
                tfXpercentage.setText(rs.getString("xpercentage"));
                tfpercentage.setText(rs.getString("xiipercentage"));
                tfaadharNo.setText(rs.getString("aadhar"));
                lblrollNo.setText(rs.getString("rollNo"));
                cbcourse.setText(rs.getString("course"));
                cbbranch.setText(rs.getString("branch"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        rollbarForID.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {
                try {
                    Conn c = new Conn();
                    String query = "select * from student where rollNo='" + rollbarForID.getSelectedItem() + "'";
                    ResultSet rs = c.s.executeQuery(query);
                    while (rs.next()) {
                        tfstudentName.setText(rs.getString("name"));
                        tffatherName.setText(rs.getString("fname"));
                        dcdob.setText(rs.getString("dob"));
                        tfaddress.setText(rs.getString("address"));
                        tfPhoneNo.setText(rs.getString("phone"));
                        tfemail.setText(rs.getString("email"));
                        tfXpercentage.setText(rs.getString("xpercentage"));
                        tfpercentage.setText(rs.getString("xiipercentage"));
                        tfaadharNo.setText(rs.getString("aadhar"));
                        lblrollNo.setText(rs.getString("rollNo"));
                        cbcourse.setText(rs.getString("course"));
                        cbbranch.setText(rs.getString("branch"));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        // login button
        submit = new JButton("Update");
        submit.setBounds(300, 480, 100, 30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("serif", Font.BOLD, 15));
        submit.addActionListener(this);
        add(submit);

        // cancel button
        cancel = new JButton("Cancel");
        cancel.setBounds(450, 480, 100, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("serif", Font.BOLD, 15));
        cancel.addActionListener(this);
        add(cancel);

        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit) {
            String rollNo = lblrollNo.getText();
            String address = tfaddress.getText();
            String phone = tfPhoneNo.getText();
            String email = tfemail.getText();
            String course = cbcourse.getText();
            String branch = cbbranch.getText();

            try {
                String query = "update student set address = '" + address + "', phone = '" + phone + "', email = '"
                        + email + "', course = '" + course + "', branch = '" + branch + "' where rollNo = '" + rollNo
                        + "'";

                Conn c = new Conn();
                c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Student Details Updated Successfully");
                setVisible(false);
            } catch (Exception ae) {
                ae.printStackTrace();
            }

        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new UpdateStudent();
    }

}
