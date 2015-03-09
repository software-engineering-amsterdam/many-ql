package lang.qls.semantics;

import lang.ql.ast.form.Form;
import lang.ql.ast.type.*;
import lang.ql.semantics.errors.Message;
import lang.qls.ast.Page;
import lang.qls.ast.Rule.*;
import lang.qls.ast.Rule.WidgetValue.WidgetValue;
import lang.qls.ast.Statement.*;
import lang.qls.ast.Statement.Question;
import lang.qls.ast.Statement.Statement;
import lang.qls.ast.Stylesheet;
import lang.qls.ast.StylesheetVisitor;
import lang.qls.semantics.messages.StyleError;

import java.util.*;

/**
 * Created by bore on 03/03/15.
 */
public class TypeChecker implements StylesheetVisitor<Boolean>, StatementVisitor<Boolean>
{
    private Map<String, Type> qlQuestions;
    private Set<String> refQuestions;
    private List<Message> messages;

    private static final Map<Type, Set<String>> allowedWidgets;

    static
    {
        allowedWidgets = new HashMap<>();

        Set<String> i = new HashSet<>();
        i.add("slider");
        i.add("spinbox");
        i.add("text");
        allowedWidgets.put(new IntType(), i);

        Set<String> s = new HashSet<>();
        s.add("text");
        allowedWidgets.put(new StrType(), s);

        Set<String> b = new HashSet<>();
        b.add("radio");
        b.add("checkbox");
        b.add("dropdown");
        allowedWidgets.put(new BoolType(), b);
    }

    public static List<Message> check(Stylesheet s, Form f)
    {
        Map<String, Type> qs = QLQuestionVisitor.extractQuestions(f);
        TypeChecker checker = new TypeChecker(qs);
        checker.visit(s);

        checker.allQuestionsReferencedCheck();

        return checker.messages;
    }

    private TypeChecker(Map<String, Type> qlQuestions)
    {
        this.qlQuestions = qlQuestions;
        this.refQuestions = new HashSet<>();
        this.messages = new ArrayList<>();
    }

    @Override
    public Boolean visit(Stylesheet s)
    {
        for (Page p : s.getBody())
        {
            Boolean r = p.accept(this);
            if (!(r))
            {
                return r;
            }
        }

        return true;
    }

    @Override
    public Boolean visit(Page p)
    {
        for (Statement s : p.getBody())
        {
            Boolean r = s.accept(this);
            if (!(r))
            {
                return r;
            }
        }

        return true;
    }

    @Override
    public Boolean visit(Section s)
    {
        return true;
    }

    @Override
    public Boolean visit(Question q)
    {
        return this.registerQuestion(q);
    }

    @Override
    public Boolean visit(QuestionWithRules q)
    {
        if (this.registerQuestion(q))
        {
            Rules rs = q.getBody();
            Type qType = this.qlQuestions.get(q.getId());
            return this.visitRules(rs, qType, q.getLineNumber());
        }

        return false;
    }

    private Boolean registerQuestion(Question q)
    {
        String id = q.getId();
        if (!(this.qlQuestions.containsKey(id)))
        {
            this.messages.add(StyleError.undefinedQuestion(id, q.getLineNumber()));
            return false;
        }

        if (this.refQuestions.contains(id))
        {
            this.messages.add(StyleError.questionAlreadyReferenced(id, q.getLineNumber()));
            return false;
        }

        this.refQuestions.add(id);

        return true;
    }

    @Override
    public Boolean visit(DefaultStat d)
    {
        Rules rs = d.getBody();
        return this.visitRules(rs, d.getType(), d.getLineNumber());
    }

    private Boolean visitRules(Rules rs, Type declType, int lineNumber)
    {
        Optional<Rule> opRule = rs.getRule("widget");

        if (opRule.isPresent())
        {
            Rule<WidgetValue> r = opRule.get();
            WidgetValue v = r.getValue();
            String assignedWidget = v.getTitle();

            Set<String> allowed = allowedWidgets.get(declType);
            if (!(allowed.contains(assignedWidget)))
            {
                this.messages.add(StyleError.widgetTypeMismatchDefaultStat(assignedWidget, declType.getTitle(), lineNumber));
                return false;
            }
        }

        return true;
    }

    private Boolean allQuestionsReferencedCheck()
    {
        for (String id : this.qlQuestions.keySet())
        {
            if (!(this.refQuestions.contains(id)))
            {
                this.messages.add(StyleError.questionNotReferenced(id));
                return false;
            }
        }
        return true;
    }
}
