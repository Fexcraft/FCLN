package net.fexcraft.mod.uni.ui;

import net.fexcraft.app.json.JsonMap;
import net.fexcraft.lib.common.math.V3I;
import net.fexcraft.mod.uni.tag.TagCW;
import net.fexcraft.mod.uni.world.EntityW;

import java.util.function.Consumer;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class ContainerInterface {

	public Consumer<TagCW> SEND_TO_CLIENT;
	public Consumer<TagCW> SEND_TO_SERVER;
	public UserInterface ui;//client side only
	public String uiid;
	public EntityW player;
	public JsonMap ui_map;
	public V3I pos;

	public ContainerInterface(JsonMap map, EntityW ply, V3I pos){
		ui_map = map;
		player = ply;
		this.pos = pos;
	}

	public void init(){}

	public Object get(String key, Object... objs){
		return null;
	}

	public void packet(TagCW com, boolean client){}

	public ContainerInterface set(UserInterface ui){
		this.ui = ui;
		return this;
	}

	public void onClosed(){}

	public void update(Object localcon){}

}
