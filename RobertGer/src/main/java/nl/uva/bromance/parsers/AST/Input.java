package nl.uva.bromance.parsers.AST;

/**
 * Created by Gerrit Krijnen on 2/16/2015.
 */
public class Input extends Node {
    private static final String[] parentsAllowed = {"Calculation","IfStatement","ElseStatement","ElseIfStatement"};

    public Input(int lineNumber){
        super(lineNumber,"Input");
        this.setAcceptedParents(parentsAllowed);
    }

}
