package main.manager;

import gui.MainFrame;
import gui.errors.ErrorDialog;
import gui.errors.TaZQLError;
import gui.errors.TaZQLWarning;

import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

import typechecker.TypeCheckerVisitor;
import ast.form.Form;

public class GUIManager {
	private final FileManager file;
	private final String filename;
	private final Form form;
	private final MainFrame mainFrame;
	private final TypeCheckerVisitor typeCheckerVisitor;
	
	public GUIManager() {
		this.typeCheckerVisitor = new TypeCheckerVisitor();
		this.file = new FileManager();
		this.filename = file.getFileString();
		this.form = new ASTCreator().formCreator(filename);
		this.mainFrame = new MainFrame();
	}
	
	public void runGUI(JFrame frame) {
		if(formIsCorrect()) {
			final JPanel panel = mainFrame.addFormToFrame(form);	
			frame.getContentPane().removeAll();
			frame.getContentPane().add(panel);
			frame.setTitle(form.getFormId().toString());
			frame.pack();
			frame.setVisible(true);
		}
		else {
			frame.getContentPane().removeAll();
			frame.revalidate();
			frame.repaint();
			showErrors();
		}
	}
	
	public boolean formIsCorrect () {
		return checkQuestionnaire(form);
	}
	
	public boolean checkQuestionnaire(Form form) {
		form.accept(typeCheckerVisitor);
		return noErrors();
	}
	
	public boolean noErrors() {
		return this.typeCheckerVisitor.isCorrect();
	}
	
	public void showErrors() {
		new ErrorDialog(getError(), getWarning());
	}
	
	public List<TaZQLError> getError() {
		return this.typeCheckerVisitor.getError();
	}
	
	public List<TaZQLWarning> getWarning() {
		return this.typeCheckerVisitor.getWarning();
	}
}
