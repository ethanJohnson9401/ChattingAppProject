import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {
    public GUI(String WindowName, int width, int height) {
        super(WindowName);

        

        // Initialize components
        

        // Set layout
        setLayout(new FlowLayout());

        // Add components to the frame
        

        // Set frame properties
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(width, height); // Set initial size
        setLocationRelativeTo(null); // Center the frame
        setVisible(true); // Make the frame visible

        // Add action listener to the button
     
        // Add key listener to text field for Enter key
        
    }

    public GUI(String WindowName, int width, int height, boolean visbility) {
        super(WindowName);

        

        // Initialize components
        

        // Set layout
        setLayout(new FlowLayout());

        // Add components to the frame
        

        // Set frame properties
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(width, height); // Set initial size
        setLocationRelativeTo(null); // Center the frame
        setVisible(visbility); // Make the frame visible

        // Add action listener to the button
     
        // Add key listener to text field for Enter key
        
    }

    

    // Static method to change background color
    public void changeBackgroundColor(Color color,JLabel label, GUI gui) {
        if (gui != null) {
            String hex =  Integer.toHexString(color.getRed()) + Integer.toHexString(color.getGreen()) + Integer.toHexString(color.getBlue());
            int value = Integer.parseInt(hex,16);
            if (value >= Integer.parseInt("505050",16)){
                changeFontColor(Color.BLACK, label);
            } else {
                changeFontColor(Color.WHITE, label);
            }
            gui.getContentPane().setBackground(color);
        }
    }

    public void changeBackgroundColor(Color color, GUI gui) {
        if (gui != null) {
            gui.getContentPane().setBackground(color);
        }
    }

    public void changeBackgroundColor(String hexString, JLabel label, GUI gui){
        if ((gui != null) && (hexString.charAt(0) == '#') && (hexString.length() == 7)){
            String parse = hexString.substring(1);
            int value = Integer.parseInt(parse,16);
            if (value >= Integer.parseInt("505050",16)){
                changeFontColor(Color.BLACK, label);
            } else {
                changeFontColor(Color.WHITE, label);
            }
            Color color = Color.decode(hexString);
            gui.getContentPane().setBackground(color);
        }
    }

    public void changeBackgroundColor(String hexString, GUI gui){
        if ((gui != null) && (hexString.charAt(0) == '#') && (hexString.length() == 7)){
            Color color = Color.decode(hexString);
            gui.getContentPane().setBackground(color);
        }
    }

    public void changeFontColor(Color color, JLabel label) {
        if (label != null && color != null) {
            label.setForeground(color);
        }
    }

    public void changeFontColor(String hexString, JLabel label) {
        if ((label != null) && (hexString.charAt(0) == '#') && (hexString.length() == 7)) {
            Color color = Color.decode(hexString);
            label.setForeground(color);
        }
    }

    
}
