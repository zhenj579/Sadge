package Listeners;

import discord4j.common.util.Snowflake;
import discord4j.core.event.EventDispatcher;
import discord4j.core.event.domain.message.ReactionRemoveEvent;
import discord4j.core.object.entity.Guild;

public abstract class OnReactionRemoveEventListener {

    public static void run(EventDispatcher clientDispatcher, Guild guild, Snowflake roleSnowflake)
    {
        clientDispatcher.on(ReactionRemoveEvent.class).subscribe(ReactionRemoveEvent -> {
            
        });
    }
}
