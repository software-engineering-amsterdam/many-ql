package org.uva.ql.view.widgit;

import java.awt.Dimension;

import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;

import org.uva.ql.view.observer.Observer;

public abstract class QLBaseTextField extends JTextField implements Observer, DocumentListener {

	private static final long serialVersionUID = 1L;

	public QLBaseTextField() {
		setPreferredSize(new Dimension(100, 25));
		getDocument().addDocumentListener(this);
	}

	@Override
	public void insertUpdate(DocumentEvent e) {
		try {
			System.out.println(e.getDocument().getText(0, e.getDocument().getLength()));
		} catch (BadLocationException e1) {
			System.out.println("Something went terribly wrong.");
		}
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		try {
			System.out.println(e.getDocument().getText(0, e.getDocument().getLength()));
		} catch (BadLocationException e1) {
			System.out.println("Something went terribly wrong.");
		}
	}

	@Override
	public void changedUpdate(DocumentEvent e) {
		System.out.println("When does this trigger?..");
	}

}
