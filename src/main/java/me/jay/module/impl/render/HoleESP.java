package me.jay.module.impl.render;

import me.jay.module.base.MirageModule;
import me.jay.module.base.ModuleCategory;
import me.jay.module.base.ModuleInfo;
import me.zero.alpine.listener.Subscriber;

@ModuleInfo(name = "HoleESP", category = ModuleCategory.RENDER, description = "Highlight holes deemed safe for crystal PvP", visable = false)
public class HoleESP extends MirageModule implements Subscriber { }
