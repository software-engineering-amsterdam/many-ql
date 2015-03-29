package com.form.language.gui.program;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;

import com.form.language.GrammarLexer;
import com.form.language.GrammarParser;
import com.form.language.ast.form.Form;
import com.form.language.memory.Context;

public class MainFrame {	
    private static final int FRAME_WIDTH = 500;
    private static final int FRAME_HEIGHT = 500;

    private static final int TEXTFIELD_WIDTH = 460;
    private static final int TEXTFIELD_HEIGHT = 100;

    private JFrame frame;
    private JTextArea textArea_input;
    private JTextArea textArea_output;
    private JButton button_parse;
    private JButton button_createQuestionnaire;
    private Form form;

    public MainFrame() {
	initialize();
    }

    private void initialize() {
	final Context context = new Context();
	createFrame();		
	createTextFieldInput();
	createButtonParse(context);
	createButtonQuestionnaire(context);
	createTextFieldOutput();
    }

    private void createButtonQuestionnaire(final Context context) {
	button_createQuestionnaire = new JButton("Create Questionnaire");
	button_createQuestionnaire.setEnabled(false);
	button_createQuestionnaire.setSize(TEXTFIELD_WIDTH, TEXTFIELD_HEIGHT);
	frame.getContentPane().add(button_createQuestionnaire);		
	button_createQuestionnaire.addMouseListener(buttonClickCreateQuestionnaire(context));
    }

    private MouseAdapter buttonClickCreateQuestionnaire(final Context context) {
	return new MouseAdapter() {
	    @Override
	    public void mouseClicked(MouseEvent e) {
		form.initMemory(context);
		new QuestionnaireFrame(form, context);
	    }
	};
    }

    private void createButtonParse(final Context context) {
	button_parse = new JButton("Parse");
	button_parse.setSize(TEXTFIELD_WIDTH, TEXTFIELD_HEIGHT);
	frame.getContentPane().add(button_parse);		
	button_parse.addMouseListener(buttonClickParse(context));
    }

    private MouseAdapter buttonClickParse(final Context context) {
	return new MouseAdapter() {
	    @Override
	    public void mouseClicked(MouseEvent e) {
		CharStream charStream = new ANTLRInputStream(textArea_input.getText());
		GrammarLexer lexer = new GrammarLexer(charStream);
		TokenStream tokenStream = new CommonTokenStream(lexer);
		GrammarParser parser = new GrammarParser(tokenStream);

		form = parser.form().result;
		if(form == null){
		    textArea_output.setText("Cannot parse input");
		} else {
		    form.getTypes(context);
		    handleIssues(context);
		}
	    }

	    private void handleIssues(final Context context) {
		String issues = context.getWarnings();
		if (context.hasErrors()) {
		    issues += "\n" + context.getErrors();
		} else {
		    button_createQuestionnaire.setEnabled(true);
		}
		textArea_output.setText(issues);
	    }
	};
    }
    
	private void createTextFieldOutput() {
		textArea_output = new JTextArea();
		textArea_output.setSize(TEXTFIELD_WIDTH, TEXTFIELD_HEIGHT);
		frame.getContentPane().add(textArea_output);
	}

	private void createTextFieldInput() {
		textArea_input = new JTextArea();
		textArea_input.setSize(TEXTFIELD_WIDTH, TEXTFIELD_HEIGHT);
		frame.getContentPane().add(textArea_input);
	}

    private void createFrame() {
	frame = new JFrame();
	frame.setVisible(true);
	frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	BoxLayout boxLayout = new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS); // top to bottom
    frame.setLayout(boxLayout);
    }
}
