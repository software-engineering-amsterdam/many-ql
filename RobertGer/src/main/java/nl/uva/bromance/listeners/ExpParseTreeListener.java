package nl.uva.bromance.listeners;

import nl.uva.bromance.parsers.ExpBaseListener;
import nl.uva.bromance.parsers.ExpParser;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.List;

/**
 * Created by Robert on 2/7/2015.
 */
public class ExpParseTreeListener extends ExpBaseListener {

    public static ExpParser.FieldContext fieldCtx;
    public static ExpParser.LocationContext locationCtx;

    @Override
    public void enterField(ExpParser.FieldContext ctx) {
        super.enterField(ctx);
        fieldCtx = ctx;
        System.out.println("entering field :" + fieldCtx);
    }

    public void enterLocation(ExpParser.LocationContext lct){
        super.enterLocation(lct);
        locationCtx = lct;
        System.out.println("entering location : "+lct.x.getText()+","+lct.y.getText());
    }

    public int getBurialCount() {

        List<ExpParser.BurialContext> burial = fieldCtx.burial();
        return burial.size();
    }
}
