package com.sh4man.entitylogger;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityFallingBlock;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

import java.util.List;

@Mod(modid = EntityLogger.MODID, name = EntityLogger.NAME, version = EntityLogger.VERSION)
public class EntityLogger
{
    public static final String MODID = "entitylogger";
    public static final String NAME = "Entity Logger";
    public static final String VERSION = "1.0";

    private int tickCounter = 0;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onClientTick(TickEvent.ClientTickEvent event) {
        Minecraft mc = Minecraft.getMinecraft();

        if (event.phase != TickEvent.Phase.END || mc.world == null) {
            return;
        }

        tickCounter++;
        if (tickCounter != 20) {
            return;
        }
        tickCounter = 0;

        List<Entity> loadedEntityList = mc.world.getLoadedEntityList();

        for (Entity entity : loadedEntityList) {
            if (entity instanceof EntityFallingBlock || entity instanceof EntityPlayerSP) {
                String name = entity.getName();

                if (name.trim().isEmpty()) {
                    continue;
                }

                System.out.printf("%s (%d) x=%.0f y=%.0f z=%.0f%n", name, entity.getEntityId(), entity.posX, entity.posY, entity.posZ);
            }
        }

        System.out.println();
    }
}
