package org.fugazi.ast;


public class Form extends  ASTNode{

    private String name;
//    private final list<Questions>

    public Form(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
