package org.fugazi.ast.Form;

import org.fugazi.ast.ASTNode.ASTNode;

public class Form extends ASTNode {

    private String name;
//    private list<Questions>

    public Form(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
