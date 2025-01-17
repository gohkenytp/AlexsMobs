package com.github.alexthe666.alexsmobs;

import com.github.alexthe666.alexsmobs.config.AMConfig;
import com.github.alexthe666.alexsmobs.misc.*;
import com.github.alexthe666.alexsmobs.world.AMWorldRegistry;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.SpecialRecipeSerializer;
import net.minecraft.loot.ILootSerializer;
import net.minecraft.loot.LootConditionType;
import net.minecraft.loot.conditions.ILootCondition;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.Feature;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static com.github.alexthe666.alexsmobs.AlexsMobs.MODID;

@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CommonProxy {
    public static final LootConditionType MATCHES_BANANA_CONDTN = registerLootCondition("alexsmobs:matches_banana_tag", new MatchesBananaTagCondition.Serializer());
    public static final LootConditionType MATCHES_BLOSSOM_CONDTN = registerLootCondition("alexsmobs:matches_blossom_tag", new MatchesBlossomTagCondition.Serializer());
    public static SpecialRecipeSerializer MIMICREAM_RECIPE;

    @SubscribeEvent
    public static void registerModifierSerializers(RegistryEvent.Register<GlobalLootModifierSerializer<?>> event) {
        if (AMConfig.bananasDropFromLeaves) {
            event.getRegistry().register(new BananaLootModifier.Serializer().setRegistryName(new ResourceLocation("alexsmobs:banana_drop")));
        }
        if (AMConfig.acaciaBlossomsDropFromLeaves) {
            event.getRegistry().register(new BlossomLootModifier.Serializer().setRegistryName(new ResourceLocation("alexsmobs:blossom_drop")));
        }
    }

    @SubscribeEvent
    public static void registerRecipes(RegistryEvent.Register<IRecipeSerializer<?>> event) {
        if(AMConfig.mimicreamRepair){
            MIMICREAM_RECIPE = new SpecialRecipeSerializer<>(RecipeMimicreamRepair::new);
            MIMICREAM_RECIPE.setRegistryName(new ResourceLocation("alexsmobs:mimicream_repair_recipe"));
            event.getRegistry().register(MIMICREAM_RECIPE);
        }
    }

    private static LootConditionType registerLootCondition(String registryName, ILootSerializer<? extends ILootCondition> serializer) {
        return Registry.register(Registry.LOOT_CONDITION_TYPE, new ResourceLocation(registryName), new LootConditionType(serializer));
    }

    public void init() {
    }

    public void clientInit() {
    }

    public Item.Properties setupISTER(Item.Properties group) {
        return group;
    }

    public PlayerEntity getClientSidePlayer() {
        return null;
    }

    public void openBookGUI(ItemStack itemStackIn) {
    }

    public Object getArmorModel(int armorId, LivingEntity entity) {
        return null;
    }

    public void onEntityStatus(Entity entity, byte updateKind) {
    }

    public void updateBiomeVisuals(int x, int z) {
    }

    public void setupParticles() {
    }

    public void setRenderViewEntity(Entity entity) {

    }

    public void resetRenderViewEntity() {

    }

    public int getPreviousPOV(){
        return 0;
    }

    public boolean isFarFromCamera(double x, double y, double z) {
        return true;
    }
}
