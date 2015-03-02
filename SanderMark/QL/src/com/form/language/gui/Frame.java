package com.form.language.gui;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;

import com.form.language.GrammarLexer;
import com.form.language.GrammarParser;
import com.form.language.ast.Form;

public class Frame {

	private JFrame frame;
	private JTextArea textArea_input;
	private JTextArea textArea_output;
	

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
		
		JButton btnNewButton = new JButton("Parse");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CharStream charStream = new ANTLRInputStream(textArea_input.getText());
				GrammarLexer lexer = new GrammarLexer(charStream);
				TokenStream tokenStream = new CommonTokenStream(lexer);
				GrammarParser parser = new GrammarParser(tokenStream);
				Form form = parser.form().result;
				QuestionFrame qf = new QuestionFrame(form);
			}
		});
		btnNewButton.setBounds(335, 120, 89, 23);
		frame.getContentPane().add(btnNewButton);
	}
}
