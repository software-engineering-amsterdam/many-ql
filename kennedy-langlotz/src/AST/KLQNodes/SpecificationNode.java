package AST.KLQNodes;

import AST.Node;
import AST.Visitor;

import java.util.ArrayList;

/**
 * Created by juriaan on 10-2-15.
 */
public class SpecificationNode extends Node {
    public enum SpecificationType{
        ID, TYPE, VALUE, TEXT, REQUIRES, ONLY
    }

    private SpecificationType specificationType;

    public SpecificationNode(SpecificationType specificationType){
        this.specificationType = specificationType;
    }

    @Override
    public void accept(Visitor visitor){
        for(Node child : this.getChildren()){
            child.accept(visitor);
        }
        visitor.visit(this);
    }

    public SpecificationType getSpecificationType() {
        return specificationType;
    }
}
