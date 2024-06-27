package me.jay.module.impl.combat;

import me.jay.module.base.MirageModule;
import me.jay.module.base.ModuleCategory;
import me.jay.module.base.ModuleInfo;
import me.zero.alpine.listener.Subscriber;

@ModuleInfo(name = "Criticals", category = ModuleCategory.COMBAT, description = "Automatic critical hits on enemies", visable = true)
public class Criticals extends MirageModule implements Subscriber { }
