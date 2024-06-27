package me.jay.module.impl.render;

import me.jay.module.base.MirageModule;
import me.jay.module.base.ModuleCategory;
import me.jay.module.base.ModuleInfo;
import me.zero.alpine.listener.Subscriber;

@ModuleInfo(name = "Fullbright", category = ModuleCategory.RENDER, description = "Make the world brighter", visable = false)
public class Fullbright extends MirageModule implements Subscriber { }
