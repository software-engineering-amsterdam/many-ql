package qls.util;

import ql.ast.AstNode;
import ql.ast.form.Form;
import ql.semantics.errors.Messages;
import ql.tests.TestHelper;
import qls.ast.AstBuilder;
import qls.ast.Stylesheet;
import qls.gen.QLSLexer;
import qls.gen.QLSParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;

/**
 * Created by bore on 12/03/15.
 */
public class ParserHelper
{

    public static Messages getStylesheet(String stylePath, String formPath)
    {
        Stylesheet s = TestHelper.as(ParseStylesheet(stylePath), Stylesheet.class);
        Form f = TestHelper.as(ql.util.ParserHelper.ParseForm(formPath), Form.class);

        return qls.semantics.TypeChecker.check(s, f);
    }

    public static AstNode ParseStylesheet(String file)
    {
        CharStream stream =  ql.util.ParserHelper.createInputStream(file);
        QLSParser parser = createQLSParser(stream);
        QLSParser.StylesheetContext s = parser.stylesheet();
        AstBuilder visitor = new AstBuilder();

        return s.accept(visitor);
    }

    private static QLSParser createQLSParser(CharStream stream)
    {
        QLSLexer lexer = new QLSLexer(stream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        return new QLSParser(tokens);
    }
}
