package qls.gui;

import ql.gui.SimpleModeler;
import ql.gui.canvas.Canvas;
import ql.gui.input.Input;
import ql.gui.input.InputBuilder;
import ql.gui.label.Label;
import ql.gui.segment.*;
import ql.semantics.ConditionalQuestion;
import ql.semantics.Flat;
import qls.ast.*;
import qls.ast.Page;
import qls.ast.rule.Rules;
import qls.ast.statement.*;
import qls.ast.statement.Section;
import qls.ast.statement.Statement;
import qls.semantics.FormStyle;
import qls.semantics.RulesToGui;

import java.util.*;

/**
 * Created by Nik on 10-3-15.
 */
public class StyledModeler extends SimpleModeler implements StylesheetVisitor<Segment>, StatementVisitor<Segment>
{
    private final Stylesheet stylesheet;
    private final FormStyle formStyle;

    public StyledModeler(Flat flat, Stylesheet stylesheet, FormStyle formStyle)
    {
        super(flat);
        this.stylesheet = stylesheet;
        this.formStyle = formStyle;
    }

    @Override
    public Canvas model()
    {
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
        return getConditional(q.getId());
    }

    @Override
    public Segment visit(QuestionWithRules q)
    {

        return getConditional(q.getId());
    }

    private Segment getConditional(String id)
    {
        ConditionalQuestion cq = this.getFlat().getConditionalQuestion(id);
        Row row = cq.getQuestion().accept(this);
        Rules rules = formStyle.getStyleForQuestion(id);
        RowStyle style = RulesToGui.convert(rules);
        row.applyStyle(style);
        return row;
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
