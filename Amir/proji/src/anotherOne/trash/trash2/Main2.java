package anotherOne.main.trash;

//
//package com.javacodegeeks.snippets.desktop;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Main2 {

    public static void main(String args[]) {

  JFrame frame = new JFrame("Button Sample");

  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

  final JButton button1 = new JButton("Press me");

  final JButton button2 = new JButton("Press me");

  ActionListener actionListener = new ActionListener() {

@Override

public void actionPerformed(ActionEvent actionEvent) {

    JButton jButton = (JButton) actionEvent.getSource();

    int r = (int) (Math.random() * 100);

    int g = (int) (Math.random() * 100);

    int b = (int) (Math.random() * 100);

    jButton.setBackground(new Color(r, g, b));

}

  };

  PropertyChangeListener propChangeListn = new PropertyChangeListener() {

@Override

public void propertyChange(PropertyChangeEvent event) {

    String property = event.getPropertyName();

    if ("background".equals(property)) {

  button2.setBackground((Color) event.getNewValue());

    }

}

  };

  button1.addActionListener(actionListener);

  button1.addPropertyChangeListener(propChangeListn);

  button2.addActionListener(actionListener);

  Container cPane = frame.getContentPane();

  cPane.add(button1, BorderLayout.NORTH);

  cPane.add(button2, BorderLayout.SOUTH);

  frame.setSize(500, 300);

  frame.setVisible(true);
    }
}