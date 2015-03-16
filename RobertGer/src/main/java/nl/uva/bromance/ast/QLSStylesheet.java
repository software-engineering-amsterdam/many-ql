package nl.uva.bromance.ast;

public class QLSStylesheet extends QLSNode {

    public QLSStylesheet(int lineNumber) {
        super(lineNumber, QLSStylesheet.class);
    }

    @Override
    public void printDebug(int i) {
        for (int j = 0; j < i; j++) {
            System.out.print("\t");
        }
        System.out.print("[Stylesheet] { }\n");
        for (QLSNode n : this.getChildren()) {
            n.printDebug(i + 1);
        }
    }
}
