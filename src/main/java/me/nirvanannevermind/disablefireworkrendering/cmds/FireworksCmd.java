package me.nirvanannevermind.disablefireworkrendering.cmds;

import net.minecraft.command.CommandException;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;

import javax.annotation.Nullable;
import java.util.List;

public class FireworksCmd implements ICommand {

    @Override
    public String getName() {
        return "togglefireworks";
    }

    @Override
    public String getUsage(ICommandSender sender) {
        return "togglefireworks";
    }

    @Override
    public List<String> getAliases() {
        return null;
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
        if(me.nirvanannevermind.disablefireworkrendering.DisableFireworkRendering.INSTANCE.enabled) {
            me.nirvanannevermind.disablefireworkrendering.DisableFireworkRendering.INSTANCE.enabled = false;
            sender.sendMessage(new TextComponentString("Fireworks Rendering Enabled!"));
        } else {
            me.nirvanannevermind.disablefireworkrendering.DisableFireworkRendering.INSTANCE.enabled = true;
            sender.sendMessage(new TextComponentString("Fireworks Rendering Disabled!"));
        }
    }

    @Override
    public boolean checkPermission(MinecraftServer server, ICommandSender sender) {
        return true;
    }

    @Override
    public List<String> getTabCompletions(MinecraftServer server, ICommandSender sender, String[] args, @Nullable BlockPos targetPos) {
        return null;
    }

    @Override
    public boolean isUsernameIndex(String[] args, int index) {
        return false;
    }

    @Override
    public int compareTo(ICommand iCommand) {
        return 0;
    }
}
