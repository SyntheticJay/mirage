package me.jay.module.impl.player;

import me.jay.module.base.MirageModule;
import me.jay.module.base.ModuleCategory;
import me.jay.module.base.ModuleInfo;
import me.zero.alpine.listener.Subscriber;

@ModuleInfo(name = "AutoEat", category = ModuleCategory.PLAYER, description = "Automatically eat for you", visable = true)
public class AutoEat extends MirageModule implements Subscriber { }
