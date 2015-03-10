package edu.parser.QLS;

import edu.nodes.QuestionType;
import edu.nodes.styles.Style;
import edu.parser.QLS.nodes.AbstractNode;
import edu.parser.QLS.nodes.Identifier;
import edu.parser.QLS.nodes.Section;
import edu.parser.QLS.nodes.Stylesheet;
import edu.parser.QLS.nodes.statement.Default;
import edu.parser.QLS.nodes.statement.Page;
import edu.parser.QLS.nodes.statement.QLSQuestion;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Steven Kok on 06/03/2015.
 */
public class QuestionRetriever implements QLSVisitor {

    private List<QLSQuestion> questions = new ArrayList<>();

    public List<QLSQuestion> retrieveQuestions(Stylesheet stylesheet) {
        questions.clear();
        visit(stylesheet);
        return questions;
    }

    @Override
    public AbstractNode visit(Stylesheet stylesheet) {
        stylesheet.getStatements()
                .stream()
                .forEach(statement -> statement.accept(this));
        return stylesheet;
    }

    @Override
    public AbstractNode visit(Page page) {
        page.getSections()
                .stream()
                .forEach(section -> section.accept(this));
        return page;
    }

    @Override
    public AbstractNode visit(QLSQuestion question) {
        questions.add(question);
        return question;
    }

    @Override
    public AbstractNode visit(Identifier identifier) {
        return identifier;
    }

    @Override
    public AbstractNode visit(Section section) {
        section.getQuestions()
                .stream()
                .forEach(s -> s.accept(this));
        return section;
    }

    @Override
    public AbstractNode visit(Default aDefault) {
        return aDefault;
    }

    @Override
    public AbstractNode visit(QuestionType questionType) {
        return questionType;
    }

    @Override
    public AbstractNode visit(Style style) {
        return style;
    }
}
