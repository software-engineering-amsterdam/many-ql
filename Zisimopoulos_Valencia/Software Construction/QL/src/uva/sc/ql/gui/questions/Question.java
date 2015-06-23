package uva.sc.ql.gui.questions;

import java.awt.Component;
import javax.swing.JFrame;
import uva.sc.ql.atom.ID;

@SuppressWarnings("serial")
public abstract class Question extends JFrame {

    public abstract Component drawQuestion(ID id, String label,
	    boolean isEditable);

}
