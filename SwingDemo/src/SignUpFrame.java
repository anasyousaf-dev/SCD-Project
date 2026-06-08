import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class SignUpFrame extends JFrame {

    private static final long serialVersionUID = 1L;

    private JPanel contentPane;

    private JTextField txtName;
    private JTextField txtEmail;
    private JTextField txtPassword;

    public SignUpFrame() {

        setTitle("Sign Up");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 500, 400);
        setLocationRelativeTo(null);

        contentPane = new JPanel();
        contentPane.setBackground(new Color(45, 49, 50));
        contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblTitle = new JLabel("Library Book Issue System");
        lblTitle.setForeground(new Color(0, 255, 255));
        lblTitle.setFont(new Font("Lucida Grande", Font.BOLD, 20));
        lblTitle.setBounds(90, 20, 300, 30);
        contentPane.add(lblTitle);

        JLabel lblCreate = new JLabel("Create Account");
        lblCreate.setForeground(new Color(0, 255, 255));
        lblCreate.setFont(new Font("Lucida Grande", Font.BOLD, 14));
        lblCreate.setBounds(180, 60, 150, 20);
        contentPane.add(lblCreate);

        JLabel lblName = new JLabel("Name");
        lblName.setForeground(new Color(0, 255, 255));
        lblName.setFont(new Font("Lucida Grande", Font.BOLD, 14));
        lblName.setBounds(70, 110, 100, 25);
        contentPane.add(lblName);

        txtName = new JTextField();
        txtName.setBounds(180, 110, 200, 30);
        contentPane.add(txtName);

        JLabel lblEmail = new JLabel("Email");
        lblEmail.setForeground(new Color(0, 255, 255));
        lblEmail.setFont(new Font("Lucida Grande", Font.BOLD, 14));
        lblEmail.setBounds(70, 160, 100, 25);
        contentPane.add(lblEmail);

        txtEmail = new JTextField();
        txtEmail.setBounds(180, 160, 200, 30);
        contentPane.add(txtEmail);

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setForeground(new Color(0, 255, 255));
        lblPassword.setFont(new Font("Lucida Grande", Font.BOLD, 14));
        lblPassword.setBounds(70, 210, 100, 25);
        contentPane.add(lblPassword);

        txtPassword = new JTextField();
        txtPassword.setBounds(180, 210, 200, 30);
        contentPane.add(txtPassword);

        JButton btnCreate = new JButton("Create Account");
        btnCreate.setBounds(100, 290, 150, 35);
        contentPane.add(btnCreate);

        JButton btnBack = new JButton("Back");
        btnBack.setBounds(270, 290, 120, 35);
        contentPane.add(btnBack);

        btnCreate.addActionListener(e -> {

            try {

                String name = txtName.getText().trim();
                String email = txtEmail.getText().trim();
                String password = txtPassword.getText().trim();

                if (name.isEmpty()
                        || email.isEmpty()
                        || password.isEmpty()) {

                    throw new EmptyFieldException(
                            "Please Fill All Fields");
                }

                if (!email.contains("@")
                        || !email.contains(".")) {

                    throw new InvalidEmailException(
                            "Invalid Email Format");
                }

                JOptionPane.showMessageDialog(
                        null,
                        "Account Created Successfully");

                LoginFrame login = new LoginFrame();
                login.setVisible(true);

                dispose();
            }

            catch (EmptyFieldException
                    | InvalidEmailException ex) {

                JOptionPane.showMessageDialog(
                        null,
                        ex.getMessage());
            }
        });

        btnBack.addActionListener(e -> {

            LoginFrame login = new LoginFrame();
            login.setVisible(true);

            dispose();
        });
    }
}