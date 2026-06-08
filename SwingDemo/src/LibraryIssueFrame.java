import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import javax.swing.*;
import javax.swing.border.*;

public class LibraryIssueFrame extends JFrame {

    private static final long serialVersionUID = 1L;

    private JPanel contentPane;
    private JTextField textField_StdName;
    private JTextField textField_RN;
    private JTextField textField_BT;
    private JTextField textField_ID;
    private JTextField textField_RD;

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {

            try {

                LibraryIssueFrame frame = new LibraryIssueFrame();
                frame.setVisible(true);

            } catch (Exception e) {

                e.printStackTrace();
            }
        });
    }

    public LibraryIssueFrame() {

        setTitle("Library Book Issue System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 560, 620);
        setLocationRelativeTo(null);

        contentPane = new JPanel();
        contentPane.setBackground(new Color(45, 49, 50));
        contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblTitle = new JLabel("Library Book Issue System");
        lblTitle.setForeground(new Color(0, 255, 255));
        lblTitle.setFont(new Font("Lucida Grande", Font.BOLD, 20));
        lblTitle.setBounds(135, 20, 320, 30);
        contentPane.add(lblTitle);

        JLabel lblStudentName = new JLabel("Student Name");
        lblStudentName.setForeground(new Color(0, 255, 255));
        lblStudentName.setFont(new Font("Lucida Grande", Font.BOLD, 14));
        lblStudentName.setBounds(70, 90, 130, 20);
        contentPane.add(lblStudentName);

        JLabel lblRollNumber = new JLabel("Roll Number");
        lblRollNumber.setForeground(new Color(0, 255, 255));
        lblRollNumber.setFont(new Font("Lucida Grande", Font.BOLD, 14));
        lblRollNumber.setBounds(70, 130, 130, 20);
        contentPane.add(lblRollNumber);

        JLabel lblBookTitle = new JLabel("Book Title");
        lblBookTitle.setForeground(new Color(0, 255, 255));
        lblBookTitle.setFont(new Font("Lucida Grande", Font.BOLD, 14));
        lblBookTitle.setBounds(70, 170, 130, 20);
        contentPane.add(lblBookTitle);

        JLabel lblBookCategory = new JLabel("Book Category");
        lblBookCategory.setForeground(new Color(0, 255, 255));
        lblBookCategory.setFont(new Font("Lucida Grande", Font.BOLD, 14));
        lblBookCategory.setBounds(70, 210, 130, 20);
        contentPane.add(lblBookCategory);

        JLabel lblBookType = new JLabel("Book Type");
        lblBookType.setForeground(new Color(0, 255, 255));
        lblBookType.setFont(new Font("Lucida Grande", Font.BOLD, 14));
        lblBookType.setBounds(70, 250, 130, 20);
        contentPane.add(lblBookType);

        JLabel lblIssueDate = new JLabel("Issue Date");
        lblIssueDate.setForeground(new Color(0, 255, 255));
        lblIssueDate.setFont(new Font("Lucida Grande", Font.BOLD, 14));
        lblIssueDate.setBounds(70, 290, 130, 20);
        contentPane.add(lblIssueDate);

        JLabel lblReturnDate = new JLabel("Return Date");
        lblReturnDate.setForeground(new Color(0, 255, 255));
        lblReturnDate.setFont(new Font("Lucida Grande", Font.BOLD, 14));
        lblReturnDate.setBounds(70, 330, 130, 20);
        contentPane.add(lblReturnDate);

        textField_StdName = new JTextField();
        textField_StdName.setBounds(230, 85, 200, 30);
        contentPane.add(textField_StdName);

        textField_RN = new JTextField();
        textField_RN.setBounds(230, 125, 200, 30);
        contentPane.add(textField_RN);

        textField_BT = new JTextField();
        textField_BT.setBounds(230, 165, 200, 30);
        contentPane.add(textField_BT);

        textField_ID = new JTextField();
        textField_ID.setBounds(230, 285, 200, 30);
        contentPane.add(textField_ID);

        textField_RD = new JTextField();
        textField_RD.setBounds(230, 325, 200, 30);
        contentPane.add(textField_RD);

        JComboBox<String> comboBox_BC = new JComboBox<>();

        comboBox_BC.setModel(
                new DefaultComboBoxModel<>(
                        new String[] {
                                "Choose Option",
                                "AI",
                                "Programming",
                                "Databases",
                                "Networking"
                        }));

        comboBox_BC.setBounds(230, 205, 200, 30);
        contentPane.add(comboBox_BC);

        JRadioButton radionbtn_NE = new JRadioButton("New Edition");
        radionbtn_NE.setForeground(new Color(0, 255, 255));
        radionbtn_NE.setBackground(new Color(45, 49, 50));
        radionbtn_NE.setSelected(true);
        radionbtn_NE.setBounds(230, 248, 130, 23);
        contentPane.add(radionbtn_NE);

        JRadioButton radionbtn_OE = new JRadioButton("Old Edition");
        radionbtn_OE.setForeground(new Color(0, 255, 255));
        radionbtn_OE.setBackground(new Color(45, 49, 50));
        radionbtn_OE.setBounds(360, 248, 130, 23);
        contentPane.add(radionbtn_OE);

        ButtonGroup bg = new ButtonGroup();
        bg.add(radionbtn_NE);
        bg.add(radionbtn_OE);

        JButton btnIssueBook = new JButton("Issue Book");
        btnIssueBook.setBounds(70, 500, 130, 35);
        contentPane.add(btnIssueBook);

        JButton btnReset = new JButton("Reset");
        btnReset.setBounds(210, 500, 130, 35);
        contentPane.add(btnReset);

        JButton btnExit = new JButton("Exit");
        btnExit.setBounds(350, 500, 130, 35);
        contentPane.add(btnExit);

        btnIssueBook.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                try {

                    String name = textField_StdName.getText().trim();
                    String roll = textField_RN.getText().trim();
                    String book = textField_BT.getText().trim();
                    String issueDate = textField_ID.getText().trim();
                    String returnDate = textField_RD.getText().trim();

                    if (name.isEmpty()
                            || roll.isEmpty()
                            || book.isEmpty()
                            || issueDate.isEmpty()
                            || returnDate.isEmpty()) {

                        throw new EmptyFieldException(
                                "Please Fill All Fields");
                    }

                    int rn = Integer.parseInt(roll);

                    if (comboBox_BC.getSelectedIndex() == 0) {

                        throw new NullSelectionException(
                                "Please Select Book Category");
                    }

                    LocalDate id = LocalDate.parse(issueDate);
                    LocalDate rd = LocalDate.parse(returnDate);

                    if (rd.isBefore(id)) {

                        throw new InvalidDateException(
                                "Return Date Cannot Be Before Issue Date");
                    }

                    JOptionPane.showMessageDialog(
                            null,
                            "Book Issued Successfully!\n\n"
                                    + "Student Name: " + name + "\n"
                                    + "Roll Number: " + rn + "\n"
                                    + "Book Title: " + book);

                    JOptionPane.showMessageDialog(
                            null,
                            "Operation Completed");
                }

                catch (EmptyFieldException
                        | NullSelectionException
                        | InvalidDateException ex) {

                    JOptionPane.showMessageDialog(
                            null,
                            ex.getMessage());
                }

                catch (NumberFormatException ex) {

                    JOptionPane.showMessageDialog(
                            null,
                            "Roll Number Must Be Numeric");
                }

                catch (DateTimeParseException ex) {

                    JOptionPane.showMessageDialog(
                            null,
                            "Invalid Date Format\nUse YYYY-MM-DD");
                }

                finally {

                    System.out.println("Program Executed");
                }
            }
        });

        btnReset.addActionListener(e -> {

            textField_StdName.setText("");
            textField_RN.setText("");
            textField_BT.setText("");
            textField_ID.setText("");
            textField_RD.setText("");

            comboBox_BC.setSelectedIndex(0);

            radionbtn_NE.setSelected(true);
        });

        btnExit.addActionListener(e -> System.exit(0));
    }
}