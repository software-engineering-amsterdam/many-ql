package nl.uva.softwcons;

import java.io.IOException;
import java.io.InputStream;

import nl.uva.softwcons.ast.ASTBuilderVisitor;
import nl.uva.softwcons.ast.form.Form;
import nl.uva.softwcons.generated.QLLexer;
import nl.uva.softwcons.generated.QLParser;

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

    public static void main(String[] args) throws IOException {
        InputStream input = Questionnaire.class.getResourceAsStream("/form.ql");
        Form form = Questionnaire.build(input);
    }
}
