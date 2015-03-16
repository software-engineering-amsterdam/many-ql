package ql.semantics;

import ql.ast.form.Form;
import ql.ast.form.FormVisitor;
import ql.ast.statement.*;
import ql.ast.type.*;
import ql.semantics.errors.Error;
import ql.semantics.errors.Messages;
import ql.semantics.errors.Warning;

/**
 * Created by bore on 13/02/15.
 */

public class TypeChecker implements FormVisitor<Boolean>, StatVisitor<Boolean>
{
    private final QuestionMap questionMap;
    private final QuestionDependencies questionDependencies;
    private final LabelMap labels;
    private final Messages messages;

    public static Messages check(Form f)
    {
        QuestionResult questionResult = QuestionCollector.collect(f);

        if (questionResult.containsErrors())
        {
            return questionResult.getMessages();
        }

        QuestionMap questions = questionResult.getQuestionMap();
        QuestionDependencies dependencies = QuestionDependenciesBuilder.build(f);
        TypeChecker typeChecker = new TypeChecker(questions, dependencies);

        if (f.accept(typeChecker))
        {
            typeChecker.checkForCyclicDependencies();
            typeChecker.checkForLabelDuplication();
        }

        return typeChecker.messages;
    }

    private TypeChecker(QuestionMap questions, QuestionDependencies dependencies)
    {
        this.questionMap = questions;
        this.questionDependencies = dependencies;
        this.labels = new LabelMap();
        this.messages = new Messages();
    }

    @Override
    public Boolean visit(Form form)
    {
        for (Statement statement : form.getBody())
        {
            if (!(statement.accept(this)))
            {
                return false;
            }
        }

        return true;
    }

    @Override
    public Boolean visit(IfCondition condition)
    {
        InferredTypeResult condResult = TypeDeducer.deduceType(condition.getCondition(), questionMap);
        if (condResult.containsErrors())
        {
            this.messages.addAll(condResult.getMessages());
            return false;
        }

        if (this.isTypeAllowedInCond(condResult.getType()))
        {
            this.messages.add(Error.ifConditionShouldBeBoolean(condition.getLineNumber()));
            return false;
        }

        for (Statement statement : condition.getBody())
        {
            if (!(statement.accept(this)))
            {
                return false;
            }
        }

        return true;
    }

    private boolean isTypeAllowedInCond(Type type)
    {
        return !type.isBool();
    }

    @Override
    public Boolean visit(Question q)
    {
        this.labels.registerLabel(q);
        return true;
    }

    @Override
    public Boolean visit(CalculatedQuestion q)
    {
        this.labels.registerLabel(q);
        Type defined = q.getType();

        InferredTypeResult typeResult = TypeDeducer.deduceType(q.getCalculation(), questionMap);
        if (typeResult.containsErrors())
        {
            this.messages.addAll(typeResult.getMessages());
            return false;
        }

        Type assigned = typeResult.getType().promoteTo(defined);

        if (!(defined.equals(assigned)))
        {
            this.messages.add(Error.identifierDefEvalMismatch(q.getId(), defined.getTitle(), assigned.getTitle(),
                    q.getLineNumber()));

            return false;
        }

        return true;
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
