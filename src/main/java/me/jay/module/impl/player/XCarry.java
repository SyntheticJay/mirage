package me.jay.module.impl.player;

import me.jay.module.base.MirageModule;
import me.jay.module.base.ModuleCategory;
import me.jay.module.base.ModuleInfo;
import me.zero.alpine.listener.Subscriber;

@ModuleInfo(name = "XCarry", category = ModuleCategory.PLAYER, description = "Place items in your crafting table as storage", visable = true)
public class XCarry extends MirageModule implements Subscriber { }
