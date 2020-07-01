package Commands;

import discord4j.core.object.entity.Message;
import discord4j.core.object.entity.channel.TextChannel;
import discord4j.discordjson.json.UserData;

import java.util.ArrayList;
import java.util.Random;

public class Commands {
    String[] timCommandList = new String[]{
            "!roll",
            "!coinflip",
            "!compliment",
            "!tim",
            "!welcome",
            "!help"};

    //!roll out of 100
    public void roll(TextChannel channel)
    {
        Random randomRoll = new Random();
        int roll = randomRoll.nextInt(99) + 1;
        channel.createMessage(Integer.toString(roll)).block();
    }

    //!coinflip
    public void coinFlip(TextChannel channel)
    {
        String result;
        Random r = new Random();
        int coin = r.nextInt(100)+1;
        if (coin%2 == 1)
        {
            result = "heads";
        }
        else
            result = "tails";
        channel.createMessage("The result of the coinflip is " + result).block();
    }

    private String complimentRandomizer() {
        String[] choice = new String[]{
                "You're even better than a unicorn, because you're real.",
                "You’re more helpful than you realize.",
                "Your personality is lovely.",
                "You are the most perfect you there is.",
                "I would take you out on a date if I was real.",
                "You look great today.",
                "When you say you will do something, I trust you."
        };
        Random r = new Random();
        int random = r.nextInt(choice.length);
        return choice[random];
    }

    //!compliment
    public void printCompliment(TextChannel channel)
    {
        channel.createEmbed(embed ->{
            embed.setDescription(complimentRandomizer());
        }).block();
    }

    //!tim
    public void mentionTimZhen(TextChannel channel)
    {
        channel.createMessage("<@149606618978451456> is very handsome").block();
    }

    //!welcome
    public void welcome(TextChannel channel, Message author)
    {
        channel.createMessage("Welcome <@" + author.getUserData().id() + ">").block();
    }

    //!help
    public void help(TextChannel channel)
    {
        String listOfCommands = "";
        for (String i : timCommandList)
        {
            listOfCommands += i;
            listOfCommands += '\n';
        }
        channel.createMessage(listOfCommands);
    }



}
