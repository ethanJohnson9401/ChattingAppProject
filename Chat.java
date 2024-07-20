import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Chat extends GUI{

    GUI m_chat;
    private JPanel messagePanel;
    private JTextField messageInput;
    private JButton sendButton;

    private void sendMessage(String username) {
        String message = messageInput.getText();
        if (!message.isEmpty()) {
            // Create a panel for each message
            JPanel messageContainer = new JPanel();
            messageContainer.setLayout(new BorderLayout());
            messageContainer.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
            
            // Username and timestamp
            JLabel userLabel = new JLabel(username + " | " + getCurrentTime());
            userLabel.setFont(new Font("Arial", Font.PLAIN, 10));
            if (getChatBackgroundColor() >= Integer.parseInt("505050",16)){
                userLabel.setForeground(Color.BLACK);
            } else {
                userLabel.setForeground(Color.WHITE);
            }
            messageContainer.add(userLabel, BorderLayout.NORTH);
            
            // Message text
            JTextArea messageTextArea = new JTextArea(message);
            messageTextArea.setEditable(false);
            messageTextArea.setLineWrap(true);
            messageTextArea.setWrapStyleWord(true);
            if (this.messagePanel.getBackground() == Color.lightGray){
                messageTextArea.setBackground(Color.DARK_GRAY);
                messageTextArea.setForeground(Color.lightGray);
            } else {
                messageTextArea.setBackground(Color.lightGray);
                messageTextArea.setForeground(Color.DARK_GRAY);
            }
            JScrollPane messageScrollPane = new JScrollPane(messageTextArea);
            messageScrollPane.setBorder(BorderFactory.createEmptyBorder());
            messageContainer.add(messageScrollPane, BorderLayout.CENTER);
    
            // Add the message container to the message panel
            messagePanel.add(messageContainer);
            messagePanel.add(Box.createVerticalStrut(5)); // Add some space between messages
            messagePanel.revalidate();
            messageInput.setText("");
    
            // Scroll to the bottom
            SwingUtilities.invokeLater(() -> {
                JScrollBar vertical = messageScrollPane.getVerticalScrollBar();
                vertical.setValue(vertical.getMaximum());
            });
        }
    }
    


    private String getCurrentTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        return sdf.format(new Date());
    }

    public void changeChatBackgroundColor(Color color){
        this.messagePanel.setBackground(color);
    }

    public void changeChatBackgroundColor(String hexString){
        if ((hexString.charAt(0) == '#') && (hexString.length() == 7)){
            Color color = Color.decode(hexString);
            this.messagePanel.setBackground(color);
        }
    }

    public int getChatBackgroundColor(){
        Color color = this.messagePanel.getBackground();
        String hex =  Integer.toHexString(color.getRed()) + Integer.toHexString(color.getGreen()) + Integer.toHexString(color.getBlue());
        return Integer.parseInt(hex,16);
    }
    
    public Chat(String name, String WindowName, int width, int height){
        super(WindowName, width, height);
        m_chat = this;
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
                sendMessage(name);
            }
        });

        // Action listener for the message input field (press Enter to send)
        messageInput.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage(name);
            }
        });

        
    }

}
