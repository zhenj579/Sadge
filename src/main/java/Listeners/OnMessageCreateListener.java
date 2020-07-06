package Listeners;

import Commands.Commands;
import discord4j.common.util.Snowflake;
import discord4j.core.GatewayDiscordClient;
import discord4j.core.event.EventDispatcher;
import discord4j.core.event.domain.Event;
import discord4j.core.event.domain.lifecycle.DisconnectEvent;
import discord4j.core.event.domain.message.MessageCreateEvent;
import discord4j.core.object.entity.channel.TextChannel;

public abstract class OnMessageCreateListener{

    public static void run(GatewayDiscordClient gateway, TextChannel channel)
    {
        EventDispatcher clientDispatcher = gateway.getEventDispatcher();
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
                   Commands.listCommands(channel);
                   break;
               case "!disconnect":
                   Commands.disconnect(gateway, channel);
                   break;
               case "!leky":
                   Commands.leky(channel);
                   break;
               case "!makeRole":
                   Commands.makeRole(gateway.getGuildById(Snowflake.of("724757461944238100")).block(), channel);
               default:
                   break;
           }
        });
    }

}
