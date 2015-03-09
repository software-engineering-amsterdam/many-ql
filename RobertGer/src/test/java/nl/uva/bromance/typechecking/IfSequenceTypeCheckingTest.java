package nl.uva.bromance.typechecking;

import nl.uva.bromance.ast.AST;
import nl.uva.bromance.ast.ASTTest;
import nl.uva.bromance.ast.conditionals.ElseIfStatement;
import nl.uva.bromance.ast.conditionals.ElseStatement;
import nl.uva.bromance.ast.conditionals.IfStatement;

import java.io.IOException;
import java.util.List;

/*
* Tests both ifSequence and loose if, else if and else statements.
* */
public class IfSequenceTypeCheckingTest extends ASTTest {


    //Check if statement
    @org.junit.Test
    public void correctIfStatement() throws IOException {
        String content = "Name: \"Tax\" {\n" +
                "    Form: \"default\" {\n" +
                CORRECT_IF +
                "}}";
        AST ast = createAst(content);
        List<IfStatement> questionList = ast.getFirstEncounteredChildrenOfType_ForAST_DeepSearch(IfStatement.class);
        IfStatement question = questionList.get(1);
    }


    @org.junit.Test
    public void ifStatementWithoutBodyContents() throws IOException {
        String content = "Name: \"Tax\" {\n" +
                "    Form: \"default\" {\n" +
                "\n     If: something{}" +
                "    }}";

        AST ast = createAst(content);
        List<IfStatement> questionList = ast.getFirstEncounteredChildrenOfType_ForAST_DeepSearch(IfStatement.class);
        IfStatement question = questionList.get(1);

    }

    @org.junit.Test
    public void malformedIfStatementBody() throws IOException {
        String content = "Name: \"Tax\" {\n" +
                "    Form: \"default\" {\n" +
                "\n     If: something{" +
                "    }}";

        AST ast = createAst(content);
        List<IfStatement> questionList = ast.getFirstEncounteredChildrenOfType_ForAST_DeepSearch(IfStatement.class);
        IfStatement question = questionList.get(1);
    }

    @org.junit.Test
    public void ifStatementHasNoExpression() throws IOException {
        String content = "Name: \"Tax\" {\n" +
                "    Form: \"default\" {\n" +
                "\n     If: { Text: \"something\" }" +
                "    }}";

        AST ast = createAst(content);
        List<IfStatement> questionList = ast.getFirstEncounteredChildrenOfType_ForAST_DeepSearch(IfStatement.class);
        IfStatement question = questionList.get(1);
    }

    @org.junit.Test
    public void multipleIfStatements() throws IOException {
        String content = "Name: \"Tax\" {\n" +
                "    Form: \"default\" {\n" +
                CORRECT_IF +
                CORRECT_IF +
                "    }}";
        AST ast = createAst(content);
        List<IfStatement> questionList = ast.getFirstEncounteredChildrenOfType_ForAST_DeepSearch(IfStatement.class);
        IfStatement question = questionList.get(1);
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
        List<ElseIfStatement> questionList = ast.getFirstEncounteredChildrenOfType_ForAST_DeepSearch(ElseIfStatement.class);
        ElseIfStatement question = questionList.get(1);
    }

    @org.junit.Test
    public void elseIfStatementWithoutPrecedingIfStatement() throws IOException {
        String content = "Name: \"Tax\" {\n" +
                "    Form: \"default\" {\n" +
                CORRECT_ELSE_IF +
                "    }}";

        AST ast = createAst(content);
        List<ElseIfStatement> questionList = ast.getFirstEncounteredChildrenOfType_ForAST_DeepSearch(ElseIfStatement.class);
        ElseIfStatement question = questionList.get(1);
    }

    @org.junit.Test
    public void elseIfWithoutBodyContents() throws IOException {
        String content = "Name: \"Tax\" {\n" +
                "    Form: \"default\" {\n" +
                CORRECT_IF +
                "\n     Else If: something{}" +
                "    }}";
        AST ast = createAst(content);
        List<ElseIfStatement> questionList = ast.getFirstEncounteredChildrenOfType_ForAST_DeepSearch(ElseIfStatement.class);
        ElseIfStatement question = questionList.get(1);

    }

    @org.junit.Test
    public void elseIfWithoutExpression() throws IOException {
        String content = "Name: \"Tax\" {\n" +
                "    Form: \"default\" {\n" +
                CORRECT_IF +
                "\n     Else If: {}" +
                "    }}";
        AST ast = createAst(content);
        List<ElseIfStatement> questionList = ast.getFirstEncounteredChildrenOfType_ForAST_DeepSearch(ElseIfStatement.class);
        ElseIfStatement question = questionList.get(1);

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
        List<ElseIfStatement> questionList = ast.getFirstEncounteredChildrenOfType_ForAST_DeepSearch(ElseIfStatement.class);
        ElseIfStatement question = questionList.get(1);
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
        List<ElseStatement> questionList = ast.getFirstEncounteredChildrenOfType_ForAST_DeepSearch(ElseStatement.class);
        ElseStatement question = questionList.get(1);
    }

    @org.junit.Test
    public void elseStatementWithoutBodyContents() throws IOException {
        String content = "Name: \"Tax\" {\n" +
                "    Form: \"default\" {\n" +
                CORRECT_IF +
                "\n     Else:{}" +
                "    }}";

        AST ast = createAst(content);
        List<ElseStatement> questionList = ast.getFirstEncounteredChildrenOfType_ForAST_DeepSearch(ElseStatement.class);
        ElseStatement question = questionList.get(1);
    }

    @org.junit.Test
    public void elseWithoutPrecedingIf() throws IOException {
        String content = "Name: \"Tax\" {\n" +
                "    Form: \"default\" {\n" +
                CORRECT_ELSE +
                "    }}";

        AST ast = createAst(content);
        List<ElseStatement> questionList = ast.getFirstEncounteredChildrenOfType_ForAST_DeepSearch(ElseStatement.class);
        ElseStatement question = questionList.get(1);
    }

    @org.junit.Test
    public void elseWithoutBodyContent() throws IOException {
        String content = "Name: \"Tax\" {\n" +
                "    Form: \"default\" {\n" +
                CORRECT_IF +
                CORRECT_ELSE_IF +
                "     Else:{}" +
                "    }}";

        AST ast = createAst(content);
        List<ElseStatement> questionList = ast.getFirstEncounteredChildrenOfType_ForAST_DeepSearch(ElseStatement.class);
        ElseStatement question = questionList.get(1);

    }

    @org.junit.Test
    public void malformedElseStatement() throws IOException {
        String content = "Name: \"Tax\" {\n" +
                "    Form: \"default\" {\n" +
                CORRECT_IF +
                "     Else:{" +
                "    }}";

        AST ast = createAst(content);
        List<ElseStatement> questionList = ast.getFirstEncounteredChildrenOfType_ForAST_DeepSearch(ElseStatement.class);
        ElseStatement question = questionList.get(1);

    }

}
