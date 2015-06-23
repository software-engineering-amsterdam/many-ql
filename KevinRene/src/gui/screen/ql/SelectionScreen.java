package gui.screen.ql;

import gui.Screen;
import gui.content.UILog;
import gui.file.FileChooser;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import ql.Value;
import ql.ast.QLNode;
import ql.ast.Statement;
import ql.ast.expression.Identifier;
import ql.ast.statement.Form;
import ql.ast.visitor.typechecker.TypeChecker;
import ql.ast.visitor.typechecker.TypeEnvironment;
import ql.errorhandling.ErrorEnvironment;
import ql.gui.Component;
import ql.gui.widget.input.Button;
import ql.parser.Parser;
import qls.ast.expression.literal.StringLiteral;
import qls.gui.structure.UISection;

public class SelectionScreen extends Screen {
	private FileChooser fileChooser;

	private Button openButton, clearButton;
	private UILog log;
	
	private UISection logSection, buttonSection;
	
	private QLNode parsedTree;
	
	public SelectionScreen(Component handler) {
		super(new Identifier("QL Page"));
		
		log = new UILog(this);
		logSection = new UISection(new StringLiteral("Output log"));
		logSection.addComponent(log, "span");
		
		openButton = new Button("Open QL File...");
		clearButton = new Button("Clear log");
		
		buttonSection = new UISection(new StringLiteral("Buttons"));
		buttonSection.addComponent(openButton, "");
		buttonSection.addComponent(clearButton, "");
		
		addSection(buttonSection, "wrap");
		addSection(logSection);
		
		fileChooser = new FileChooser(FileChooser.QL);
		fileChooser.setHandler(this);
		
		setHandler(handler);
	}	
	
	public QLNode getFormAst() {
		return parsedTree;
	}
	
	private String loadSelectedFile(String path) {
		Path filePath = Paths.get(path);
		
		try {
			return new String(Files.readAllBytes(filePath));
		} catch (IOException e) {
			log.appendMessage(filePath + " cannot be found.");
		}
		
		return null;
	}
	
	private boolean processFile(File file) {
		String fileContents = loadSelectedFile(file.getAbsolutePath());
		
		if(fileContents == null) {
			return false;
		}
		
		parsedTree = Parser.parse(fileContents);
		
		if(!(parsedTree instanceof Form)) {
			return false;
		} 
		
		ErrorEnvironment errorEnvironment = TypeChecker.check((Statement) parsedTree, new TypeEnvironment());
		log.appendMessage(errorEnvironment.getErrors());
		
		return !errorEnvironment.hasErrors();
	}
	
	private void handleFileChooser() {
		if (fileChooser.showOpenDialog(getScreen())) {
			if(processFile(fileChooser.getSelectedFile())) {
				super.handleChange(null, this);
			}
		} else {
			log.appendMessage("Open command cancelled by user.");
		}
	}
	
	@Override
	public void handleChange(Value changedValue, Component source) {
		if(source == openButton) {
			handleFileChooser();
		}
		
		if(source == clearButton) {
			log.clear();
		}
	}
}