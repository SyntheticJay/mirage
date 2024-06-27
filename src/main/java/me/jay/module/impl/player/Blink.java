package me.jay.module.impl.player;

import me.jay.module.base.MirageModule;
import me.jay.module.base.ModuleCategory;
import me.jay.module.base.ModuleInfo;
import me.zero.alpine.listener.Subscriber;

@ModuleInfo(name = "Blink", category = ModuleCategory.PLAYER, description = "Immobilise packets until disabled", visable = true)
public class Blink extends MirageModule implements Subscriber { }
