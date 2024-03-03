package net.fexcraft.mod.uni.item;

import net.fexcraft.mod.uni.tag.TagCW;
import net.minecraft.item.ItemStack;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public abstract class StackWrapper {

	public static StackWrapper EMPTY = null;
	protected ItemWrapper item;

	public StackWrapper(ItemWrapper item){
		this.item = item;
	}

	public abstract <IS> IS local();

	public abstract Object direct();

	public abstract StackWrapper setTag(TagCW tag);

	public abstract TagCW getTag();

	public abstract boolean hasTag();

	public ItemWrapper getItem(){
		return item;
	}

	public abstract String getName();

	public abstract int maxsize();

	public abstract int damage();

	public abstract int count();

	public abstract void count(int am);

	public abstract StackWrapper copy();

	public abstract void save(TagCW com);

	public abstract boolean empty();

	public abstract void createTagIfMissing();

}
