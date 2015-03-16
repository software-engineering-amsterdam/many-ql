package org.fugazi.ql.ast;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.fugazi.ql.ast.form.Form;
import org.fugazi.ql.ast.type.Type;
import org.fugazi.ql.parser.QLLexer;
import org.fugazi.ql.parser.QLParser;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

public class QLASTBuilder {

    private final QLParser parser;
    private final FugaziQLVisitor visitor;

    public QLASTBuilder(InputStream inputStream) throws IOException {

        ANTLRInputStream input = new ANTLRInputStream(inputStream);
        QLLexer lexer = new QLLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        this.parser = new QLParser(tokens);

        this.visitor = new FugaziQLVisitor();
    }

    public Form buildForm() {
        Form form = (Form) buildFromTree(parser.form());
        form.setIdentifierTypes(this.visitor.getIdentifierTypes());

        return form;
    }

    private AbstractASTNode buildFromTree(ParseTree tree) {
        return tree.accept(this.visitor);
    }
}