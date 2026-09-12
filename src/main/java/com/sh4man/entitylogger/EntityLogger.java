package com.sh4man.entitylogger;

import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = EntityLogger.MODID, name = EntityLogger.NAME, version = EntityLogger.VERSION)
public class EntityLogger
{
    public static final String MODID = "entitylogger";
    public static final String NAME = "Entity Logger";
    public static final String VERSION = "1.0";

    private static Logger logger;

    Minecraft mc = Minecraft.getMinecraft();

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        // some example code
        logger.info("Hello, Minecraft");
    }
}
