package net.techcable.npclib.nms.versions.v1_8_R1.network;

import lombok.*;

import java.lang.reflect.Field;

import net.minecraft.server.v1_8_R1.EnumProtocolDirection;
import net.minecraft.server.v1_8_R1.NetworkManager;
import net.techcable.npclib.utils.Reflection;

@Getter
public class NPCNetworkManager extends NetworkManager {

    public NPCNetworkManager() {
        super(EnumProtocolDirection.CLIENTBOUND); //MCP = isClientSide ---- SRG=field_150747_h
        Field channel = Reflection.makeField(NetworkManager.class, "i"); //MCP = channel ---- SRG=field_150746_k
        Field address = Reflection.makeField(NetworkManager.class, "j"); //MCP = address ---- SRG=field_77527_e

        Reflection.setField(channel, this, new NullChannel());
        Reflection.setField(address, this, new NullSocketAddress());

    }

}
