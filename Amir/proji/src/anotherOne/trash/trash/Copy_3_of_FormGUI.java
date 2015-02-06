package anotherOne.ast.trash;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import anotherOne.ast.BoxObject;
import anotherOne.ast.FormObject;
import anotherOne.ast.expression.Id;
import anotherOne.ast.expression.VariablesCollectionVisitor;
import anotherOne.ast.expression.arithmeticExpr.Integ;
import anotherOne.ast.expression.arithmeticExpr.IntIdExpr;
import anotherOne.ast.expression.booleanExpr.BiggerThanExpr;
import anotherOne.ast.expression.booleanExpr.BooleanExpressionEvaluationVisitor;
import anotherOne.ast.question.ComputedQuestion;
import anotherOne.ast.question.IfQuestion;
import anotherOne.ast.question.Question;
import anotherOne.ast.question.ValueStorage;
import anotherOne.ast.questionsVisitors.QuestionValuesVisitor;
import anotherOne.ast.value.BooleanTypeValue;
import anotherOne.ast.value.NumericalTypeValue;
import anotherOne.ast.value.StringTypeValue;
import anotherOne.ast.value.TypeValue;
import anotherOne.grammar.QuestionnaireBuilderVisitor;
//import javax.swing.SpringLayout;

/** Client */

public class Copy_3_of_FormGUI extends JFrame {
	public static Map<String, Id> tapuz;
	public static JFrame frame = new JFrame();
//	public static JPanel panel2 = new JPanel(new GridBagLayout());
	public static JPanel pan = new JPanel(new GridBagLayout());
	public static GridBagConstraints gbc = new GridBagConstraints();
	public static JFrame frame3 = new JFrame();

    public static JFrame frame9;
	public static JLabel defaultLabel = new JLabel("Please select an option ", JLabel.CENTER);
	public static ValueStorage values = new ValueStorage();
	public static HashMap<String, TypeValue> vali = new HashMap<String,TypeValue>();;
	public static HashMap<String, Question> questionsBank = new HashMap<String,Question>();;
	public static Map<String,TypeValue> tempVarsColl2 = new HashMap<String, TypeValue>();
	public static Map<String,Id> tempVarsColl = new HashMap<String, Id>();
	public Copy_3_of_FormGUI()
	{
	}
	
	public static void main(FormObject questionnaire) { // (String[] args) {
		System.out.println("been here FormGui.main");
		printForm(questionnaire);
		fixThisDelete();
		setGridConstraints();
		JPanel pnl = pan(questionnaire);
		defineFrame();
		frame9.add(pnl);

	}

	public static void printForm(FormObject questionnaire){
		
		for (BoxObject box : questionnaire.getBoxs()){
			System.out.println("BOXXXXXXX ID: "+box.id);
			printQstns(box.questionsList);
		}
	}

	static void printQstns(List<Question> questions){
	for (Question question : questions){
		if(question instanceof IfQuestion){
			printQstns(((IfQuestion) question).getQuestions());
		}
		else{
		System.out.println("QUESTIONNNNNN ID: "+question.getId());
	}
	}
	}
	
	static void fixThisDelete(){
		vali.put("1", new NumericalTypeValue(1));
		values.vali.put("2", new StringTypeValue("hiho"));
		NumericalTypeValue value = (NumericalTypeValue)vali.get("1");
	}
	
	static void defineFrame(){
		frame9 = new JFrame("JFrame Example");
        frame9.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame9.setLayout(new GridLayout(0, 1, 2, 2));
        frame9.setVisible(true);
		frame9.setBounds(0,0,300,300);

	}

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

	static JPanel processQuestions(List<Question> questions, JPanel panel){
		for (Question question : questions){
			questionsBank.put(question.getId(), question);
			System.out.println(question);
		}

		for (Question question : questions){
			tempVarsColl2.put(question.getId(), question.getType());
			System.out.println(question);
		}

		int i = 0;
		for (Question question : questions){
			System.out.println(question);

		if (question instanceof IfQuestion){
			i++;
			System.out.println(i);

			// add hiding / condition
//			if (((IfQuestion)question).questionCondition){
			BooleanExpressionEvaluationVisitor bbb =  new BooleanExpressionEvaluationVisitor(tempVarsColl2);
			if ((((IfQuestion)question).boolExpr).accept(new BooleanExpressionEvaluationVisitor(tempVarsColl2))){//.questionCondition){
				System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
				processQuestions(((IfQuestion)question).isTrueList,panel);}
				else {System.out.println("?????????????????????????????????????");}
//	
//			}
//			JCheckBox jcheck = (JCheckBox)question.getType().getWidget();
//reall			((IfQuestion)question).getType();
//neces			IfQuestion ifq = (IfQuestion)question;//..bindExpressions (question);
//sary?		---	VariablesCollectionVisitor boolVariables = new VariablesCollectionVisitor(new HashMap<String, Id>());
//			ifq.boolExpr.accept(boolVariables);
//restore 			boolean condition = ifq.boolExpr.accept(new BooleanExpressionEvaluationVisitor(boolVariables.idMap));

//			for (Question quest : ((IfQuestion)question).isTrueList)
//			int innie = cq.arithmeticExpr.accept(new ArithmeticExpressionEvaluationVisitor(),tempVarsColl);
//			Map<String,Id>cq.arithmeticExpr.accept(new VariablesCollectionVisitor()); 
//			cq.expInputVaribales = tempVarsColl;

//				for (String idString : boolVariables.idMap.keySet()){
//				for (Question quest : ((IfQuestion)question).isTrueList){
//				//				ifq.expInputVaribales.keySet()){
//				System.out.println("This" + idString);							// check if exists
//				if (questionsBank.get(idString).getType() instanceof BooleanTypeValue){
//				bindConditionalToBoolean((JCheckBox)questionsBank.get(idString).getType().getWidget(), quest);
//				}
//				else if (questionsBank.get(idString).getType() instanceof NumericalTypeValue){
//					
//				}
////				bindConditionaltoArithmetic((JTextField)questionsBank.get(idString).getType().getWidget(), quest);
//				}
//				}
////			System.out.println(innie);
//////			panel.add(question.getType().getWidget(),gbc);
////			jtxt.setText("" + innie + 1);
//rrr			panel.add(jcheck,gbc);
//			System.out.println("been here ----->  FormGui.processQuestions, after adding panel ");

//			;}

		
		}
		
		else {
//			updateFromTextField((JTextField)question.getType().getWidget());				
			System.out.println("been here ----> question!");

			panel.add(new JLabel ((String)question.accept(new QuestionValuesVisitor(frame9)).get(1)),gbc); //question.
			panel.add(new JLabel (question.getId()),gbc); //question.
				
				if (question.isComputed()){
					System.out.println("been here1 ----> questions");
					
					JTextField jtxt = (JTextField)question.getType().getWidget(); 
					ComputedQuestion cq = (ComputedQuestion)question;//..bindExpressions (question);
					VariablesCollectionVisitor intVariables = new VariablesCollectionVisitor(new HashMap<String, Id>());
					System.out.println("been here2 ----> questions");
					
					cq.arithmeticExpr.accept(new VariablesCollectionVisitor(intVariables.idMap));
					tapuz = intVariables.idMap; 
					int innie = cq.arithmeticExpr.accept(new BooleanExpressionEvaluationVisitor(tempVarsColl2));
//					Map<String,Id>cq.arithmeticExpr.accept(new VariablesCollectionVisitor()); 
					cq.expInputVaribales = tempVarsColl;
//					for (String idString : cq.expInputVaribales.keySet()){
					for (String idString : tapuz.keySet()){
								System.out.println("been here3 ----> questions");

						System.out.println("This" + idString);							// check if exists
					bindTxtFields((JTextField)cq.getType().getWidget(),(JTextField)questionsBank.get(idString).getType().getWidget(), cq.getId(),idString);
					}
					System.out.println(innie);
//					panel.add(question.getType().getWidget(),gbc);
					jtxt.setText("" + innie);
					panel.add(jtxt,gbc);
					;}
				else {
					System.out.println("JUST CHECKING AGAIN:   QUESTIONNNNNN ID: "+question.getId());
					Component jComp = question.getType().getWidget();
					if(jComp instanceof JTextField) {						
						updateFromTextField((JTextField)jComp, question.getId());
					}
					else {
//						bindConditionalToBoolean((JCheckBox)questionsBank.get("delete").getType().getWidget(), question);
					}
						
					panel.add(question.getType().getWidget(),gbc);
				}
				gbc.gridy++;
		}
		}		
		return panel;
	}

	static JPanel pan (FormObject questionnaire){
		JPanel panel1 = new JPanel(new GridBagLayout());
		panel1.setBorder(BorderFactory.createEmptyBorder(4, 10, 10, 10));

		for (BoxObject box : questionnaire.getBoxs()){
			processQuestions(box.getQuestions(),panel1);
		}

		return panel1;
	}

	public static void updateFromTextField (JTextField jtxt, String id){ // attention - > Component should be controlled on subtype downcasting.
		
		jtxt.getDocument().addDocumentListener(new DocumentListener(){

		@Override
		public void changedUpdate(DocumentEvent arg0) {
			warn(); // update**
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
			System.out.println("change!!");
			int inputValue = Integer.parseInt(jtxt.getText());
			System.out.println("the parsed int is: " + inputValue);
			//			theMap.p
			NumericalTypeValue num = new NumericalTypeValue(1);
			((NumericalTypeValue)questionsBank.get(id).getType()).setValue(inputValue);
			
			values.vali.put(id, new NumericalTypeValue(inputValue));
			//			values._values.put("real test", num); // currently NumericalTypeValue and not just an Object value
			System.out.print("Updated values environment with: " 
			+ ((NumericalTypeValue)values.vali.get(id)).getValue());			
			System.out.println(
			"Updated values environment with: " 
			+ 
			((NumericalTypeValue)questionsBank.get(id).getType()).getValue());
		}
			

		});}

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
			
			
//			int input4 = ((ComputedQuestion)questionsBank.get(trgtId)).arithmeticExpr.accept(new ArithmeticExpressionEvaluationVisitor(), tempVarsColl);
			int input3 = Integer.parseInt(trgt.getText());
			// 
			IntIdExpr intIdExpr = new IntIdExpr(trgtId);
			intIdExpr.setValue(input3);
			((ComputedQuestion)questionsBank.get(trgtId)).expInputVaribales.put(orgnId,intIdExpr);
			System.out.println("###############: "+orgnId);
			((NumericalTypeValue)tempVarsColl2.get(orgnId)).setValue(input3);
//			tempVarsColl2.put(orgnId, tempVarsColl2.get(orgnId));
			System.out.println("====::  " + ((NumericalTypeValue)tempVarsColl2.get(orgnId)).getValue());
			tapuz.put(orgnId,intIdExpr);
			//			tempVarsColl = ((ComputedQuestion)questionsBank.get(trgtId)).expInputVaribales;//.expInputVaribales;
			int tapuzim = ((ComputedQuestion)questionsBank.get(trgtId)).arithmeticExpr.accept(new BooleanExpressionEvaluationVisitor(tempVarsColl2));
			System.out.println("@@@@@@@@@: " + tapuzim);
//			int tapuzim = new BooleanExpressionEvaluationVisitor(tapuz).visit 
			int input4 = 1000000000;		  // ((ComputedQuestion)questionsBank.get(trgtId)).arithmeticExpr.accept(new ArithmeticExpressionEvaluationVisitor(), ((ComputedQuestion)questionsBank.get(trgtId)).expInputVaribales);
			int ss = (((ComputedQuestion)questionsBank.get(trgtId)).expInputVaribales).size();
			System.out.println("mapssize:  " + ss);
			System.out.println("check binding88: " + input4);
//			
			System.out.println("check binding: " + (((IntIdExpr)((ComputedQuestion)questionsBank.get(trgtId)).expInputVaribales.get(orgnId)).getValue()));
//			orgn.setText("" + input4);
			orgn.setText("" + tapuzim);
//			orgn.setText("it should be this one" + input3);

			
			((NumericalTypeValue)questionsBank.get(trgtId).getType()).setValue(input4);
			System.out.println("iterates?      " + input4);
			System.out.println("Updated values environment with computed value: " 
			+ ((NumericalTypeValue)questionsBank.get(trgtId).getType()).getValue());

		}
	});
	}
	
	public static void bindConditionalToBoolean (JCheckBox inputCB, Question question){//JTextField orgn, JTextField trgt, String trgtId, String orgnId){

        inputCB.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent e) {
                System.out.println(e.getStateChange() == ItemEvent.SELECTED
                    ? "SELECTED" : "DESELECTED");
            }
        });
	}
        
//		inputComp.getDocument().addDocumentListener(new DocumentListener(){
//
//		@Override
//		public void changedUpdate(DocumentEvent arg0) {
//			warn();
//		}
//
//		@Override
//		public void insertUpdate(DocumentEvent arg0) {
//			warn();
//		}
//
//		@Override
//		public void removeUpdate(DocumentEvent arg0) {
//			warn();	
//		}
//
//		public void warn(){
//			
//			
////			int input4 = ((ComputedQuestion)questionsBank.get(trgtId)).arithmeticExpr.accept(new ArithmeticExpressionEvaluationVisitor(), tempVarsColl);
//			int input3 = Integer.parseInt(trgt.getText());
//			// 
//			
//			((ComputedQuestion)questionsBank.get(trgtId)).expInputVaribales.put(orgnId,new Id(trgtId,input3));
////			tempVarsColl = ((ComputedQuestion)questionsBank.get(trgtId)).expInputVaribales;//.expInputVaribales;
//			int input4 = ((ComputedQuestion)questionsBank.get(trgtId)).arithmeticExpr.accept(new ArithmeticExpressionEvaluationVisitor(), ((ComputedQuestion)questionsBank.get(trgtId)).expInputVaribales);
//			int ss = (((ComputedQuestion)questionsBank.get(trgtId)).expInputVaribales).size();
//			System.out.println("mapssize:  " + ss);
//			System.out.println("check binding88: " + input4);
////			
//			System.out.println("check binding: " + ((ComputedQuestion)questionsBank.get(trgtId)).expInputVaribales.get(orgnId).getNumericalValue());
//			orgn.setText("" + input4);
////			orgn.setText("it should be this one" + input3);
//
//			
//			((NumericalTypeValue)questionsBank.get(trgtId).getType()).setValue(input4);
//			System.out.println("iterates?      " + input4);
//			System.out.println("Updated values environment with computed value: " 
//			+ questionsBank.get(trgtId).getType().getValue());
//
//		}
//	});
//	}

//	public static void bindConditionalToArithmetic (Component inputComp, Question question){//JTextField orgn, JTextField trgt, String trgtId, String orgnId){
//
//		inputComp.getDocument().addDocumentListener(new DocumentListener(){
//
//		@Override
//		public void changedUpdate(DocumentEvent arg0) {
//			warn();
//		}
//
//		@Override
//		public void insertUpdate(DocumentEvent arg0) {
//			warn();
//		}
//
//		@Override
//		public void removeUpdate(DocumentEvent arg0) {
//			warn();	
//		}
//
//		public void warn(){
//			
//			
////			int input4 = ((ComputedQuestion)questionsBank.get(trgtId)).arithmeticExpr.accept(new ArithmeticExpressionEvaluationVisitor(), tempVarsColl);
//			int input3 = Integer.parseInt(trgt.getText());
//			// 
//			
//			((ComputedQuestion)questionsBank.get(trgtId)).expInputVaribales.put(orgnId,new Id(trgtId,input3));
////			tempVarsColl = ((ComputedQuestion)questionsBank.get(trgtId)).expInputVaribales;//.expInputVaribales;
//			int input4 = ((ComputedQuestion)questionsBank.get(trgtId)).arithmeticExpr.accept(new ArithmeticExpressionEvaluationVisitor(), ((ComputedQuestion)questionsBank.get(trgtId)).expInputVaribales);
//			int ss = (((ComputedQuestion)questionsBank.get(trgtId)).expInputVaribales).size();
//			System.out.println("mapssize:  " + ss);
//			System.out.println("check binding88: " + input4);
////			
//			System.out.println("check binding: " + ((ComputedQuestion)questionsBank.get(trgtId)).expInputVaribales.get(orgnId).getNumericalValue());
//			orgn.setText("" + input4);
////			orgn.setText("it should be this one" + input3);
//
//			
//			((NumericalTypeValue)questionsBank.get(trgtId).getType()).setValue(input4);
//			System.out.println("iterates?      " + input4);
//			System.out.println("Updated values environment with computed value: " 
//			+ questionsBank.get(trgtId).getType().getValue());
//
//		}
//	});
//	}

}	
	
/*
/values.vali.put(question.getId(),null); // should return null from the value environment
/values.vali.put(question.getId(),null); // should return null from the value environment
 values.vali.put(idString, new StringTypeValue("hiho"));
//NumericalTypeValue value2 = (NumericalTypeValue)vali.get("1");
//System.out.println(((NumericalTypeValue)vali.get("1")).getValue());
//System.out.println((new NumericalTypeValue(1)).getValue());//.get("1").getValue());

System.out.println(
"The trick worked: " +
//String str = "" + 
((StringTypeValue)values.vali.get(idString)).getValue());

System.out.println(
"The trick worked2: " +
//String str = "" + 
(((NumericalTypeValue)vali.get("1")).getValue()));						
//((StringTypeValue)values.vali.get(id.getIdValue())).getValue());

					Component jComp = question.getType().getWidget();
//					panel1.add(jComp); // here!!!
					if(jComp instanceof JTextField) {						
//					updateFromTextField((JTextField)jComp, question.getId());
					}					
					else /*if (jComp instanceof JCheckBox)* / {
					}

//		for (BoxObject box : questionnaire.getBoxs()){
			
//		for (Question question : box.getQuestions()){
//			questionsBank.put(question.getId(), question);
//			
//		}
//		}
//		for (Question question : box.getQuestions()){
//
//			}		


for (Question nestedQuest : ((IfQuestion)question).isTrueList){
			
			}
*/