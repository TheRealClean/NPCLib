package net.techcable.npclib.nms;

import java.util.UUID;

import com.google.common.base.Preconditions;

import net.techcable.npclib.HumanNPC;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class NMSHumanNPC extends NMSLivingNPC<IHumanNPCHook> implements HumanNPC {

    public NMSHumanNPC(NMSRegistry registry, UUID id, String name) {
        super(registry, id, name, EntityType.PLAYER);
    }

    @Override
    protected IHumanNPCHook doSpawn(Location toSpawn) {
        return NMSRegistry.getNms().spawnHumanNPC(toSpawn, this);
    }

    private UUID skin;

    @Override
    public UUID getSkin() {
        return skin;
    }

    @Override
    public void setSkin(UUID skin) {
        this.skin = skin;
        if (isSpawned()) getHook().setSkin(skin);
    }

    @Override
    public void setSkin(String skin) {
        Preconditions.checkNotNull(skin, "Skin is null");
        // Hacky uuid load
        UUID id = Bukkit.getOfflinePlayer(skin).getUniqueId();
        // If the uuid's variant is '3' than it must be an offline uuid
        Preconditions.checkArgument(id.variant() != 3, "Invalid player name %s", skin);
        setSkin(id);
    }

    private boolean showInTabList = true;

    @Override
    public void setShowInTabList(boolean show) {
        boolean wasShownInTabList = showInTabList;
        this.showInTabList = show;
        if (isSpawned() && showInTabList != wasShownInTabList) {
            if (showInTabList) {
                getHook().showInTablist();
            } else {
                getHook().hideFromTablist();
            }
        }
    }

    @Override
    public boolean isShownInTabList() {
        return showInTabList;
    }

    @Override
    public Player getEntity() {
        return (Player) getHook().getEntity();
    }
}
