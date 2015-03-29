package nl.uva.softwcons.qls;

import java.io.IOException;
import java.io.InputStream;

import nl.uva.softwcons.generated.QLSLexer;
import nl.uva.softwcons.generated.QLSParser;
import nl.uva.softwcons.qls.ast.ASTBuilderVisitor;
import nl.uva.softwcons.qls.ast.stylesheet.Stylesheet;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class StylesheetBuilder {

    public static Stylesheet build(final String input) {
        return parseStylesheet(new ANTLRInputStream(input));
    }

    public static Stylesheet build(final InputStream input) throws IOException {
        return parseStylesheet(new ANTLRInputStream(input));
    }

    private static Stylesheet parseStylesheet(final ANTLRInputStream input) {
        final QLSLexer lexer = new QLSLexer(input);
        final QLSParser parser = new QLSParser(new CommonTokenStream(lexer));
        final ParseTree tree = parser.stylesheet();

        return (Stylesheet) new ASTBuilderVisitor().visit(tree);
    }

}
