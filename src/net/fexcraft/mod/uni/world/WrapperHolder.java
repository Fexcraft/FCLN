package net.fexcraft.mod.uni.world;

import net.fexcraft.lib.common.math.V3I;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public abstract class WrapperHolder {

	public static final ConcurrentHashMap<Object, WorldW> WORLDS = new ConcurrentHashMap<>();
	public static Function<Object, WorldW> LEVEL_PROVIDER;
	public static WrapperHolder INSTANCE;

	public static WorldW getWorld(Object obj){
		if(obj == null) return null;
		if(!WORLDS.containsKey(obj)){
			WORLDS.put(obj, LEVEL_PROVIDER.apply(obj));
		}
		return WORLDS.get(obj);
	}

	public static <W extends WorldW> W getClientWorld(){
		return INSTANCE.getClientWorld0();
	}

	public abstract <W extends WorldW> W getClientWorld0();

	public static V3I getPos(Object obj){
		return INSTANCE.getPos0(obj);
	}

	public abstract V3I getPos0(Object o);

	public static CubeSide getSide(Object o){
		return INSTANCE.getSide0(o);
	}

	public abstract CubeSide getSide0(Object o);

	public static <S> S getLocalSide(CubeSide side){
		return INSTANCE.getLocalSide0(side);
	}

	public abstract <S> S getLocalSide0(CubeSide side);

	public static List<UUID> getOnlinePlayerIDs(){
		return INSTANCE.getOnlinePlayerIDs0();
	}

	public abstract List<UUID> getOnlinePlayerIDs0();

	public abstract void reset();

}
