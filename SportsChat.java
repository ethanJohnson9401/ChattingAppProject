import java.awt.Color;

public class SportsChat extends Chat {

    Chat m_sportsChat;
    
    public SportsChat(String name){
        super(name, "Sports", 600, 600);
        m_sportsChat = this;
        m_sportsChat.changeChatBackgroundColor(Color.lightGray);

    }

}
