package gui.menu;

import gui.Composite;
import gui.Widget;
import gui.widget.composite.Panel;
import gui.widget.input.Button;
import gui.widget.io.FileChooser;
import gui.widget.io.Log;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.JComponent;

import ql.Value;
import ql.ast.expression.Identifier;

public class FileSelectionMenu extends Composite {
	private FileChooser fileChooser;
	private Panel buttonPanel, panel;
	private Button openButton;
	private Log log;
	private String content = "";
	
	public FileSelectionMenu() {
		super(new Identifier("File Selection Panel"));
		
		log = new Log();
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
		log.appendMessage(logMessage);
	}
	
	public String getFileLines() {
		return content;
	}
	
	private void loadFileLines(File file) {
		Path path = Paths.get(file.getAbsolutePath());
		
		try {
			content = new String(Files.readAllBytes(path));
		} catch (IOException e) {
			log.appendMessage(file.getAbsolutePath() + " cannot be found.");
		}
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public void handleChange(Value changedValue, Widget source) {
		if (source == openButton) {
			if (fileChooser.showOpenDialog(panel)) {
				File file = fileChooser.getSelectedFile();
				loadFileLines(file);
				
				super.handleChange(changedValue, this);
			} else {
				log.appendMessage("Open command cancelled by user.\n");
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
