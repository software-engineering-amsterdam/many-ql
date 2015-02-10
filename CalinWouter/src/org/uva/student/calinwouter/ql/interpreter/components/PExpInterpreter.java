package org.uva.student.calinwouter.ql.interpreter.components;

import com.sun.org.apache.xpath.internal.operations.And;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.uva.student.calinwouter.ql.generated.node.*;
import org.uva.student.calinwouter.ql.interpreter.interfaces.InterpreterInterface;
import org.uva.student.calinwouter.ql.interpreter.model.Environment;

import java.util.Objects;

public class PExpInterpreter implements InterpreterInterface<PExp> {

    @Override
    public Object interprete(Environment e, PExp node) {
        if(node instanceof AAddExp) {
            return ((Integer) new PExpInterpreter().interprete(e,((AAddExp) node).getLeft())) +
                    ((Integer) new PExpInterpreter().interprete(e,((AAddExp) node).getRight()));
        } else if (node instanceof ASubExp) {
            return ((Integer) new PExpInterpreter().interprete(e,((ASubExp) node).getLeft())) -
                    ((Integer) new PExpInterpreter().interprete(e,((ASubExp) node).getRight()));
        } else if (node instanceof AMulExp) {
            return ((Integer) new PExpInterpreter().interprete(e,((AMulExp) node).getLeft())) *
                    ((Integer) new PExpInterpreter().interprete(e,((AMulExp) node).getRight()));
        }else if (node instanceof ADivExp) {
            return ((Integer) new PExpInterpreter().interprete(e,((ADivExp) node).getLeft())) /
                ((Integer) new PExpInterpreter().interprete(e,((ADivExp) node).getRight()));
        }else if (node instanceof AModExp) {
            return ((Integer) new PExpInterpreter().interprete(e,((AModExp) node).getLeft())) %
                    ((Integer) new PExpInterpreter().interprete(e,((AModExp) node).getRight()));
        }else if (node instanceof AAndExp) {
            return ((Boolean) new PExpInterpreter().interprete(e,((AAndExp) node).getLeft())) &&
                    ((Boolean) new PExpInterpreter().interprete(e,((AAndExp) node).getRight()));
        } else if (node instanceof AOrExp) {
            return ((Boolean) new PExpInterpreter().interprete(e,((AOrExp) node).getLeft())) ||
                    ((Boolean) new PExpInterpreter().interprete(e,((AOrExp) node).getRight()));
        } else  if (node instanceof AEqExp) {
            return ((Boolean) new PExpInterpreter().interprete(e,((AEqExp) node).getLeft())) ==
                    ((Boolean) new PExpInterpreter().interprete(e,((AEqExp) node).getRight()));
        } else  if (node instanceof ANeqExp) {
            return ((Boolean) new PExpInterpreter().interprete(e,((ANeqExp) node).getLeft())) !=
                    ((Boolean) new PExpInterpreter().interprete(e,((ANeqExp) node).getRight()));
        } else if (node instanceof ALteExp) {
            return ((Integer) new PExpInterpreter().interprete(e,((ALteExp) node).getLeft())) <=
                    ((Integer) new PExpInterpreter().interprete(e,((ALteExp) node).getRight()));
        } else if (node instanceof AGteExp) {
            return ((Integer) new PExpInterpreter().interprete(e,((AGteExp) node).getLeft())) >=
                    ((Integer) new PExpInterpreter().interprete(e,((AGteExp) node).getRight()));
        } else if (node instanceof ALtExp) {
            return ((Integer) new PExpInterpreter().interprete(e,((ALtExp) node).getLeft())) <
                    ((Integer) new PExpInterpreter().interprete(e,((ALtExp) node).getRight()));
        } else if (node instanceof AGtExp) {
            return ((Integer) new PExpInterpreter().interprete(e,((AGtExp) node).getLeft())) >
                    ((Integer) new PExpInterpreter().interprete(e,((AGtExp) node).getRight()));
        } else if (node instanceof ANotExp) {
            return new PExpInterpreter().interprete(e, ((ANotExp) node).getExp());
        } else if (node instanceof AParenExp) {
            return new PExpInterpreter().interprete(e, ((AParenExp) node).getExp());
        } else if (node instanceof ATrueExp) {
            return new Boolean(true);
        } else if (node instanceof AFalseExp) {
            return new Boolean(false);
        } else if (node instanceof ANumberExp) {
            return new Integer(((ANumberExp) node).getNumber().getText());
        } else if (node instanceof AIdentExp) {
            return e.getEnvVars().get(((AIdentExp) node).getIdent().getText());
        }
        return null;
    }
}
