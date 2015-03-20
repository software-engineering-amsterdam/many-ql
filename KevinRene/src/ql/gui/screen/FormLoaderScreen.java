package ql.gui.screen;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import ql.TypeEnvironment;
import ql.Value;
import ql.ast.QLNode;
import ql.ast.Statement;
import ql.ast.statement.Form;
import ql.ast.visitor.typechecker.TypeChecker;
import ql.errorhandling.ErrorEnvironment;
import ql.gui.UIComponent;
import ql.gui.content.UILog;
import ql.gui.file.FormFileChooser;
import ql.gui.structure.Panel;
import ql.gui.widget.input.Button;
import ql.parser.Parser;

public class FormLoaderScreen extends Screen {
	private FormFileChooser fileChooser;
	private Panel buttonPanel, logPanel;
	private Button openButton;
	private UILog log;
	private QLNode parsedTree;
	
	public FormLoaderScreen(UIComponent handler) {
		log = new UILog();
		log.setHandler(this);
		logPanel = new Panel(this);
		logPanel.addComponent(log, "span");
		
		openButton = new Button("Open QL File...");
		buttonPanel = new Panel(this);
		buttonPanel.addComponent(openButton, "span");
		
		addScreenSection(buttonPanel, "wrap");
		addScreenSection(logPanel);
		
		fileChooser = new FormFileChooser();
		fileChooser.setHandler(this);
		
		setHandler(handler);
	}	
	
	public QLNode getFormAst() {
		return parsedTree;
	}
	
	private void addLogMessage(String logMessage) {
		log.appendMessage(logMessage + "\n");
	}
	
	private String loadSelectedFile() {
		File selectedFile = fileChooser.getSelectedFile();
		Path filePath = Paths.get(selectedFile.getAbsolutePath());
		
		try {
			return new String(Files.readAllBytes(filePath));
		} catch (IOException e) {
			addLogMessage(selectedFile.getAbsolutePath() + " cannot be found.");
		}
		
		return null;
	}
	
	private boolean processFile() {
		String fileContents = loadSelectedFile();
		
		if(fileContents == null) {
			return false;
		}
		
		parsedTree = Parser.parse(fileContents);
		
		if(!(parsedTree instanceof Form)) {
			return false;
		} 
		
		ErrorEnvironment errorEnvironment = TypeChecker.check((Statement) parsedTree, new TypeEnvironment());
		addLogMessage(errorEnvironment.getErrors());
		
		return !errorEnvironment.hasErrors();
	}
	
	@Override
	public void handleChange(Value changedValue, UIComponent source) {
		if (source != openButton) {
			return;
		}
		
		if (fileChooser.showOpenDialog(getScreen())) {
			if(processFile()) {
				super.handleChange(changedValue, this);
			}
		} else {
			addLogMessage("Open command cancelled by user.");
		}
	}
}
