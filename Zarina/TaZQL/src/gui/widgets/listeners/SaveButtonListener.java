package gui.widgets.listeners;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Set;

import javax.swing.JOptionPane;

import evaluator.ValueRepository;

public class SaveButtonListener {
	private final ValueRepository valueRepository;
	private static final String COMMA = ",";
	private static final String NEW_LINE = "\n";
	private static final String FILE_HEADER = "Question id, Answer";

	
	public SaveButtonListener(ValueRepository valueRepository) {
		this.valueRepository = valueRepository;
		saveFile();
	}
	
	public void saveFile() {
		FileWriter fileWriter = null;
		
		try {
			fileWriter = new FileWriter("./questionnaires/result.csv");
			fileWriter.append(FILE_HEADER.toString());
			fileWriter.append(NEW_LINE);

			Set<String> keys = valueRepository.getIDkeys();
	        for(String k:keys){
	            System.out.println("Question: " +k+". Answer: " + valueRepository.getValue(k));   
	            
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
