package nl.uva.bromance.listeners;

import nl.uva.bromance.parsers.DrinkBaseListener;
import nl.uva.bromance.parsers.DrinkParser;

/**
 * Created by Robert on 2/6/2015.
 */
public class DrinkListener extends DrinkBaseListener {

    @Override
    public void enterDrink(DrinkParser.DrinkContext ctx) {
        System.out.println(ctx.getText());
    }

}
