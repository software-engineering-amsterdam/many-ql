package anotherOne.main.trash;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Test2 {

        private JFrame frame;
        private JTextField textField;
        private JTextField textField_1;

        /**
         * Launch the application.
         */
        public static void main(String[] args) {
                EventQueue.invokeLater(new Runnable() {
                        public void run() {
                                try {
                                        Test2 window = new Test2();
                                        window.frame.setVisible(true);
                                } catch (Exception e) {
                                        e.printStackTrace();
                                }
                        }
                });
        }

        /**
         * Create the application.
         */
        public Test2() {
                initialize();
        }

        /**
         * Initialize the contents of the frame.
         */
        private void initialize() {
                frame = new JFrame();
                frame.setBounds(100, 100, 401, 232);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.getContentPane().setLayout(null);

                JPanel panel = new JPanel();
                panel.setBounds(10, 11, 330, 94);
                frame.getContentPane().add(panel);
                panel.setLayout(null);

                JLabel lblNewLabel = new JLabel("Firstname :");
                lblNewLabel.setBounds(10, 11, 104, 14);
                panel.add(lblNewLabel);

                textField = new JTextField();
                textField.setBounds(76, 8, 244, 20);
                panel.add(textField);
                textField.setColumns(10);

                JLabel lblLastname = new JLabel("Lastname :");
                lblLastname.setBounds(10, 42, 78, 14);
                panel.add(lblLastname);

                textField_1 = new JTextField();
                textField_1.setBounds(76, 39, 244, 20);
                panel.add(textField_1);
                textField_1.setColumns(10);

                JButton btnValidate = new JButton("Validate");
                btnValidate.addMouseListener(new MouseAdapter() {
                        @SuppressWarnings("deprecation")
                        @Override
                        public void mousePressed(MouseEvent arg0) {
                                JPanel panel_1 = new JPanel();
                                JPanel panel_2 = new JPanel();

                                if(textField.getText().equals("")) {

                                        panel_1.setBackground(new Color(30, 144, 255));
                                        panel_1.setBounds(100, 116, 330, 26);

                                        JLabel lblMessage = new JLabel("0 :");
                                        lblMessage.setForeground(new Color(255, 255, 255));
                                        lblMessage.setFont(new Font("Tahoma", Font.BOLD, 13));

                                        panel_1.add(lblMessage);

                                        frame.getContentPane().add(panel_1);

                                        frame.revalidate();
                                        frame.repaint(10);
                                        frame.revalidate();
                                }
                                else if(textField_1.getText().equals("")) {

                                        panel_2.setBackground(new Color(50, 200, 255));
                                        panel_2.setBounds(10, 134, 330, 26);

                                        JLabel lblMessage = new JLabel("1 :");
                                        lblMessage.setBounds(50, 50, 50, 50);
                                        lblMessage.setAlignmentX(50);
                                        lblMessage.setForeground(new Color(255, 255, 255));
                                        lblMessage.setFont(new Font("Tahoma", Font.BOLD, 13));

                                        panel_2.add(lblMessage);

                                        frame.getContentPane().add(panel_2);

                                        frame.remove(panel_1);


                                        frame.revalidate();
                                        frame.repaint(10);
                                        frame.revalidate();


                                }


                        }
                });

                btnValidate.setBounds(231, 71, 89, 23);
                panel.add(btnValidate);


        }
}