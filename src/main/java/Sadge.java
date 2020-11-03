import Listeners.OnMessageCreateListener;
import Listeners.OnReactionAddEventListener;
import Listeners.OnReadyEventListener;
import Utility.Utility;
import discord4j.common.util.Snowflake;
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
        OnReadyEventListener.run(utility.getGeneralChannel());
        OnMessageCreateListener.run(gateway, utility.getGeneralChannel());
        OnReactionAddEventListener.run(eventDispatcher, utility.getGuildSnowflake(), utility.getTestRoleSnowflake());
    }

    public static void main(String args[])
    {
        Sadge sadge = new Sadge("token");
        sadge.start();
    }

}
