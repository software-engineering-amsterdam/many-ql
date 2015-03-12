package edu.gui.components;


import edu.gui.Observer;
import edu.parser.QL.nodes.question.Question;
import edu.parser.QLS.nodes.Section;
import edu.parser.QLS.nodes.statement.QLSQuestion;

import javax.swing.*;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Steven Kok on 25/02/2015.
 */
public class SectionsPanel extends JPanel {

    public SectionsPanel(Section section, List<Question> questions, Observer questionState) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        List<QLSQuestion> qlsSectionQuestions = section.getQuestions();
        List<Question> sectionQuestions = getSectionQuestions(questions, qlsSectionQuestions);
        QuestionsPanel questionsPanel = new QuestionsPanel(sectionQuestions, questionState);

        add(questionsPanel);

    }

    private List<Question> getSectionQuestions(List<Question> questions, List<QLSQuestion> qlsSectionQuestions) {
        return questions.stream()
                .filter(question -> isSectionQuestion(question, qlsSectionQuestions))
                .collect(Collectors.toList());
    }

    private boolean isSectionQuestion(Question question, List<QLSQuestion> sectionQuestion) {
        return sectionQuestion.stream()
                .anyMatch(q -> q.getQLSIdentifier().getIdentifier().equals(question.getQLIdentifier().getIdentifier()));
    }


}
