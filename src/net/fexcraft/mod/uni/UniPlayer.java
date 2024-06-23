package net.fexcraft.mod.uni;

import net.fexcraft.mod.uni.tag.TagCW;
import net.fexcraft.mod.uni.world.EntityW;

import java.util.function.Function;

/**
 * @author Ferdinand Calo'
 */
public class UniPlayer {

	public static Function<Object, UniPlayer> GETTER = null;
	public EntityW entity;

	public UniPlayer(){}

	public UniPlayer set(EntityW ent){
		entity = ent;
		return this;
	}

	public void save(TagCW com){

	}

	public void load(TagCW com){

	}

	public static UniPlayer get(Object playerent){
		return GETTER.apply(playerent);
	}

}
