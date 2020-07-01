package Commands;

import discord4j.core.object.entity.channel.TextChannel;


public class Commands {


    public static void onReady(TextChannel channel)
    {
        channel.createMessage("Online!").block();
    }

}
