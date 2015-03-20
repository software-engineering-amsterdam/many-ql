package ql.gui.file;

import java.io.File;

import javax.swing.filechooser.FileFilter;

public class FormFileFilter extends FileFilter {
	public final static String ql = "ql";

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
			if (extension.equals(ql)) {
				return true;
			} else {
				return false;
			}
		}

		return false;
	}

	@Override
	public String getDescription() {
		return "QL Forms";
	}
}
