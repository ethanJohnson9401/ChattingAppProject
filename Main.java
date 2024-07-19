import javax.swing.*;

import java.awt.event.ActionListener;

import java.awt.event.KeyEvent;



public class Main {

    static GUI m_gui;
    static Channel m_channel;
    private static JLabel label;
    private static JTextField textField;
    private static JButton button;

    public static void submitAction(JTextField textField, Channel channel, GUI indexGUI) {
        GUI message = new GUI(textField.getText(), 200, 150);
        JLabel label = new JLabel("Hello, " + textField.getText() + "!");
        JButton button = new JButton("Okay");
        String username = textField.getText();
        message.add(label);
        message.add(button);
        

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e){
                message.dispose();
                channel.setChannel(true, username);
                indexGUI.dispose();
            }
        });

        textField.setText(""); // Clear the text field after submission
    }
    
     public static void main(String[] args) {

        // Create GUI on the Event Dispatch Thread (EDT)
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Chat m_chat = new Chat("Example");
                m_gui = new GUI("GUI",300,300);
                label = new JLabel("Enter your name:");
                textField = new JTextField(20);
                button = new JButton("Submit");
                m_channel = new Channel();
                m_gui.add(label);
                m_gui.add(textField);
                m_gui.add(button);

                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(java.awt.event.ActionEvent e) {
                        submitAction(textField,m_channel, m_gui);
                    }
                });
                

                textField.addKeyListener(new java.awt.event.KeyListener() {
                    @Override
                    public void keyPressed(KeyEvent e) {
                        if (e.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
                            submitAction(textField,m_channel, m_gui);
                        }
                    }
                
                    @Override
                    public void keyTyped(KeyEvent e) {
                        // Not needed for your case, but must be implemented
                    }
                
                    @Override
                    public void keyReleased(KeyEvent e) {
                        // Not needed for your case, but must be implemented
                    }
                });
                


                m_gui.changeBackgroundColor("#353535", label, m_gui);
            }
        });
    }

    
    

}
