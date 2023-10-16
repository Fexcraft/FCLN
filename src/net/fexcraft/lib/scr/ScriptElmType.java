package net.fexcraft.lib.scr;

/**
 *
 * @author Ferdinand Calo' (FEX___96)
 *
 */
public enum ScriptElmType {

    NULL, STRING, INTEGER, FLOAT, BOOLEAN, LIST, OBJ, REF;

    public boolean primitive(){
        return !(this == LIST || this == OBJ);
    }

    public boolean decimal(){
        return this == FLOAT;
    }

    public boolean bool(){
        return this == BOOLEAN;
    }

    public boolean integer(){
        return this == INTEGER;
    }

    public boolean string(){
        return this == STRING;
    }

    public boolean reference(){
        return this == REF;
    }

    public boolean number(){
        return this == INTEGER || this == FLOAT;
    }

}
