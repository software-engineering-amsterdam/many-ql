package nl.uva.bromance.parsers.AST;

import nl.uva.bromance.parsers.AST.Conditionals.Conditional;
import nl.uva.bromance.parsers.AST.Conditionals.IfStatement;

/**
 * Created by Gerrit Krijnen on 2/16/2015.
 */
public class Expression extends Conditional {
    private static final String[] parentsAllowed = {"Expression","IfStatement"};
    private String text;

    public Expression(){
        super();
        this.setAcceptedParents(parentsAllowed);
    }
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
