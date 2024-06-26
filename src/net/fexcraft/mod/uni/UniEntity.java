package net.fexcraft.mod.uni;

import net.fexcraft.mod.uni.tag.TagCW;
import net.fexcraft.mod.uni.world.EntityW;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.function.Function;

/**
 * @author Ferdinand Calo'
 */
public class UniEntity {

	public static Function<Object, UniEntity> GETTER = null;
	public static Function<Object, EntityW> ENTITY_GETTER = null;
	private static ArrayList<Class<? extends AppData>> pclasses = new ArrayList<>();
	private static ArrayList<Class<? extends AppData>> eclasses = new ArrayList<>();
	private HashMap<Class<? extends AppData>, AppData> appended = new HashMap<>();
	public EntityW entity;

	public UniEntity(){}

	public UniEntity set(Object ent){
		entity = ENTITY_GETTER.apply(ent);
		if(entity.isPlayer()){
			for(Class<? extends AppData> clazz : pclasses){
				try{
					appended.put(clazz, clazz.newInstance());
				}
				catch(InstantiationException | IllegalAccessException e){
					throw new RuntimeException(e);
				}
			}
		}
		for(Class<? extends AppData> clazz : eclasses){
			try{
				appended.put(clazz, clazz.newInstance());
			}
			catch(InstantiationException | IllegalAccessException e){
				throw new RuntimeException(e);
			}
		}
		for(AppData val : appended.values()){
			val.init(this);
		}
		return this;
	}

	public void save(TagCW com){
		for(AppData val : appended.values()){
			TagCW tag = TagCW.create();
			val.save(this, tag);
			if(!tag.empty()){
				com.set(val.id(), tag);
			}
		}
	}

	public void load(TagCW com){
		for(AppData val : appended.values()){
			if(com.has(val.id())){
				val.load(this, com.getCompound(val.id()));
			}
		}
	}

	public static UniEntity get(Object playerent){
		return GETTER.apply(playerent);
	}

	public <AD extends AppData> AD get(String id){
		for(AppData val : appended.values()){
			if(val.id().equals(id)) return (AD)val;
		}
		return null;
	}

	public <AD extends AppData> AD get(Class<AD> clazz){
		return (AD)appended.get(clazz);
	}

	public static void register(Class<? extends AppData> clazz, boolean playeronly){
		if(playeronly){
			if(!pclasses.contains(clazz)) pclasses.add(clazz);
		}
		else{
			if(!eclasses.contains(clazz)) eclasses.add(clazz);
		}
	}

	public static interface AppData {

		public void save(UniEntity player, TagCW com);

		public void load(UniEntity player, TagCW com);

		public void init(UniEntity uniPlayer);

		public String id();

	}

}
