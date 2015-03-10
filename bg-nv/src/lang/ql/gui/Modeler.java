package lang.ql.gui;

import lang.ql.ast.statement.StatVisitor;
import lang.ql.gui.canvas.Canvas;
import lang.ql.gui.segment.Segment;
import lang.ql.semantics.Flat;

/**
 * Created by Nik on 10-3-15.
 */
public abstract class Modeler implements StatVisitor<Segment>
{
    public abstract Canvas model(Flat flat);
}
