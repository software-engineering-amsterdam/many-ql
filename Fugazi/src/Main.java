import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.fugazi.ast.Form.Form;
import org.fugazi.ast.FugaziQLVisitor;
import org.fugazi.ast.Statement.QuestionStatement;
import org.fugazi.ast.Statement.Statement;
import org.fugazi.ast.Type.BoolType;
import org.fugazi.ast.Type.IntType;
import org.fugazi.ast.Type.MoneyType;
import org.fugazi.parser.QLLexer;
import org.fugazi.parser.QLParser;

import java.io.FileInputStream;
import java.io.InputStream;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) throws Exception {

        String inputFile = null;

        if (args.length > 0)
            inputFile = args[0];

        InputStream is = System.in;

        if (inputFile != null)
            is = new FileInputStream(inputFile);

        ANTLRInputStream input = new ANTLRInputStream(is);

        // Lexer
        QLLexer lexer = new QLLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        
        // Parser
        QLParser parser = new QLParser(tokens);
        ParseTree tree = parser.form();

        // Construct the AST.
        FugaziQLVisitor fugaziQL = new FugaziQLVisitor();
        fugaziQL.visit(tree);

        // Get the parsed form.
        Form form = fugaziQL.getForm();
        assert form != null;
        
        // ========================================================================
        // A Test GUI - Ugly
        if (true) {
            JFrame frame = new JFrame(form.getName());
            JPanel panel = new JPanel(new GridLayout(0, 1));
            JPanel checkPanel = new JPanel(new GridLayout(0, 1));
            JPanel textFieldsPanel = new JPanel(new GridLayout(0, 1));            

            for (Statement statement : form.getStatements()) {

                // Questions
                if (statement instanceof QuestionStatement) {

                    // Bool Questions.
                    if (((QuestionStatement) statement).getType() instanceof BoolType) {
                        JCheckBox boolQuestion = new JCheckBox(((QuestionStatement) statement).getLabel());
                        boolQuestion.setSelected(false);
                        checkPanel.add(boolQuestion);
                    }

                    // Int Questions.
                    if (((QuestionStatement) statement).getType() instanceof IntType) {
                        JLabel intQuestionLabel = new JLabel(((QuestionStatement) statement).getLabel());
                        JTextField intQuestion = new JTextField();

                        textFieldsPanel.add(intQuestionLabel);
                        textFieldsPanel.add(intQuestion);
                    }

                    // Money Questions.
                    if (((QuestionStatement) statement).getType() instanceof MoneyType) {
                        JLabel moneyQuestionLabel = new JLabel(((QuestionStatement) statement).getLabel());
                        JTextField moneyQuestion = new JTextField();

                        textFieldsPanel.add(moneyQuestionLabel);
                        textFieldsPanel.add(moneyQuestion);
                    }
                }
            }

            panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
            panel.add(checkPanel, BorderLayout.LINE_START);
            panel.add(textFieldsPanel);

            frame.getContentPane().add(panel);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(480, 600);
            frame.setVisible(true);
        }
        // ==========================================================================
    }
}