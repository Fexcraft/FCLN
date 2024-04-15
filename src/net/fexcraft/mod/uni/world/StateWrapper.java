package net.fexcraft.mod.uni.world;

import net.fexcraft.mod.uni.item.StackWrapper;

import java.util.function.Function;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public abstract class StateWrapper {

    public static StateWrapper DEFAULT = null;
    public static Function<Object, StateWrapper> GETTER = null;
    public static Function<StackWrapper, StateWrapper> STACK_GETTER = null;

    public abstract Object getBlock();

    public abstract <S> S local();

    public abstract Object direct();

    public abstract <V> V getValue(Object prop);

}
