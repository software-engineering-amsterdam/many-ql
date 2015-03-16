package org.uva.ql.view;

import java.util.ArrayList;

import javax.swing.JButton;

import org.uva.ql.ast.expression.Expression;
import org.uva.ql.ast.expression.literal.Identifier;
import org.uva.ql.ast.questionnaire.Form;
import org.uva.ql.ast.questionnaire.Questionnaire;
import org.uva.ql.ast.statement.Block;
import org.uva.ql.ast.statement.IfElseStatement;
import org.uva.ql.ast.statement.IfStatement;
import org.uva.ql.ast.statement.QuestionComputed;
import org.uva.ql.ast.statement.QuestionNormal;
import org.uva.ql.ast.statement.Statement;
import org.uva.ql.ast.type.BoolType;
import org.uva.ql.ast.type.IntType;
import org.uva.ql.ast.type.StrType;
import org.uva.ql.ast.type.UndefinedType;
import org.uva.ql.ast.value.UndefinedValue;
import org.uva.ql.view.component.ExprQuestionComponent;
import org.uva.ql.view.component.QuestionComponent;
import org.uva.ql.view.listener.ButtonWidgetListener;
import org.uva.ql.view.panel.IfElseQuestionPanel;
import org.uva.ql.view.panel.IfQuestionPanel;
import org.uva.ql.view.panel.Panel;
import org.uva.ql.view.panel.QuestionPanel;
import org.uva.ql.view.widgit.CheckBox;
import org.uva.ql.view.widgit.NumberTextField;
import org.uva.ql.view.widgit.TextField;
import org.uva.ql.view.widgit.Widget;
import org.uva.ql.visitor.QuestionnaireVisitor;
import org.uva.ql.visitor.StatementVisitor;
import org.uva.ql.visitor.TypeVisitor;

public class GUIVisitor implements StatementVisitor<Object>, TypeVisitor<Object>, QuestionnaireVisitor<Object> {

	private ButtonWidgetListener widgetListener;

	public GUIVisitor() {
		widgetListener = new ButtonWidgetListener();
	}

	@Override
	public IfQuestionPanel visit(IfStatement ifStatement) {
		ArrayList<Panel> questionPanels = (ArrayList<Panel>) ifStatement.getIfBlock().accept(this);
		Expression expr = ifStatement.getExpr();
		IfQuestionPanel questionPanel = new IfQuestionPanel(questionPanels, expr);
		widgetListener.addDependentQuestionPanel(questionPanel);
		return questionPanel;
	}

	@Override
	public Panel visit(QuestionNormal questionStatement) {
		Widget widget = (Widget) questionStatement.getType().accept(this);
		Identifier identifier = questionStatement.getIdentifier();
		QuestionComponent questionComponent = new QuestionComponent(questionStatement, widget);
		widgetListener.initializeValue(identifier.toString(), new UndefinedValue());
		return questionComponent;
	}

	@Override
	public Panel visit(QuestionComputed questionComputeStatement) {
		Widget widget = (Widget) questionComputeStatement.getType().accept(this);
		ExprQuestionComponent questionComponent = new ExprQuestionComponent(questionComputeStatement, widget);
		Identifier identifier = questionComputeStatement.getIdentifier();
		widgetListener.initializeValue(identifier.toString(), new UndefinedValue());
		widgetListener.addDependentQuestionComponent(questionComponent);
		return questionComponent;
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
		FormFrame formView = new FormFrame(form.getIdentifier().toString());
		ArrayList<Panel> questionPannels = (ArrayList<Panel>) form.getBlock().accept(this);
		QuestionPanel questionPanel = new QuestionPanel(questionPannels);
		formView.addWithConstraints(questionPanel);
		JButton button = new JButton("Done");
		button.addActionListener(widgetListener);
		formView.addWithConstraints(button);
		formView.setVisible(true);
		return formView;
	}

	@Override
	public ArrayList<FormFrame> visit(Questionnaire questionnaire) {
		ArrayList<FormFrame> formViews = new ArrayList<FormFrame>();
		for (Form form : questionnaire.getForms()) {
			formViews.add((FormFrame) form.accept(this));
		}
		return formViews;
	}

	@Override
	public Widget visit(IntType node) {
		return new NumberTextField(widgetListener);
	}

	@Override
	public Widget visit(BoolType node) {
		return new CheckBox(widgetListener);
	}

	@Override
	public Widget visit(StrType node) {
		return new TextField(widgetListener);
	}

	@Override
	public Widget visit(UndefinedType undefiendType) {
		System.out.println("This should not happen.");
		return null;
	}
	
	@Override
	public IfElseQuestionPanel visit(IfElseStatement ifElseStatement) {
		ArrayList<Panel> ifQuestions = (ArrayList<Panel>) ifElseStatement.getIfBlock().accept(this);
		ArrayList<Panel> elseQuestions = (ArrayList<Panel>) ifElseStatement.getElseBLock().accept(this);
		Expression expr = ifElseStatement.getExpr();
		IfElseQuestionPanel questionPanel = new IfElseQuestionPanel(ifQuestions, elseQuestions, expr);
		widgetListener.addDependentQuestionPanel(questionPanel);
		return questionPanel;
	}


}
