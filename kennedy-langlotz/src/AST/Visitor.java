package AST;

import AST.KLQNodes.*;
import AST.KLQNodes.ASTString;

/**
 * Created by juriaan on 10-2-15.
 */
public interface Visitor {
    public void visit(Questionnaire node);
    public void visit(Question node);
    public void visit(ASTString node);
}
