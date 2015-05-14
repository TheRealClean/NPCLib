package net.techcable.npclib;

import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

import java.util.UUID;

/**
 * Represents a human non player controlled entity
 *
 *
 *
 * @author Techcable
 * @since 2.0
 * @version 2.0
 */
public interface HumanNPC extends LivingNPC {

    /**
     * Return this npc's skin
     *
     * A value of null represents a steve skin
     *
     * @return this npc's skin
     */
    public UUID getSkin();

    /**
     * Set the npc's skin
     *
     * A value of null represents a steve skin
     *
     * @param skin the player id with the skin you want
     *
     * @throws UnsupportedOperationException if skins aren't supported
     */
    public void setSkin(UUID skin);

    /**
     * Set the npc's skin
     *
     * A value f null represents a steve skin
     *
     * @param skin the player name with the skin you want
     *
     * @throws UnsupportedOperationException if skins aren't supported
     */
    public void setSkin(String skin);

    /**
     * Get the entity associated with this npc
     *
     * @return the entity
     */
    @Override
    public Player getEntity();

    /**
     * Set if the npc is shown in the tab list
     *
     * @param show whether or not to show this npc in the tab list
     */
    public void setShowInTabList(boolean show);

    /**
     * Return if the npc is shown in the tab list
     *
     * @return true if the npc is shown in the tab list
     */
    public boolean isShownInTabList();
}
