package me.nirvanannevermind.disablefireworkrendering.mixin;


import net.minecraftforge.fml.relauncher.IFMLLoadingPlugin;
import org.spongepowered.asm.launch.MixinBootstrap;
import org.spongepowered.asm.mixin.MixinEnvironment;
import org.spongepowered.asm.mixin.Mixins;

import java.util.Map;

@IFMLLoadingPlugin.Name(value = "disablefireworkrendering")
@IFMLLoadingPlugin.MCVersion(value = "1.12.2")
public final class Loader implements IFMLLoadingPlugin {

    public Loader() {
        System.out.println("Init");
        MixinBootstrap.init();
        Mixins.addConfiguration("mixins.disablefireworkrendering.json");
        MixinEnvironment.getDefaultEnvironment().setSide(MixinEnvironment.Side.CLIENT);
    }

    @Override
    public String[] getASMTransformerClass() {
        return new String[0];
    }

    @Override
    public String getModContainerClass() {
        return null;
    }

    @Override
    public String getSetupClass() {
        return null;
    }

    @Override
    public void injectData(Map<String, Object> data) {
    }

    @Override
    public String getAccessTransformerClass() {
        return null;
    }
}