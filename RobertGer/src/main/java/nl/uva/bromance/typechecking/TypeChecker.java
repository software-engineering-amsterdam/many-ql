package nl.uva.bromance.typechecking;

import nl.uva.bromance.ast.*;
import nl.uva.bromance.ast.conditionals.ElseIfStatement;
import nl.uva.bromance.ast.conditionals.ElseStatement;
import nl.uva.bromance.ast.conditionals.Expression;
import nl.uva.bromance.ast.conditionals.IfStatement;
import nl.uva.bromance.ast.visitors.NodeVisitor;
import nl.uva.bromance.ast.visitors.NullNodeVisitor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by Gerrit Krijnen on 2/17/2015.
 */
public class TypeChecker implements NodeVisitor {
    private ReferenceMap referenceMap = new ReferenceMap();
    private List<TypeCheckingException> exceptions = new ArrayList<>();

    public List<TypeCheckingException> runChecks(QLNode node) {
        node.accept(this);
        return exceptions;
    }

    @Override
    public void visit(Calculation calculation) {

    }

    @Override
    public void visit(Form form) {
        Optional<String> identifier = form.getIdentifier();
        if (identifier.isPresent()) {
            if (referenceMap.get(identifier.get()) != null) {
                exceptions.add(new TypeCheckingException.AlreadyDefinedTypeCheckingException(form, identifier.get()));
            } else {
                referenceMap.put(identifier.get(), form);
            }
        } else {
            exceptions .add(new TypeCheckingException.NoIdentifierDefinedTypeCheckingException(form.getLineNumber()));
        }
    }

    @Override
    public void visit(Input input) {

    }

    @Override
    public void visit(Label label) {

    }

    @Override
    public void visit(LabelText labelText) {

    }

    @Override
    public void visit(Question question){
        if (question.getQuestionString() == null) {
            exceptions.add( new TypeCheckingException("Question Error: No question asked"));
        }
        if ((question.isQuestionTypeBoolean() || question.isQuestionTypeString()) && question.getQuestionRange().isPresent()) {
            exceptions.add( new TypeCheckingException.QuestionRangeTypeCheckingException("TypeChecker Error @ line " + question.getLineNumber() + ": Question " + question.getIdentifier() + ", no range allowed for types boolean and string."));
        }
//TODO: Identifiers are forced by the grammar. Optional can go.
        if (question.getIdentifier().isPresent()) {
            if (referenceMap.get(question.getIdentifier().get().getId()) != null) {
                exceptions.add(new TypeCheckingException.AlreadyDefinedTypeCheckingException(question, question.getIdentifier().get().getId()));
            } else {
                referenceMap.put(question.getIdentifier().get().getId(), question);
            }
        } else {
            exceptions.add(new TypeCheckingException.NoIdentifierDefinedTypeCheckingException(question.getLineNumber()));
        }
    }

    @Override
    public void visit(Questionnaire questionnaire) {

    }

    @Override
    public void visit(IfStatement ifStatement) {

    }

    @Override
    public void visit(ElseIfStatement elseIfStatement) {

    }

    @Override
    public void visit(ElseStatement elseStatement) {

    }

    @Override
    public void visit(Expression expression) {

    }
}
