package anotherOne.main.trash;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;

import javax.swing.*;

import anotherOne.ast.question.Question;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class ExampleAppStarter {
    public static void main(String [] args) {
        new ExampleAppStarter().start();
    }
    private void start() {
        MainWindow m = new MainWindow();
        new DialogWindow(m);
    }
} // ExampleAppStarter

class MainWindow implements Observer {
    private JLabel label;
    @Override // Observer interface's implemented method
    public void update(Observable o, Object data) {	
        label.setText((String) data); // displays new text in JLabel
        System.out.print("check");
    }
    MainWindow() {	
        JFrame frame = new JFrame("Main Window");
        frame.getRootPane().setBorder(
            BorderFactory.createEmptyBorder(20, 20, 20, 20));		
        label = new JLabel("Click button in Dialog...");
        label.setFont(new Font("Dialog", Font.PLAIN, 20));	
        frame.add(label);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);
        frame.setLocation(200, 200);
        frame.setVisible(true);
    }
} // MainWindow

class DialogWindow {
//	public List<Question> questionList = new ArrayList<Question>();
	public List<JTextField> textfields = new ArrayList();
	
	// textfields.
    private int clicks;
    DialogWindow(MainWindow mainWindow) {
    	textfields.add(new JTextField("surprise"));
    	textfields.add(new JTextField("test2"));
    	textfields.add(new JTextField("test3"));
    	
    	
        // Create Observable and add Observer		
        final MessageObservable observable = new MessageObservable();
        observable.addObserver(mainWindow);
        // Display Dialog
//        JFrame frm = new JFrame("dd");
        
        JFrame dialog = new JFrame("Dialog");		
        JButton button = new JButton("Press me");
        button.setFont(new Font("Dialog", Font.PLAIN, 20));
        JTextField txt = new JTextField (10);
        txt.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.print("!!!!!");
				String data = txt.getText();				
	        	observable.changeData(data);
			}
        });

        
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String data = "button clicked in dialog [" + ++clicks + "]";
                observable.changeData(data);
            }
        });		
//        frm.add(new JTextField("ooooo",10));
//        frm.setVisible(true);
        dialog.add(button);
        dialog.add(txt);
        dialog.setSize(100, 150);
        dialog.setLocation(600, 200);
        dialog.setVisible(true);
    }
    
    public void test () {
    	
    }
} // DialogWindow

class MessageObservable extends Observable {
    MessageObservable() {	
        super();
    }
    void changeData(Object data) {
        setChanged(); // the two methods of Observable class
        notifyObservers(data);
    }
} // MessageObservable