package edu.parser.QLS.nodes;

import edu.nodes.styles.Style;
import edu.parser.QLS.QLSVisitor;
import edu.parser.QLS.nodes.statement.QLSQuestion;

import java.util.List;

/**
 * Created by Steven Kok on 28/02/2015.
 */
public class Section implements AbstractNode {
    private final String title;
    private final List<QLSQuestion> questions;
    private final List<Style> styles;

    public Section(String title, List<QLSQuestion> questions, List<Style> styles) {
        this.title = title;
        this.questions = questions;
        this.styles = styles;
    }

    public String getTitle() {
        return title;
    }

    public List<QLSQuestion> getQuestions() {
        return questions;
    }

    public List<Style> getStyles() {
        return styles;
    }

    @Override
    public AbstractNode accept(QLSVisitor QLSVisitor) {
        return QLSVisitor.visit(this);
    }
}
