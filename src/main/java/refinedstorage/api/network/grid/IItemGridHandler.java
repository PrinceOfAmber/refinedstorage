package refinedstorage.api.network.grid;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;

import javax.annotation.Nullable;

/**
 * Defines the behavior of item grids.
 */
public interface IItemGridHandler {
    /**
     * Called when a player tries to extract an item from the grid.
     *
     * @param hash   The hash of the item we're trying to extract, see {@link refinedstorage.api.network.NetworkUtils#getItemStackHashCode(ItemStack)}
     * @param flags  How we are extracting, see {@link GridExtractFlags}
     * @param player The player that is attempting the extraction
     */
    void onExtract(int hash, int flags, EntityPlayerMP player);

    /**
     * Called when a player tries to insert an item to the grid.
     *
     * @param stack The item we're trying to insert
     * @return The remainder, or null if there is no remainder
     */
    @Nullable
    ItemStack onInsert(ItemStack stack);

    /**
     * Called when a player is trying to insert an item that it is holding in their hand in the GUI.
     *
     * @param single If we are only inserting 1 item
     * @param player The player that is attempting the insert
     */
    void onInsertHeldItem(boolean single, EntityPlayerMP player);

    /**
     * Called when a player requested crafting for an item.
     *
     * @param hash     The hash of the item we're requesting crafting for, see {@link refinedstorage.api.network.NetworkUtils#getItemStackHashCode(ItemStack)}
     * @param quantity The amount of that item that has to be crafted
     */
    void onCraftingRequested(int hash, int quantity);

    /**
     * Called when a player wants to cancel a crafting task.
     *
     * @param id The task ID, or -1 for all tasks
     */
    void onCraftingCancelRequested(int id);
}
