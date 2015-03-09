package org.fugazi.ql.gui.block;

import org.fugazi.ql.gui.ui_elements.UIQuestion;

import java.util.HashMap;
import java.util.Map;

public abstract class Block {

    protected final String name;
    protected Map<String, UIQuestion> body = new HashMap<>();

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

    public Map<String, UIQuestion> getBody() {
        return this.body;
    }

    public String getName() {
        return this.name;
    }
}
