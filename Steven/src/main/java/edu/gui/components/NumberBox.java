package edu.gui.components;

import edu.parser.QL.nodes.question.Question;

import javax.swing.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.PlainDocument;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

/**
 * Created by Steven Kok on 25/02/2015.
 */
public class NumberBox extends AbstractBox implements FocusListener {
    private final JTextField textField;

    public NumberBox(Question question) {
        super(question);
        textField = new JTextField();
        textField.setDocument(getPlainDocument());
        textField.addFocusListener(this);
        textField.setColumns(15);
        initialize();
    }

    private PlainDocument getPlainDocument() {
        PlainDocument plainDocument = new PlainDocument();
        plainDocument.setDocumentFilter(new DocumentFilter() {
            @Override
            public void insertString(FilterBypass fb, int off, String str, AttributeSet attr)
                    throws BadLocationException {
                fb.insertString(off, str.replaceAll("\\D++", ""), attr);  // remove non-digits
            }

            @Override
            public void replace(FilterBypass fb, int off, int len, String str, AttributeSet attr)
                    throws BadLocationException {
                fb.replace(off, len, str.replaceAll("\\D++", ""), attr);  // remove non-digits
            }
        });
        return plainDocument;
    }

    @Override
    public void removeEventListeners() {
        textField.removeFocusListener(this);
    }

    public void initialize() {
        textField.setText(getQuestion().getValue().getValue());
        if (computedQuestion(getQuestion())) {
            textField.setEditable(false);
            this.removeEventListeners();
        }
    }

    @Override
    public void focusGained(FocusEvent e) {
    }

    @Override
    public void focusLost(FocusEvent e) {
        notifyObservers();
    }

    @Override
    public void notifyObservers() {
        getObservers().stream()
                .forEach(observer -> observer.update(this));
    }

    @Override
    public JComponent getComponent() {
        return textField;
    }

    public String getText() {
        return textField.getText();
    }

}
