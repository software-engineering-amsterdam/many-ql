package anotherOne.main.trash;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
 
/**
 *
 * @web http://java-buddy.blogspot.com/
 */
public class JavaDynUI extends JFrame {
 
    static JavaDynUI myFrame;
    static int countMe = 0;
    JPanel mainPanel;
 
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            createAndShowGUI();
        });
    }
 
    private static void createAndShowGUI() {
        myFrame = new JavaDynUI();
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.prepareUI();
        myFrame.pack();
        myFrame.setVisible(true);
    }
 
    private void prepareUI() {
        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
 
        JButton buttonAdd = new JButton("Add subPanel");
        buttonAdd.addActionListener(new ActionListener() {
 
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.add(new subPanel());
                myFrame.pack();
            }
        });
         
        JButton buttonRemoveAll = new JButton("Remove All");
        buttonRemoveAll.addActionListener(new ActionListener() {
 
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.removeAll();
                myFrame.pack();
            }
        });
 
        getContentPane().add(mainPanel, BorderLayout.CENTER);
        getContentPane().add(buttonAdd, BorderLayout.PAGE_START);
        getContentPane().add(buttonRemoveAll, BorderLayout.PAGE_END);
    }
 
    private class subPanel extends JPanel {
         
        subPanel me;
 
        public subPanel() {
            super();
            me = this;
            JLabel myLabel = new JLabel("Hello subPanel(): " + countMe++);
            add(myLabel);
            JButton myButtonRemoveMe = new JButton("remove me");
            myButtonRemoveMe.addActionListener(new ActionListener(){
 
                @Override
                public void actionPerformed(ActionEvent e) {
                    me.getParent().remove(me);
                    myFrame.pack();
                }
            });
            add(myButtonRemoveMe);
        }
    }
}