package qls.gui;

import ql.gui.SimpleModeler;
import ql.gui.canvas.Canvas;
import ql.gui.segment.Row;
import ql.gui.segment.RowStyle;
import ql.gui.segment.Segment;
import ql.semantics.CondQuestionTable;
import qls.ast.Page;
import qls.ast.Stylesheet;
import qls.ast.StylesheetVisitor;
import qls.ast.rule.Rules;
import qls.ast.statement.*;
import qls.semantics.QuestionStyles;
import qls.semantics.RowStyleBuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nik on 10-3-15.
 */
public class StyledModeler extends SimpleModeler implements StylesheetVisitor<Void>, StatementVisitor<Segment>
{
    private final Stylesheet stylesheet;
    private final QuestionStyles questionStyles;
    private List<ql.gui.segment.Page> pages;

    public StyledModeler(CondQuestionTable condQuestionTable, Stylesheet stylesheet, QuestionStyles questionStyles)
    {
        super(condQuestionTable);
        this.stylesheet = stylesheet;
        this.questionStyles = questionStyles;
    }

    @Override
    public Canvas buildCanvas()
    {
        this.pages = new ArrayList<>();
        this.stylesheet.accept(this);
        return new Canvas(this.getCondQuestionTable().getTitle(), this.pages);
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
        List<Segment> segments = new ArrayList<>();

        for (Statement stat : p.getBody())
        {
            if (stat.isRenderable())
            {
                Segment segment = stat.accept(this);
                segments.add(segment);
            }
        }

        this.pages.add(new ql.gui.segment.Page(segments, p.getTitle()));

        return null;
    }

    @Override
    public Segment visit(Section s)
    {
        List<Segment> segments = new ArrayList<>();
        s.getBody().stream()
                .filter(stat -> stat.isRenderable())
                .forEach(stat -> segments.add(stat.accept(this)));

        return new ql.gui.segment.Section(s.getName(), segments);
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
        ql.ast.statement.Question q = this.getQuestion(id);
        Row row = q.accept(this);
        Rules rules = questionStyles.getStyleForQuestion(id);
        RowStyle style = RowStyleBuilder.build(rules);
        row.applyStyle(style);

        return row;
    }

    @Override
    public Segment visit(DefaultStat d)
    {
        throw new IllegalStateException("Visiting a default node is not allowed");
    }
}
