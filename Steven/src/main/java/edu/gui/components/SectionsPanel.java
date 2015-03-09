package edu.gui.components;


import edu.gui.Observer;
import edu.nodes.styles.Style;
import edu.parser.QL.nodes.question.Question;
import edu.parser.QLS.nodes.Section;
import edu.parser.QLS.nodes.statement.QLSQuestion;

import javax.swing.*;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by Steven Kok on 25/02/2015.
 */
public class SectionsPanel extends JPanel {

    public SectionsPanel(Section section, Map<Question, List<Style>> questions, Observer questionState) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        List<QLSQuestion> qlsSectionQuestions = getQLSSectionQuestions(section);
        List<Question> sectionQuestions = getSectionQuestions(questions, qlsSectionQuestions);
        QuestionsPanel questionsPanel = new QuestionsPanel(sectionQuestions, questionState);

        add(questionsPanel);

    }

    private List<Question> getSectionQuestions(Map<Question, List<Style>> questions, List<QLSQuestion> qlsSectionQuestions) {
        return questions.keySet()
                .stream()
                .filter(question -> isSectionQuestion(question, qlsSectionQuestions))
                .collect(Collectors.toList());
    }

    private List<QLSQuestion> getQLSSectionQuestions(Section sections) {
        return sections.getStatements()
                .stream()
                .filter(statement -> statement instanceof QLSQuestion)
                .map(question -> (QLSQuestion) question)
                .collect(Collectors.toList());
    }

    private boolean isSectionQuestion(Question question, List<QLSQuestion> sectionQuestion) {
        return sectionQuestion.stream()
                .anyMatch(q -> q.getIdentifier().getIdentifier().equals(question.getIdentifier().getIdentifier()));
    }


}
