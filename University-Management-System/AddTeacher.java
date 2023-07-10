import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.*;
import com.toedter.calendar.JDateChooser;

public class AddTeacher extends JFrame implements ActionListener {
    JTextField tfName, tfaddress, tfemail, tfpercentage, tffatherName, tfPhoneNo, tfXpercentage, tfaadharNo;
    JLabel lblempNo;
    JDateChooser dcdob;
    JComboBox cbcourse, cbbranch;
    JButton submit, cancel;

    Random ran = new Random();
    long first4 = Math.abs((ran.nextLong() % 9000L) + 1000L);

    AddTeacher() {
        setSize(820, 600);
        setLocation(250, 50);

        // Heading
        setLayout(null);
        JLabel heading = new JLabel("New Faculty Details");
        heading.setBounds(305, 20, 200, 50);
        heading.setFont(new Font("serif", Font.BOLD, 20));
        add(heading);

        // ------------------------------------------------------------------
        // username hardcode
        JLabel facultyName = new JLabel("Name");
        facultyName.setBounds(50, 150, 100, 30);
        facultyName.setFont(new Font("serif", Font.BOLD, 20));
        add(facultyName);

        // enter username field
        tfName = new JTextField();
        tfName.setBounds(200, 150, 150, 30);
        add(tfName);

        // -----------------------------------------------------------
        // roll number hardcode
        JLabel empNumber = new JLabel("Employee ID");
        empNumber.setBounds(50, 200, 200, 30);
        empNumber.setFont(new Font("serif", Font.BOLD, 20));
        add(empNumber);

        lblempNo = new JLabel("011" + first4);
        lblempNo.setBounds(200, 200, 200, 30);
        lblempNo.setFont(new Font("serif", Font.BOLD, 20));
        add(lblempNo);

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
        tfpercentage = new JTextField();
        tfpercentage.setBounds(200, 350, 150, 30);
        add(tfpercentage);

        // ------------------------------------------------------------------
        // course hardcode
        JLabel course = new JLabel("Qualification");
        course.setBounds(50, 400, 200, 30);
        course.setFont(new Font("serif", Font.BOLD, 20));
        add(course);

        String courseArray[] = { "B.Tech", "BBA", "BCA", "CPA", "MBA", "MSC", "BCOM", "BA" };
        cbcourse = new JComboBox(courseArray);
        cbcourse.setBounds(200, 400, 150, 30);
        cbcourse.setBackground(Color.WHITE);
        cbcourse.setForeground(Color.BLACK);
        add(cbcourse);
        // ------------------------------------------------------------------
        // father hardcode
        JLabel fatherName = new JLabel("Father's Name");
        fatherName.setBounds(400, 150, 200, 30);
        fatherName.setFont(new Font("serif", Font.BOLD, 20));
        add(fatherName);

        // enter father field
        tffatherName = new JTextField();
        tffatherName.setBounds(600, 150, 150, 30);
        add(tffatherName);

        // ------------------------------------------------------------------
        // date of birth hardcode
        JLabel dateOfBirth = new JLabel("Date of Birth");
        dateOfBirth.setBounds(400, 200, 200, 30);
        dateOfBirth.setFont(new Font("serif", Font.BOLD, 20));
        add(dateOfBirth);

        dcdob = new JDateChooser();
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
        tfXpercentage = new JTextField();
        tfXpercentage.setBounds(600, 300, 150, 30);
        add(tfXpercentage);

        // ------------------------------------------------------------------
        // aadhar number hardcode
        JLabel aadharNo = new JLabel("Aadhar No");
        aadharNo.setBounds(400, 350, 200, 30);
        aadharNo.setFont(new Font("serif", Font.BOLD, 20));
        add(aadharNo);

        // enter aadhar number field
        tfaadharNo = new JTextField();
        tfaadharNo.setBounds(600, 350, 150, 30);
        add(tfaadharNo);

        // ------------------------------------------------------------------
        // branch hardcode
        JLabel branch = new JLabel("Department");
        branch.setBounds(400, 400, 200, 30);
        branch.setFont(new Font("serif", Font.BOLD, 20));
        add(branch);

        String branchArray[] = { "Computer Science", "Electronics", "Mechanical", "Civil", "IT" };
        cbbranch = new JComboBox(branchArray);
        cbbranch.setBounds(600, 400, 150, 30);
        cbbranch.setBackground(Color.WHITE);
        cbbranch.setForeground(Color.BLACK);
        add(cbbranch);

        // login button
        submit = new JButton("Submit");
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
            String name = tfName.getText();
            String father_name = tffatherName.getText();
            String roll = lblempNo.getText();
            String dob = ((JTextField) dcdob.getDateEditor().getUiComponent()).getText();
            String Address = tfaddress.getText();
            String phoneNumber = tfPhoneNo.getText();
            String email = tfemail.getText();
            String percentX = tfpercentage.getText();
            String percentXII = tfXpercentage.getText();
            String aadharNumber = tfaadharNo.getText();
            String courses = (String) cbcourse.getSelectedItem();
            String branches = (String) cbbranch.getSelectedItem();

            try {
                String query = "insert into student values('" + name + "', '" + father_name + "', '" + roll + "','"
                        + dob + "','" + Address + "','" + phoneNumber + "','" + email + "','" + percentX + "','"
                        + percentXII + "','" + aadharNumber + "','" + courses + "','" + branches + "')";

                Conn c = new Conn();
                c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Student Details Inserted Successfully");
            } catch (Exception ae) {
                ae.printStackTrace();
            }

        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new AddTeacher();
    }

}
