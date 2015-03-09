package com.form.language.gui;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;

import com.form.language.GrammarLexer;
import com.form.language.GrammarParser;
import com.form.language.ast.Form;
import com.form.language.error.CheckTypeErrors;
import com.form.language.error.CheckVariableErrors;
import com.form.language.error.ErrorCollector;
import com.form.language.memory.IdCollector;
import com.form.language.memory.IdTypeTable;
import com.form.language.memory.RuntimeMemory;

public class Frame {

	private JFrame frame;
	private JTextArea textArea_input;
	private JTextArea textArea_output;
	private JButton button_parse;
	private JButton button_createQuestionnaire;
	
	private Form form;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame window = new Frame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Frame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 367);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
				
		textArea_input = new JTextArea();
		textArea_input.setBounds(10, 11, 414, 98);
		frame.getContentPane().add(textArea_input);
		
		textArea_output = new JTextArea();
		textArea_output.setBounds(10, 154, 414, 91);
		frame.getContentPane().add(textArea_output);

		final JPanel panel = new JPanel();
		panel.setBounds(10, 256, 414, 62);
		frame.getContentPane().add(panel);
		
		button_parse = new JButton("Parse");
		button_parse.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {				
				CharStream charStream = new ANTLRInputStream(textArea_input.getText());
				GrammarLexer lexer = new GrammarLexer(charStream);
				TokenStream tokenStream = new CommonTokenStream(lexer);
				GrammarParser parser = new GrammarParser(tokenStream);
				
				form = parser.form().result;
				
				IdCollector ids = new IdCollector();
				form.collectIds(ids);
				
				IdTypeTable idTable = new IdTypeTable(ids);
				form.setTypes(idTable);
				
				List<String> errorsStrings = new ArrayList<String>();
				ErrorCollector varErrors = CheckVariableErrors.containsUndeclaredVariables(ids, idTable);
				if(!varErrors.isEmpty()){
					errorsStrings.add("There are variable errors:");
					errorsStrings.addAll(varErrors.print());
				}
				
				if(CheckTypeErrors.containsErrors(form)){
					errorsStrings.add("There are type errors:");
					ErrorCollector errors = new ErrorCollector();
					form.getErrors(errors);
					errorsStrings.addAll(errors.print());
				} 
							
				if(errorsStrings.isEmpty())
				{
					button_createQuestionnaire.setEnabled(true);
				}
			}
		});
		button_parse.setBounds(335, 120, 89, 23);
		frame.getContentPane().add(button_parse);
		
		button_createQuestionnaire = new JButton("Create Survey");
		button_createQuestionnaire.setEnabled(false);
		button_createQuestionnaire.setBounds(216, 120, 109, 23);
		frame.getContentPane().add(button_createQuestionnaire);
		button_createQuestionnaire.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {			
				
				RuntimeMemory mem = form.initMemory();
				
				QuestionFrame qf = new QuestionFrame(form);
			}
		});
	}
}
