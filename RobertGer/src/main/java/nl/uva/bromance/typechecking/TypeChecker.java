package nl.uva.bromance.typechecking;

import nl.uva.bromance.ast.Form;
import nl.uva.bromance.ast.QLNode;
import nl.uva.bromance.ast.Question;
import nl.uva.bromance.ast.visitors.NullQLNodeVisitor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gerrit Krijnen on 2/17/2015.
 */
public class TypeChecker extends NullQLNodeVisitor {
    private ReferenceMap referenceMap = new ReferenceMap();
    private List<TypeCheckingException> exceptions = new ArrayList<>();

    public List<TypeCheckingException> runChecks(QLNode node) {
        node.accept(this);
        return exceptions;
    }

    @Override
    public void visit(Form form) {
        String identifier = form.getIdentifier();
        if (referenceMap.get(identifier) != null) {
            exceptions.add(new TypeCheckingException.AlreadyDefinedTypeCheckingException(form, identifier));
        } else {
            referenceMap.put(identifier, form);
        }
    }

    @Override
    public void visit(Question question) {
        if (question.getQuestionString() == null) {
            exceptions.add(new TypeCheckingException("Question Error: No question asked"));
        }
        if ((question.isQuestionTypeBoolean() || question.isQuestionTypeString()) && question.getQuestionRange().isPresent()) {
            exceptions.add(new TypeCheckingException.QuestionRangeTypeCheckingException("TypeChecker Error @ line " + question.getLineNumber() + ": Question " + question.getIdentifier() + ", no range allowed for types boolean and string."));
        }
        if (referenceMap.get(question.getIdentifier().getId()) != null) {
            exceptions.add(new TypeCheckingException.AlreadyDefinedTypeCheckingException(question, question.getIdentifier().getId()));
        } else {
            referenceMap.put(question.getIdentifier().getId(), question);
        }
    }
}
