package me.jay.module.impl.movement;

import me.jay.event.client.TickEvent;
import me.jay.module.base.MirageModule;
import me.jay.module.base.ModuleCategory;
import me.jay.module.base.ModuleInfo;
import me.zero.alpine.listener.Listener;
import me.zero.alpine.listener.Subscribe;
import me.zero.alpine.listener.Subscriber;
import org.lwjgl.glfw.GLFW;


@ModuleInfo(name = "SafeWalk", description = "Prevent you from walking off edges of blocks", category = ModuleCategory.MOVEMENT, visable = true)
public class SafeWalk extends MirageModule implements Subscriber { }
