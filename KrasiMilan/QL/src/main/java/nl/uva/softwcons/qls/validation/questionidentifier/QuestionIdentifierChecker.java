package nl.uva.softwcons.qls.validation.questionidentifier;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import nl.uva.softwcons.ql.ast.LineInfo;
import nl.uva.softwcons.ql.ast.expression.identifier.Identifier;
import nl.uva.softwcons.ql.ast.form.Form;
import nl.uva.softwcons.ql.validation.Checker;
import nl.uva.softwcons.ql.validation.Error;
import nl.uva.softwcons.ql.validation.identifier.error.DuplicateQuestionIdentifier;
import nl.uva.softwcons.qls.ast.segment.Page;
import nl.uva.softwcons.qls.ast.segment.Question;
import nl.uva.softwcons.qls.ast.segment.Section;
import nl.uva.softwcons.qls.ast.segment.SegmentVisitor;
import nl.uva.softwcons.qls.ast.stylesheet.Stylesheet;
import nl.uva.softwcons.qls.ast.stylesheet.StylesheetVisitor;
import nl.uva.softwcons.qls.validation.questionidentifier.error.MissingQuestionIdentifier;
import nl.uva.softwcons.qls.validation.questionidentifier.error.UnknownQuestionIdentifier;

public final class QuestionIdentifierChecker extends Checker implements StylesheetVisitor<List<Error>>,
        SegmentVisitor<Void> {
    private final Set<Identifier> formQuestionsIdentifiers;
    private final Set<Identifier> stylesheetQuestionsIdentifiers;

    public static List<Error> check(final Stylesheet stylesheet, final Form form) {
        return stylesheet.accept(new QuestionIdentifierChecker(form));
    }

    private QuestionIdentifierChecker(final Form form) {
        this.formQuestionsIdentifiers = FormQuestionCollector.collectFrom(form);
        this.stylesheetQuestionsIdentifiers = new HashSet<Identifier>();
    }

    @Override
    public List<Error> visit(final Stylesheet stylesheet) {
        stylesheet.getPages().forEach(p -> p.accept(this));
        final Set<Identifier> missingIdentifiers = getMissingIdentifiers();
        if (!missingIdentifiers.isEmpty()) {
            this.addError(new MissingQuestionIdentifier(missingIdentifiers));
        }

        return this.getErrors();
    }

    @Override
    public Void visit(final Page page) {
        page.getSegments().forEach(s -> s.accept(this));
        return null;
    }

    @Override
    public Void visit(final Question question) {
        final Identifier currentIdentifier = question.getId();
        final LineInfo currentLineInfo = question.getLineInfo();
        if (!formQuestionsIdentifiers.contains(currentIdentifier)) {
            this.addError(new UnknownQuestionIdentifier(currentLineInfo));
        }
        if (stylesheetQuestionsIdentifiers.contains(currentIdentifier)) {
            this.addError(new DuplicateQuestionIdentifier(currentLineInfo));
        }
        stylesheetQuestionsIdentifiers.add(currentIdentifier);
        return null;
    }

    @Override
    public Void visit(final Section section) {
        section.getContent().forEach(c -> c.accept(this));
        return null;
    }

    private Set<Identifier> getMissingIdentifiers() {
        final Set<Identifier> missingIdentifiers = new HashSet<Identifier>(formQuestionsIdentifiers);
        missingIdentifiers.removeAll(stylesheetQuestionsIdentifiers);
        return missingIdentifiers;
    }

}
