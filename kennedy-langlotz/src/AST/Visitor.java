package AST;

import AST.KLQNodes.*;

/**
 * Created by juriaan on 10-2-15.
 */
public interface Visitor {
    public void visit(QuestionnaireNode node);
    public void visit(QuestionNode node);
    public void visit(SpecificationNode node);
    public void visit(QuestionIdentifierNode node);
    public void visit(QuestionTypeNode node);
    public void visit(QuestionTextNode node);
    public void visit(QuestionValueNode node);
    public void visit(AnswersNode node);
    public void visit(StringNode node);
}
