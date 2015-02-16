package nl.uva.bromance.parsers.AST.Conditionals;

import nl.uva.bromance.parsers.AST.Expression;
import nl.uva.bromance.parsers.AST.Node;

/**
 * Created by Gerrit Krijnen on 2/16/2015.
 */
public class IfStatement extends Expression {
    public void printDebug(int i){
        for (int j=0; j < i; j++){
            System.out.print("\t");
        }
        System.out.print("[If Statement]\n");
        for (Node n :children){
            n.printDebug(i+1);
        }
    }
}
