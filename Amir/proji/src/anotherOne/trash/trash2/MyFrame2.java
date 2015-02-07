package anotherOne.main.trash;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

//import net.miginfocom.swing.MigLayout;

public class MyFrame2 extends JFrame {
    private JPanel main;
    private JPanel s1;
    private JPanel s2;
    private JPanel s3;

    public static void main(String[] args) throws InterruptedException {
        MyFrame2 f = new MyFrame2();
        f.setVisible(true);
        Thread.sleep(5000); //you can see all three panels for two seconds

        f.main.remove(f.s1);
        f.main.validate();
        Thread.sleep(2000);
        f.main.remove(f.s2);
        f.main.validate();
        Thread.sleep(2000);
        f.main.remove(f.s3);
        f.main.validate();
    }

    public MyFrame2() {
        main = new JPanel();

//        main.setLayout(new MigLayout());

        main.add(new JLabel("Why does s3 not disappear?"),"w 200, h 100, wrap");

        s1 = new JPanel();
        s1.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.GRAY,1),"s1"));
        main.add(s1,"w 90%, h 300, wrap");

        s2 = new JPanel();
        s2.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.GRAY,1),"s2"));
        main.add(s2,"w 90%, h 300, wrap");

        s3 = new JPanel();
        s3.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.GRAY,1),"s3"));
        main.add(s3,"w 90%, h 300, wrap");

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(main, BorderLayout.CENTER);

        setSize(new Dimension(800, 600));

    }
}