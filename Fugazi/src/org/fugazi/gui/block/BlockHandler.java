package org.fugazi.gui.block;

import org.fugazi.gui.ui_elements.UIQuestion;

import java.util.ArrayDeque;
import java.util.Deque;

public class BlockHandler {

    private Deque<Block> blocksStack = new ArrayDeque<>();
    private Block currentBlock = null;

    public BlockHandler() {
    }

    public Block getCurrentBlock() {
        return this.currentBlock;
    }

    public Deque<Block> getBlocks() {
        return this.blocksStack;
    }

    public void resetCurrentBlock() {
        this.currentBlock = blocksStack.getFirst();
    }

    public void addBlock(Block _block) {
        blocksStack.push(_block);
        currentBlock = _block;
    }

    public void previousBlock() {
        blocksStack.pop();
        currentBlock = blocksStack.getLast();
    }

    public boolean isBlockExists(String _blockName) {
        for (Block block : blocksStack) {
            if (block.getName().equals(_blockName)) {
                return true;
            }
        }
        return false;
    }

    public UIQuestion getExistingQuestion(String _questId) {
        for (Block block : blocksStack) {
            if (block.getBody().containsKey(_questId)) {
                return block.getBody().get(_questId);
            }
        }
        return null;
    }

    public boolean isQuestionExists(String _id) {
        for (Block block : blocksStack) {
            if (block.getBody().containsKey(_id)) {
                return true;
            }
        }
        return false;
    }
}