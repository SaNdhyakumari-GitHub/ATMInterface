
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

    public class ATMInterfaceGUI implements ActionListener {
        private JFrame frame;
        private JPanel panel;
        private JLabel balanceLabel;
        private JButton TransactionsHistoryButton, withdrawButton, depositButton, TransferButton, QuitButton;

        private double balance = 1000; // initial balance

        public ATMInterfaceGUI() {
            frame = new JFrame("ATM Interface");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 200);

            panel = new JPanel();
            panel.setLayout(new GridLayout(4, 1));

            balanceLabel = new JLabel("Your balance is " + balance, JLabel.CENTER);
            panel.add(balanceLabel);

            TransactionsHistoryButton= new JButton("Check Balance");
            TransactionsHistoryButton.addActionListener(this);
            panel.add(TransactionsHistoryButton);

            withdrawButton = new JButton("Withdraw");
            withdrawButton.addActionListener(this);
            panel.add(withdrawButton);

            depositButton = new JButton("Deposit");
            depositButton.addActionListener(this);
            panel.add(depositButton);

            TransferButton = new JButton("Transfer");
            TransferButton.addActionListener(this);
            panel.add(TransferButton);

            QuitButton = new JButton("Quit");
            QuitButton.addActionListener(this);
            panel.add(QuitButton);


            frame.add(panel);
            frame.setVisible(true);
        }

        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == TransactionsHistoryButton) {
                JOptionPane.showMessageDialog(frame, "Your balance is " + balance);
            } else if (e.getSource() == withdrawButton) {
                String input = JOptionPane.showInputDialog(frame, "Enter amount to withdraw:");
                double amount = Double.parseDouble(input);
                if (balance >= amount) {
                    balance -= amount;
                    balanceLabel.setText("Your balance is " + balance);
                    JOptionPane.showMessageDialog(frame, "You have withdrawn " + amount + ". Your new balance is " + balance);
                } else {
                    JOptionPane.showMessageDialog(frame, "Insufficient funds.");
                }
            } else if (e.getSource() == depositButton) {
                String input = JOptionPane.showInputDialog(frame, "Enter amount to deposit:");
                double amount = Double.parseDouble(input);
                balance += amount;
                balanceLabel.setText("Your balance is " + balance);
                JOptionPane.showMessageDialog(frame, "You have deposited " + amount + ". Your new balance is " + balance);
            } else if(e.getSource() == TransferButton) {
                String input = JOptionPane.showInputDialog(frame, "Enter amount that to be transfer:");
                double amount = Double.parseDouble(input);
                 if (balance >= amount) {
                     balance -= amount;
                     balanceLabel.setText("Your balance is " + balance);
                     JOptionPane.showMessageDialog(frame, "You have transfer " + amount + ". Your new balance is " + balance);
                 } else {
                     JOptionPane.showMessageDialog(frame, "Insufficient funds.");
                 }
            } else if (e.getSource() == QuitButton) {
                String input = JOptionPane.showInputDialog(frame, "Are you sure you want to quit?");
                double amount = Double.parseDouble(input);

                   frame.dispose();
                }
        }

        public static void main(String[] args) {
            new ATMInterfaceGUI();
        }
    }
