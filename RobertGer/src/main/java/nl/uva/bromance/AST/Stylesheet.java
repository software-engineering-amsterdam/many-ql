package nl.uva.bromance.AST;

public class Stylesheet extends Node {

    public Stylesheet(int lineNumber) {
        super(lineNumber, Stylesheet.class);
    }

    @Override
    public void printDebug(int i) {
        for (int j = 0; j < i; j++) {
            System.out.print("\t");
        }
        System.out.print("[Root] { }\n");
        for (Node n : getChildren()) {
            n.printDebug(i + 1);
        }
    }
}
