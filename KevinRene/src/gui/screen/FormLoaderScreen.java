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
import ql.error.TypeErrors;
import ql.parser.Parser;

public class FormLoaderScreen extends Screen {
	private final String FAILURE = "Failed";
	
	private FormFileChooser fileChooser;
	private Section buttonPanel, logPanel;
	private Button openButton;
	private UILog log;
	private QLNode formAst;
	private TypeErrors errorEnvironment;
	
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
		
		errorEnvironment = new TypeErrors();
		
		setHandler(handler);
	}	
	
	public QLNode getFormAst() {
		return formAst;
	}
	
	private void logErrors() {
		log.appendMessage(errorEnvironment.getErrors());
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
	
	private boolean createFormAst(String formCode) {
        formAst = Parser.parse(formCode);

		if(formAst instanceof Form) {
			return TypeChecker.check((Statement) formAst, new TypeEnvironment(), errorEnvironment);
		}
		
		return false;
	}
	
	@Override
	public void handleChange(Value<?> changedValue, UIComponent source) {
		if (source != openButton) {
			return;
		}
		
		if (fileChooser.showOpenDialog(getScreen())) {
			String fileContents = loadSelectedFile();
			if(fileContents == FAILURE) {
				return;
			}
			
			if(createFormAst(fileContents)) {
				super.handleChange(changedValue, this);
			} else {
				addLogMessage("File is not a valid form.");
				logErrors();
			}
		} else {
			addLogMessage("Open command cancelled by user.");
		}
	}
}
