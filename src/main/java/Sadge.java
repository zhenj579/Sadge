import discord4j.common.util.Snowflake;
import discord4j.core.DiscordClient;
import discord4j.core.GatewayDiscordClient;
import discord4j.core.object.entity.channel.TextChannel;

public class Sadge {

    private final DiscordClient client;
    private final GatewayDiscordClient gateway;
    private final Utility utility;

    public Sadge(String token)
    {
        client = DiscordClient.create(token);
        gateway = client.login().block();
        utility = new Utility(gateway);
        start();
        gateway.onDisconnect().block();
    }

    private void start()
    {
        TextChannel generalChannel = (TextChannel) utility.getGeneralChannel();
        generalChannel.createMessage("Online!").block();

    }

    private void disconnect()
    {
        gateway.logout().block();
    }

    public static void main(String args[])
    {
        Sadge sadge = new Sadge("NzI0NzU0MTU1NjQxNTAzODA0.XviWmg._v0TY1r_Hs8xDGSGK90mtsE_QaU");
    }

}
