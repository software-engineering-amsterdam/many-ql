package edu.parser

import edu.parser.QLS.nodes.Section
import edu.parser.QLS.nodes.statement.Default
import edu.parser.QLS.nodes.statement.Page
import edu.parser.QLS.nodes.statement.QLSQuestion

/**
 * Created by Steven Kok on 11/03/2015.
 */
public class SectionBuilder {
    private String title;
    private List<QLSQuestion> questions
    private List<Default> defaultStatements

    SectionBuilder() {
        title = "title"
        this.questions = new ArrayList<>()
    }

    public Section build() {
        return new Section(title, questions, defaultStatements)
    }

    public SectionBuilder addQuestion(QLSQuestion qlsQuestion) {
        questions.add(qlsQuestion)
        return this
    }

    public SectionBuilder addDefault(Default aDefault) {
        defaultStatements.add(aDefault)
        return this
    }

    public SectionBuilder title(String title) {
        this.title = title
        return this
    }
}
