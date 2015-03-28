package main.manager;

import gui.MainFrame;
import typechecker.TypeChecker;
import ast.form.Form;

public class GUIManager {
	private final FileManager file;
	private final String filename;
	private final Form form;
	private final TypeChecker typeChecker;
	private final boolean formIsCorrect;
	private final MainFrame mainFrame;
	
	public GUIManager() {
		this.file = new FileManager();
		this.filename = file.getFileString();
		this.form = new ASTCreator().formCreator(filename);
		this.typeChecker = new TypeChecker();
		this.formIsCorrect = typeChecker.checkQuestionnaire(form);
		this.mainFrame = new MainFrame();
	}
	
	public void runGUI() {
		if(formIsCorrect) {
			mainFrame.addFormToFrame(form);	
		}
		else {
			mainFrame.showGUI();
			typeChecker.showErrors();
		}
	}
}
