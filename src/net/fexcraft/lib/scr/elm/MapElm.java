/*
 * Copyright (c) 2023, Ferdinand Calo' / "Fexcraft". All rights reserved.
 *
 *
 */
package net.fexcraft.lib.scr.elm;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import net.fexcraft.lib.scr.ScriptElm;
import net.fexcraft.lib.scr.ScriptElmType;

/**
 * 
 * @author Ferdinand Calo' (FEX___96)
 *
 */
public class MapElm implements ScriptElm {
	
	private Map<String, ScriptElm> value;

	public MapElm(Map<String, ScriptElm> type){
		value = type;
	}

	public MapElm(boolean hash){
		value = hash ? new HashMap<>() : new TreeMap<>();
	}

	@Override
	public String scr_str(){
		return value.toString();
	}

	@Override
	public int scr_int(){
		return value.size();
	}

	@Override
	public float scr_flt(){
		return value.size();
	}

	@Override
	public boolean scr_bln(){
		return value.size() > 1;
	}

	@Override
	public ScriptElmType scr_type(){
		return ScriptElmType.OBJ;
	}

	@Override
	public ScriptElm scr_get(String sub){
		ScriptElm elm = value.get(sub);
		return elm == null ? NULL : elm;
	}

	@Override
	public void scr_set(String sub, ScriptElm val, boolean ov){
		ScriptElm elm = value.get(sub);
		if(elm == null || (ov && elm.replaceable())) value.put(sub, val);
		else elm.scr_set(val);
	}

	@Override
	public ScriptElm exec(String str, ScriptElm... args){
		return NULL;
	}

}
