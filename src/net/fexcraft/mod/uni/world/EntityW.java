package net.fexcraft.mod.uni.world;

import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.lib.common.math.V3I;
import net.fexcraft.mod.uni.item.StackWrapper;
import net.fexcraft.mod.uni.ui.UIKey;

import java.util.UUID;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public interface EntityW extends MessageSender {

	public boolean isOnClient();

	public int getId();

	public WorldW getWorld();

	public boolean isPlayer();

	public boolean isAnimal();

	public boolean isHostile();

	public boolean isLiving();

	public boolean isRiding();

	public String getRegName();

	public <E> E local();

	public Object direct();

	public V3D getPos();

	public void decreaseXZMotion(double x);

	public void setYawPitch(float oyaw, float opitch, float yaw, float pitch);

	public void openUI(String id, V3I pos);

	public void openUI(UIKey key, V3I pos);

	public void drop(StackWrapper stack, float height);

	public boolean isCreative();

	public UUID getUUID();

	public StackWrapper getHeldItem(boolean main);

	public void closeUI();

	public String dimid();

	public int dim12();

}
