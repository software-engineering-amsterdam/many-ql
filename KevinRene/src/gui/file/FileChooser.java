package gui.file;

import gui.Widget;

import java.io.File;

import javax.swing.JComponent;
import javax.swing.JFileChooser;

import ql.Value;

public class FileChooser implements Widget {
	private JFileChooser fileChooser;
	private Widget handler;
	
	public FileChooser() {
		fileChooser = new JFileChooser();
		fileChooser.addChoosableFileFilter(new FormFilter());
		fileChooser.setAcceptAllFileFilterUsed(false);
	}
	
	public File getSelectedFile() {
		return fileChooser.getSelectedFile();
	}
	
	public boolean showOpenDialog(Widget parent) {
		int returnValue = fileChooser.showOpenDialog(parent.getComponent());
		
		if(returnValue == JFileChooser.APPROVE_OPTION) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void setHandler(Widget handler) {
		this.handler = handler;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public void handleChange(Value changedValue, Widget source) {
		handler.handleChange(changedValue, source);
	}

	@Override
	public void updateComponent() {
		fileChooser.revalidate();
		fileChooser.repaint();
	}

	@Override
	public JComponent getComponent() {
		return fileChooser;
	}
}
