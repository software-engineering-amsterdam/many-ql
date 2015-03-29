package com.form.language.memory;

import java.util.List;

import com.form.language.ast.expression.Expression;
import com.form.language.ast.expression.variable.Reference;
import com.form.language.ast.expression.variable.ReferenceCollection;
import com.form.language.ast.statement.question.Question;
import com.form.language.ast.statement.question.QuestionId;
import com.form.language.ast.type.ErrorType;
import com.form.language.ast.type.Type;
import com.form.language.ast.values.GenericValue;
import com.form.language.gui.components.QuestionComponent;
import com.form.language.issue.Error;
import com.form.language.issue.IssueCollector;
import com.form.language.issue.Warning;

public class Context {
    private QuestionDeclarations questionDeclarations;
    private QuestionReferences questionReferences;
    private QuestionLabels questionLabels;
    private QuestionValues questionValues;
    private IfDependencies ifConditions;
    private IssueCollector errors;
    private IssueCollector warnings;

    public Context() {
	this.questionValues = new QuestionValues();
	this.ifConditions = new IfDependencies();
	this.questionReferences = new QuestionReferences();
	this.questionDeclarations = new QuestionDeclarations();
	this.errors = new IssueCollector();
	this.warnings = new IssueCollector();
	this.questionLabels = new QuestionLabels();
    }

    public void addDependantQuestion(Expression condition, QuestionComponent question) {
	ifConditions.add(condition, question);
    }

    public List<QuestionComponent> getDependantQuestions(Expression exp) {
	return ifConditions.get(exp);
    }

    public void addReference(ReferenceCollection references, Expression value) {
	questionReferences.putAll(references, value);
    }

    public List<Expression> getReferencingExpressions(String id) {
	return questionReferences.get(id);
    }

    public void setValue(String key, GenericValue value) {
	questionValues.put(key, value);
    }

    public GenericValue getValue(String s) {
	return questionValues.get(s);
    }

    public void addQuestion(Question question) {
	questionDeclarations.put(question.getId(),question);
    }

    public void addLabel(String s) {
	questionLabels.add(s);
    }
    
    public boolean containsLabel(String s){
	return questionLabels.contains(s);
    }
    
    public Type getIdType(Reference id) {
	Question declaration = questionDeclarations.get(id.getName());
	if (declaration == null) {
	    this.addError(new Error(id.getTokenInfo(), "Undeclared variable reference"));
	    return new ErrorType();
	}
	return declaration.getType(this);
    }

    public boolean hasErrors() {
	return !errors.isEmpty();
    }
    
    public boolean hasWarnings() {
	return !warnings.isEmpty();
    }
    
    public void addError(Error e) {
	errors.add(e);
    }

    public String getErrors() {
	return errors.toString();
    }
    
    public void addWarning(Warning e) {
	warnings.add(e);
    }

    public String getWarnings() {
	return warnings.toString();
    }
}