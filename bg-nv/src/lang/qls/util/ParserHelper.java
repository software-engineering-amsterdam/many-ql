package lang.qls.util;

import lang.ql.ast.AstNode;
import lang.ql.ast.form.Form;
import lang.ql.semantics.errors.Messages;
import lang.ql.tests.TestHelper;
import lang.qls.ast.AstBuilder;
import lang.qls.ast.Stylesheet;
import lang.qls.gen.QLSLexer;
import lang.qls.gen.QLSParser;
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
        Form f = TestHelper.as(lang.ql.util.ParserHelper.ParseForm(formPath), Form.class);

        return lang.qls.semantics.TypeChecker.check(s, f);
    }

    public static AstNode ParseStylesheet(String file)
    {
        CharStream stream =  lang.ql.util.ParserHelper.createInputStream(file);
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
