package me.jay.module.impl.combat;

import me.jay.module.base.MirageModule;
import me.jay.module.base.ModuleCategory;
import me.jay.module.base.ModuleInfo;
import me.zero.alpine.listener.Subscriber;

@ModuleInfo(name = "AutoDisconnect", category = ModuleCategory.COMBAT, description = "Automatically log you out in high risk situations", visable = true)
public class AutoDisconnect extends MirageModule implements Subscriber { }
