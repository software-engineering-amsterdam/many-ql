package gui.screen;

import gui.UIComponent;
import gui.content.UILog;
import gui.file.FormFileChooser;
import gui.structure.Section;
import gui.widget.input.Button;

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
import ql.parser.Parser;

public class FormLoaderScreen extends Screen {
	private final String FAILURE = "Failed";
	
	private FormFileChooser fileChooser;
	private Section buttonPanel, logPanel;
	private Button openButton;
	private UILog log;
	private QLNode parsedTree;
	
	public FormLoaderScreen(UIComponent handler) {
		log = new UILog();
		logPanel = new Section(this);
		logPanel.addComponent(log);
		
		openButton = new Button("Open QL File...");
		buttonPanel = new Section(this);
		buttonPanel.addComponent(openButton);
		
		addScreenSection(buttonPanel);
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
		
		return FAILURE;
	}
	
	private boolean isValidForm(QLNode tree) {
		return tree instanceof Form;
	}
	
	private boolean processFile() {
		String fileContents = loadSelectedFile();
		
		if(fileContents == FAILURE) {
			return false;
		}
		
		parsedTree = Parser.parse(fileContents);
		
		if(!isValidForm(parsedTree)) {
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
