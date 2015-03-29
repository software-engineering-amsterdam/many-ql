package nl.uva.bromance.grammar;

import org.junit.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

/*
* Tests both ifSequence and loose if, else if and else statements.
* */
public class IfSequenceGrammarTest extends GrammarTest {

    @Test
    public void correctIfSequence() throws IOException {
        String content = "Name: \"Tax\" {\n" +
                "    Form: \"default\" {\n" +
                CORRECT_IF +
                CORRECT_ELSE_IF +
                CORRECT_ELSE +
                "}}";
        walker.walk(listener, createTree(content));

        assertThat(listener.ifStatementCount).isEqualTo(1);
        assertThat(listener.elseIfStatementCount).isEqualTo(1);
        assertThat(listener.elseStatementCount).isEqualTo(1);
    }

    @Test
    public void correctIfSequence_WithMultipleElseIf
            () throws IOException {
        String content = "Name: \"Tax\" {\n" +
                "    Form: \"default\" {\n" +
                CORRECT_IF +
                CORRECT_ELSE_IF +
                CORRECT_ELSE_IF +
                CORRECT_ELSE +
                "}}";
        walker.walk(listener, createTree(content));

        assertThat(listener.ifStatementCount).isEqualTo(1);
        assertThat(listener.elseIfStatementCount).isEqualTo(2);
        assertThat(listener.elseStatementCount).isEqualTo(1);
    }
}
