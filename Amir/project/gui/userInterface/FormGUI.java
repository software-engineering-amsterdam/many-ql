package project.gui.userInterface;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;

import project.ast.FormObject;
import project.ast.boxs.BoxObject;
import project.ast.expression.Id;
import project.ast.expression.VariablesCollectionVisitor;
import project.ast.expression.booleanExpr.ExpressionEvaluationVisitor;
import project.ast.question.ComputedQuestion;
import project.ast.question.Question;
import project.ast.questionsVisitors.QuestionValuesVisitor;
import project.ast.value.NumericalTypeValue;
import project.ast.value.TypeValue;
import project.trash.recent.IfQuestion;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** Client */

public class FormGUI extends JFrame {
	public static JFrame frame = new JFrame();
	//	public static JPanel panel2 = new JPanel(new GridBagLayout());
	public static JPanel pan = new JPanel(new GridBagLayout());
	public static GridBagConstraints gbc = new GridBagConstraints();
	public static JFrame frame9;

	public static HashMap<String, Question> questionsBank = new HashMap<String,Question>();;
	public static Map<String,TypeValue> tempVarsColl2 = new HashMap<String, TypeValue>();

	public FormGUI()
	{
	}

	public static void main(FormObject questionnaire) {
		setGridConstraints();
		JPanel pnl = pan(questionnaire);
		defineFrame();
		frame9.add(pnl);
	}

	static void defineFrame(){
		frame9 = new JFrame("JFrame Example");
		frame9.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame9.setLayout(new GridLayout(0, 1, 2, 2));
		frame9.setVisible(true);
		frame9.setBounds(0,0,300,300);
	}

/*
    reference to undefined questions
    duplicate question declarations with different types
    conditions that are not of the type boolean
    operands of invalid type to operators
    references to questions with an undefined value
    cyclic dependencies between questions
    duplicate labels (warning)
*/
	static void setGridConstraints(){	
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(6, 6, 0, 0);
		gbc.gridx = GridBagConstraints.RELATIVE;
		gbc.gridy = 0;
		gbc.gridwidth = 20; //GridBagConstraints.REMAINDER;
		gbc.gridy++;
		gbc.gridy++;
	}

	static JPanel pan (FormObject questionnaire){
		JPanel panel1 = new JPanel(new GridBagLayout());
		panel1.setBorder(BorderFactory.createEmptyBorder(4, 10, 10, 10));

		for (BoxObject box : questionnaire.getBoxs()){
			processQuestions(box.getQuestions(),panel1);
		}
		return panel1;
	}

	static void putInValueEnvironment(List<Question> questions){

		for (Question question : questions){
			// if exists -> 
			// 			if type1 != type2 -> error
			//			else -> warning


			questionsBank.put(question.getId(), question);
			System.out.println("added to tempVarsColl2: " + question.getId());// + ", + ," + ((NumericalTypeValue)question.getType()).getValue());
			tempVarsColl2.put(question.getId(), question.getType());
		}
	}

	static JPanel processQuestions(List<Question> questions, JPanel panel){

		putInValueEnvironment(questions);

		for (Question question : questions){

			if (question instanceof IfQuestion){
				/*panel = */processQuestions(((IfQuestion)question).isTrueList,panel);
				processIfQuestion(question);
			}
			else {

				question.setLabel(new JLabel ((String)question.accept(new QuestionValuesVisitor(frame9)).get(1)));
				panel.add(question.getLabel(),gbc);
				//				panel.add(new JLabel (((BasicQuestion)question).questionText),gbc); //question.
				panel.add(question.getType().getWidget(),gbc);

				if (question.isComputed()){
					ComputedQuestion cq = ((ComputedQuestion)question);
					for (String idString : cq.getExpressionVariables().keySet()){
						bindTxtFields((JTextField)cq.getType().getWidget(),(JTextField)questionsBank.get(idString).getType().getWidget(), cq.getId(),idString);
					}
					JTextField jtxt = (JTextField)question.getType().getWidget(); 
					//if not null:
					jtxt.setText("" + cq.arithmeticExpr.accept(new ExpressionEvaluationVisitor(tempVarsColl2)));
				}
				gbc.gridy++;
			}
		}		
		return panel;
	}

	static void processIfQuestion(Question question){
		VariablesCollectionVisitor idVariables =  new VariablesCollectionVisitor(new HashMap<String,Id>());
		((IfQuestion)question).boolExpr.accept(idVariables);
		for (String idString : idVariables.idMap.keySet()){
			System.out.println(idString);
			bindConditionalToBoolean((JCheckBox)(questionsBank.get(idString).getType().getWidget()),((IfQuestion)question).isTrueList);
			//question if does not exist -> give exception
		}
		// check the next line for booleanity -> if not -> throw exception
		// if expr = instance of boolean / is true|false, else throw exception "not legitimate boolean expressio"
		if ((((IfQuestion)question).boolExpr).accept(new ExpressionEvaluationVisitor(tempVarsColl2)) == false){
			for (Question quest : ((IfQuestion)question).isTrueList){
				quest.getType().getWidget().setVisible(false);
				quest.getLabel().setVisible(false);
			}
		}
	}

	static void processComputationDependencies(Question question){}

	public static void bindTxtFields (JTextField orgn, JTextField trgt, String trgtId, String orgnId){

		trgt.getDocument().addDocumentListener(new DocumentListener(){

			@Override
			public void changedUpdate(DocumentEvent arg0) {
				warn();
			}

			@Override
			public void insertUpdate(DocumentEvent arg0) {
				warn();
			}

			@Override
			public void removeUpdate(DocumentEvent arg0) {
				warn();	
			}

			public void warn(){

				int input3 = Integer.parseInt(trgt.getText());
				((NumericalTypeValue)tempVarsColl2.get(orgnId)).setValue(input3);
				int tapuzim = ((ComputedQuestion)questionsBank.get(trgtId)).arithmeticExpr.accept(new ExpressionEvaluationVisitor(tempVarsColl2));
				orgn.setText("" + tapuzim);
			}
		});
	}

	public static void bindConditionalToBoolean (JCheckBox inputCB, List<Question> questions){//JTextField orgn, JTextField trgt, String trgtId, String orgnId){

		inputCB.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if ( e.getStateChange() == ItemEvent.SELECTED ){
					inputCB.setText("Yes");
					for (Question question : questions){
						question.getType().getWidget().setVisible(true);
						question.getLabel().setVisible(true);
					}
				}
				else { 
					inputCB.setText("No");
					for (Question question : questions){
						question.getType().getWidget().setVisible(false);
						question.getLabel().setVisible(false);
					}
				}
				frame9.repaint();
			}});
	}
}