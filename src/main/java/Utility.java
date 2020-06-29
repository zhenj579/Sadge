import discord4j.common.util.Snowflake;
import discord4j.core.GatewayDiscordClient;
import discord4j.core.object.entity.Role;
import discord4j.core.object.entity.channel.Channel;

import java.util.List;

public class Utility {
    private final String guildID;
    private final String generalChannelID;
    private final Snowflake guildSnowflake;
    private final Snowflake generalChannelSnowflake;
    private final Channel generalChannel;
    private final List<Role> roles;

    public Utility(GatewayDiscordClient gateway)
    {
        guildID = "724757461944238100";
        generalChannelID = "724757461944238103";
        guildSnowflake = Snowflake.of(guildID);
        generalChannelSnowflake = Snowflake.of(generalChannelID);
        roles = gateway.getGuildRoles(guildSnowflake).collectList().block();
        generalChannel = gateway.getChannelById(generalChannelSnowflake).block();
    }

    public final Snowflake getGuildSnowflake()
    {
        return guildSnowflake;
    }
    public final Snowflake getGeneralChannelSnowflake() { return generalChannelSnowflake; }
    public final String getGeneralChannelID() { return generalChannelID; }
    public final String getGuildID() { return guildID; }
    public final List<Role> getRoles() { return roles; }
    public final Channel getGeneralChannel() { return generalChannel; }
}
