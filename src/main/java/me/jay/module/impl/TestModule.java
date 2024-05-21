package me.jay.module.impl;

import me.jay.Mirage;
import me.jay.module.base.Module;
import me.jay.module.base.ModuleCategory;
import me.jay.module.base.ModuleInfo;
import org.lwjgl.glfw.GLFW;

@ModuleInfo(name = "TestModule", description = "A test module", category = ModuleCategory.MOVEMENT, defaultKeyBind = GLFW.GLFW_KEY_B, visable = false)
public class TestModule extends Module {
    @Override
    public void onEnable() {
        Mirage.clientLogger.info("enabled module");
    }

    @Override
    public void onDisable() {
        Mirage.clientLogger.info("disabled module");
    }
}
