package nl.uva.bromance.listeners;

import nl.uva.bromance.parsers.ExpBaseListener;
import nl.uva.bromance.parsers.ExpParser;

import java.util.List;

/**
 * Created by Robert on 2/7/2015.
 */
public class ExpParseTreeListener extends ExpBaseListener {

    public static ExpParser.FieldContext fieldCtx;

    @Override
    public void enterField(ExpParser.FieldContext ctx) {
        super.enterField(ctx);
        fieldCtx = ctx;
    }

    public int getBurialCount() {

        List<ExpParser.BurialContext> burial = fieldCtx.burial();
        return burial.size();
    }
}
