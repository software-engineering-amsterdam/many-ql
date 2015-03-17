package uva.sc.ql.gui;

import java.awt.Component;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public abstract class Question extends JFrame {

    public abstract Component drawQuestion(String id, String label, boolean isEditable);

}
