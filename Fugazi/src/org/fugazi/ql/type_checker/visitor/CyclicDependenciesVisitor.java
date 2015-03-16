package org.fugazi.ql.type_checker.visitor;

import org.fugazi.ql.ast.expression.Expression;
import org.fugazi.ql.ast.expression.literal.ID;
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

    public CyclicDependenciesVisitor(){
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

    // a = b, a - depender, b - dependee
    private boolean checkDependency(ID depender, ID dependee) {
        List<String> dependenciesForDepender =
                this.questionDependencies.getIdDependencyNames(depender);

        if ((dependenciesForDepender != null)
                && dependenciesForDepender.contains(dependee.getName())) {
            return true;
        }
        return false;
    }

    /**
     * =======================
     * Private data handling functions
     * =======================
     */

    private void updateDependencyGraph(ID depender, ID dependee) {

        // get all indirectly affected nodes (that depend on the depender)
        List<ID> idsToAddNewDependencyTo = this.getAllIdsWithNewIndirectDependency(depender);

        // for a new depender add also all dependencies of dependee (propagate backwards)
        for (ID newDependant : idsToAddNewDependencyTo) {
            this.addSingleDependencyForId(newDependant, dependee);
        }

        // for a new depender add also all dependencies of dependee (propagate forward)
        this.addDependenciesForId(depender, this.questionDependencies.getIdDependencies(dependee));
    }

    private List<ID> getAllIdsWithNewIndirectDependency(ID depender) {
        // all the ids that are dependent on depender directly or indirectly
        // ids depending on them need to be updated too with the new dependee
        List<ID> idsToAddNewDependencyTo = new ArrayList<>();
        // temporary list used for traversing the graph.
        // pop first element, update all it's dependencies and add them
        // used to traverse the graph until all elements indirectly affected
        // by new dependence relation found
        List<ID> idsWithNewDependencies = new ArrayList<>();
        idsWithNewDependencies.add(depender);

        while (idsWithNewDependencies.size() > 0) {
            ID indirectDependee = idsWithNewDependencies.remove(0);

            // check all elements that depend on newDependee and therefore indirectly on passed dependee
            for (ID key : this.questionDependencies.getIds()) {
                List<String> dependenciesForKey = this.questionDependencies.getIdDependencyNames(key);

                if ((dependenciesForKey != null)
                        && dependenciesForKey.contains(indirectDependee.getName())) {
                    idsToAddNewDependencyTo.add(key);
                }
            }
            idsToAddNewDependencyTo.add(depender);
        }

        return idsToAddNewDependencyTo;
    }

    private void addDependenciesForId(ID depender, List<ID> newDepenees) {
        if (newDepenees != null) {
            for (ID newDependee : newDepenees) {
                this.addSingleDependencyForId(depender, newDependee);
            }
        }
        return;
    }

    private void addSingleDependencyForId(ID depender, ID dependee) {
        this.questionDependencies.addIdDependenant(depender, dependee);
        return;
    }

    // a = b, a - depender, b - dependee
    private void addAndCheckDependency(ID depender, ID dependee) {
        boolean revertedDependencyExists = this.checkDependency(dependee, depender);
        if (revertedDependencyExists) {
            this.astIssueHandler.registerNewError(
                    ASTNodeIssueType.ERROR.CYCLIC, depender,
                    "Circular dependency between this node and " +
                            dependee.toString() + "."
            );
        }
        this.updateDependencyGraph(depender, dependee);
    }
}
