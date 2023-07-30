import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class project extends JFrame implements ActionListener {

    project() {
        setSize(1540, 850);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1300, 650, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);

        // menu bar
        // MAIN HEADER TITLE - INFORMATION
        JMenuBar mb = new JMenuBar();

        // --------------------------------------------------------------
        JMenu newInformation = new JMenu("New Information");
        newInformation.setForeground(Color.BLUE);
        mb.add(newInformation);

        // inside new information
        JMenuItem facultyInfo = new JMenuItem("New Faculty Information");
        facultyInfo.setBackground(Color.WHITE);
        facultyInfo.addActionListener(this);
        newInformation.add(facultyInfo);

        JMenuItem studentInfo = new JMenuItem("New Student Information");
        studentInfo.setBackground(Color.WHITE);
        studentInfo.addActionListener(this);
        newInformation.add(studentInfo);

        // --------------------------------------------------------------------

        // --------------------------------------------------------------------
        JMenu viewDetails = new JMenu("View Details");
        viewDetails.setForeground(Color.RED);
        mb.add(viewDetails);

        // inside new information
        JMenuItem studentDetails = new JMenuItem("View Student Details");
        studentDetails.setBackground(Color.WHITE);
        studentDetails.addActionListener(this);
        viewDetails.add(studentDetails);

        JMenuItem teacherDetails = new JMenuItem("View Faculty Details");
        teacherDetails.setBackground(Color.WHITE);
        teacherDetails.addActionListener(this);
        viewDetails.add(teacherDetails);
        // --------------------------------------------------------------------

        // --------------------------------------------------------------------
        // MAIN HEADER TITLE - LEAVE
        JMenu applyLeave = new JMenu("Apply Leave");
        applyLeave.setForeground(Color.BLUE);
        mb.add(applyLeave);

        // inside new information
        JMenuItem studentLeave = new JMenuItem("Student Leave");
        studentLeave.setBackground(Color.WHITE);
        studentLeave.addActionListener(this);
        applyLeave.add(studentLeave);

        JMenuItem teacherLeave = new JMenuItem("Faculty Leave");
        teacherLeave.setBackground(Color.WHITE);
        teacherLeave.addActionListener(this);
        applyLeave.add(teacherLeave);
        // --------------------------------------------------------------------

        // --------------------------------------------------------------------
        // MAIN HEADER TITLE - LEAVE DETAILS
        JMenu leaveDetails = new JMenu("Leave Details");
        leaveDetails.setForeground(Color.RED);
        mb.add(leaveDetails);

        // inside new information
        JMenuItem studentLeaveDetails = new JMenuItem("Student Leave Details");
        studentLeaveDetails.setBackground(Color.WHITE);
        studentLeaveDetails.addActionListener(this);
        leaveDetails.add(studentLeaveDetails);

        JMenuItem teacherLeaveDetails = new JMenuItem("Faculty Leave Details");
        teacherLeaveDetails.setBackground(Color.WHITE);
        teacherLeaveDetails.addActionListener(this);
        leaveDetails.add(teacherLeaveDetails);
        // --------------------------------------------------------------------

        // --------------------------------------------------------------------
        // MAIN HEADER TITLE - EXAMINATION
        JMenu examination = new JMenu("Examination");
        examination.setForeground(Color.BLUE);
        mb.add(examination);

        // inside new information
        JMenuItem examinationDetails = new JMenuItem("Examination Results");
        examinationDetails.setBackground(Color.WHITE);
        examinationDetails.addActionListener(this);
        examination.add(examinationDetails);

        JMenuItem enterMarks = new JMenuItem("Enter Marks");
        enterMarks.setBackground(Color.WHITE);
        enterMarks.addActionListener(this);
        examination.add(enterMarks);
        // --------------------------------------------------------------------

        // --------------------------------------------------------------------
        // MAIN HEADER TITLE - UPDATE DETAILS
        JMenu updateDetails = new JMenu("Update Details");
        updateDetails.setForeground(Color.RED);
        mb.add(updateDetails);

        // inside new information
        JMenuItem updateStudentDetails = new JMenuItem("Update Student Details");
        updateStudentDetails.setBackground(Color.WHITE);
        updateStudentDetails.addActionListener(this);
        updateDetails.add(updateStudentDetails);

        JMenuItem updateTeachersDetails = new JMenuItem("Update Faculty Details");
        updateTeachersDetails.setBackground(Color.WHITE);
        updateTeachersDetails.addActionListener(this);
        updateDetails.add(updateTeachersDetails);
        // --------------------------------------------------------------------

        // --------------------------------------------------------------------
        // MAIN HEADER TITLE - FEE DETAILS
        JMenu feeDetails = new JMenu("Fee Details");
        feeDetails.setForeground(Color.BLUE);
        mb.add(feeDetails);

        // inside new information
        JMenuItem feeStructure = new JMenuItem("Fee Structure");
        feeStructure.setBackground(Color.WHITE);
        feeStructure.addActionListener(this);
        feeDetails.add(feeStructure);

        JMenuItem studentFeeForm = new JMenuItem("Student Fee Form");
        studentFeeForm.setBackground(Color.WHITE);
        studentFeeForm.addActionListener(this);
        feeDetails.add(studentFeeForm);
        // --------------------------------------------------------------------

        // --------------------------------------------------------------------
        // MAIN HEADER TITLE - UTILITY
        JMenu utility = new JMenu("Utility");
        utility.setForeground(Color.RED);
        mb.add(utility);

        // inside new information
        JMenuItem notepad = new JMenuItem("Notepad");
        notepad.setBackground(Color.WHITE);
        notepad.addActionListener(this);
        utility.add(notepad);

        JMenuItem calculator = new JMenuItem("Calculator");
        calculator.setBackground(Color.WHITE);
        calculator.addActionListener(this);
        utility.add(calculator);

        // --------------------------------------------------------------------

        // --------------------------------------------------------------------
        // MAIN HEADER TITLE - ABOUT
        JMenu about = new JMenu("About");
        about.setForeground(Color.BLUE);
        mb.add(about);

        JMenuItem aboutUs = new JMenuItem("About Us");
        aboutUs.setBackground(Color.WHITE);
        aboutUs.addActionListener(this);
        about.add(aboutUs);

        // --------------------------------------------------------------------

        // --------------------------------------------------------------------
        // MAIN HEADER TITLE - EXIT
        JMenu exit = new JMenu("Exit");
        exit.setForeground(Color.RED);
        mb.add(exit);

        JMenuItem exitBar = new JMenuItem("Exit");
        exitBar.setBackground(Color.WHITE);
        exitBar.addActionListener(this);
        exit.add(exitBar);
        // --------------------------------------------------------------------

        setJMenuBar(mb);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent i) {
        String msg = i.getActionCommand();

        if (msg.equals("Exit")) {
            setVisible(false);
        } else if (msg.equals("Calculator")) {
            try {
                Runtime.getRuntime().exec("calc.exe");
            } catch (Exception e) {

            }
        } else if (msg.equals("Notepad"))

        {
            try {
                Runtime.getRuntime().exec("notepad.exe");
            } catch (Exception e) {

            }
        } else if (msg.equals("New Faculty Information")) {
            new AddTeacher();
        } else if (msg.equals("New Student Information")) {
            new AddStudent();
        } else if (msg.equals("View Faculty Details")) {
            new TeacherDetails();
        } else if (msg.equals("View Student Details")) {
            new StudentDetails();
        } else if (msg.equals("Faculty Leave")) {
            new TeacherLeave();
        } else if (msg.equals("Student Leave")) {
            new StudentLeave();
        } else if (msg.equals("Faculty Leave Details")) {
            new TeacherLeaveDetails();
        } else if (msg.equals("Student Leave Details")) {
            new StudentLeaveDetails();
        } else if (msg.equals("Update Faculty Details")) {
            new UpdateTeacher();
        } else if (msg.equals("Update Student Details")) {
            new UpdateStudent();
        } else if (msg.equals("Examination Results")) {
            new ExaminationDetails();
        } else if (msg.equals("Enter Marks")) {
            new EnterMarks();
        } else if (msg.equals("Fee Structure")) {
            new FeeStructure();
        } else if (msg.equals("About Us")) {
            new About();
        } else if (msg.equals("Student Fee Form")) {
            new StudentFeeForm();
        }
    }

    public static void main(String[] args) {
        new project();
    }
}
