package nl.uva.bromance.grammar;

import nl.uva.bromance.listeners.GrammarErrorListener;
import nl.uva.bromance.listeners.QLParseTreeListener;
import nl.uva.bromance.parsers.QLLexer;
import nl.uva.bromance.parsers.QLParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

import java.io.ByteArrayInputStream;
import java.io.IOException;

/**
 * Created by Robert on 3/1/2015.
 */
public class GrammarTest {


    protected ParseTreeWalker walker;
    protected static final String CORRECT_FORM = "    Form: \"default\" {\n" +
            "       Label: \"something\"{" +
            "           Text: \"something\"" +
            "      }}";

    protected static final String CORRECT_QUESTION = "\n     Question: \"question\"{" +
            "           Text: \"text?\"" +
            "           Answer: integer" +
            "       }";
    protected static final String CORRECT_CALCULATION = "\n     Calculation: \"calculation\"{" +
            IfSequenceGrammarTest.CORRECT_IF +
            "    }";
    protected static final String CORRECT_ELSE = "\n     Else:{ Text: \"something\"}";
    protected static final String CORRECT_IF = "\n     If: something{  Text: \"something\" }";
    protected static final String CORRECT_ELSE_IF = "Else If: something{ Text: \"something\"}";

    protected FakeGrammarListener listener;

    //TODO: consider asserting the messages in expectedException
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Before
    public void setup() {
        listener = new FakeGrammarListener();
        walker = new ParseTreeWalker();
    }

    protected static QLParser.QuestionnaireContext createTree(String content) throws IOException {
        QLLexer lexer = new QLLexer(new ANTLRInputStream(new ByteArrayInputStream(content.getBytes())));
        lexer.removeErrorListeners();
        lexer.addErrorListener(new GrammarErrorListener());
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        QLParser parser = new QLParser(tokens);
        parser.removeErrorListeners();
        parser.addErrorListener(new GrammarErrorListener());
        return parser.questionnaire();
    }

    //TODO: Maybe move the entire thing to GrammarTest? Duplication in other tests.
    static class FakeGrammarListener extends QLParseTreeListener {

        public int formCount = 0;
        public int questionnaireCount = 0;
        public int ifStatementCount = 0;
        public int elseIfStatementCount = 0;
        public int elseStatementCount = 0;
        public int calculationCount = 0;
        public int expressionCount = 0;
        public int questionCount = 0;
        public int questionTextCount = 0;


        @Override
        public void exitIfStatement(QLParser.IfStatementContext ctx) {
            super.exitIfStatement(ctx);
            ifStatementCount += 1;
        }

        @Override
        public void exitElseIfStatement(QLParser.ElseIfStatementContext ctx) {
            super.exitElseIfStatement(ctx);
            this.elseIfStatementCount += 1;
        }

        @Override
        public void exitElseStatement(QLParser.ElseStatementContext ctx) {
            super.exitElseStatement(ctx);
            this.elseStatementCount += 1;
        }


        @Override
        public void exitCalculation(QLParser.CalculationContext ctx) {
            super.exitCalculation(ctx);
            this.calculationCount += 1;
        }


        @Override
        public void exitForm(QLParser.FormContext ftx) {
            super.exitForm(ftx);
            formCount += 1;
        }

        @Override
        public void exitQuestionnaire(QLParser.QuestionnaireContext ctx) {
            super.exitQuestionnaire(ctx);
            questionnaireCount += 1;
        }

        @Override
        public void exitExpression(QLParser.ExpressionContext ctx) {
            super.exitExpression(ctx);
            this.expressionCount += 1;
        }

        @Override
        public void exitQuestion(QLParser.QuestionContext qtx) {
            super.exitQuestion(qtx);
            questionCount += 1;
        }


        @Override
        public void exitQuestionText(QLParser.QuestionTextContext ctx) {
            super.exitQuestionText(ctx);
            this.questionTextCount += 1;
        }
    }
}