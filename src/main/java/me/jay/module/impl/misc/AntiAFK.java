package me.jay.module.impl.misc;

import me.jay.module.base.MirageModule;
import me.jay.module.base.ModuleCategory;
import me.jay.module.base.ModuleInfo;
import me.zero.alpine.listener.Subscriber;

@ModuleInfo(name = "AntiAFK", description = "Prevent you from getting kicked", category = ModuleCategory.MISC, visable = true)
public class AntiAFK extends MirageModule implements Subscriber { }
