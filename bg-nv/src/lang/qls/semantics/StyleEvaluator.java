package lang.qls.semantics;

import lang.ql.ast.form.Form;
import lang.ql.ast.type.Type;
import lang.ql.semantics.QuestionCollector;
import lang.ql.semantics.QuestionResult;
import lang.ql.semantics.QuestionMap;
import lang.qls.ast.Page;
import lang.qls.ast.rule.Rules;
import lang.qls.ast.statement.*;
import lang.qls.ast.Styleable;
import lang.qls.ast.Stylesheet;
import lang.qls.ast.StylesheetVisitor;

/**
 * Created by bore on 09/03/15.
 */
public class StyleEvaluator implements StylesheetVisitor<Void>, StatementVisitor<Void>
{
    private QuestionMap questions;
    private StyleStack styleStack;
    private FormStyle styles;

    public static FormStyle getStyles(Stylesheet s, Form f)
    {
        QuestionResult result = QuestionCollector.collect(f);
        StyleEvaluator styleEval = new StyleEvaluator(result.getQuestionMap());
        styleEval.visit(s);

        return styleEval.styles;
    }

    private StyleEvaluator(QuestionMap questions)
    {
        this.questions = questions;
        this.styleStack = new StyleStack();
        this.styles = new FormStyle();
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

        this.styleStack.push(style);

        for (Statement stat : stats)
        {
            stat.accept(this);
        }

        this.styleStack.pop();
    }

    @Override
    public Void visit(Question q)
    {
        Type questionType = this.questions.getType(q.getId());
        Rules result = this.styleStack.getRulesForType(questionType);

        this.styles.registerStyle(q.getId(), result);

        return null;
    }

    @Override
    public Void visit(QuestionWithRules q)
    {
        Rules r = q.getBody();
        Type questionType = this.questions.getType(q.getId());
        Style s = new Style();
        s.addRules(questionType, r);

        this.styleStack.push(s);
        Rules result = this.styleStack.getRulesForType(questionType);
        this.styleStack.pop();

        this.styles.registerStyle(q.getId(), result);

        return null;
    }

    @Override
    public Void visit(DefaultStat d)
    {
        return null;
    }
}
