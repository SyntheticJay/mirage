package me.jay.module.impl.combat;

import me.jay.module.base.MirageModule;
import me.jay.module.base.ModuleCategory;
import me.jay.module.base.ModuleInfo;
import me.zero.alpine.listener.Subscriber;

@ModuleInfo(name = "AutoTotem", category = ModuleCategory.COMBAT, description = "Automatically use totem of undying in high risk situations", visable = true)
public class AutoTotem extends MirageModule implements Subscriber { }
