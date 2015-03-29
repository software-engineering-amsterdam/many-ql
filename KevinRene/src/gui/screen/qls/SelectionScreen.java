package gui.screen.qls;

import gui.Screen;
import gui.content.UILog;
import gui.file.FileChooser;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import ql.Value;
import ql.ast.expression.Identifier;
import ql.ast.statement.Form;
import ql.ast.visitor.typechecker.TypeEnvironment;
import ql.errorhandling.ErrorEnvironment;
import ql.gui.Component;
import ql.gui.widget.input.Button;
import qls.ast.expression.literal.StringLiteral;
import qls.ast.statement.Stylesheet;
import qls.ast.visitor.WidgetEnvironment;
import qls.ast.visitor.domaincreator.ConditionalDomain;
import qls.ast.visitor.domaincreator.DomainCreator;
import qls.ast.visitor.pagebuilder.PageBuilder;
import qls.ast.visitor.widgetbinder.WidgetBinder;
import qls.gui.structure.UISection;

public class SelectionScreen extends Screen {
	private FileChooser fileChooser;

	private Button openButton, clearButton;
	private UILog log;
	
	private UISection logSection, buttonSection;
	
	private Component qlsInterface;
	
	public SelectionScreen(Component handler) {
		super(new Identifier("QLS Loader"));
		
		log = new UILog(this);
		logSection = new UISection(new StringLiteral("Output log"));
		logSection.addComponent(log, "span");
		
		openButton = new Button("Open QLS File...");
		clearButton = new Button("Clear log");
		buttonSection = new UISection(new StringLiteral("Buttons"));
		buttonSection.addComponent(openButton, "");
		buttonSection.addComponent(clearButton, "");
		
		addSection(buttonSection, "wrap");
		addSection(logSection);
		
		fileChooser = new FileChooser(FileChooser.QLS);
		fileChooser.setHandler(this);
		
		setHandler(handler);
	}	
	
	public Component getQLSInterface() {
		return qlsInterface;
	}

	private String stripExtension(String string) {
		return string.replaceFirst("[.][^.]+$", "");
	}
	
	private String loadSelectedFile(String path, String extension) {
		Path filePath = Paths.get(stripExtension(path) + "." + extension);
		
		try {
			return new String(Files.readAllBytes(filePath));
		} catch (IOException e) {
			log.appendMessage(filePath + " cannot be found.");
		}
		
		return null;
	}
	
	private boolean processFile(File file) {
		boolean errorsFound = false;
		
		String qlContents = loadSelectedFile(file.getAbsolutePath(), FileChooser.QL);
		String qlsContents = loadSelectedFile(file.getAbsolutePath(), FileChooser.QLS);
		
		if(qlContents == null || qlsContents == null) {
			return false;
		}
		
		ql.ast.Statement qlTree = (ql.ast.Statement) ql.parser.Parser.parse(qlContents);
		
		if(!(qlTree instanceof Form)) {
			return false;
		}		
		
		TypeEnvironment typeEnvironment = new TypeEnvironment();
		ErrorEnvironment errors = ql.ast.visitor.typechecker.TypeChecker.check(qlTree, typeEnvironment);
		
		if(errors.hasErrors()) {
			log.appendMessage("-- QL Errors --");
			log.appendMessage(errors.getErrors());
			
			errorsFound = true;
		}
		
		qls.ast.Statement qlsTree = (qls.ast.Statement) qls.parser.Parser.parse(qlsContents);

		if(!(qlsTree instanceof Stylesheet)) {
			return false;
		}
		
		errors = qls.ast.visitor.typechecker.TypeChecker.check(qlsTree, typeEnvironment);
		
		if(errors.hasErrors()) {
			log.appendMessage("-- QLS Errors --");
			log.appendMessage(errors.getErrors());
			
			errorsFound = true;
		}

		WidgetEnvironment widgets = WidgetBinder.bind(qlsTree, typeEnvironment);
		List<ConditionalDomain> domains = DomainCreator.create(qlTree, widgets);
		
		qlsInterface = PageBuilder.build(qlsTree, domains, widgets);
		
		return !errorsFound;
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
