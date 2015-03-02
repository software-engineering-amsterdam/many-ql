package org.uva.ql.view;

import java.util.ArrayList;

import org.uva.ql.ast.questionnaire.Form;
import org.uva.ql.ast.questionnaire.Questionnaire;
import org.uva.ql.ast.statement.Block;
import org.uva.ql.ast.statement.IfElseStatement;
import org.uva.ql.ast.statement.IfStatement;
import org.uva.ql.ast.statement.QuestionCompute;
import org.uva.ql.ast.statement.QuestionNormal;
import org.uva.ql.ast.statement.Statement;
import org.uva.ql.ast.type.BoolType;
import org.uva.ql.ast.type.IntType;
import org.uva.ql.ast.type.StrType;
import org.uva.ql.evaluation.Evaluator;
import org.uva.ql.view.widgit.CheckBox;
import org.uva.ql.view.widgit.NumberTextField;
import org.uva.ql.view.widgit.TextField;
import org.uva.ql.view.widgit.Widget;
import org.uva.ql.visitor.QuestionnaireVisitor;
import org.uva.ql.visitor.StatementVisitor;
import org.uva.ql.visitor.TypeVisitor;

public class GUIVisitor implements StatementVisitor<Object>, TypeVisitor<Object>, QuestionnaireVisitor<Object> {

	private final Evaluator evaluator;
	
	public GUIVisitor(Evaluator evaluator) {
		this.evaluator = evaluator;
	}
	
	@Override
	public DependentQuestionPanel visit(IfStatement ifStatement) {
		ArrayList<Panel> questionPanels = (ArrayList<Panel>) ifStatement.getIfBlock().accept(this);
		DependentQuestionPanel questionPanel = new DependentQuestionPanel(questionPanels, ifStatement.getExpr());
		System.out.println("if statement");
		return questionPanel;
	}

	@Override
	public Panel visit(QuestionNormal questionStatement) {
		System.out.println("normal question");
		Widget<?> widget = (Widget<?>) questionStatement.getType().accept(this);
		QuestionComponent questionComponent = new QuestionComponent(questionStatement, widget);
		return questionComponent;
	}

	@Override
	public Panel visit(QuestionCompute questionComputeStatement) {
		System.out.println("Question Compute");
		Widget<?> widget = (Widget<?>) questionComputeStatement.getType().accept(this);
		DependentQuestionComponent question = new DependentQuestionComponent(questionComputeStatement, widget);
		return question;
	}

	@Override
	public ArrayList<Panel> visit(Block blockStatement) {
		ArrayList<Panel> questionPannels = new ArrayList<Panel>();
		for (Statement statement : blockStatement.getStatements()) {
			questionPannels.add((Panel) statement.accept(this));
		}
		return questionPannels;
	}

	@Override
	public FormFrame visit(Form form) {
		FormFrame formView = new FormFrame(form.getIdentifier().getValue());
		ArrayList<Panel> questionPannels = (ArrayList<Panel>) form.getBlock().accept(this);
		QuestionPanel questionPanel = new QuestionPanel(questionPannels);
		formView.add(questionPanel);
		formView.setVisible(true);
		return formView;
	}

	@Override
	public ArrayList<FormFrame> visit(Questionnaire questionnaire) {
		System.out.println("Visiting block");
		ArrayList<FormFrame> formViews = new ArrayList<FormFrame>();
		for (Form form : questionnaire.getForms()) {
			formViews.add((FormFrame) form.accept(this));
		}
		return formViews;
	}

	@Override
	public Widget<Integer> visit(IntType node) {
		return new NumberTextField();
	}

	@Override
	public Widget<Boolean> visit(BoolType node) {
		return new CheckBox();
	}

	@Override
	public Widget<String> visit(StrType node) {
		return new TextField();
	}

	@Override
	public Object visit(IfElseStatement ifElseStatement) {
		return null;
	}

	public Evaluator getEvaluator() {
		return evaluator;
	}
}
