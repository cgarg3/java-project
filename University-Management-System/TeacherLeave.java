import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class TeacherLeave extends JFrame implements ActionListener {

    Choice rollbarForID;
    JComboBox rollbarForTime;
    JDateChooser dateForLeave;
    JButton submit, cancel;

    TeacherLeave() {
        setSize(400, 400);
        setLocation(400, 100);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel heading = new JLabel("Apply Leave (Teacher)");
        heading.setBounds(40, 30, 300, 30);
        add(heading);

        JLabel empId = new JLabel("Employee ID");
        empId.setBounds(60, 60, 200, 30);
        add(empId);

        rollbarForID = new Choice();
        rollbarForID.setBounds(60, 90, 150, 20);
        add(rollbarForID);
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from teacher");
            while (rs.next()) {
                rollbarForID.add(rs.getString("empID"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        // date of birth hardcode
        JLabel date = new JLabel("Date");
        date.setBounds(60, 130, 150, 30);
        add(date);

        dateForLeave = new JDateChooser();
        dateForLeave.setBounds(60, 160, 150, 20);
        add(dateForLeave);

        JLabel time = new JLabel("Time");
        time.setBounds(60, 200, 190, 20);
        add(time);

        String timeArray[] = { "Half Day", "Full Day", "1 Week", "1 Month" };
        rollbarForTime = new JComboBox(timeArray);
        rollbarForTime.setBounds(60, 230, 150, 20);
        rollbarForTime.setBackground(Color.WHITE);
        rollbarForTime.setForeground(Color.BLACK);
        add(rollbarForTime);

        // submit button
        submit = new JButton("Submit");
        submit.setBounds(60, 280, 100, 30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("serif", Font.BOLD, 15));
        submit.addActionListener(this);
        add(submit);

        // cancel button
        cancel = new JButton("Cancel");
        cancel.setBounds(200, 280, 100, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("serif", Font.BOLD, 15));
        cancel.addActionListener(this);
        add(cancel);
        setVisible(true);
    }

    public static void main(String[] args) {
        new TeacherLeave();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == submit) {
                String empID = rollbarForID.getSelectedItem();
                String date = ((JTextField) dateForLeave.getDateEditor().getUiComponent()).getText();
                String time = (String) rollbarForTime.getSelectedItem();

                String query = "insert into teacherleave values('" + empID + "', '" + date + "', '" + time + "')";
                try {
                    Conn c = new Conn();
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Leave Confirmed");
                    setVisible(false);
                } catch (Exception exep) {
                    exep.printStackTrace();
                }

            } else {
                setVisible(false);
            }
        } catch (Exception ae) {
            ae.printStackTrace();
        }
    }
}
