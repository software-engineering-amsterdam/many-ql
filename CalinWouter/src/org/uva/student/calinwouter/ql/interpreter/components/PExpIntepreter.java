package org.uva.student.calinwouter.ql.interpreter.components;

import com.sun.org.apache.xpath.internal.operations.And;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.uva.student.calinwouter.ql.generated.node.*;
import org.uva.student.calinwouter.ql.interpreter.interfaces.InterpreterInterface;
import org.uva.student.calinwouter.ql.interpreter.model.Environment;

import java.util.Objects;

/**
 * Created by calin on 2/9/15.
 */
public class PExpIntepreter implements InterpreterInterface<PExp> {

    @Override
    public Object interprete(Environment e, PExp node) {
        if(node instanceof AAddExp) {
            return new PExpIntepreter().interprete(e,((AAddExp) node).getLeft()) +
                    new PExpIntepreter().interprete(e,((AAddExp) node).getRight());
        } else if (node instanceof ASubExp) {
            PExpIntepreter leftI = new PExpIntepreter();
            leftI.interprete(e,((ASubExp) node).getLeft());
            PExpIntepreter rightI = new PExpIntepreter();
            rightI.interprete(e,((ASubExp) node).getRight());
            if(leftI.getExpValue() instanceof String && rightI.getExpValue() instanceof String)
                expValue = Integer.parseInt(leftI.getExpValue().toString()) - (Integer.parseInt(rightI.getExpValue().toString()));
            //expValue = ((Integer) leftI.getExpValue()) - ((Integer)rightI.getExpValue());
        } else if (node instanceof AMulExp) {
            PExpIntepreter leftI = new PExpIntepreter();
            leftI.interprete(e,((AMulExp) node).getLeft());
            PExpIntepreter rightI = new PExpIntepreter();
            rightI.interprete(e,((AMulExp) node).getRight());
            expValue = ((Integer) leftI.getExpValue()) * ((Integer)rightI.getExpValue());
        }else if (node instanceof ADivExp) {
            PExpIntepreter leftI = new PExpIntepreter();
            leftI.interprete(e,((ADivExp) node).getLeft());
            PExpIntepreter rightI = new PExpIntepreter();
            rightI.interprete(e,((ADivExp) node).getRight());
            expValue = ((Integer) leftI.getExpValue()) - ((Integer)rightI.getExpValue());
        }else if (node instanceof AModExp) {
            PExpIntepreter leftI = new PExpIntepreter();
            leftI.interprete(e,((AModExp) node).getLeft());
            PExpIntepreter rightI = new PExpIntepreter();
            rightI.interprete(e,((AModExp) node).getRight());
            expValue = ((Integer) leftI.getExpValue()) % ((Integer)rightI.getExpValue());
        }else if (node instanceof AAndExp) {
            PExpIntepreter leftI = new PExpIntepreter();
            leftI.interprete(e,((AAndExp) node).getLeft());
            PExpIntepreter rightI = new PExpIntepreter();
            rightI.interprete(e,((AAndExp) node).getRight());
            expValue = ((Boolean) leftI.getExpValue()) && ((Boolean)rightI.getExpValue());
        } else if (node instanceof AOrExp) {
            PExpIntepreter leftI = new PExpIntepreter();
            leftI.interprete(e,((AOrExp) node).getLeft());
            PExpIntepreter rightI = new PExpIntepreter();
            rightI.interprete(e,((AOrExp) node).getRight());
            expValue = ((Boolean) leftI.getExpValue()) || ((Boolean)rightI.getExpValue());
        } else  if (node instanceof AEqExp) {
            PExpIntepreter leftI = new PExpIntepreter();
            leftI.interprete(e,((AEqExp) node).getLeft());
            PExpIntepreter rightI = new PExpIntepreter();
            rightI.interprete(e,((AEqExp) node).getRight());
            expValue = ((Boolean) leftI.getExpValue()) == ((Boolean)rightI.getExpValue());
        } else  if (node instanceof ANeqExp) {
            PExpIntepreter leftI = new PExpIntepreter();
            leftI.interprete(e,((ANeqExp) node).getLeft());
            PExpIntepreter rightI = new PExpIntepreter();
            rightI.interprete(e,((ANeqExp) node).getRight());
            expValue = ((Boolean) leftI.getExpValue()) != ((Boolean)rightI.getExpValue());
        } else if (node instanceof ALteExp) {
            PExpIntepreter leftI = new PExpIntepreter();
            leftI.interprete(e,((ALteExp) node).getLeft());
            PExpIntepreter rightI = new PExpIntepreter();
            rightI.interprete(e,((ALteExp) node).getRight());
            expValue = ((Integer) leftI.getExpValue()) < ((Integer)rightI.getExpValue());
        } else if (node instanceof AGteExp) {
            PExpIntepreter leftI = new PExpIntepreter();
            leftI.interprete(e,((AGteExp) node).getLeft());
            PExpIntepreter rightI = new PExpIntepreter();
            rightI.interprete(e,((AGteExp) node).getRight());
            expValue = ((Integer) leftI.getExpValue()) < ((Integer)rightI.getExpValue());
        } else if (node instanceof ALtExp) {
            PExpIntepreter leftI = new PExpIntepreter();
            leftI.interprete(e, ((ALtExp) node).getLeft());
            PExpIntepreter rightI = new PExpIntepreter();
            rightI.interprete(e,((ALtExp) node).getRight());
            expValue = ((Integer) leftI.getExpValue()) < ((Integer)rightI.getExpValue());
        } else if (node instanceof AGtExp) {
            PExpIntepreter leftI = new PExpIntepreter();
            leftI.interprete(e,((AGtExp) node).getLeft());
            PExpIntepreter rightI = new PExpIntepreter();
            rightI.interprete(e,((AGtExp) node).getRight());
            expValue = ((Integer) leftI.getExpValue()) < ((Integer)rightI.getExpValue());
        } else if (node instanceof ANotExp) {
            PExpIntepreter expI = new PExpIntepreter();
            expI.interprete(e, ((ANotExp) node).getExp());
            expValue = ! ((Boolean) expI.getExpValue());
        } else if (node instanceof AParenExp) {
            PExpIntepreter expI = new PExpIntepreter();
            expI.interprete(e, ((AParenExp) node).getExp());
            expValue = ((Boolean) expI.getExpValue());
        } else if (node instanceof ATrueExp) {
            expValue = new Boolean(true);
        } else if (node instanceof AFalseExp) {
            expValue = new Boolean(false);
        } else if (node instanceof ANumberExp) {
            expValue = new Integer(((ANumberExp) node).getNumber().toString());
        } else if (node instanceof AIdentExp) {
            expValue = e.getEnvVars().get(((AIdentExp) node).getIdent().getText());
        }
        return null;
    }
}
