package uva.TaxForm.GUI;

import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Layout extends JPanel {
	
	List<String> returnedData = new ArrayList<String>();
	//returnedData = retrieveData();
	
	JPanel containerPanel;
	
	public Layout() {
		
		//create a container JPanel object to hold our rows
		containerPanel = new JPanel(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		
		JPanel rowPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

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
	
	/*public Layout() {
		
	}
	
	public FlowLayoutPanel setLayout() {
		
		return new FlowLayoutPanel();
	}
	
	class FlowLayoutPanel extends JPanel {
		
		public FlowLayoutPanel() {
		
			BoxLayoutPanelY blpY = new BoxLayoutPanelY();
			add(blpY);
		}
	}
	
	class BoxLayoutPanelY extends JPanel {
		
		public BoxLayoutPanelY() {
			
			setLayout( new BoxLayout( this, BoxLayout.Y_AXIS) );
			
			BoxLayoutPanelX blpX = new BoxLayoutPanelX();
			add(blpX);
		}
	}
	
	class BoxLayoutPanelX extends JPanel {
		
		public BoxLayoutPanelX() {
			
			setLayout( new BoxLayout( this, BoxLayout.X_AXIS) );
			
			JLabel l1 = new JLabel( "label1" );
			l1.setSize(50, 30);
			add(l1);
			
			JTextField t1 = new JTextField( "een" );
			t1.setSize(30, 30);
			add(t1);
		}
	}*/
	
	/*List<String> returnedData = new ArrayList<String>();
	//returnedData = retrieveData();
	
	public Layout() {
		
		//create a container JPanel object to hold our rows
		JPanel containerPanel = new JPanel(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		
		for(String d:returnedData){
			//create JPanel object for each row of returned data
			JPanel rowPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

			//create JLabels to hold columns of data
			JLabel nameLabel = new JLabel(d.getName());
			JLabel dateLabel = new JLabel(d.getDate());
			JLabel sizeLabel = new JLabel(d.getSize());

			//add label to rowPanel
			rowPanel.add(nameLabel);
			rowPanel.add(dateLabel);
			rowPanel.add(sizeLabel);

			//add filled row panel to container
			containerPanel.add(rowPanel);
		}
	}*/

}
