package nl.uva.bromance.AST.Conditionals;

import nl.uva.bromance.AST.Exceptions.InvalidOperandException;

/**
 * Created by Ger on 24-2-2015.
 */
public abstract class Operator {
    public abstract Result performOperation(Result one, Result two) throws InvalidOperandException;
}
