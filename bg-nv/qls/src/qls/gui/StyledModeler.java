package qls.gui;

import ql.gui.GuiElement;
import ql.gui.SimpleModeler;
import ql.gui.canvas.Canvas;
import ql.gui.segment.*;
import ql.semantics.ConditionalQuestion;
import ql.semantics.Flat;
import qls.ast.*;
import qls.ast.Page;
import qls.ast.rule.Rules;
import qls.ast.statement.*;
import qls.ast.statement.Section;
import qls.semantics.FormStyle;
import qls.semantics.RulesToGui;

import java.util.*;

/**
 * Created by Nik on 10-3-15.
 */
// TODO
public class StyledModeler extends SimpleModeler implements StylesheetVisitor<Segment>, StatementVisitor<Segment>
{
    private final Stylesheet stylesheet;
    private final FormStyle formStyle;
    private Map<String, GuiElement> elems;
    private Flat flat;

    public StyledModeler(Stylesheet stylesheet, FormStyle formStyle)
    {
        super();
        this.stylesheet = stylesheet;
        this.formStyle = formStyle;
    }

    @Override
    public Canvas model(Flat flat)
    {
        // We do not need renderables, we only need to avoid visiting default statements
//        //TODO: get the renderables!
//        Collection<Renderable> renderables = Collections.emptyList();
//
//        List<Segment> segments = new ArrayList<>();
//        for (Renderable r : renderables)
//        {
//            // TODO: create a renderable visitor?
//            // segments.add(r.accept(this));
//        }
        this.flat = flat;
        List<Segment> pageSegments = new ArrayList<>();
        for (Page p : this.stylesheet.getBody())
        {
            pageSegments.add(p.accept(this));
        }

        return new Canvas("Unicorn!", pageSegments);
    }

    @Override
    public Segment visit(Section s)
    {
        List<Segment> segments = new ArrayList<>();

        for (Statement stat : s.getBody())
        {
            if (stat.isRenderable())
            {
                Segment segment = stat.accept(this);
                segments.add(segment);
            }
        }
        return new ql.gui.segment.Section(segments, true);
    }

    @Override
    public Segment visit(qls.ast.statement.Question q)
    {
        ConditionalQuestion cq = this.flat.getConditionalQuestion(q.getId());

        Segment qs = cq.getQuestion().accept(this);
        List<Segment> r = new ArrayList<>();
        r.add(qs);
        Rules rules = formStyle.getStyleForQuestion(q.getId());
        RowStyle style = RulesToGui.convert(rules);
        return new Conditional(cq.getCondition(), r, style);
    }

    @Override
    public Segment visit(QuestionWithRules q)
    {
        ConditionalQuestion cq = this.flat.getConditionalQuestion(q.getId());

        Segment qs = cq.getQuestion().accept(this);
        List<Segment> r = new ArrayList<>();
        r.add(qs);
        return new Conditional(cq.getCondition(), r);
    }

    @Override
    public Segment visit(DefaultStat d)
    {
        throw new IllegalStateException("Visiting a default node is not allowed");
    }

    @Override
    public Segment visit(Stylesheet s)
    {
        return null;
    }

    @Override
    public Segment visit(Page p)
    {
        List<Segment> segments = new ArrayList<>();

        for (Statement stat : p.getBody())
        {
            if (stat.isRenderable())
            {
                Segment segment = stat.accept(this);
                segments.add(segment);
            }
        }

        return new ql.gui.segment.Page(segments, true);
    }
}
