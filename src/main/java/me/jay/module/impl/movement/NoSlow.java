package me.jay.module.impl.movement;

import me.jay.module.base.MirageModule;
import me.jay.module.base.ModuleCategory;
import me.jay.module.base.ModuleInfo;
import me.zero.alpine.listener.Subscriber;


@ModuleInfo(name = "NoSlow", description = "Removes slowdowns", category = ModuleCategory.MOVEMENT, visable = true)
public class NoSlow extends MirageModule implements Subscriber { }
