/*
 * This class (MessageGenerator.java) was created by <zazpro>. It's distributed as
 * part of the Baubles Stuff Mod. Get the Source Code in github:
 * https://github.com/ZAZPRO/BaublesStuff
 *
 * Baubles Stuff is Open Source and distributed under the
 * Baubles Stuff License: https://github.com/ZAZPRO/BaublesStuff/blob/master/LICENSE.MD
 *
 * © 2016 zazpro
 */

package md.zazpro.mod.common.network;

import io.netty.buffer.ByteBuf;
import md.zazpro.mod.common.tileentity.TEExpGenerator;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class MessageGenerator implements IMessage, IMessageHandler<MessageGenerator, IMessage> {
    public int bsu;
    public int lvl;
    public BlockPos pos;

    public MessageGenerator() {

    }

    public MessageGenerator(TEExpGenerator tile) {
        this.bsu = tile.getBsuStored();
        this.lvl = tile.getLvlStored();
        this.pos = tile.getPos();
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        this.bsu = buf.readInt();
        this.lvl = buf.readInt();
        this.pos = new BlockPos(buf.readInt(), buf.readInt(), buf.readInt());
    }

    @Override
    public void toBytes(ByteBuf buf) {
        buf.writeInt(bsu);
        buf.writeInt(lvl);
        buf.writeInt(pos.getX());
        buf.writeInt(pos.getY());
        buf.writeInt(pos.getZ());
    }

    @Override
    public IMessage onMessage(MessageGenerator message, MessageContext ctx) {

        TileEntity tileEntity = FMLClientHandler.instance().getClient().theWorld.getTileEntity(message.pos);

        if (tileEntity instanceof TEExpGenerator) {
            ((TEExpGenerator) tileEntity).setBsuStored(message.bsu);
            ((TEExpGenerator) tileEntity).setLvlStored(message.lvl);
        }

        return null;
    }
}
