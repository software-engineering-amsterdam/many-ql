package org.fugazi.ql.ast;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.fugazi.ql.ast.form.Form;
import org.fugazi.ql.parser.QLLexer;
import org.fugazi.ql.parser.QLParser;

import java.io.IOException;
import java.io.InputStream;

public class QLASTBuilder {

    private final QLParser parser;

    public QLASTBuilder(InputStream inputStream) throws IOException {

        ANTLRInputStream input = new ANTLRInputStream(inputStream);
        QLLexer lexer = new QLLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        this.parser = new QLParser(tokens);
    }

    public Form buildForm() {
        return (Form) buildFromTree(parser.form());
    }

    private AbstractASTNode buildFromTree(ParseTree tree) {
        return tree.accept(new FugaziQLVisitor());
    }
}