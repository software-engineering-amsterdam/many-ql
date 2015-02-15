package nl.uva.softwcons.ast.expression;

import nl.uva.softwcons.ast.ASTNode;
import nl.uva.softwcons.eval.value.Value;

public abstract class Expression implements ASTNode {

    public abstract Value evaluate();

}
