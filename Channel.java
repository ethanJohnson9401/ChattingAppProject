import javax.swing.*;
import java.awt.event.*;

public class Channel extends GUI{

    GUI m_channel;
    JLabel m_label;
    String[] options = {"Sports","1","2"};
    JComboBox<String> m_dropdown = new JComboBox<>(options);
    String username;
    SportsChat m_sports;
    
    public Channel() {
        super("Channel Select", 200, 200, false);
        m_channel = this;
        add(m_dropdown);

        m_dropdown.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get the selected item
                int selectedItem = (int) m_dropdown.getSelectedIndex();
                // Display the selected item
                switch (selectedItem) {
                    case 0:
                        m_sports = new SportsChat(username);
                        break;
                    
                    case 1:

                        break;

                    case 2:
                        
                        break;
                
                    default:
                        break;
                }
            }
        });

    }

    public void setChannel(boolean b, String name){
        username = name;
        m_label = new JLabel("Welcome, " + name);
        add(m_label);
        setVisible(b);
    }

}