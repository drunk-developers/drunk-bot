package drinkalot.bot.drunk;

import java.io.FileInputStream;
import java.util.Properties;

public class MyBotMain {
    
    public static void main(String[] args) throws Exception {

        Properties p = new Properties();
        p.load(new FileInputStream("irc.properties"));

        // Now start our bot up.
        DrunkBot bot = new DrunkBot();
        
        // Enable debugging output.
        bot.setVerbose(true);
        
        // Connect to the IRC server.
        bot.connect(p.getProperty("irc.server.location"),
                    Integer.parseInt(p.getProperty("irc.server.port")),
                    p.getProperty("irc.server.password"));

        bot.joinChannel(p.getProperty("irc.server.channel"));
    }
}
