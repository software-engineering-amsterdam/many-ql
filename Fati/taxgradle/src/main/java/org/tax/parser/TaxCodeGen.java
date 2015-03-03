package org.tax.parser;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.tax.datatypes.QLType;
import org.tax.expression.Expression;
import org.tax.exprgen.ExprLexer;
import org.tax.exprgen.ExprParser;
import org.tax.exprgen.ExprVisitor;
import org.tax.taxgen.TaxBaseListener;
import org.tax.taxgen.TaxParser;

public class TaxCodeGen extends TaxBaseListener {

	private volatile JFrame frame = null;
	private volatile JPanel panel = null;
	private volatile GridBagConstraints c;
	private Map<JComponent, String> componentToVarMap;
//	private Map<String, String> varToComponentMap; 
	private Map<String, Variable> varToComponentMap; 
	private String currentVariable = null;
	private Type currentType = null;

	enum Type {
		INTEGER, MONEY, DATE, BOOLEAN, STRING, DECIMAL
	}
	
	TaxCodeGen() {
		componentToVarMap = new ConcurrentHashMap<>();
		varToComponentMap = new ConcurrentHashMap<>();
	}

	@Override public void enterProg(TaxParser.ProgContext ctx) {
		System.out.println("We are parsing it.");
			try {
				javax.swing.SwingUtilities.invokeAndWait(new Runnable() {
					public void run() {
						createAndShowGUI();
					}

				});
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	private void createAndShowGUI() {
		frame = new JFrame("Questionnaire");
		panel = new JPanel();

		panel.setLayout(new GridBagLayout());
		c = new GridBagConstraints();
		
		frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override public void exitProg(TaxParser.ProgContext ctx) { 
		frame.pack();
		frame.setVisible(true);


	}

	@Override public void exitVariable(TaxParser.VariableContext ctx) { 
		currentVariable = ctx.getText();
	}
	
	@Override public void exitExpression(TaxParser.ExpressionContext ctx) { 
//			ExprLexer lexer = new ExprLexer(new ANTLRInputStream(ctx.getText()));
//			ExprParser parser = new ExprParser(new CommonTokenStream(lexer));
//			ParseTree tree = parser.expression();
//			System.out.println(ctx.getText());
//			
//	        ExprVisitor<Expression<? extends FormType>> eval = new ExprManVisitor(varToComponentMap);
//	        eval.visit(tree);	

//		System.out.println("inside expression ----------------");
//		System.out.println(ctx.getParent().getParent().getChild(0).getText());
//		if (ctx.getParent().getText().equals("money")) {
//			System.out.print("type is money and the expression is ");
//			System.out.println(ctx.getText());
//
//		}
	}
	

	@Override public void exitBracketedquestionlist(TaxParser.BracketedquestionlistContext ctx) { 
	}
	
	private Expression<? extends QLType> parseExpression(String expr, String type) {
		System.out.println("type is " + type);
		ExprLexer lexer = new ExprLexer(new ANTLRInputStream(expr));
		ExprParser parser = new ExprParser(new CommonTokenStream(lexer));
		ParseTree tree = parser.expression();

		ExprVisitor<Expression<? extends QLType>> eval = new ExprManVisitor(varToComponentMap, type);
		return eval.visit(tree);



	}
	
	@Override public void exitQuestion(TaxParser.QuestionContext ctx) { 
//		System.out.println(ctx.variable().getText() + ", and the type is : " + ctx.type().getText());
			Variable var = null;
			System.out.println(ctx.getText());
			if (ctx.type().expression() != null) {
				System.out.println(ctx.variable().getText() + " primitive type " + ctx.type().primitiveType().getText());
				Expression<? extends QLType> expr = parseExpression(ctx.type().expression().getText(), ctx.type().primitiveType().getText());
				System.out.println("Evaluated expresssion" + ctx.variable().getText() + "  " + expr.evaluate());
				var = new VariableWithExpr<>(ctx.variable().getText(), expr.evaluate().toString(), ctx.type().primitiveType().getText(), expr);
			}
			else var = new Variable(ctx.variable().getText(), "0", ctx.type().getText());
			
			varToComponentMap.put(ctx.variable().getText(), var);
	}

	@Override public void exitQuestionStatement(TaxParser.QuestionStatementContext ctx) { 
		JLabel emptyLabel = new JLabel(ctx.getText());
		c.gridx = 0;
		panel.add(emptyLabel, c);
	}
	
	@Override public void exitPrimitiveType(TaxParser.PrimitiveTypeContext ctx) { 
		currentType = Type.valueOf(ctx.getText().toUpperCase());
	}
	
	@Override public void exitType(TaxParser.TypeContext ctx) {
		if (ctx.expression() != null) {
//			expressionTypeChecker(ctx.expression(), ctx.primitiveType());
		}

        String[] booleanStrings = { "Yes", "No"};

//		if (ctx.getText().equals("boolean")) {
		if (currentType == Type.BOOLEAN) {
			JComboBox<String> booleanCombo = new JComboBox<>(booleanStrings);
		    booleanCombo.setSelectedIndex(0);
			booleanCombo.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					@SuppressWarnings("unchecked")
					JComboBox<String> cb = (JComboBox<String>)e.getSource();
//					componentToVarMap.put(cb, componentToVarMap.get(cb));
					updateMaps(cb);
					printStringMap();
				}
			});
			c.gridx = 1;
			panel.add(booleanCombo, c); 
			componentToVarMap.put(booleanCombo, currentVariable);
			varToComponentMap.put(currentVariable, new Variable(currentVariable, "Yes", "Boolean"));
		}
//        if (ctx.getText().equals("money")) {
        if (currentType == Type.MONEY) {
        	addTextField(ctx, "0.0");
        }
        
//		if (ctx.getText().equals("integer")) {
		if (currentType == Type.INTEGER) {
			addTextField(ctx, "0");
		}
		
//		if (ctx.getText().equals("date")) {
		if (currentType == Type.DATE) {
			addTextField(ctx, "01-01-2001");
		}
		
//		if (ctx.getText().equals("decimal")) {
		if (currentType == Type.DECIMAL) {
			addTextField(ctx, "0.0");
		}
	}

//	private void expressionTypeChecker(ExpressionContext expression,
//			PrimitiveTypeContext primitiveTypeContext) {
//		if (expression.literal() != null) {
//			System.out.println(expression.literal().getText());
//		}
//	}

	private void addTextField(TaxParser.TypeContext ctx, String initialValue) {
		if (ctx.getText().equals("money")) {
			JTextField field = new JTextField();
			field.setPreferredSize(new Dimension(200, 24));
			field.setText("0.0");
			field.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					JTextField f = (JTextField) e.getSource();
//					variableMap.put(currentVariable, (String)f.getText());
//					componentToVarMap.put(f, componentToVarMap.get(f));
					updateMaps(f);
					printStringMap();
				} 
				
			});
			c.gridx = 1;
			panel.add(field, c);
//			variableMap.put(currentVariable, initialValue);
			componentToVarMap.put(field, currentVariable);

			//amir check below
			varToComponentMap.put(currentVariable, new Variable(currentVariable, initialValue, "String"));
		}
	}
	
	private void printStringMap() {
		// TODO Auto-generated method stub
		Iterator<Map.Entry<String, Variable>> i = varToComponentMap.entrySet().iterator(); 
		while(i.hasNext()){
		    String key = i.next().getKey();
                System.out.println(key + ", "+ varToComponentMap.get(key));
		}
		System.out.println("----------------------------");

	}
	
	@SuppressWarnings({ "unchecked", "unused" })
	private void printAllValues() {
		Iterator<Map.Entry<JComponent, String>> i = componentToVarMap.entrySet().iterator(); 
		while(i.hasNext()){
		    JComponent key = i.next().getKey();
		    if (key instanceof JTextField)
                System.out.println((String)((JTextField)(key)).getText()+", "+componentToVarMap.get(key));
		    if (key instanceof JComboBox)
		    	System.out.println((String)((JComboBox<String>)(key)).getSelectedItem()+", "+componentToVarMap.get(key));
		}
		System.out.println("----------------------------");
	}

	@SuppressWarnings("unchecked")
	private void updateMaps(JComponent comp) {
		String varName = componentToVarMap.get(comp);
		componentToVarMap.put(comp, varName);
		
//		if (comp instanceof JTextField) {
//			varToComponentMap.put(varName, new Variable(varName, (String)((JTextField)comp).getText(), String.class));
//		}
//		if (comp instanceof JComboBox) {
//			varToComponentMap.put(varName, new Variable(varName, (String)((JComboBox<String>)comp).getSelectedItem(), Boolean.class));
//		}

	}
	
	@Override public void enterIfquestionlist(TaxParser.IfquestionlistContext ctx) { 
		
	}


}
