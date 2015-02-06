package anotherOne.main.trash;

import java.awt.*;

import java.applet.*;



public class CheckBoxApplet extends Applet

{

    Checkbox checkbox1;


    public void init()

    {

        checkbox1 = new Checkbox("Option 1", null, true);

        add(checkbox1);

    }



    public void paint(Graphics g)

    {

        Font font = g.getFont();

        FontMetrics fontMetrics = g.getFontMetrics(font);

        int height = fontMetrics.getHeight();



        boolean checked = checkbox1.getState();

        if (checked)

            g.drawString("Option1 selected", 20, 120);

        else

            g.drawString("Option1 not selected", 20, 120);

        }



    public boolean action(Event evt, Object arg)

    {

        repaint();

        return true;

    }

}