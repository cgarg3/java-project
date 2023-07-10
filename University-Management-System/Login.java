import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
    JButton login, cancel;
    JTextField tfusername, tfpassword;

    Login() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        // username hardcode
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(40, 20, 100, 20);
        add(lblusername);

        // enter username field
        tfusername = new JTextField();
        tfusername.setBounds(150, 20, 150, 20);
        add(tfusername);

        // password hardcode
        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(40, 50, 100, 20);
        add(lblpassword);

        // enter password field
        tfpassword = new JPasswordField();
        tfpassword.setBounds(150, 50, 150, 20);
        add(tfpassword);

        // login button
        login = new JButton("Login");
        login.setBounds(40, 100, 100, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.setFont(new Font("serif", Font.BOLD, 15));
        login.addActionListener(this);
        add(login);

        // cancel button
        cancel = new JButton("Cancel");
        cancel.setBounds(150, 100, 100, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("serif", Font.BOLD, 15));
        cancel.addActionListener(this);
        add(cancel);

        // image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("./icons/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 0, 200, 200);
        add(image);

        setSize(600, 300);
        setLocation(500, 250);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == login) {
            String username = tfusername.getText();
            String password = tfpassword.getText();

            String query = "select * from login where username = '" + username + "' and password = '" + password + "'";
            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);

                if (rs.next()) {
                    setVisible(false);
                    new project();
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Username or Password");
                    setVisible(false);
                }
            } catch (Exception ae) {
                ae.printStackTrace();
            }
        } else if (e.getSource() == cancel) {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
