package me.jay.module.impl.combat;

import me.jay.module.base.MirageModule;
import me.jay.module.base.ModuleCategory;
import me.jay.module.base.ModuleInfo;
import me.zero.alpine.listener.Subscriber;

@ModuleInfo(name = "AutoArmor", category = ModuleCategory.COMBAT, description = "Automatically equips the best armor in your inventory", visable = true)
public class AutoArmor extends MirageModule implements Subscriber { }
