package me.jay.module.impl.movement;

import me.jay.module.base.MirageModule;
import me.jay.module.base.ModuleCategory;
import me.jay.module.base.ModuleInfo;
import me.zero.alpine.listener.Subscriber;


@ModuleInfo(name = "InventoryMove", description = "Move while in your inventory", category = ModuleCategory.MOVEMENT, visable = true)
public class InventoryMove extends MirageModule implements Subscriber { }
