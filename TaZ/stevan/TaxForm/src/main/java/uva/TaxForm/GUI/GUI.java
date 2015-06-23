package uva.TaxForm.GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.LayoutManager;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class GUI extends JFrame {
	
	JFrame frame;
	JPanel containerPanel;
	
	public GUI() {
		
		//create frame
		frame = new JFrame("TaxForm");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize( new Dimension(400, 600) );
		frame.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		//show frame
		frame.pack();
		frame.setVisible(true);
		
		//set frame position on screen, center
		frame.setLocationRelativeTo(null);
	}
	
	public void addContainerPanel() {
		
		containerPanel = new JPanel();
		containerPanel.setLayout(new BoxLayout(containerPanel, BoxLayout.PAGE_AXIS));
		frame.add(containerPanel);
		frame.revalidate();
		//frame.repaint();
	}
	
	public void addRowPanel() {
		
		JPanel rowPanel = new JPanel();
		rowPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		//create JLabels to hold columns of data
		JLabel nameLabel = new JLabel("name");
		JLabel dateLabel = new JLabel("date");
		JLabel sizeLabel = new JLabel("size");

		//add label to rowPanel
		rowPanel.add(nameLabel);
		rowPanel.add(dateLabel);
		rowPanel.add(sizeLabel);
		
		//add filled row panel to container
		containerPanel.add(rowPanel);
	}
}
