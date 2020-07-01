package Listeners;

import discord4j.core.event.EventDispatcher;
import discord4j.core.event.domain.lifecycle.DisconnectEvent;
import discord4j.core.event.domain.message.MessageCreateEvent;
import discord4j.core.object.entity.channel.TextChannel;

public class OnMessageCreateListener{

    public static void run(EventDispatcher clientDispatcher, TextChannel channel)
    {
        clientDispatcher.on(MessageCreateEvent.class).subscribe(MessageCreateEvent -> {
           String messageContent = MessageCreateEvent.getMessage().getContent();
           switch(messageContent)
           {
               case "!hello":
                   channel.createMessage("Hello!").block();
                   break;
               default:
                   break;
           }
        });
    }

}
