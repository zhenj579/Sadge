import Listeners.OnMessageCreateListener;
import Utility.Utility;
import discord4j.core.DiscordClient;
import discord4j.core.GatewayDiscordClient;
import discord4j.core.event.EventDispatcher;
import discord4j.core.event.domain.message.MessageCreateEvent;
import discord4j.core.object.entity.Message;
import discord4j.core.object.entity.channel.TextChannel;

public class Sadge {

    private final DiscordClient client;
    private final GatewayDiscordClient gateway;
    private final EventDispatcher eventDispatcher;
    private final Utility utility;

    public Sadge(String token)
    {
        client = DiscordClient.create(token);
        gateway = client.login().block();
        eventDispatcher = gateway.getEventDispatcher();
        utility = new Utility(gateway);
    }

    public void start()
    {
        listen();
        gateway.onDisconnect().block();
    }

    private void listen()
    {
        OnMessageCreateListener.run(eventDispatcher, (TextChannel)utility.getGeneralChannel());
        eventDispatcher.on(MessageCreateEvent.class).subscribe(messageCreateEvent -> {
            String messageContent = messageCreateEvent.getMessage().getContent();
            if(messageContent.equals("!disconnect"))
            {
                disconnect();
            }
        });
    }

    private void disconnect()
    {
        gateway.logout().block();
    }

    public static void main(String args[])
    {
        Sadge sadge = new Sadge("NzI0NzU0MTU1NjQxNTAzODA0.XviWmg._v0TY1r_Hs8xDGSGK90mtsE_QaU");
        sadge.start();
    }

}
