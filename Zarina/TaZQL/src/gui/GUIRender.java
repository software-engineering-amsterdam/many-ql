package gui;

import evaluator.ValueRepository;
import gui.questions.SimpleQuestionUI;
import gui.widgets.IWidgetComponent;

import java.util.LinkedHashMap;
import java.util.Set;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;
import ast.expression.BracketsExpression;
import ast.expression.arithmetic.AdditionExpression;
import ast.expression.arithmetic.DivisionExpression;
import ast.expression.arithmetic.MultiplicationExpression;
import ast.expression.arithmetic.SubstractionExpression;
import ast.expression.comparison.EqualExpression;
import ast.expression.comparison.GreaterEqualExpression;
import ast.expression.comparison.GreaterThanExpression;
import ast.expression.comparison.LessEqualExpression;
import ast.expression.comparison.LessThanExpression;
import ast.expression.comparison.NotEqualExpression;
import ast.expression.logical.AndExpression;
import ast.expression.logical.OrExpression;
import ast.expression.variables.BooleanVariable;
import ast.expression.variables.Id;
import ast.expression.variables.IntegerVariable;
import ast.expression.variables.StringVariable;
import ast.form.Form;
import ast.form.IFormVisitor;
import ast.question.ComputationQuestion;
import ast.question.IfElseStatement;
import ast.question.IfStatement;
import ast.question.Question;
import ast.question.SimpleQuestion;
import ast.type.ChoiceType;
import ast.type.DigitsType;
import ast.type.TextType;
import ast.type.UndefinedType;
import ast.unary.MinusExpression;
import ast.unary.NotExpression;
import ast.unary.PlusExpression;

public class GUIRender implements IFormVisitor<JPanel> {
	private final JPanel panel;
	private final ValueRepository valueRepository;
	private final LinkedHashMap<String, SimpleQuestionUI> widgetsRepository;
	
	public GUIRender(ValueRepository valueRepository) {
		this.panel = new JPanel();
		this.panel.setLayout(new MigLayout("wrap 2")); 
		this.valueRepository = valueRepository;
		this.widgetsRepository = new LinkedHashMap<String, SimpleQuestionUI>();
	}
	
	public static JPanel maker(Form form, ValueRepository valueRepository) {
		GUIRender visitor = new GUIRender(valueRepository);
		form.accept(visitor);
		return visitor.getPanel();
	}
	
	
	public JPanel getPanel() {
		return panel;
	}
	
	public void attachPanel(JPanel attachedPanel) {
		this.panel.add(attachedPanel);
	}
	
	public void getLabel(String text) {
		this.panel.add(new JLabel(text));
		this.panel.setVisible(true);
	}
	
	//to be changed in widget
	public JComponent addWidget(IWidgetComponent co) { 
		this.panel.add(co.getWidget(), "wrap");
		this.panel.setVisible(true); //temporary
		this.panel.validate();
		this.panel.repaint();
		return panel;
	}
	

	public void addToPanel() {
		Set<String> keys = widgetsRepository.keySet();
        for(String k:keys){
            System.out.println(k+" <- id of label & widget ");
            this.panel.add(widgetsRepository.get(k).getLabel());
            this.panel.add(widgetsRepository.get(k).getWc().getWidget(), "wrap");
        }	
	}
	public Set<String> getIDkeys() {
		Set<String> keys = widgetsRepository.keySet();
		return keys;
	}
	
	public void putWidgetRepository(String id, SimpleQuestionUI widgets) {
		this.widgetsRepository.put(id, widgets);
	}
	
	public SimpleQuestionUI getIDSimpleQuestionUI(String id) {
		return this.widgetsRepository.get(id);
	}
	
	 public boolean containsSimpleQuestionUI(String id) {
		 return this.widgetsRepository.containsKey(id);
	 }

	// ***** visitor's part , yeah ugly...cause i have separated it now *****

	@Override
	public JPanel visit(Form form) {
		for(Question q : form.getQuestionText()){
			q.accept(new GUIVisitor(this, valueRepository));
		}
		addToPanel();
		return panel;
	}
	
	@Override
	public JPanel visit(Question question) {
		
		return null;
	}

	@Override
	public JPanel visit(SimpleQuestion simpleQuestion) {
		//new Update().update();
		//new GUIVisitor(this).widget(simpleQuestion).addDocListener();
	//	getLabel(simpleQuestion.getQuestionText());
		//addWidget(widget(simpleQuestion));
		//widget(simpleQuestion).addDocListener();	
		//System.out.println(widget(simpleQuestion).getValue());
		//SimpleQuestionUI simp = new SimpleQuestionUI();
		//Connector conny = new Connector(this);
		//conny.widget(simpleQuestion);
		
		//this.panel.add(conny.widget(simpleQuestion).getWidget());
		//System.out.println("Test: are you working or what");
		//IQuestions q;
		//this.panel.add(simp.createdLabel(), "wrap");
		
	//	getLabel(simpleQuestion.getQuestionText());
		
		//new Connector().widget(simpleQuestion);
	//	System.out.println("q:");
	//	this.panel.add(simp.createdLabel(), "wrap");
	//	SimpleQuestion sq = new SimpleQuestion(simpleQuestion.getQuestionId(),simpleQuestion.getQuestionText(), simpleQuestion.getQuestionType());
	//	c.setIdWidget(simpleQuestion.getQuestionId());
	//	c.setLabel(simpleQuestion.getQuestionText());
	//	c.setWidgetType(simpleQuestion.getQuestionType());
	//	this.panel.add(sq.g, "wrap");
	//	this.panel.setVisible(true); //temporary
	//	visibility(true);
	//	attachEvent('onUnfocus', call_update_symboltable_with_its_data());
		return null;
	}

@Override
public JPanel visit(ComputationQuestion calQuestion) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public JPanel visit(IfStatement ifStatement) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public JPanel visit(IfElseStatement ifElseStatement) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public JPanel visit(BracketsExpression expr) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public JPanel visit(MultiplicationExpression expr) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public JPanel visit(DivisionExpression expr) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public JPanel visit(AdditionExpression expr) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public JPanel visit(SubstractionExpression expr) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public JPanel visit(EqualExpression expr) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public JPanel visit(NotEqualExpression expr) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public JPanel visit(LessThanExpression expr) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public JPanel visit(GreaterThanExpression expr) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public JPanel visit(LessEqualExpression expr) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public JPanel visit(GreaterEqualExpression expr) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public JPanel visit(NotExpression expr) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public JPanel visit(PlusExpression expr) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public JPanel visit(MinusExpression expr) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public JPanel visit(AndExpression expr) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public JPanel visit(OrExpression expr) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public JPanel visit(StringVariable string) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public JPanel visit(IntegerVariable integer) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public JPanel visit(BooleanVariable bool) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public JPanel visit(Id identifier) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public JPanel visit(TextType type) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public JPanel visit(DigitsType type) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public JPanel visit(ChoiceType type) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public JPanel visit(UndefinedType type) {
	// TODO Auto-generated method stub
	return null;
}
}