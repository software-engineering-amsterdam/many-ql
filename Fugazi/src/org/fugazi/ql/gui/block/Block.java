package org.fugazi.ql.gui.block;

import org.fugazi.ql.gui.ui_elements.UIQuestion;

import java.util.HashMap;

public abstract class Block {

    protected final String name;
    protected HashMap<String, UIQuestion> body = new HashMap<>();

    public Block(String _name) {
        this.name = _name;
    }

    public void add(UIQuestion _question) {
        if (!this.body.containsKey(_question)) {
            this.body.put(_question.getId(), _question);
        }
    }

    public void clearBlock() {
        this.body.clear();
    }

    public HashMap<String, UIQuestion> getBody() {
        return this.body;
    }

    public String getName() {
        return this.name;
    }
}
