package Listeners;

import Commands.Commands;
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
               case "!roll":
                   Commands.roll(channel);
                   break;
               case "!coinflip":
                   Commands.coinFlip(channel);
                   break;
               case "!compliment":
                   Commands.printCompliment(channel);
                   break;
               case "!tim":
                   Commands.mentionTim(channel);
                   break;
               case "!welcome":
                   Commands.welcome(channel, MessageCreateEvent.getMessage());
                   break;
               case "!help":
                   Commands.help(channel);
                   break;
               default:
                   break;
           }
        });
    }

}
