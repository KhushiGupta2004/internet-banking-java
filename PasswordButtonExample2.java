import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PasswordButtonExample2 extends JFrame {
    private JTextField usernameField, passwordField;
    private JButton submitButton;

    public PasswordButtonExample2() {
        setTitle("Password Button Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        JLabel usernameLabel = new JLabel("Username:");
        usernameField = new JTextField(20);
        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField(20);
        submitButton = new JButton("Submit");

        // Add an ActionListener to the password field to check the length and format
        passwordField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (usernameField.getText().isEmpty() || passwordField.getText().isEmpty()) {
                    // Handle empty fields
                    JOptionPane.showMessageDialog(null, "Please enter both username and password.");
                    return;
                }

                if (passwordField.getText().length() < 6) {
                    // Show a popup message if the password is too short
                    JOptionPane.showMessageDialog(null, "Password must be at least 6 characters long.");
                    return;
                }

                else{
                    // Enable the submit button and open a new window
                    submitButton.setEnabled(true);
                    openNewWindow();
                }             }
        });

        add(usernameLabel);
        add(usernameField);
        add(passwordLabel);
        add(passwordField);
        add(submitButton);

        pack();
        setVisible(true);
    }

    private void openNewWindow() {
        JFrame newWindow = new JFrame("New Window");
        newWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        newWindow.setSize(300, 200);
        newWindow.setLayout(new FlowLayout());

        JButton button1 = new JButton("Credit");
        JButton button2 = new JButton("Debit");
        JButton button3 = new JButton("Transfer");

        // Add action listeners to the buttons if needed
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle button 1 click
                openCreditWindow();
            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle button 2 click
                openDebitWindow();
            }
        });

        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle button 3 click
                openTransferWindow();
            }
        });

        JLabel balanceLabel = new JLabel("Current Balance: 10000"); // Add the balance label

        newWindow.add(balanceLabel);
        newWindow.add(new JLabel("Welcome, " + usernameField.getText() + "!"));
        newWindow.add(button1);
        newWindow.add(button2);
        newWindow.add(button3);
        newWindow.setVisible(true);
    }

    private void openCreditWindow() {
        JFrame creditWindow = new JFrame("Credit Window");
        creditWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        creditWindow.setSize(300, 200);
        creditWindow.setLayout(new FlowLayout());

        // Add components for the credit window (e.g., labels, text fields, buttons)
        JLabel accountNumberLabel = new JLabel("Account Number:");
        JTextField accountNumberField = new JFormattedTextField("0000000000"); // Format as 10-digit number
        accountNumberField.setColumns(10);
        JLabel amountLabel = new JLabel("Amount:");
        JTextField amountField = new JTextField(20);
        JButton creditButton = new JButton("Credit");

        // Add action listener to the credit button
        creditButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle credit button click
                try {
                    int accountNumber = Integer.parseInt(accountNumberField.getText());
                    int amount = Integer.parseInt(amountField.getText());
                    if (amount > 10000) {
                        JOptionPane.showMessageDialog(null, "Cannot credit more than 10000.");
                    } else {
                        // Implement your credit logic here (including account number validation)
                        JOptionPane.showMessageDialog(null, "Credited " + amountField.getText() + "' to account number " + accountNumber+"Net Balance:"+(10000-amount));
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid account number or amount.");
                }
            }
        });

        creditWindow.add(accountNumberLabel);
        creditWindow.add(accountNumberField);
        creditWindow.add(amountLabel);
        creditWindow.add(amountField);
        creditWindow.add(creditButton);

        creditWindow.setVisible(true);
    }

    private void openDebitWindow() {
        JFrame debitWindow = new JFrame("Debit Window");
        debitWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        debitWindow.setSize(300, 200);
        debitWindow.setLayout(new FlowLayout());

        // Add components for the debit window (e.g., labels, text fields, buttons)
        JLabel amountLabel = new JLabel("Amount:");
        JTextField amountField = new JTextField(20);
        JButton debitButton = new JButton("Debit");

        // Add action listener to the debit button
        debitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle debit button click
                try {
                    int amount = Integer.parseInt(amountField.getText());
                    if (amount > 10000) {
                        JOptionPane.showMessageDialog(null, "Cannot debit more than 10000.");
                    } else {
                        // Implement your debit logic here
                        JOptionPane.showMessageDialog(null, "Debited " + amountField.getText() +"   Net Balance:"+(10000+amount));
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid amount.");
                }
            }
        });

        debitWindow.add(amountLabel);
        debitWindow.add(amountField);
        debitWindow.add(debitButton);

        debitWindow.setVisible(true);
    }

    private void openTransferWindow() {
        JFrame transferWindow = new JFrame("Transfer Window");
        transferWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        transferWindow.setSize(300, 200);
        transferWindow.setLayout(new FlowLayout());

        // Add components for the transfer window (e.g., labels, text fields, buttons)
        JLabel accountNumberLabel = new JLabel("Account Number:");
        JTextField accountNumberField = new JFormattedTextField("0000000000");
accountNumberField.setColumns(10);
        JLabel amountLabel = new JLabel("Amount:");
        JTextField amountField = new JTextField(20);
        JButton transferButton = new JButton("Transfer");

        // Add action listener to the transfer button
        transferButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle transfer button click
                try {
int accountNumber = Integer.parseInt(accountNumberField.getText());
                    int amount = Integer.parseInt(amountField.getText());
                    if (amount > 10000) {
                        JOptionPane.showMessageDialog(null, "Cannot transfer more than 10000.");
                    } else {
                        // Implement your transfer logic here
                        JOptionPane.showMessageDialog(null, "Transfer of "+amountField.getText()+" to Acc no.: "+accountNumber+" successful!    "+"Net bal: "+(10000-amount));
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid amount.");
                }
            }
        });

        transferWindow.add(accountNumberLabel);
        transferWindow.add(accountNumberField);
        transferWindow.add(amountLabel);
        transferWindow.add(amountField);
        transferWindow.add(transferButton);

        transferWindow.setVisible(true);
    }

    private boolean isPasswordValid(String password) {
        // Implement your password validation logic here
        // For example, you can check for specific character requirements
        return password.matches("[A-Za-z0-9]{6}"); // Matches 6 alphanumeric characters
    }

    public static void main(String[] args) {
        new PasswordButtonExample();
    }
}