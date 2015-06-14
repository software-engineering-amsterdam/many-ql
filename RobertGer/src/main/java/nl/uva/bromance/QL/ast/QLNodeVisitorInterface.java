package nl.uva.bromance.QL.ast;

import nl.uva.bromance.QL.ast.nodes.Form;
import nl.uva.bromance.QL.ast.nodes.Question;
import nl.uva.bromance.QL.ast.nodes.Questionnaire;

public interface QLNodeVisitorInterface {

    void visit(QLNode qlNode);

    void visit(Form form);

    void visit(Question question);

    void visit(Questionnaire questionnaire);
}
