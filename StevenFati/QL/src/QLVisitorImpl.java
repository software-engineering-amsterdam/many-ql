import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;

/**
 * Created by Steven Kok on 2/16/2015.
 */
public class QLVisitorImpl implements QLVisitor {
    @Override
    public Object visitStart(QLParser.StartContext ctx) {
        return null;
    }

    @Override
    public Object visitStatement(QLParser.StatementContext ctx) {
        return null;
    }

    @Override
    public Object visitIf_statement(QLParser.If_statementContext ctx) {
        return null;
    }

    @Override
    public Object visitElse_clause(QLParser.Else_clauseContext ctx) {
        return null;
    }

    @Override
    public Object visitExpression(QLParser.ExpressionContext ctx) {
        return null;
    }

    @Override
    public Object visitBool(QLParser.BoolContext ctx) {
        return null;
    }

    @Override
    public Object visitOperator(QLParser.OperatorContext ctx) {
        return null;
    }

    @Override
    public Object visitIdentifier(QLParser.IdentifierContext ctx) {
        return null;
    }

    @Override
    public Object visitQuestion(QLParser.QuestionContext ctx) {
        return null;
    }

    @Override
    public Object visitQuestion_type(QLParser.Question_typeContext ctx) {
        return null;
    }

    @Override
    public Object visitQuestion_label(QLParser.Question_labelContext ctx) {
        return null;
    }

    @Override
    public Object visit(ParseTree parseTree) {
        return null;
    }

    @Override
    public Object visitChildren(RuleNode ruleNode) {
        return null;
    }

    @Override
    public Object visitTerminal(TerminalNode terminalNode) {
        return null;
    }

    @Override
    public Object visitErrorNode(ErrorNode errorNode) {
        return null;
    }
}
