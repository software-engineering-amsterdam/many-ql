package nl.uva.bromance.ast.operators;

import nl.uva.bromance.ast.conditionals.Result;
import nl.uva.bromance.ast.visitors.OperatorVisitor;

/**
 * Created by Ger on 24-2-2015.
 */
public abstract class Operator {

    public abstract Result performOperation(Result one, Result two);

    public abstract String getOperatorString();

    public abstract void accept(OperatorVisitor visitor);
}
