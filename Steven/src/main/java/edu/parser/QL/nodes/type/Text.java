package edu.parser.QL.nodes.type;

import edu.gui.components.store.Store;
import edu.parser.QL.nodes.AbstractNode;

/**
 * Created by Steven Kok on 21/02/2015.
 */
public class Text implements Store, AbstractNode {

    private final String text;

    public Text(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }


    @Override
    public String getValue() {
        return getText();
    }
}
