package ql.gui;

import ql.ast.statement.StatVisitor;
import ql.gui.canvas.Canvas;
import ql.gui.segment.Segment;
import ql.semantics.Flat;

/**
 * Created by Nik on 10-3-15.
 */
public abstract class Modeler implements StatVisitor<Segment>
{
    public abstract Canvas model(Flat flat);
}
