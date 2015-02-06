package com.fugazi.ql;

import com.fugazi.ql.grammar.QLBaseListener;
import com.fugazi.ql.grammar.QLParser;

/** Convert short array inits like {1,2,3} to "\u0001\u0002\u0003" */
public class ShortToUnicodeString extends QLBaseListener {

    /** Translate { to " */
    @Override
    public void enterInit(QLParser.InitContext ctx) {
        System.out.print('"');
    }

    /** Translate } to " */
    @Override
    public void exitInit(QLParser.InitContext ctx) {
        System.out.print('"');
    }

    /** Translate integers to 4-digit hexadecimal strings prefixed with \\u */
    @Override
    public void enterValue(QLParser.ValueContext ctx) {

        // Assumes no nested array initializers
        int value = Integer.valueOf(ctx.INT().getText());
        System.out.printf("\\u%04x", value);
    }
}