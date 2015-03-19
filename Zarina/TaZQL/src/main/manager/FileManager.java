package main.manager;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;

public class FileManager {
	final JFileChooser fileChooser = new JFileChooser();
	
	public String getFileString() {
		try {
			return fileToString(fileName());
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog (null, "You didn't choose (existing) file.", "Error!", JOptionPane.ERROR_MESSAGE);
		}
		return null;
	}
	
	public String fileToString(String filename) throws FileNotFoundException  {
		File file = new File(filename);
		StringBuilder fileContents = new StringBuilder((int)file.length());
		Scanner scan = new Scanner(file);
		String lineSeparator = System.getProperty("line.separator");
		
		try {
		    while(scan.hasNextLine()) {        
		        fileContents.append(scan.nextLine() + lineSeparator);
		    }
		return fileContents.toString();
		} 
		finally {
		    scan.close();
		}
	}
	
	public String fileName() {
		customazeFileChooser();
		fileFilter();
		int result = fileChooser.showOpenDialog(new JOptionPane());	
		
		if (!(result == JFileChooser.APPROVE_OPTION)) {
			return "";
		}
		   
		File selectedFile = fileChooser.getSelectedFile();
		String fileName = selectedFile.getAbsolutePath();
		return fileName;
        
	}
	
	private JFileChooser customazeFileChooser() {
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		fileChooser.setCurrentDirectory(new File("C:\\")); 
		fileChooser.setDialogTitle("Choose a tax form");
		fileChooser.setApproveButtonText("Load form");
		
		return fileChooser;
	}
	
	private JFileChooser fileFilter() {
		fileChooser.setFileFilter(new FileFilter() {        
			 
			@Override
		       public String getDescription() {
		            return "Questionnaires (*.ql)";
		        }
		 
		   @Override
		       public boolean accept(File f) {
		            if (f.isDirectory()) {
		                return true;
		            } else {
		                return f.getName().toLowerCase().endsWith(".ql");
		            }
		        }
		    });
		return fileChooser;
		
	}
}
