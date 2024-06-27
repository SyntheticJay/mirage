package me.jay.module.impl.render;

import me.jay.module.base.MirageModule;
import me.jay.module.base.ModuleCategory;
import me.jay.module.base.ModuleInfo;
import me.zero.alpine.listener.Subscriber;

@ModuleInfo(name = "Breadcrumbs", category = ModuleCategory.RENDER, description = "Leave a trail of where you have been", visable = false)
public class Breadcrumbs extends MirageModule implements Subscriber { }
