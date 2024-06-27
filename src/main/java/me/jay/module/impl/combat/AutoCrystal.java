package me.jay.module.impl.combat;

import me.jay.module.base.MirageModule;
import me.jay.module.base.ModuleCategory;
import me.jay.module.base.ModuleInfo;
import me.zero.alpine.listener.Subscriber;

@ModuleInfo(name = "AutoCrystal", category = ModuleCategory.COMBAT, description = "Automatically place & explode crystals in PvP", visable = true)
public class AutoCrystal extends MirageModule implements Subscriber { }
