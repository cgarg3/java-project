import javax.security.auth.Subject;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class EnterMarks extends JFrame implements ActionListener {

    Choice rollBarForID;
    JComboBox rollBarForSemester;
    JButton submit, back;
    JTextField sub1, sub2, sub3, sub4, sub5;
    JTextField marks1, marks2, marks3, marks4, marks5;

    EnterMarks() {
        setLayout(null);
        setSize(1000, 470);
        setLocation(180, 130);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("./icons/exam.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(550, 50, 500, 300);
        add(image);

        JLabel heading = new JLabel("Enter Marks of Student");
        heading.setBounds(50, 0, 500, 40);
        heading.setFont(new Font("Tahoma", Font.BOLD, 25));
        add(heading);

        JLabel rollNo = new JLabel("Select Roll Number");
        rollNo.setBounds(50, 70, 150, 20);
        add(rollNo);

        rollBarForID = new Choice();
        rollBarForID.setBounds(200, 70, 100, 20);
        add(rollBarForID);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("Select * from student");
            while (rs.next()) {
                rollBarForID.add(rs.getString("rollno"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel semester = new JLabel("Select Semester");
        semester.setBounds(50, 110, 150, 20);
        add(semester);

        String semesterArray[] = { "1st Semester", "2nd Semester", "3rd Semester", "4th Semester" };
        rollBarForSemester = new JComboBox(semesterArray);
        rollBarForSemester.setBounds(200, 110, 150, 20);
        add(rollBarForSemester);

        JLabel enterSubject = new JLabel("Enter Subject");
        enterSubject.setBounds(100, 170, 150, 20);
        add(enterSubject);

        JLabel enterMarks = new JLabel("Enter Marks");
        enterMarks.setBounds(300, 170, 150, 20);
        add(enterMarks);

        sub1 = new JTextField();
        sub1.setBounds(50, 200, 200, 20);
        add(sub1);

        sub2 = new JTextField();
        sub2.setBounds(50, 230, 200, 20);
        add(sub2);

        sub3 = new JTextField();
        sub3.setBounds(50, 260, 200, 20);
        add(sub3);

        sub4 = new JTextField();
        sub4.setBounds(50, 290, 200, 20);
        add(sub4);

        sub5 = new JTextField();
        sub5.setBounds(50, 320, 200, 20);
        add(sub5);

        marks1 = new JTextField();
        marks1.setBounds(250, 200, 200, 20);
        add(marks1);

        marks2 = new JTextField();
        marks2.setBounds(250, 230, 200, 20);
        add(marks2);

        marks3 = new JTextField();
        marks3.setBounds(250, 260, 200, 20);
        add(marks3);

        marks4 = new JTextField();
        marks4.setBounds(250, 290, 200, 20);
        add(marks4);

        marks5 = new JTextField();
        marks5.setBounds(250, 320, 200, 20);
        add(marks5);

        submit = new JButton("Submit");
        submit.setBounds(90, 360, 100, 30);
        submit.addActionListener(this);
        add(submit);

        back = new JButton("Back");
        back.setBounds(220, 360, 100, 30);
        back.addActionListener(this);
        add(back);

        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit) {
            try {
                Conn c = new Conn();
                String query1 = "insert into subject values('" + rollBarForID.getSelectedItem() + "', '"
                        + rollBarForSemester.getSelectedItem() + "', '" + sub1.getText() + "', '" + sub2.getText()
                        + "', '"
                        + sub3.getText() + "', '" + sub4.getText() + "', '" + sub5.getText() + "')";
                String query2 = "insert into marks values('" + rollBarForID.getSelectedItem() + "', '"
                        + rollBarForSemester.getSelectedItem() + "', '" + marks1.getText() + "', '" + marks2.getText()
                        + "', '" + marks3.getText() + "', '" + marks4.getText() + "', '" + marks5.getText()
                        + "')";
                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);
                JOptionPane.showMessageDialog(null, "Marks Entered Successfully");
                setVisible(false);
            } catch (Exception ae) {
                ae.printStackTrace();
            }

        } else {
            new project();
        }
    }

    public static void main(String[] args) {
        new EnterMarks();
    }
}
