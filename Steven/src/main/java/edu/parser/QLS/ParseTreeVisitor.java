package edu.parser.QLS;

import edu.exceptions.ParseException;
import edu.parser.AbstractNode;
import edu.parser.QLS.antlrGenerated.QLSBaseVisitor;
import edu.parser.QLS.antlrGenerated.QLSParser;
import edu.parser.QLS.nodes.*;
import edu.parser.QLS.nodes.statement.Default;
import edu.parser.QLS.nodes.statement.Question;
import edu.parser.QLS.nodes.statement.Statement;
import edu.parser.QLS.nodes.styles.*;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Steven Kok on 28/02/2015.
 */
public class ParseTreeVisitor extends QLSBaseVisitor<AbstractNode> {
    @Override
    public Stylesheet visitStylesheet(@NotNull QLSParser.StylesheetContext ctx) {
        Identifier identifier = (Identifier) visitIdentifier(ctx.identifier());
        List<AbstractNode> stylesheetElements = getStatements(ctx.stylesheet_element());
        return new Stylesheet(identifier, stylesheetElements);
    }

    public List<AbstractNode> getStatements(List<QLSParser.Stylesheet_elementContext> stylesheetElements) {
        if (isPopulated(stylesheetElements)) {
            return collectAbstractNodes(stylesheetElements);
        }
        return Collections.emptyList();
    }

    private boolean isPopulated(List<QLSParser.Stylesheet_elementContext> stylesheetElements) {
        return stylesheetElements != null && !stylesheetElements.isEmpty();
    }

    private <T extends ParserRuleContext> List<AbstractNode> collectAbstractNodes(List<T> elements) {
        return elements.stream()
                .map(this::visit)
                .collect(Collectors.toList());
    }

    @Override
    public AbstractNode visitStyle(@NotNull QLSParser.StyleContext ctx) {
        if (ctx.color != null) {
            return new Color(ctx.NUMBERS().getText());
        } else if (ctx.width != null) {
            return new Width(ctx.NUMBERS().getText());
        } else if (ctx.font != null) {
            String text = ctx.STRING().getText();
            return new Font(removeQuotesFromString(text));
        } else if (ctx.widget != null) {
            return new Widget(ctx.UPPERCASE().getText());
        } else {
            throw new ParseException("Couldn't parse style for input: " + ctx.getText());
        }
    }

    @Override
    public AbstractNode visitIdentifier(@NotNull QLSParser.IdentifierContext ctx) {
        return new Identifier(ctx.getText());
    }

    @Override
    public AbstractNode visitStatement(@NotNull QLSParser.StatementContext ctx) {
        if (ctx.default_statement() != null) {
            return visitDefault_statement(ctx.default_statement());
        } else if (ctx.question() != null) {
            return visitQuestion(ctx.question());
        }
        throw new ParseException("Couldn't parse statement for input: " + ctx.getText());
    }

    @Override
    public AbstractNode visitDefault_statement(@NotNull QLSParser.Default_statementContext ctx) {
        QuestionType questionType = (QuestionType) visitQuestion_type(ctx.question_type());
        List<Style> styles = collectStyles(ctx.style());
        return new Default(questionType, styles);
    }

    @Override
    public AbstractNode visitQuestion_type(@NotNull QLSParser.Question_typeContext ctx) {
        return new QuestionType(ctx.getText());
    }

    @Override
    public AbstractNode visitPage(@NotNull QLSParser.PageContext ctx) {
        List<AbstractNode> pages = collectAbstractNodes(ctx.section());
        return new Page(pages);
    }

    @Override
    public AbstractNode visitSection(@NotNull QLSParser.SectionContext ctx) {
        String title = ctx.STRING().getSymbol().getText();
        List<Statement> sections = collectSections(ctx.statement());
        return new Section(removeQuotesFromString(title), sections);
    }

    private String removeQuotesFromString(String title) {
        return title.substring(1, title.length() - 1);
    }

    private List<Statement> collectSections(List<QLSParser.StatementContext> elements) {
        return elements.stream()
                .map(element -> (Statement) this.visit(element))
                .collect(Collectors.toList());
    }

    @Override
    public AbstractNode visitQuestion(@NotNull QLSParser.QuestionContext ctx) {
        Identifier identifier = (Identifier) visitIdentifier(ctx.identifier());
        List<Style> styles = collectStyles(ctx.style());
        return new Question(identifier, styles);
    }

    private List<Style> collectStyles(List<QLSParser.StyleContext> elements) {
        return elements.stream()
                .map(element -> (Style) this.visit(element))
                .collect(Collectors.toList());
    }
}
