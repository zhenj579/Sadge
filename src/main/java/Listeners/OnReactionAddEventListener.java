package Listeners;

import discord4j.common.util.Snowflake;
import discord4j.core.event.EventDispatcher;
import discord4j.core.event.domain.message.ReactionAddEvent;
import discord4j.core.object.entity.Member;
import discord4j.core.object.entity.Role;
import discord4j.core.object.entity.User;
import discord4j.core.object.entity.channel.MessageChannel;

public abstract class OnReactionAddEventListener {

    public static void run(EventDispatcher dispatcher, Snowflake guild, Snowflake roleSnowflake)
    {
        dispatcher.on(ReactionAddEvent.class).subscribe(ReactionAddEvent -> {
            User user = ReactionAddEvent.getUser().block();
            if(user.isBot()) return;
            Member member = user.asMember(guild).block();
            MessageChannel generalChannel = ReactionAddEvent.getChannel().block();
            boolean hasRole = false;
            for(Role role : member.getRoles().collectList().block())
            {
                if(role.getId().toString().equals(roleSnowflake.toString())) hasRole = true;
            }
            if(!hasRole)
            {
                member.addRole(roleSnowflake).block();
                generalChannel.createMessage("Assigned user: " + user.getMention() + " test role! ").block();
            }
            else
            {
                member.removeRole(roleSnowflake).block();
                generalChannel.createMessage("Removed test role from user: " + user.getMention()).block();
            }
        });
    }
}
