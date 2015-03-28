package nl.uva.bromance.ast.operators;

import nl.uva.bromance.ast.conditionals.Result;
import nl.uva.bromance.ast.visitors.OperatorVisitor;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Ger on 24-2-2015.
 */
public abstract class Operator {
    public static List<Operator> operatorTypes = Arrays.asList(new AndOperator(), new OrOperator(), new DivideOperator(), new MultiplyOperator(), new EqualsOperator(), new NotEqualsOperator(), new LargerThanOrEqualsOperator(), new LargerThanOperator(), new MinusOperator(), new PlusOperator(), new SmallerThanOrEqualsOperator(), new SmallerThanOperator());

    public abstract Result performOperation(Result one, Result two);

    public abstract String getOperatorString();

    public abstract Operator getNewOperatorOfThisType();

    public abstract void accept(OperatorVisitor visitor);
}
