package drinkalot.bot.drunk;

import org.jibble.pircbot.*;

import java.util.Calendar;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Random;

public class DrunkBot extends PircBot {

    public DrunkBot() {
        this.setName("DrunkBot");
    }

    public Calendar calculateNextFridayAt18PM() {

        Calendar nextFridayAt18PM = Calendar.getInstance();

        nextFridayAt18PM.set(Calendar.HOUR_OF_DAY, 18);
        nextFridayAt18PM.set(Calendar.MINUTE, 0);
        nextFridayAt18PM.set(Calendar.SECOND, 0);

        while (nextFridayAt18PM.get(Calendar.DAY_OF_WEEK) != Calendar.FRIDAY) {
            nextFridayAt18PM.add(Calendar.DAY_OF_MONTH, 1);
        }

        return nextFridayAt18PM;
    }

    public String getInsult() {
        String insult = "You heathen swine";

        try {
            URL yahoo = new URL("http://www.webinsult.com/");
            BufferedReader bf = new BufferedReader(new InputStreamReader(yahoo.openStream()));
            String inputLine;

            while ((inputLine = bf.readLine()) != null) {
                if (inputLine.contains("class=\"insult\" id=\"insult\"")) {
                    insult = inputLine.substring(inputLine.lastIndexOf("\">") + 2, inputLine.lastIndexOf("</div>"));
                    break;
                }
            }
            bf.close();
            
        } catch (Exception ex) {
            //DO NOTHING
        }

        return insult;
    }

    public void onMessage(String channel, String sender, String login, String hostname, String message) {

        String time = new java.util.Date().toString();
        Calendar now = Calendar.getInstance();
        Calendar nextFridayAt18PM = calculateNextFridayAt18PM();
        Random generator = new Random();

       if (generator.nextInt(10)<5 ){
            sendMessage(channel, sender + ", " + getInsult());
            return;
       }

        if (message.equalsIgnoreCase("time")) {
            sendMessage(channel, sender + ": The time is now " + time);

        } else if (message.toLowerCase().contains("jolas")) {

            long timeLeftToBeer = (nextFridayAt18PM.getTimeInMillis() - now.getTimeInMillis()) / (1000 * 60);
            sendMessage(channel, "Still " + timeLeftToBeer + " minutes left to drink beer :-(");
        }

    }
}
