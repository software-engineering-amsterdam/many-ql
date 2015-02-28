package org.fugazi.gui.block.block_memento;

import org.fugazi.gui.block.Block;

public class BlockMemento {

    private final Block block;

    public BlockMemento(Block _block) {
        this.block = _block;
    }

    public Block getSavedBlock() {
        return this.block;
    }
}