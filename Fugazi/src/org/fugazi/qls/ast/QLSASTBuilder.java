package org.fugazi.qls.ast;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.fugazi.ql.ast.AbstractASTNode;
import org.fugazi.qls.ast.stylesheet.StyleSheet;
import org.fugazi.qls.parser.QLSLexer;
import org.fugazi.qls.parser.QLSParser;

import java.io.IOException;
import java.io.InputStream;

public class QLSASTBuilder {

    private final QLSParser parser;

    public QLSASTBuilder(InputStream inputStream) throws IOException {

        ANTLRInputStream input = new ANTLRInputStream(inputStream);
        QLSLexer lexer = new QLSLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        this.parser = new QLSParser(tokens);
    }

    public StyleSheet buildStyleSheet() {
        return (StyleSheet) buildFromTree(parser.stylesheet());
    }

    private AbstractASTNode buildFromTree(ParseTree tree) {
        return tree.accept(new FugaziQLSVisitor());
    }
}
