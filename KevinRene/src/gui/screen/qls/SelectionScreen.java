package gui.screen.qls;

import gui.Screen;
import gui.content.UILog;
import gui.file.FileChooser;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import ql.TypeEnvironment;
import ql.Value;
import ql.ast.QLNode;
import ql.ast.expression.Identifier;
import ql.ast.statement.Form;
import ql.errorhandling.ErrorEnvironment;
import ql.gui.UIComponent;
import ql.gui.widget.input.Button;
import ql.value.StringValue;
import qls.ast.Statement;
import qls.ast.expression.literal.StringLiteral;
import qls.ast.visitor.typechecker.TypeChecker;
import qls.gui.structure.UISection;
import qls.parser.Parser;

public class SelectionScreen extends Screen {
	private FileChooser fileChooser;

	private Button openButton;
	private UILog log;
	
	private UISection logSection, buttonSection;
	
	private QLNode parsedTree;
	
	public SelectionScreen(UIComponent handler) {
		super(new Identifier("QLS Loader"));
		
		log = new UILog();
		log.setHandler(this);
		logSection = new UISection(new StringLiteral("Output log"));
		logSection.addComponent(log, "span");
		
		openButton = new Button("Open QLS File...");
		buttonSection = new UISection(new StringLiteral("Buttons"));
		buttonSection.addComponent(openButton, "span");
		
		addSection(buttonSection, "wrap");
		addSection(logSection);
		
		fileChooser = new FileChooser(FileChooser.QLS);
		fileChooser.setHandler(this);
		
		setHandler(handler);
	}	
	
	public QLNode getFormAst() {
		return parsedTree;
	}
	
	private void addLogMessage(String logMessage) {
		log.appendMessage(new StringValue(logMessage + "\n"));
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
