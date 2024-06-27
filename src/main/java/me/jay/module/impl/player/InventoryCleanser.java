package me.jay.module.impl.player;

import me.jay.module.base.MirageModule;
import me.jay.module.base.ModuleCategory;
import me.jay.module.base.ModuleInfo;
import me.zero.alpine.listener.Subscriber;

@ModuleInfo(name = "InventoryCleanser", category = ModuleCategory.PLAYER, description = "Filter out un-needed items in your inventory", visable = true)
public class InventoryCleanser extends MirageModule implements Subscriber { }
