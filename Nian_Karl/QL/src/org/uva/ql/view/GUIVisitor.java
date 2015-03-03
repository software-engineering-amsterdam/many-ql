package org.uva.ql.view;

import java.util.ArrayList;
import java.util.List;

import org.uva.ql.ast.expression.Expression;
import org.uva.ql.ast.expression.literal.Identifier;
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
import org.uva.ql.ast.value.Undefined;
import org.uva.ql.ast.value.Value;
import org.uva.ql.evaluation.Evaluator;
import org.uva.ql.view.listener.WidgetListener;
import org.uva.ql.view.widgit.CheckBox;
import org.uva.ql.view.widgit.NumberTextField;
import org.uva.ql.view.widgit.TextField;
import org.uva.ql.view.widgit.Widget;
import org.uva.ql.visitor.QuestionnaireVisitor;
import org.uva.ql.visitor.StatementVisitor;
import org.uva.ql.visitor.TypeVisitor;

public class GUIVisitor implements StatementVisitor<Object>, TypeVisitor<Object>, QuestionnaireVisitor<Object> {

	private final Evaluator evaluator;
	private List<DependentQuestionPanel> dependentQuestionPanels;

	public GUIVisitor(Evaluator evaluator) {
		this.evaluator = evaluator;
		dependentQuestionPanels = new ArrayList<DependentQuestionPanel>();
	}

	@Override
	public DependentQuestionPanel visit(IfStatement ifStatement) {
		ArrayList<Panel> questionPanels = (ArrayList<Panel>) ifStatement.getIfBlock().accept(this);
		Expression expr = ifStatement.getExpr();
		DependentQuestionPanel questionPanel = new DependentQuestionPanel(questionPanels, expr);
		dependentQuestionPanels.add(questionPanel);
		return questionPanel;
	}

	@Override
	public Panel visit(QuestionNormal questionStatement) {
		System.out.println("normal question");
		Widget widget = (Widget) questionStatement.getType().accept(this);
		QuestionComponent questionComponent = new QuestionComponent(questionStatement, widget);

		evaluator.addValue(questionStatement.getIdentifier().toString(), new Undefined());
		return questionComponent;
	}

	@Override
	public Panel visit(QuestionCompute questionComputeStatement) {
		System.out.println("Question Compute");
		Widget widget = (Widget) questionComputeStatement.getType().accept(this);
		DependentQuestionComponent question = new DependentQuestionComponent(questionComputeStatement, widget);
		Identifier identifier = questionComputeStatement.getIdentifier();
		if (evaluator.getValue(identifier.toString()) != null) {
			// to do soething else
		} else {
			evaluator.addValue(questionComputeStatement.getIdentifier().toString(), new Undefined());
		}

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
		FormFrame formView = new FormFrame(form.getIdentifier().toString());
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
	public Object visit(IfElseStatement ifElseStatement) {
		return null;
	}

	public Evaluator getEvaluator() {
		return evaluator;
	}

	WidgetListener widgetListener = new WidgetListener() {

		@Override
		public void widgetValueChanged(String identifier, Value value) {
			evaluator.addValue(identifier, value);
			System.out.println(evaluator.getValue(identifier));
//			System.out.println("Identifier: " + identifier + " changed with value: " + value.getValue());
			for (DependentQuestionPanel pannel: dependentQuestionPanels) {
				pannel.evaluateAndShow(evaluator);
			}
		}
	};
}
