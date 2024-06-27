package me.jay.module.impl.movement;

import me.jay.module.base.MirageModule;
import me.jay.module.base.ModuleCategory;
import me.jay.module.base.ModuleInfo;
import me.zero.alpine.listener.Subscriber;


@ModuleInfo(name = "NoFall", description = "Prevent fall damage", category = ModuleCategory.MOVEMENT, visable = true)
public class NoFall extends MirageModule implements Subscriber { }
