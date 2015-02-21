package nl.uva.bromance.AST.Conditionals;

import nl.uva.bromance.AST.Node;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Gerrit Krijnen on 2/16/2015.
 */
public class Expression extends Node {
    //TODO: Add Input Class
    private static final List<Class<? extends Node>> parentsAllowed = new ArrayList<>(Arrays.asList(Expression.class, IfStatement.class, ElseIfStatement.class, ElseStatement.class));
    private String text;

    public Expression(int lineNumber) {
        super(lineNumber, Expression.class);
        this.setAcceptedParents(parentsAllowed);
    }

    @Override
    public void printDebug(int i) {
        for (int j = 0; j < i; j++) {
            System.out.print("\t");
        }
        System.out.print("[Expression] " + text + " \n");
        for (Node n : children) {
            n.printDebug(i + 1);
        }

    }

    public void setText(String t) {
        this.text = t;
    }

}
