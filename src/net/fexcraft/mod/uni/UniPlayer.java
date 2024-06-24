package net.fexcraft.mod.uni;

import net.fexcraft.mod.uni.tag.TagCW;
import net.fexcraft.mod.uni.world.EntityW;
import scala.App;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * @author Ferdinand Calo'
 */
public class UniPlayer {

	public static Function<Object, UniPlayer> GETTER = null;
	private static HashMap<Class<? extends AppData>, AppData> appended = new HashMap<>();
	private static ArrayList<Class<? extends AppData>> classes = new ArrayList<>();
	public EntityW entity;

	public UniPlayer(){
		for(Class<? extends AppData> clazz : classes){
			try{
				appended.put(clazz, clazz.newInstance());
			}
			catch(InstantiationException | IllegalAccessException e){
				throw new RuntimeException(e);
			}
		}
	}

	public UniPlayer set(EntityW ent){
		entity = ent;
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

	public static UniPlayer get(Object playerent){
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

	public static void register(Class<? extends AppData> clazz){
		if(!classes.contains(clazz)) classes.add(clazz);
	}

	public static interface AppData {

		public void save(UniPlayer player, TagCW com);

		public void load(UniPlayer player, TagCW com);

		public String id();

	}

}
