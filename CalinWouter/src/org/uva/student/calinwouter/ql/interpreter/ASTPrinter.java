package org.uva.student.calinwouter.ql.interpreter;

import org.uva.student.calinwouter.ql.generated.analysis.DepthFirstAdapter;
import org.uva.student.calinwouter.ql.generated.node.Node;

public class ASTPrinter extends DepthFirstAdapter {
    int indent;

    private void printIndent() {
        for (int i = 0; i < indent; i++) {
            System.out.print(" ");
        }
    }

    private void printNode(Node node) {
        printIndent();
        System.out.println(node.getClass().toString().replace("org.uva.student.calinwouter.ql.generated.node.", ""));
    }

    @Override
    public void defaultIn(Node node)
    {
        printNode(node);
        indent++;
    }

    @Override
    public void defaultOut(Node node)
    {
        indent--;
    }
}
