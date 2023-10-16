/*
 * Copyright (c) 2023, Ferdinand Calo'. All rights reserved.
 *
 *
 */
package net.fexcraft.lib.scr;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * "FEX Script" Version 2.0
 *
 * @author Ferdinand Calo' (FEX___96)
 *
 */
public class Script {

    public ArrayList<String> deps = new ArrayList<>();
    public HashMap<String, ScriptElm> global = new HashMap<>();
    public HashMap<String, ScriptAction> actions = new HashMap<>();

}
