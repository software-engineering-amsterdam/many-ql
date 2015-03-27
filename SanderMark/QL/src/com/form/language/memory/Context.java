package com.form.language.memory;

import java.util.List;

import com.form.language.ast.expression.Expression;
import com.form.language.ast.expression.variable.Reference;
import com.form.language.ast.statement.Question;
import com.form.language.ast.type.ErrorType;
import com.form.language.ast.type.Type;
import com.form.language.ast.values.GenericValue;
import com.form.language.gui.components.QuestionComponent;
import com.form.language.issue.Error;
import com.form.language.issue.IssueCollector;
import com.form.language.issue.Warning;

public class Context {
    private ReferenceValues memory;
    private QuestionDependencies ifConditions;
    private IdReferences idReferences;
    private IdCollection globalIdList;
    private IssueCollector errors;
    private IssueCollector warnings;
    private IdDeclarations declarations;
    private QuestionLabels questionLabels;

    public Context() {
	this.memory = new ReferenceValues();
	this.ifConditions = new QuestionDependencies();
	this.idReferences = new IdReferences();
	this.globalIdList = new IdCollection();
	this.declarations = new IdDeclarations();
	this.errors = new IssueCollector();
	this.warnings = new IssueCollector();
	this.questionLabels = new QuestionLabels();
    }

    public void addDependantQuestion(Expression condition, QuestionComponent question) {
	this.ifConditions.add(condition, question);
    }

    public List<QuestionComponent> getDependantQuestions(Expression exp) {
	return this.ifConditions.get(exp);
    }

    public void addReference(IdCollection references, Expression value) {
	this.idReferences.putAll(references, value);
    }

    public List<Expression> getReferencingExpressions(String id) {
	return idReferences.get(id);
    }

    public void setValue(String key, GenericValue value) {
	this.memory.put(key, value);
    }

    public GenericValue getValue(String s) {
	return this.memory.get(s);
    }

    public void addQuestion(Question question) {
	this.declarations.put(question.getId(),question);
    }

    public void addId(Reference id) {
	this.globalIdList.addId(id);
    }
    
    public void addLabel(String s) {
	this.questionLabels.add(s);
    }
    
    public boolean containsLabel(String s){
	return this.questionLabels.contains(s);
    }
    public Type getIdType(Reference id) {
	Question declaration = this.declarations.get(id.getName());
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
	this.errors.add(e);
    }

    public String getErrors() {
	return errors.toString();
    }
    
    public void addWarning(Warning e) {
	this.warnings.add(e);
    }

    public String getWarnings() {
	return warnings.toString();
    }
}