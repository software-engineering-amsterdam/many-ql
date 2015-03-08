package nl.uva.softwcons.ql;

import java.io.IOException;
import java.io.InputStream;

import nl.uva.softwcons.generated.QLLexer;
import nl.uva.softwcons.generated.QLParser;
import nl.uva.softwcons.ql.ast.ASTBuilderVisitor;
import nl.uva.softwcons.ql.ast.form.Form;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class Questionnaire {

    public static Form build(String input) {
        return parseForm(new ANTLRInputStream(input));
    }

    public static Form build(InputStream input) throws IOException {
        return parseForm(new ANTLRInputStream(input));
    }

    private static Form parseForm(ANTLRInputStream input) {
        QLLexer lexer = new QLLexer(input);
        QLParser parser = new QLParser(new CommonTokenStream(lexer));
        ParseTree tree = parser.form();

        return (Form) new ASTBuilderVisitor().visit(tree);
    }

}
