package me.jay.module.impl.render;

import me.jay.Mirage;
import me.jay.module.base.MirageModule;
import me.jay.module.base.ModuleCategory;
import me.jay.module.base.ModuleInfo;
import me.zero.alpine.listener.Subscriber;

@ModuleInfo(name = "Notifications", category = ModuleCategory.RENDER, description = "Displays notifications in the top right corner of the screen", visable = false)
public class Notifications extends MirageModule implements Subscriber {

}
