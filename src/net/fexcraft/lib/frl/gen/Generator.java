package net.fexcraft.lib.frl.gen;

import java.util.ArrayList;

import net.fexcraft.lib.common.math.Vec3f;
import net.fexcraft.lib.frl.GLO;
import net.fexcraft.lib.frl.Polyhedron;

/**
 * 
 * @author Ferdinand Calo' (FEX___96)
 *
 * @param <GL>
 */
public class Generator<GL extends GLO> {

	protected static final Vec3f NULL_VEC = new Vec3f(0, 0, 0);
	
	protected Polyhedron<GL> poly;
	protected ValueMap map = new ValueMap();
	
	public Generator(Polyhedron<GL> poli){
		if(poli != null) poly = poli;
		else poly = new Polyhedron<>();
	}
	
	public Generator(Polyhedron<GL> poli, float texW, float texH){
		this(poli);
		map.put("texture_width", texW);
		map.put("texture_height", texH);
	}
	
	public Generator(Polyhedron<GL> poli, float texW, float texH, Type type){
		this(poli, texW, texH);
		map.put("type", type);
	}
	
	public Generator(Polyhedron<GL> poli, Type type){
		this(poli, 0, 0, type);
	}

	public Polyhedron<GL> get(){
		return poly;
	}
	
	public Polyhedron<GL> make(){
		Type type = map.getValue("type", Type.NONE);
		switch(type){
			case CYLINDER:{
				Generator_Cylinder.make(poly, map);
				break;
			}
			case CUBOID:{
				Generator_Cuboid.make(poly, map);
				break;
			}
			default: break;
		}
		return poly;
	}
	
	public Generator<GL> setValue(String key, Object value){
		map.put(key, value);
		return this;
	}
	
	public Generator<GL> set(String key, Object value){
		map.put(key, value);
		return this;
	}
	
	public Generator<GL> removePolygon(int index){
		if(!map.has("rem_poly")) map.addArray("rem_poly", int.class);
		map.getArray("rem_poly").add(index);
		return this;
	}
	
	public Generator<GL> removePolygon(int... idxs){
		for(int i : idxs) removePolygon(i);
		return this;
	}

	public ValueMap getMap(){
		return map;
	}
	
	public static enum Type {
		
		NONE, CUBOID, CYLINDER
		
	}

	protected static boolean[] intToBoolArray(ArrayList<Integer> array, int size){
		boolean[] bool = new boolean[size];
		if(array == null || array.size() == 0) return bool;
		for(int i = 0; i < array.size(); i++){
			int j = array.get(i);
			if(j >= 0 && j < bool.length) bool[j] = true;
		}
		return bool;
	}

	protected static boolean detached(boolean[] rems, boolean[] deuv, int i){
		return rems[i] || deuv[i];
	}

}
