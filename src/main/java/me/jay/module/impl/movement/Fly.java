package me.jay.module.impl.movement;

import me.jay.module.base.MirageModule;
import me.jay.module.base.ModuleCategory;
import me.jay.module.base.ModuleInfo;
import me.zero.alpine.listener.Subscriber;


@ModuleInfo(name = "Fly", description = "Enable the ability to fly", category = ModuleCategory.MOVEMENT, visable = true)
public class Fly extends MirageModule implements Subscriber { }
