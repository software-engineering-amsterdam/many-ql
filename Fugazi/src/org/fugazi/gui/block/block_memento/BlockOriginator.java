package org.fugazi.gui.block.block_memento;

import org.fugazi.gui.block.Block;

public class BlockOriginator{

    private Block block;

    public void set(Block _block) {
        this.block = _block;
    }

    public BlockMemento storeInMemento() {
        return new BlockMemento(this.block);
    }

    public Block restoreFromMemento(BlockMemento _memento) {
        this.block = _memento.getSavedBlock();
        return this.block;
    }
}