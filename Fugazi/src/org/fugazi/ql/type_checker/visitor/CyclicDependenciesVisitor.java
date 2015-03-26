package org.fugazi.ql.type_checker.visitor;

import org.fugazi.ql.ast.expression.Expression;
import org.fugazi.ql.ast.expression.literal.ID;
import org.fugazi.ql.ast.form.form_data.QLFormDataStorage;
import org.fugazi.ql.ast.form.form_data.visitor.FullQLFormVisitor;
import org.fugazi.ql.ast.statement.ComputedQuestion;
import org.fugazi.ql.type_checker.dependency.DependencyManager;
import org.fugazi.ql.type_checker.issue.ASTNodeIssueType;

import java.util.ArrayList;
import java.util.List;

public class CyclicDependenciesVisitor extends FullQLFormVisitor {

    // used to detect circular dependencies
    private final DependencyManager questionDependencies;
    private ID assignableIdLiteral;

    public CyclicDependenciesVisitor(QLFormDataStorage _formData){
        super(_formData);
        this.questionDependencies = new DependencyManager();
    }

    /**
     * =======================
     * General visitors
     * =======================
     */

    @Override
    public Void visitComputedQuestion(ComputedQuestion assignQuest) {

        ID identifier = assignQuest.getIdentifier();
        Expression computed = assignQuest.getComputedExpression();

        // check if no circular reference
        // is performed while visiting idLiterals
        // from the computed expression

        // first - mark which identifier is dependent on
        // each of the identifiers that will appear while
        // visiting the computed expression
        this.assignableIdLiteral = identifier;

        // this is the only part of visitedQuestion
        // that needs further visiting
        computed.accept(this);

        // analyzing dependencies finished for
        // identifier from this computed question
        this.assignableIdLiteral = null;
        return null;
    }

    /**
     * =======================
     * Literal visitors
     * =======================
     */

    @Override
    public Void visitID(ID idLiteral) {
        // if we are inside a computed expression
        // a dependency needs to be added and marked
        if (this.assignableIdLiteral != null) {
            // assignableIdLiteral is dependent on
            // the current idLiteral
            this.addAndCheckDependency(this.assignableIdLiteral, idLiteral);
        }

        return null;
    }

    /**
     * =======================
     * Checker functions
     * =======================
     */

    // a = b, a - to, b - from
    private boolean checkDependency(ID to, ID from) {
        List<String> toDependencies =
                this.questionDependencies.getIdDependencyNames(to);

        if ((toDependencies != null)
                && toDependencies.contains(from.getName())) {
            return true;
        }
        return false;
    }

    /**
     * =======================
     * Private data handling functions
     * =======================
     */

    private void updateDependencyGraph(ID to, ID from) {

        // get all indirectly affected nodes (that depend on the to)
        List<ID> idsToAddNewDependencyTo = this.getAllIdsWithNewIndirectDependency(to);

        // for a new to add also all dependencies of from (propagate backwards)
        for (ID newDependant : idsToAddNewDependencyTo) {
            this.addSingleDependencyForId(newDependant, from);
        }

        // for a new to add also all dependencies of from (propagate forward)
        this.addDependenciesForId(to, this.questionDependencies.getIdDependencies(from));
    }

    private List<ID> getAllIdsWithNewIndirectDependency(ID depender) {
        // all the ids that are dependent on depender directly or indirectly
        // ids depending on them need to be updated too with the new dependee
        List<ID> idsToAddNewDependencyTo = new ArrayList<>();

        // temporary list used for traversing the graph.
        // pop first element, update all it's dependencies and add them
        // used to traverse the graph until all elements indirectly affected
        // by new dependence relation found
        List<ID> idsToAnalyze = new ArrayList<>();
        idsToAnalyze.add(depender);

        while (idsToAnalyze.size() > 0) {
            ID indirectFrom = idsToAnalyze.remove(0);

            // check all elements that depend on from and therefore indirectly on passed depender
            for (ID from : this.questionDependencies.getIds()) {
                List<String> dependenciesForKey = this.questionDependencies.getIdDependencyNames(from);

                if ((dependenciesForKey != null)
                        && dependenciesForKey.contains(indirectFrom.getName())) {
                    idsToAddNewDependencyTo.add(from);
                }
            }
            idsToAddNewDependencyTo.add(depender);
        }

        return idsToAddNewDependencyTo;
    }

    private void addDependenciesForId(ID to, List<ID> fromIds) {
        if (fromIds != null) {
            for (ID newDependee : fromIds) {
                this.addSingleDependencyForId(to, newDependee);
            }
        }
        return;
    }

    private void addSingleDependencyForId(ID to, ID from) {
        this.questionDependencies.addIdDependenant(to, from);
        return;
    }

    private void addAndCheckDependency(ID to, ID from) {
        boolean revertedDependencyExists = this.checkDependency(from, to);
        if (revertedDependencyExists) {
            this.astIssueHandler.registerNewError(
                    ASTNodeIssueType.ERROR.CYCLIC, to,
                    "Circular dependency between this node and " +
                            from.toString() + "."
            );
        }
        this.updateDependencyGraph(to, from);
    }
}
