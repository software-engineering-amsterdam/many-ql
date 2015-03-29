package gui.listeners;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Set;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import main.manager.FileManager;
import evaluator.ValueRepository;

public class SaveButtonListener {
	private final ValueRepository valueRepository;
	private static final String COMMA = ",";
	private static final String NEW_LINE = "\n";
	private static final String FILE_HEADER = "Question id, Answer";
	
	public SaveButtonListener(ValueRepository valueRepository) {
		this.valueRepository = valueRepository;
		selectDirectory();
	}
	
	public void selectDirectory() {
		final String filePath;
		final JFileChooser chooser=new JFileChooser();
		FileManager manager = new FileManager();
		manager.customazeFileChooser(chooser, "Save questionnaire as CSV");
		  
		final int result =chooser.showSaveDialog(null);
		if (result == JFileChooser.APPROVE_OPTION) {
			filePath = chooser.getSelectedFile().getPath();
			saveFile(filePath);
		}
	}
	
	public void saveFile(String filePath) {
		FileWriter fileWriter = null;
		
		try {
			fileWriter = new FileWriter(filePath + ".csv"); 
			fileWriter.append(FILE_HEADER.toString());
			fileWriter.append(NEW_LINE);

			Set<String> keys = valueRepository.getIDkeys();
	        for(String k:keys){
	            fileWriter.append(k);
				fileWriter.append(COMMA);
				fileWriter.append(valueRepository.getValue(k).toString());
				fileWriter.append(NEW_LINE);
	        }
	        JOptionPane.showMessageDialog(null, "Form was successfully saved!", "Success", JOptionPane.INFORMATION_MESSAGE);
		} 
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error found in a form!", "Error!", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		} 
		finally {
			try {
				fileWriter.flush();
				fileWriter.close();
			} 
			catch (IOException e) {
				JOptionPane.showMessageDialog(null, "Error during closing or flushing of file!", "Error!", JOptionPane.ERROR_MESSAGE);
				
		        e.printStackTrace();
			}			
		}
	}
}
