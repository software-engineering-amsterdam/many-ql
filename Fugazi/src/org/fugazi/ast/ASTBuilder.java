package org.fugazi.ast;

import org.fugazi.ast.Form.Form;
import org.fugazi.ast.ASTNode.AbstractASTNode;
import org.fugazi.parser.QLLexer;
import org.fugazi.parser.QLParser;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.InputStream;
import java.io.IOException;

/**
 * Builds the AST.
 */
public class ASTBuilder {
    
    // The auto-generated QLParser
    private QLParser parser;

    public ASTBuilder(InputStream inputStream) throws IOException {

        ANTLRInputStream input = new ANTLRInputStream(inputStream);
        QLLexer lexer = new QLLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        parser = new QLParser(tokens);
    }

    /**
     *  Builds the form from the Parsed tree.
     * @return form
     */
    public Form buildForm() {
        ParseTree tree = parser.form();
        return (Form) buildFromTree(tree);
    }

    private AbstractASTNode buildFromTree(ParseTree tree) {
        
        FugaziQLVisitor qlVisitor = new FugaziQLVisitor();
        return tree.accept(qlVisitor);
    }
}
