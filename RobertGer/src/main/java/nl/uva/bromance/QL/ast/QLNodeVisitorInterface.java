package nl.uva.bromance.QL.ast;

import nl.uva.bromance.QL.ast.nodes.Calculation;
import nl.uva.bromance.QL.ast.nodes.Form;
import nl.uva.bromance.QL.ast.nodes.Question;
import nl.uva.bromance.QL.ast.nodes.Questionnaire;
import nl.uva.bromance.QL.controlstructures.Else;
import nl.uva.bromance.QL.controlstructures.If;
import nl.uva.bromance.QL.controlstructures.IfSequence;
import nl.uva.bromance.QL.expressions.unary.Variable;

public interface QLNodeVisitorInterface {

    void visit(QLNode qlNode);

    void visit(Form form);

    void visit(Question question);

    void visit(Questionnaire questionnaire);

    void visit(If _if);

    void visit(Calculation calc);

    void visit(Variable var);

    void visit();

    void exit(If _f);

    void visit(Else _else);

    void visit(IfSequence sequence);

    void exit(IfSequence sequence);
}
