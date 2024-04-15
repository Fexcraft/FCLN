package net.fexcraft.mod.uni.world;

import net.fexcraft.mod.uni.IDL;
import net.fexcraft.mod.uni.item.StackWrapper;

import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public abstract class StateWrapper {

    public static StateWrapper DEFAULT = null;
    public static Function<Object, StateWrapper> STATE_WRAPPER = null;
    public static Function<StackWrapper, StateWrapper> STACK_WRAPPER = null;
    public static ConcurrentHashMap<Object, StateWrapper> WRAPPERS = new ConcurrentHashMap<>();

    public static StateWrapper of(Object state){
        StateWrapper wrapper = WRAPPERS.get(state);
        if(wrapper == null) WRAPPERS.put(state, wrapper = STATE_WRAPPER.apply(state));
        return wrapper;
    }
    public static StateWrapper from(StackWrapper stack){
        return STACK_WRAPPER.apply(stack);
    }

    public abstract Object getBlock();

    public abstract <S> S local();

    public abstract Object direct();

    public abstract <V> V getValue(Object prop);

    public abstract IDL getIDL();

    public abstract int get12Meta();

}
