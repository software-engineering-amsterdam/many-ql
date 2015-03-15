package nl.uva.bromance.ast;

import nl.uva.bromance.ast.conditionals.ElseIfStatement;
import nl.uva.bromance.ast.conditionals.ElseStatement;
import nl.uva.bromance.ast.conditionals.IfStatement;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/*
* Tests both ifSequence and loose if, else if and else statements.
* */
public class IfSequenceASTTest extends ASTTest {


    @Test
    public void correctIfSequence() throws IOException {
        String content = "Name: \"Tax\" {\n" +
                "    Form: \"default\" {\n" +
                CORRECT_IF +
                CORRECT_ELSE_IF +
                CORRECT_ELSE +
                "}}";
        AST ast = createAst(content);
        List<IfStatement> ifStatementList = ast.getFirstEncounteredChildrenOfType_ForAST_DeepSearch(IfStatement.class);
        List<ElseIfStatement> elseIfStatementLis
                = ast.getFirstEncounteredChildrenOfType_ForAST_DeepSearch(ElseIfStatement.class);
        List<ElseStatement> elseStatementList = ast.getFirstEncounteredChildrenOfType_ForAST_DeepSearch(ElseStatement.class);

        assertThat(ifStatementList).hasSize(1);
        assertThat(elseIfStatementLis).hasSize(1);
        assertThat(elseStatementList).hasSize(1);
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

        AST ast = createAst(content);
        List<IfStatement> ifStatementList = ast.getFirstEncounteredChildrenOfType_ForAST_DeepSearch(IfStatement.class);
        List<ElseIfStatement> elseIfStatementLis
                = ast.getFirstEncounteredChildrenOfType_ForAST_DeepSearch(ElseIfStatement.class);
        List<ElseStatement> elseStatementList = ast.getFirstEncounteredChildrenOfType_ForAST_DeepSearch(ElseStatement.class);

        assertThat(ifStatementList).hasSize(1);
        assertThat(elseIfStatementLis).hasSize(2);
        assertThat(elseStatementList).hasSize(1);
    }

    //Check if statement
    @org.junit.Test
    public void correctIfStatement() throws IOException {
        String content = "Name: \"Tax\" {\n" +
                "    Form: \"default\" {\n" +
                CORRECT_IF +
                "}}";
        AST ast = createAst(content);
        List<IfStatement> ifStatementList = ast.getFirstEncounteredChildrenOfType_ForAST_DeepSearch(IfStatement.class);
        IfStatement ifStatement = ifStatementList.get(0);

        assertThat(ifStatement.hasChildren()).isTrue();
        assertThat(ifStatement.getLineNumber()).isGreaterThan(0);
    }

    @org.junit.Test
    public void multipleIfStatements() throws IOException {
        String content = "Name: \"Tax\" {\n" +
                "    Form: \"default\" {\n" +
                CORRECT_IF +
                CORRECT_IF +
                "    }}";
        AST ast = createAst(content);
        List<IfStatement> ifStatementList = ast.getFirstEncounteredChildrenOfType_ForAST_DeepSearch(IfStatement.class);

        assertThat(ifStatementList).hasSize(2);
    }


    //Check else if statement

    @org.junit.Test
    public void correctElseIf() throws IOException {
        String content = "Name: \"Tax\" {\n" +
                "    Form: \"default\" {\n" +
                CORRECT_IF +
                CORRECT_ELSE_IF +
                "    }}";
        AST ast = createAst(content);
        List<ElseIfStatement> elseIfStatementList = ast.getFirstEncounteredChildrenOfType_ForAST_DeepSearch(ElseIfStatement.class);
        List<IfStatement> ifStatementList = ast.getFirstEncounteredChildrenOfType_ForAST_DeepSearch(IfStatement.class);
        ElseIfStatement elseIfStatement = elseIfStatementList.get(0);

        assertThat(elseIfStatementList).hasSize(1);
        assertThat(ifStatementList).hasSize(1);
        assertThat(elseIfStatement.hasChildren()).isTrue();
        assertThat(elseIfStatement.getLineNumber()).isGreaterThan(0);
    }

    @org.junit.Test
    public void multipleCorrectElseIf() throws IOException {
        String content = "Name: \"Tax\" {\n" +
                "    Form: \"default\" {\n" +
                CORRECT_IF +
                CORRECT_ELSE_IF +
                CORRECT_ELSE_IF +
                "    }}";
        AST ast = createAst(content);
        List<ElseIfStatement> elseIfStatementList = ast.getFirstEncounteredChildrenOfType_ForAST_DeepSearch(ElseIfStatement.class);

        assertThat(elseIfStatementList).hasSize(2);

    }


    //Check Else Statement

    @org.junit.Test
    public void correctElse() throws IOException {
        String content = "Name: \"Tax\" {\n" +
                "    Form: \"default\" {\n" +
                CORRECT_IF +
                CORRECT_ELSE +
                "    }}";

        AST ast = createAst(content);
        List<ElseStatement> elseStatementList = ast.getFirstEncounteredChildrenOfType_ForAST_DeepSearch(ElseStatement.class);
        ElseStatement elseStatement = elseStatementList.get(0);

        assertThat(elseStatementList).hasSize(1);
        assertThat(elseStatement.hasChildren()).isTrue();
        assertThat(elseStatement.getLineNumber()).isGreaterThan(0);

    }

}
