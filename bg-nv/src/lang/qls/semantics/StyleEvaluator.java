package lang.qls.semantics;

import lang.ql.ast.form.Form;
import lang.ql.ast.type.Type;
import lang.qls.ast.Page;
import lang.qls.ast.Rule.Rules;
import lang.qls.ast.Statement.*;
import lang.qls.ast.Styleable;
import lang.qls.ast.Stylesheet;
import lang.qls.ast.StylesheetVisitor;

/**
 * Created by bore on 09/03/15.
 */
public class StyleEvaluator implements StylesheetVisitor<Void>, StatementVisitor<Void>
{
    private StyleScope styleScopes;
    private QuestStyles styles;
    private QuestTypes qlQuestions;

    public static QuestStyles getStyles(Stylesheet s, Form f)
    {
        QuestTypes qs = QLQuestionVisitor.extractQuestions(f);
        StyleEvaluator styleEval = new StyleEvaluator(qs);
        styleEval.visit(s);

        return styleEval.styles;
    }

    public StyleEvaluator(QuestTypes qlQuestions)
    {
        this.qlQuestions = qlQuestions;
        this.styleScopes = new StyleScope();
        this.styles = new QuestStyles();
    }

    @Override
    public Void visit(Stylesheet s)
    {
        for (Page p : s.getBody())
        {
            p.accept(this);
        }

        return null;
    }

    @Override
    public Void visit(Page p)
    {
        this.visitStyleable(p, p.getBody());
        return null;
    }

    @Override
    public Void visit(Section sec)
    {
        this.visitStyleable(sec, sec.getBody());
        return null;
    }

    private void visitStyleable(Styleable s, Iterable<Statement> stats)
    {
        Style style = s.getDefaultStyle();

        this.styleScopes.addStyle(style);

        for (Statement stat : stats)
        {
            stat.accept(this);
        }

        this.styleScopes.removeStyle();
    }

    @Override
    public Void visit(Question q)
    {
        Type questionType = this.qlQuestions.getType(q.getId());
        Rules result = this.styleScopes.getRulesForType(questionType);

        this.styles.registerStyle(q.getId(), result);

        return null;
    }

    @Override
    public Void visit(QuestionWithRules q)
    {
        Rules r = q.getBody();
        Type questionType = this.qlQuestions.getType(q.getId());
        Style s = new Style();
        s.addRules(questionType, r);

        this.styleScopes.addStyle(s);
        Rules result = this.styleScopes.getRulesForType(questionType);
        this.styleScopes.removeStyle();

        this.styles.registerStyle(q.getId(), result);

        return null;
    }

    @Override
    public Void visit(DefaultStat d)
    {
        return null;
    }
}
