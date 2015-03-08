package nl.uva.bromance.ast.operator;

import nl.uva.bromance.ast.conditionals.Result;
import nl.uva.bromance.ast.exceptions.InvalidOperandException;

/**
 * Created by Ger on 24-2-2015.
 */
public abstract class Operator {
    public abstract Result performOperation(Result one, Result two) throws InvalidOperandException;

    public abstract String getOperatorString();
}
