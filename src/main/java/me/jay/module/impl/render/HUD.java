package me.jay.module.impl.render;

import me.jay.event.render.Render2DEvent;
import me.jay.module.base.MirageModule;
import me.jay.module.base.ModuleCategory;
import me.jay.module.base.ModuleInfo;
import me.jay.value.impl.BooleanValue;
import me.zero.alpine.listener.Listener;
import me.zero.alpine.listener.Subscribe;
import me.zero.alpine.listener.Subscriber;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

@ModuleInfo(name = "HUD", category = ModuleCategory.RENDER, description = "Renders the HUD", visable = false)
public class HUD extends MirageModule implements Subscriber {
    public HUD() {
        this.setModuleState(true);
    }

    @NotNull
    private final BooleanValue watermark = new BooleanValue("Watermark", true);

    @NotNull
    private final BooleanValue moduleList = new BooleanValue("Module List", true);

    @Subscribe
    private final Listener<Render2DEvent> renderListener = new Listener<>(event -> {
        DrawContext context = event.drawContext();

        if (watermark.getObject()) {
            context.drawText(mc.textRenderer, "Mirage", 5, 5, 0xFFFFFFFF, true);
        }

        if (moduleList.getObject()) {
            ArrayList<MirageModule> activeModules = mirage.moduleManager.getActiveModules();

            activeModules.sort((o1, o2) -> {
                float w1;

                if (o2.getSuffix() != null) {
                    w1 = mc.textRenderer.getWidth(o2.getModuleInfo().name() + " [" + o2.getSuffix() + "]");
                } else {
                    w1 = mc.textRenderer.getWidth(o2.getModuleInfo().name());
                }

                float w2;

                if (o1.getSuffix() != null) {
                    w2 = mc.textRenderer.getWidth(o1.getModuleInfo().name() + " [" + o1.getSuffix() + "]");
                } else {
                    w2 = mc.textRenderer.getWidth(o1.getModuleInfo().name());
                }

                return Float.compare(w2, w1);
            });

            AtomicReference<Integer> y = new AtomicReference<>(5);

            activeModules.forEach(module -> {
                String moduleName = module.getModuleInfo().name();

                if (module.getSuffix() != null) {
                    moduleName += " [" + module.getSuffix() + "]";
                }

                int x = mc.getWindow().getScaledWidth() - 5 - mc.textRenderer.getWidth(moduleName);

                context.drawText(mc.textRenderer, moduleName, x, y.get(), 0xFFFFFFFF, true);

                y.set(y.get() + mc.textRenderer.fontHeight + 2);
            });
        }
    });
}
