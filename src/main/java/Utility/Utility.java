package Utility;

import discord4j.common.util.Snowflake;
import discord4j.core.GatewayDiscordClient;
import discord4j.core.object.entity.Guild;
import discord4j.core.object.entity.Role;
import discord4j.core.object.entity.channel.Channel;
import discord4j.core.object.entity.channel.TextChannel;

import java.util.List;

public class Utility {
    private final String guildID;
    private final String generalChannelID;
    private final String testRoleID;
    private final Snowflake guildSnowflake;
    private final Snowflake generalChannelSnowflake;
    private final Snowflake testRoleSnowflake;
    private final TextChannel generalChannel;
    private final Guild guild;
    private final List<Role> roles;

    public Utility(GatewayDiscordClient gateway)
    {
        guildID = "724757461944238100";
        generalChannelID = "724757461944238103";
        testRoleID = "725839870634885251";
        guildSnowflake = Snowflake.of(guildID);
        testRoleSnowflake = Snowflake.of(testRoleID);
        generalChannelSnowflake = Snowflake.of(generalChannelID);
        roles = gateway.getGuildRoles(guildSnowflake).collectList().block();
        generalChannel = gateway.getChannelById(generalChannelSnowflake).ofType(TextChannel.class).block();
        guild = gateway.getGuildById(guildSnowflake).block();
    }

    public final Snowflake getGuildSnowflake()
    {
        return guildSnowflake;
    }
    public final Snowflake getGeneralChannelSnowflake() { return generalChannelSnowflake; }
    public final Snowflake getTestRoleSnowflake() { return testRoleSnowflake; }
    public final String getGeneralChannelID() { return generalChannelID; }
    public final String getGuildID() { return guildID; }
    public final String getTestRoleID() { return testRoleID; }
    public final List<Role> getRoles() { return roles; }
    public final TextChannel getGeneralChannel() { return generalChannel; }
}
