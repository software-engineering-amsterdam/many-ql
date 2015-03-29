package qls.gui;

import ql.gui.SimpleModeler;
import ql.gui.canvas.Canvas;
import ql.gui.segment.*;
import ql.semantics.CondQuestionTable;
import qls.ast.*;
import qls.ast.Page;
import qls.ast.rule.Rules;
import qls.ast.statement.*;
import qls.ast.statement.Section;
import qls.ast.statement.Statement;
import qls.semantics.QuestionStyles;
import qls.semantics.RowStyleBuilder;

import java.util.*;

/**
 * Created by Nik on 10-3-15.
 */
public class StyledModeler extends SimpleModeler implements StylesheetVisitor<Segment>, StatementVisitor<Segment>
{
    private final Stylesheet stylesheet;
    private final QuestionStyles questionStyles;

    public StyledModeler(CondQuestionTable condQuestionTable, Stylesheet stylesheet, QuestionStyles questionStyles)
    {
        super(condQuestionTable);
        this.stylesheet = stylesheet;
        this.questionStyles = questionStyles;
    }

    @Override
    public Canvas model()
    {
        List<ql.gui.segment.Page> pages = new ArrayList<>();
        for (Page p : this.stylesheet.getBody())
        {
            //TODO: get rid of this cast if possible
            ql.gui.segment.Page page = (ql.gui.segment.Page) p.accept(this);
            pages.add(page);
        }

        return new Canvas(getCondQuestionTable().getTitle(), pages);
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

    // TODO: why throw exception for the default stat but not for the stylesheet?
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

        return new ql.gui.segment.Page(segments, p.getName(), true);
    }
}
