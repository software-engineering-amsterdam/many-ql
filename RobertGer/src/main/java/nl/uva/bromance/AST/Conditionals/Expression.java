package nl.uva.bromance.AST.Conditionals;

import nl.uva.bromance.AST.Node;

/**
 * Created by Gerrit Krijnen on 2/16/2015.
 */
public class Expression extends Node {
    private static final String[] parentsAllowed = {"Expression","IfStatement","ElseIfStatement","ElseStatement","Input"};
    private String text;

    public Expression(int lineNumber){
        super(lineNumber,"Expression");
        this.setAcceptedParents(parentsAllowed);
    }
    @Override
    public void printDebug(int i){
        for (int j=0; j < i; j++){
            System.out.print("\t");
        }
        System.out.print("[Expression] "+text+" \n");
        for (Node n :children){
            n.printDebug(i+1);
        }

    }
    public void setText(String t){
        this.text = t;
    }

}
