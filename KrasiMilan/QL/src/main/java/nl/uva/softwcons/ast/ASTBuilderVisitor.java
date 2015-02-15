package nl.uva.softwcons.ast;

import java.util.List;
import java.util.stream.Collectors;

import nl.uva.softwcons.ast.expression.Expression;
import nl.uva.softwcons.ast.form.Form;
import nl.uva.softwcons.ast.statement.ComputedQuestion;
import nl.uva.softwcons.ast.statement.Conditional;
import nl.uva.softwcons.ast.statement.Question;
import nl.uva.softwcons.ast.statement.Statement;
import nl.uva.softwcons.ast.type.Type;
import nl.uva.softwcons.generated.QLBaseVisitor;
import nl.uva.softwcons.generated.QLParser.ComputedQuestionContext;
import nl.uva.softwcons.generated.QLParser.ConditionalContext;
import nl.uva.softwcons.generated.QLParser.FormContext;
import nl.uva.softwcons.generated.QLParser.SimpleQuestionContext;
import nl.uva.softwcons.generated.QLParser.TypeContext;
import nl.uva.softwcons.util.Utils;

public class ASTBuilderVisitor extends QLBaseVisitor<ASTNode> {

    @Override
    public Form visitForm(FormContext ctx) {
        final String formName = ctx.ID().getText();
        final List<Statement> statements = ctx.statement().stream().map(st -> (Statement) st.accept(this))
                .collect(Collectors.toList());

        return new Form(formName, statements);
    }

    @Override
    public Question visitSimpleQuestion(SimpleQuestionContext ctx) {
        final String id = ctx.ID().getText();
        final String label = Utils.unquote(ctx.STRING().getText());
        final Type type = (Type) ctx.type().accept(this);

        return new Question(id, label, type);
    }

    @Override
    public ComputedQuestion visitComputedQuestion(ComputedQuestionContext ctx) {
        final String id = ctx.ID().getText();
        final String label = Utils.unquote(ctx.STRING().getText());
        final Type type = (Type) ctx.type().accept(this);
        final Expression value = (Expression) ctx.expr().accept(this);

        return new ComputedQuestion(id, label, type, value);
    }

    @Override
    public Conditional visitConditional(ConditionalContext ctx) {
        final Expression condition = (Expression) ctx.expr().accept(this);
        final List<Question> questions = ctx.question().stream().map(q -> (Question) q.accept(this))
                .collect(Collectors.toList());

        return new Conditional(condition, questions);
    }

    @Override
    public Type visitType(TypeContext ctx) {
        return Type.valueOf(ctx.getText().toUpperCase());
    }

}
