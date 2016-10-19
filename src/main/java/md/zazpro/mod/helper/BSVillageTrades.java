/*
 * This class (BSVillageTrades.java) was created by <zazpro>. It's distributed as
 * part of the Baubles Stuff Mod. Get the Source Code in github:
 * https://github.com/ZAZPRO/BaublesStuff
 *
 * Baubles Stuff is Open Source and distributed under the
 * Baubles Stuff License: https://github.com/ZAZPRO/BaublesStuff/blob/master/LICENSE.MD
 *
 * © 2016 zazpro
 */

package md.zazpro.mod.helper;

import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;

import javax.annotation.Nonnull;
import java.util.Random;

public class BSVillageTrades {

    public static ItemStack copyStackWithAmount(ItemStack itemStack, int amount) {
        if (itemStack == null)
            return null;
        ItemStack itemStack2 = itemStack.copy();
        itemStack2.stackSize = amount;
        return itemStack2;
    }

    public static class EmeraldForItemstack implements EntityVillager.ITradeList {
        public ItemStack itemBuy;
        public EntityVillager.PriceInfo amount;

        public EmeraldForItemstack(@Nonnull ItemStack item, @Nonnull EntityVillager.PriceInfo amount) {
            this.itemBuy = item;
            this.amount = amount;
        }

        @Override
        public void modifyMerchantRecipeList(MerchantRecipeList recipeList, Random random) {
            recipeList.add(new MerchantRecipe(copyStackWithAmount(this.itemBuy, this.amount.getPrice(random)), Items.EMERALD));
        }

    }

    public static class ItemstackForEmerald implements EntityVillager.ITradeList {
        public ItemStack sellingItem;
        public EntityVillager.PriceInfo priceInfo;

        public ItemstackForEmerald(Item item, EntityVillager.PriceInfo priceInfo) {
            this.sellingItem = new ItemStack(item);
            this.priceInfo = priceInfo;
        }

        public ItemstackForEmerald(ItemStack itemStack, EntityVillager.PriceInfo priceInfo) {
            this.sellingItem = itemStack;
            this.priceInfo = priceInfo;
        }

        @Override
        public void modifyMerchantRecipeList(MerchantRecipeList recipeList, Random random) {
            int i = 1;
            if (this.priceInfo != null)
                i = this.priceInfo.getPrice(random);
            ItemStack itemStack1;
            ItemStack itemStack2;
            if (i < 0) {
                itemStack1 = new ItemStack(Items.EMERALD);
                itemStack2 = copyStackWithAmount(sellingItem, -i);
            } else {
                itemStack1 = new ItemStack(Items.EMERALD, i, 0);
                itemStack2 = copyStackWithAmount(sellingItem, i);
            }
            recipeList.add(new MerchantRecipe(itemStack1, itemStack2));
        }

    }
}
