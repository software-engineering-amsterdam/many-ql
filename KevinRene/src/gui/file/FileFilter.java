package gui.file;

import java.io.File;


public class FileFilter extends javax.swing.filechooser.FileFilter {
	private String filterExtension;
	
	public FileFilter(String filterExtension) {
		this.filterExtension = filterExtension;
	}
	
	/*
	 * Get the extension of a file.
	 */
	public String getExtension(File f) {
		String ext = null;
		String s = f.getName();
		int i = s.lastIndexOf('.');

		if (i > 0 && i < s.length() - 1) {
			ext = s.substring(i + 1).toLowerCase();
		}
		return ext;
	}

	@Override
	public boolean accept(File path) {
		if (path.isDirectory()) {
			return true;
		}

		String extension = getExtension(path);
		
		if (extension != null) {
			if (extension.equals(filterExtension)) {
				return true;
			} else {
				return false;
			}
		}

		return false;
	}

	@Override
	public String getDescription() {
		return filterExtension.toUpperCase() + " forms";
	}
}