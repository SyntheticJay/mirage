package me.jay.module.impl.misc;

import me.jay.module.base.MirageModule;
import me.jay.module.base.ModuleCategory;
import me.jay.module.base.ModuleInfo;
import me.zero.alpine.listener.Subscriber;

@ModuleInfo(name = "Freecam", description = "Control the client camera separated from the player", category = ModuleCategory.MISC, visable = true)
public class Freecam extends MirageModule implements Subscriber { }
