package ql.semantics;

import ql.ast.form.Form;
import ql.ast.form.FormVisitor;
import ql.ast.statement.*;
import ql.ast.type.*;
import ql.semantics.errors.Error;
import ql.semantics.errors.Messages;
import ql.semantics.errors.Warning;
import ql.util.StringHelper;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by bore on 13/02/15.
 */

public class TypeChecker implements FormVisitor<Void>, StatVisitor<Void>
{
    private final QuestionSet questionSet;
    private final QuestionDependencies questionDependencies;
    private final LabelMap labels;
    private final Messages messages;

    public static Messages check(Form f)
    {
        QuestionSet questions = QuestionCollector.collect(f);
        QuestionDependencies dependencies = QuestionDependenciesBuilder.build(f);
        TypeChecker typeChecker = new TypeChecker(questions, dependencies);
        typeChecker.checkForIdentDuplication();

        f.accept(typeChecker);

        typeChecker.checkForCyclicDependencies();
        typeChecker.checkForLabelDuplication();

        return typeChecker.messages;
    }

    private TypeChecker(QuestionSet questions, QuestionDependencies dependencies)
    {
        this.questionSet = questions;
        this.questionDependencies = dependencies;
        this.labels = new LabelMap();
        this.messages = new Messages();
    }

    private void checkForIdentDuplication()
    {
        Set<List<Question>> identDuplications = this.getDuplicate();

        for (List<Question> qs : identDuplications)
        {
            List<String> lines = this.getLineNumbers(qs);
            String id = qs.get(0).getId();
            Error error = Error.identifierAlreadyDeclared(id, lines);

            this.messages.add(error);
        }
    }

    private List<String> getLineNumbers(List<Question> questions)
    {
        List<String> lines = new ArrayList<>();
        for (Question q : questions)
        {
            lines.add(Integer.toString(q.getLineNumber()));
        }
        return lines;
    }

    private Set<List<Question>> getDuplicate()
    {
        Map<String, List<Question>> idToQuestion = new HashMap<>();
        for (Question q : this.questionSet)
        {
            if (idToQuestion.containsKey(q.getId()))
            {
                List<Question> list = idToQuestion.get(q.getId());
                list.add(q);
            }
            else
            {
                List<Question> list = new ArrayList<>();
                list.add(q);
                idToQuestion.put(q.getId(), list);
            }
        }

        return idToQuestion.values().stream().
                filter(s -> s.size() > 1).
                collect(Collectors.toSet());
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
        InferredTypeResult condResult = TypeDeducer.deduceType(condition.getCondition(), questionSet);
        if (condResult.containsErrors())
        {
            this.messages.addAll(condResult.getMessages());
            //return false;
        }

        if (this.isTypeAllowedInCond(condResult.getType()))
        {
            this.messages.add(Error.ifConditionShouldBeBoolean(condition.getLineNumber()));
            //return false;
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

        InferredTypeResult typeResult = TypeDeducer.deduceType(q.getCalculation(), questionSet);
        if (typeResult.containsErrors())
        {
            this.messages.addAll(typeResult.getMessages());
        }

        Type assigned = typeResult.getType().promoteTo(defined);

        if (!(defined.equals(assigned)))
        {
            this.messages.add(Error.identifierDefEvalMismatch(q.getId(), defined.getTitle(), assigned.getTitle(),
                    q.getLineNumber()));
        }

        return null;
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
