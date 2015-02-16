package org.fugazi.ast;

import org.fugazi.ast.form.Form;
import org.fugazi.parser.QLLexer;
import org.fugazi.parser.QLParser;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.InputStream;
import java.io.IOException;

public class ASTBuilder {

    private final QLParser parser;

    public ASTBuilder(InputStream inputStream) throws IOException {

        ANTLRInputStream input = new ANTLRInputStream(inputStream);
        QLLexer lexer = new QLLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        parser = new QLParser(tokens);
    }

    public Form buildForm() {
        return (Form) buildFromTree(parser.form());
    }

    private AbstractASTNode buildFromTree(ParseTree tree) {
        return tree.accept(new FugaziQLVisitor());
    }
}
