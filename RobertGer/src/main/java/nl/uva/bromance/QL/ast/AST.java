package nl.uva.bromance.QL.ast;


import nl.uva.bromance.QL.expressions.unary.Primitive;

import java.util.Map;

public class AST<NODETYPE extends Node<NODETYPE>> {

    private final NODETYPE root;
    private Map<String, Primitive> identifiers;

    public AST(NODETYPE root, Map<String, Primitive> identifiers) {
        this.root = root;
        this.identifiers = identifiers;
    }

    public Map<String, Primitive> getIdentifierMap(){
        return this.identifiers;
    }

    public NODETYPE getRoot() {
        return root;
    }


}