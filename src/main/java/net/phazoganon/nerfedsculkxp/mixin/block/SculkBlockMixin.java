package net.phazoganon.nerfedsculkxp.mixin.block;

import net.minecraft.core.BlockPos;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SculkBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(SculkBlock.class)
public abstract class SculkBlockMixin extends DropExperienceBlock {
    public SculkBlockMixin(Properties properties) {
        super(UniformInt.of(0, 1), properties);
    }
    @Override
    public int getExpDrop(BlockState blockState, LevelAccessor levelAccessor, BlockPos blockPos, BlockEntity blockEntity, Entity entity, ItemStack itemStack) {
        return UniformInt.of(0, 1).sample(levelAccessor.getRandom());
    }
}