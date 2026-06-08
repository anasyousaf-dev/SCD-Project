import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class LoginFrame extends JFrame {

    private static final long serialVersionUID = 1L;

    private JPanel contentPane;
    private JTextField txtEmail;
    private JTextField txtPassword;

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {

            try {

                LoginFrame frame = new LoginFrame();
                frame.setVisible(true);

            } catch (Exception e) {

                e.printStackTrace();
            }
        });
    }

    public LoginFrame() {

        setTitle("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 500, 350);
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

        JLabel lblWelcome = new JLabel("Welcome Back!");
        lblWelcome.setForeground(new Color(0, 255, 255));
        lblWelcome.setFont(new Font("Lucida Grande", Font.BOLD, 14));
        lblWelcome.setBounds(180, 60, 150, 20);
        contentPane.add(lblWelcome);

        JLabel lblEmail = new JLabel("Email");
        lblEmail.setForeground(new Color(0, 255, 255));
        lblEmail.setFont(new Font("Lucida Grande", Font.BOLD, 14));
        lblEmail.setBounds(80, 110, 80, 25);
        contentPane.add(lblEmail);

        txtEmail = new JTextField();
        txtEmail.setBounds(180, 110, 180, 30);
        contentPane.add(txtEmail);

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setForeground(new Color(0, 255, 255));
        lblPassword.setFont(new Font("Lucida Grande", Font.BOLD, 14));
        lblPassword.setBounds(80, 160, 80, 25);
        contentPane.add(lblPassword);

        txtPassword = new JTextField();
        txtPassword.setBounds(180, 160, 180, 30);
        contentPane.add(txtPassword);

        JButton btnLogin = new JButton("Login");
        btnLogin.setBounds(120, 230, 120, 35);
        contentPane.add(btnLogin);

        JButton btnSignUp = new JButton("Sign Up");
        btnSignUp.setBounds(260, 230, 120, 35);
        contentPane.add(btnSignUp);

        btnLogin.addActionListener(e -> {

            try {

                String email = txtEmail.getText().trim();
                String password = txtPassword.getText().trim();

                if (email.isEmpty() || password.isEmpty()) {

                    throw new EmptyFieldException(
                            "Please Fill All Fields");
                }

                if (!email.contains("@")
                        || !email.contains(".")) {

                    throw new InvalidEmailException(
                            "Invalid Email Format");
                }

                LibraryIssueFrame library =
                        new LibraryIssueFrame();

                library.setVisible(true);

                dispose();
            }

            catch (EmptyFieldException
                    | InvalidEmailException ex) {

                JOptionPane.showMessageDialog(
                        null,
                        ex.getMessage());
            }
        });

        btnSignUp.addActionListener(e -> {

            SignUpFrame signup = new SignUpFrame();
            signup.setVisible(true);

            dispose();
        });
    }
}