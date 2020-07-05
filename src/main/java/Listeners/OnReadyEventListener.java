package Listeners;

import discord4j.core.object.entity.channel.TextChannel;
import discord4j.core.object.reaction.ReactionEmoji;

public abstract class OnReadyEventListener {

    public static void run(TextChannel generalChannel)
    {
        ReactionEmoji emoji = ReactionEmoji.unicode("\uD83D\uDC4B");
        generalChannel.createMessage("Online!").block().addReaction(emoji).block();
    }
}
