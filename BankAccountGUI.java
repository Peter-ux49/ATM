import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BankAccountGUI extends JFrame {
    private BankAccount bankAccount;

    private JTextField withdrawalField;
    private JTextField depositField;
    private JTextArea balanceArea;

    public BankAccountGUI() {
        super("Bank Account GUI");
        bankAccount = new BankAccount();

        withdrawalField = new JTextField(10);
        depositField = new JTextField(10);
        balanceArea = new JTextArea(10, 30);
        balanceArea.setEditable(false);

        createGUI();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void createGUI() {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Withdrawal amount:"));
        inputPanel.add(withdrawalField);
        inputPanel.add(new JLabel("Deposit amount:"));
        inputPanel.add(depositField);

        JPanel buttonPanel = new JPanel();
        JButton withdrawButton = new JButton("Withdraw");
        JButton depositButton = new JButton("Deposit");
        JButton displayButton = new JButton("Display Balance");
        JButton finishButton = new JButton("Finish");

        withdrawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double withdrawalAmount = Double.parseDouble(withdrawalField.getText());
                bankAccount.withdraw(withdrawalAmount);
                updateBalance();
            }
        });

        depositButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double depositAmount = Double.parseDouble(depositField.getText());
                bankAccount.deposit(depositAmount);
                updateBalance();
            }
        });

        displayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateBalance();
            }
        });

        finishButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Thank you, please remove your card");
                System.exit(0);
            }
        });

        buttonPanel.add(withdrawButton);
        buttonPanel.add(depositButton);
        buttonPanel.add(displayButton);
        buttonPanel.add(finishButton);

        mainPanel.add(inputPanel, BorderLayout.NORTH);
        mainPanel.add(buttonPanel, BorderLayout.CENTER);
        mainPanel.add(new JScrollPane(balanceArea), BorderLayout.SOUTH);

        add(mainPanel);
    }

    private void updateBalance() {
        balanceArea.setText("Current Balance: " + bankAccount.getBalance());
    }


    }

