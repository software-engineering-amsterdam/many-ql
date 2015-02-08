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

    private String currentBurial;
    @Override
    public void enterField(ExpParser.FieldContext ctx) {
        super.enterField(ctx);
        fieldCtx = ctx;
        List<ParseTree> kids = ctx.children;

        System.out.println("entering field :" + fieldCtx);
    }

    public void enterLocation(ExpParser.LocationContext lct){
        super.enterLocation(lct);
        System.out.println("[Hard Parse] Treasure :"+currentBurial+" is buried at : "+lct.x.getText()+","+lct.y.getText());
    }
    public void exitLocation(ExpParser.LocationContext lct){
       super.exitLocation(lct);
        System.out.println("Exiting location"+lct);
    }
    public void enterBurial(ExpParser.BurialContext btx){
        super.enterBurial(btx);
        currentBurial = btx.treasure.getText();
        if (btx.at == null){
            System.err.println("Error@Line:"+btx.start.getLine()+"] Burial "+currentBurial+" has no valid location!");
        } else {
            System.out.println("[Easy Parse] Treasure :"+btx.treasure.getText()+" is buried at : "+btx.at.x.getText()+","+btx.at.y.getText());
        }
    }
    public void exitBurial(ExpParser.BurialContext btx){
        super.exitBurial(btx);
        System.out.println("Exited burial");
    }

    public int getBurialCount() {

        List<ExpParser.BurialContext> burial = fieldCtx.burial();
        return burial.size();
    }
}
