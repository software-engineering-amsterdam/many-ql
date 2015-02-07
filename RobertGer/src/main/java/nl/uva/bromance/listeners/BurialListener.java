package nl.uva.bromance.listeners;

import nl.uva.bromance.parsers.ExpBaseListener;
import nl.uva.bromance.parsers.ExpParser;
import org.antlr.v4.runtime.ParserRuleContext;

public class BurialListener extends ExpBaseListener {

    private static Integer countBurial = 0;

    @Override
    public void enterBurial(ExpParser.BurialContext ctx) {
        System.out.println(ctx.getText());
        countBurial += 1;
    }

    public Integer getCountBurial() {
        return countBurial;
    }

    @Override
    public void enterEveryRule(ParserRuleContext ctx) {
        super.enterEveryRule(ctx);
    }
}
