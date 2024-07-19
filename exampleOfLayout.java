import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class exampleOfLayout extends JFrame {
    
    private JPanel messagePanel;
    private JTextField messageInput;
    private JButton sendButton;

    public exampleOfLayout() {
        // Set up the frame
        setTitle("Texting App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 600);
        setLayout(new BorderLayout());

        // Message panel with BoxLayout
        messagePanel = new JPanel();
        messagePanel.setLayout(new BoxLayout(messagePanel, BoxLayout.Y_AXIS));
        JScrollPane scrollPane = new JScrollPane(messagePanel);
        add(scrollPane, BorderLayout.CENTER);

        // Input panel at the bottom
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BorderLayout());
        messageInput = new JTextField();
        sendButton = new JButton("Send");
        inputPanel.add(messageInput, BorderLayout.CENTER);
        inputPanel.add(sendButton, BorderLayout.EAST);
        add(inputPanel, BorderLayout.SOUTH);

        // Action listener for the send button
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage();
            }
        });

        // Action listener for the message input field (press Enter to send)
        messageInput.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage();
            }
        });
    }

    private void sendMessage() {
        String message = messageInput.getText();
        if (!message.isEmpty()) {
            JLabel messageLabel = new JLabel(message);
            messageLabel.setOpaque(true);
            messageLabel.setBackground(Color.LIGHT_GRAY);
            messageLabel.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
            messagePanel.add(messageLabel);
            messagePanel.revalidate();
            messageInput.setText("");
            JScrollBar vertical = ((JScrollPane) messagePanel.getParent().getParent()).getVerticalScrollBar();
            vertical.setValue(vertical.getMaximum());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                exampleOfLayout app = new exampleOfLayout();
                app.setVisible(true);
            }
        });
    }
}
