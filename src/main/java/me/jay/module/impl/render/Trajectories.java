package me.jay.module.impl.render;

import me.jay.event.render.Render2DEvent;
import me.jay.module.base.MirageModule;
import me.jay.module.base.ModuleCategory;
import me.jay.module.base.ModuleInfo;
import me.jay.value.impl.BooleanValue;
import me.zero.alpine.listener.Listener;
import me.zero.alpine.listener.Subscribe;
import me.zero.alpine.listener.Subscriber;
import net.minecraft.client.gui.DrawContext;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

@ModuleInfo(name = "Trajectories", category = ModuleCategory.RENDER, description = "Render a line where projectiles will land", visable = false)
public class Trajectories extends MirageModule implements Subscriber { }
