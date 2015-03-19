package ql.semantics;

import ql.ast.form.Form;
import ql.ast.form.FormVisitor;
import ql.ast.statement.*;
import ql.ast.type.*;
import ql.semantics.errors.Error;
import ql.semantics.errors.Messages;
import ql.semantics.errors.Warning;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by bore on 13/02/15.
 */

public class TypeChecker implements FormVisitor<Void>, StatVisitor<Void>
{
    private final Questions questions;
    private final QuestionDependencies questionDependencies;
    private final LabelMap labels;
    private final Messages messages;

    public static Messages check(Form f)
    {
        Questions questions = QuestionCollector.collect(f);
        QuestionDependencies dependencies = QuestionDependenciesBuilder.build(f);
        TypeChecker typeChecker = new TypeChecker(questions, dependencies);
        typeChecker.checkForIdentDuplication();

        f.accept(typeChecker);

        typeChecker.checkForCyclicDependencies();
        typeChecker.checkForLabelDuplication();

        return typeChecker.messages;
    }

    private TypeChecker(Questions questions, QuestionDependencies dependencies)
    {
        this.questions = questions;
        this.questionDependencies = dependencies;
        this.labels = new LabelMap();
        this.messages = new Messages();
    }

    private void checkForIdentDuplication()
    {
        for (String id : this.questions)
        {
            List<Question> lq = this.questions.getQuestionsById(id);
            if (this.isIdentDuplicate(lq))
            {
                this.addDuplicationError(id, lq);
            }
        }
    }

    private List<Integer> getSortedLineNumbers(List<Question> qs)
    {
        List<Integer> result = new ArrayList<>();
        for (Question q : qs)
        {
            result.add(q.getLineNumber());
        }
        Collections.sort(result);

        return result;
    }

    private boolean isIdentDuplicate(List<Question> lq)
    {
        return lq.size() > 1;
    }

    private void addDuplicationError(String id, List<Question> lq)
    {
        List<String> lines = this.getSortedLineNumbers(lq)
                .stream()
                .map(Object::toString)
                .collect(Collectors.toList());

        Error error = Error.identifierAlreadyDeclared(id, lines);

        this.messages.add(error);
    }

    @Override
    public Void visit(Form form)
    {
        for (Statement statement : form.getBody())
        {
            statement.accept(this);
        }

        return null;
    }

    @Override
    public Void visit(IfCondition condition)
    {
        Type inferredType = TypeDeducer.deduceType(condition.getCondition(), this.questions, this.messages);

        if (this.isTypeAllowedInCond(inferredType))
        {
            this.messages.add(Error.ifConditionShouldBeBoolean(condition.getLineNumber()));
        }

        for (Statement statement : condition.getBody())
        {
            statement.accept(this);
        }

        return null;
    }

    private boolean isTypeAllowedInCond(Type type)
    {
        return !type.isBool();
    }

    @Override
    public Void visit(Question q)
    {
        this.labels.registerLabel(q);
        return null;
    }

    @Override
    public Void visit(CalculatedQuestion q)
    {
        this.labels.registerLabel(q);
        Type defined = q.getType();

        Type inferredType = TypeDeducer.deduceType(q.getCalculation(), questions, this.messages);

        Type assigned = inferredType.promoteTo(defined);

        if (this.areTypesMismatched(defined, assigned))
        {
            this.messages.add(Error.identifierDefEvalMismatch(q.getId(), defined.getTitle(), assigned.getTitle(),
                    q.getLineNumber()));
        }

        return null;
    }

    private boolean areTypesMismatched(Type defined, Type assigned)
    {
        return this.isTypeDeclared(defined) &&
                this.isTypeDeclared(assigned) &&
                !(defined.equals(assigned));
    }

    private boolean isTypeDeclared(Type type)
    {
        return !type.isUndef();
    }

    private void checkForCyclicDependencies()
    {
        if (this.questionDependencies.containsCycle())
        {
            Identifiers cyclicIds = this.questionDependencies.getCycleIds();
            this.messages.add(Error.cyclicQuestions(cyclicIds.toString()));
        }
    }

    private void checkForLabelDuplication()
    {
        LabelDuplicates duplicates = this.labels.getLabelDuplicatesSet();
        for (Identifiers d : duplicates)
        {
            this.messages.add(Warning.labelDuplication(d.toString()));
        }
    }
}
