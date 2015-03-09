package lang.ql.gui;

import lang.ql.ast.form.Form;
import lang.ql.ast.form.FormVisitor;
import lang.ql.ast.statement.*;
import lang.ql.gui.canvas.Canvas;
import lang.ql.gui.input.*;
import lang.ql.gui.label.Label;
import lang.ql.gui.section.ConditionalSection;
import lang.ql.gui.section.LineSection;
import lang.ql.gui.section.Section;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Nik on 17-2-15.
 */
public class Modeler implements FormVisitor<GuiElement>, StatVisitor<GuiElement>
{


    @Override
    public Canvas visit(Form form)
    {
        List<Section> sections = new ArrayList<Section>();
        for (Statement s : form.getBody())
        {
            sections.add((Section)s.accept(this));
        }

        return new Canvas(form.getId(), sections);
    }

    @Override
    public GuiElement visit(Question q)
    {
        Label label = new Label(q.getLabel());
        Input input = InputBuilder.build(q.getId(), q.getType());
        return new LineSection(label, input);
    }

    @Override
    public GuiElement visit(CalculatedQuestion cq)
    {
        Label label = new Label(cq.getLabel());
        Input input = ExprInputBuilder.build(cq.getId(), cq.getCalculation(), cq.getType());
        return new LineSection(label, input);
    }

    @Override
    public GuiElement visit(IfCondition ifCond)
    {
        List<Section> sections = new ArrayList<Section>();
        for (Statement s : ifCond.getBody())
        {
            sections.add((Section)s.accept(this));
        }
        // TODO: get this to work
        return new ConditionalSection(ifCond.getCondition(), sections);
    }
}
