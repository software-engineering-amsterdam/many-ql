package nl.uva.bromance.QL.ast;

import nl.uva.bromance.QL.ast.nodes.Calculation;
import nl.uva.bromance.QL.ast.nodes.Form;
import nl.uva.bromance.QL.ast.nodes.Question;
import nl.uva.bromance.QL.ast.nodes.Questionnaire;
import nl.uva.bromance.QL.controlstructures.If;

public interface QLNodeVisitorInterface {

    void visit(QLNode qlNode);

    void visit(Form form);

    void visit(Question question);

    void visit(Questionnaire questionnaire);

    void visit(If _if);

    void visit(Calculation calc);
}
