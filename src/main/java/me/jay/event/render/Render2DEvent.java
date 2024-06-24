package me.jay.event.render;

import net.minecraft.client.gui.DrawContext;

public record Render2DEvent(DrawContext drawContext, float tickDelta) {}
