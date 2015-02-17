import org.antlr.v4.runtime.ANTLRFileStream
import org.antlr.v4.runtime.CommonTokenStream
import spock.lang.Specification

/**
 * Created by Steven Kok on 16/02/2015.
 */
class Walker extends Specification {

    def "smoke"() {
        setup:
        ANTLRFileStream antlrFileStream = new ANTLRFileStream("src/main/antlr/input/QL_initial");
        QLLexer lexer = new QLLexer(antlrFileStream);
        CommonTokenStream commonTokenStream = new CommonTokenStream(lexer);
        QLParser parser = new QLParser(commonTokenStream);
        def tree = parser.start()

        QLBaseVisitorImpl baseVisitor = new QLBaseVisitorImpl();
        baseVisitor.visit(tree);

        expect:
        true;
    }
}
