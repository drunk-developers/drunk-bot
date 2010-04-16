import org.jibble.pircbot.*;

public class DrunkBotInstance {
    
    public static void main(String[] args) throws Exception {
        
        // Now start our bot up.
        DrunkBot bot = new DrunkBot();
        
        // Enable debugging output.
        bot.setVerbose(true);
        
        // Connect to the IRC server.
        bot.connect("irc.sgpice.sa",6667,"pmelink");

        bot.joinChannel("#aa");
    }
}
