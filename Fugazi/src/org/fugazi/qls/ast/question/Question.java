package org.fugazi.qls.ast.question;

import org.fugazi.qls.ast.AbstractASTNode;

public class Question extends AbstractASTNode {

    private final String identifier;
    
    public Question(String _identifier) {
        this.identifier = _identifier;
    }
    
    public String getId() {
        return this.identifier;
    }
}