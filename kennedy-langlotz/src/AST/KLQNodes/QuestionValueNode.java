package AST.KLQNodes;

import AST.Node;
import AST.Visitor;

/**
 * Created by juriaan on 10-2-15.
 */
public class QuestionValueNode extends Node {

    @Override
    public void accept(Visitor visitor) {
        for(Node child : this.getChildren()){
            child.accept(visitor);
        }
        visitor.visit(this);
    }
}
