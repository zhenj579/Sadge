package Commands;

import discord4j.common.util.Snowflake;
import discord4j.core.GatewayDiscordClient;
import discord4j.core.object.entity.Guild;
import discord4j.core.object.entity.Message;
import discord4j.core.object.entity.Role;
import discord4j.core.object.entity.User;
import discord4j.core.object.entity.channel.TextChannel;
import discord4j.core.spec.RoleCreateSpec;
import discord4j.discordjson.json.UserData;
import discord4j.rest.util.Color;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public abstract class Commands {
    public static final String[] timCommandList = new String[]{
            "!roll",
            "!coinflip",
            "!compliment",
            "!tim",
            "!welcome",
            "!help",
            "!squadw"};

    public static void onReady(TextChannel channel)
    {
        channel.createMessage("Online!").block();
    }

    public static void disconnect(GatewayDiscordClient gateway, TextChannel channel)
    {
        channel.createMessage("Disconnecting!").block();
        gateway.logout().block();
    }

    //!roll out of 100
    public static void roll(TextChannel channel)
    {
        Random randomRoll = new Random();
        int roll = randomRoll.nextInt(99) + 1;
        channel.createMessage(Integer.toString(roll)).block();
    }

    //!coinflip
    public static void coinFlip(TextChannel channel)
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

    private static String complimentRandomizer() {
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
    public static void printCompliment(TextChannel channel)
    {
        channel.createEmbed(embed ->{
            embed.setDescription(complimentRandomizer());
        }).block();
    }

    //!tim
    public static void mentionTim(TextChannel channel)
    {
        channel.createMessage("<@149606618978451456> is balding <:kekw:725855517758455862>").block();
    }

    //!welcome
    public static void welcome(TextChannel channel, Message author)
    {
        channel.createMessage("Welcome <@" + author.getUserData().id() + ">").block();
    }

    //!help
    public static void listCommands(TextChannel channel)
    {
        String listCommands = "";
        for (String s : timCommandList) {
            listCommands += s;
            listCommands += "\n";
        }
        String finalListCommands = listCommands;
        channel.createEmbed(cmds ->{
            cmds.setTitle("Commands: ")
                .setDescription(finalListCommands);
        }).block();
    }

    public static void leky(TextChannel channel)
    {
        channel.createMessage("Hi <@149606618978451456> <:kekw:725855517758455862>").block();
    }

    public static void makeRole(Guild guild, TextChannel general)
    {
        boolean roleExists = false;
        List<Role> roles = guild.getRoles().collectList().block();
        for(Role r : roles)
        {
            if(r.getName().equals("trihard"))
            {
                roleExists = true;
                general.createMessage(r.getMention() + " has been deleted!").block();
                r.delete("Role exists").block();
            }
        }
        if(!roleExists)
        {
            Role test = guild.createRole(spec -> {
                spec.setColor(Color.of(24,150,32));
                spec.setMentionable(true);
                spec.setName("test");
            }).block();
            general.createMessage(test.getMention() + " has been created!").block();
        }
    }

    public static void squadW()
    {

    }



}
