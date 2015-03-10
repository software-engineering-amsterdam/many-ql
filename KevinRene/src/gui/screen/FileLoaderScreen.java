package gui.screen;

import gui.Composite;
import gui.Widget;
import gui.content.UILog;
import gui.file.FileChooser;
import gui.structure.Panel;
import gui.widget.input.Button;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.swing.JComponent;

import ql.Value;
import ql.ast.expression.Identifier;

public class FileLoaderScreen extends Composite {
	private FileChooser fileChooser;
	private Panel buttonPanel, panel;
	private Button openButton;
	private UILog log;
	private String content = "";
	
	public FileLoaderScreen() {
		super(new Identifier("File Selection Panel"));
		
		log = new UILog();
		log.setHandler(this);
		
		panel = new Panel(this);		
		buttonPanel = new Panel(this);
		
		openButton = new Button("Open QL File...");		
		buttonPanel.addComponent(openButton);
		
		panel.addComponent(buttonPanel);
		panel.addComponent(log);
		
		fileChooser = new FileChooser();
		fileChooser.setHandler(this);
	}	
	
	public void addLogMessage(String logMessage) {
		log.appendMessage(logMessage + "\n");
	}
	
	public String getFileLines() {
		return content;
	}
	
	private void loadFileLines(File file) {
		try {
			content = new String(Files.readAllBytes(Paths.get(file.getAbsolutePath())));
		} catch (IOException e) {
			addLogMessage(file.getAbsolutePath() + " cannot be found.");
		}
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public void handleChange(Value changedValue, Widget source) {
		if (source == openButton) {
			if (fileChooser.showOpenDialog(panel)) {
				loadFileLines(fileChooser.getSelectedFile());
				super.handleChange(changedValue, this);
			} else {
				addLogMessage("Open command cancelled by user.");
			}
		}
	}
	
	@Override
	public void updateComponent() {
		panel.updateComponent();
	}

	@Override
	public JComponent getComponent() {
		return panel.getComponent();
	}
}
