package ql.gui;

import ql.gui.canvas.CanvasVisitor;
import ql.gui.control.*;
import ql.gui.input.*;
import ql.gui.label.LabelVisitor;
import ql.gui.segment.SegmentVisitor;

/**
 * Created by Nik on 23-2-15.
 */
public interface ModelVisitor<T> extends CanvasVisitor<T>, SegmentVisitor<T>, LabelVisitor<T>, InputVisitor<T>, ControlVisitor<T>
{

}
