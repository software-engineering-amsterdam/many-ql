package lang.ql.gui;

import lang.ql.ast.form.Form;
import lang.ql.ast.form.FormVisitor;
import lang.ql.ast.statement.StatVisitor;
import lang.ql.gui.canvas.Canvas;

/**
 * Created by Nik on 10-3-15.
 */
public abstract class Modeler implements FormVisitor<GuiElement>, StatVisitor<GuiElement>
{
    public abstract Canvas model(Form ast);
}
