package nl.uva.bromance.ast;

import nl.uva.bromance.ast.conditionals.CanContainConditionals;
import nl.uva.bromance.ast.conditionals.ElseIfStatement;
import nl.uva.bromance.ast.conditionals.ElseStatement;
import nl.uva.bromance.ast.conditionals.IfStatement;
import nl.uva.bromance.ast.visitors.QLNodeVisitor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Form extends QLNode implements CanContainConditionals {
    private String identifier;

    private IfStatement ifStatement;
    private List<ElseIfStatement> elseIfStatements = new ArrayList<>();
    private ElseStatement elseStatement;

    public Form(int lineNumber, String id) {
        super(lineNumber);
        this.identifier = id.substring(1, id.length() - 1);
    }

    public String getIdentifier() {
        return identifier;
    }

    //TODO: Create Identifier class.
    @Override
    public Optional<IfStatement> getIfsStatement() {
        return Optional.of(ifStatement);
    }

    public void setIfStatement(IfStatement ifStatement) {
        this.ifStatement = ifStatement;
    }

    @Override
    public Optional<List<ElseIfStatement>> getElseIfStatement() {
        return Optional.of(elseIfStatements);
    }

    @Override
    public void setElseIfStatement(ElseIfStatement eifs) {
        elseIfStatements.addAll(Arrays.asList(eifs));
    }

    @Override
    public Optional<ElseStatement> getElseStatement() {
        return Optional.of(elseStatement);
    }

    @Override
    public void setElseStatement(ElseStatement es) {
        elseStatement = es;
    }

    @Override
    public void accept(QLNodeVisitor visitor) {
        visitor.visit(this);
        for (QLNode child : this.getChildren()) {
            child.accept(visitor);
        }
    }

}
