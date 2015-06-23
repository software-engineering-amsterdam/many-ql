package gui.file;

import java.io.File;

import javax.swing.JComponent;
import javax.swing.JFileChooser;

import ql.gui.DefaultComponent;
import ql.gui.Component;

public class FileChooser extends DefaultComponent implements Component {
	public final static String QL = "ql";
	public final static String QLS = "qls";
	
	private JFileChooser fileChooser;
	
	public FileChooser(String extension) {
		fileChooser = new JFileChooser();
		fileChooser.addChoosableFileFilter(new FileFilter(extension));
		fileChooser.setAcceptAllFileFilterUsed(false);
	}
	
	public File getSelectedFile() {
		return fileChooser.getSelectedFile();
	}
	
	public boolean showOpenDialog(Component parent) {
		int returnValue = fileChooser.showOpenDialog(parent.getComponent());
		
		if(returnValue == JFileChooser.APPROVE_OPTION) {
			return true;
		} else {
			return false;
		}
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