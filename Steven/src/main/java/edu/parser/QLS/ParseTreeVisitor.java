package edu.parser.QLS;

import com.sun.javaws.exceptions.InvalidArgumentException;
import edu.Widgets;
import edu.exceptions.ParseException;
import edu.parser.QLS.nodes.AbstractNode;
import edu.parser.QLS.antlrGenerated.QLSBaseVisitor;
import edu.parser.QLS.antlrGenerated.QLSParser;
import edu.parser.QLS.nodes.Identifier;
import edu.parser.QLS.nodes.Section;
import edu.parser.QLS.nodes.Stylesheet;
import edu.parser.QLS.nodes.statement.Default;
import edu.parser.QLS.nodes.statement.Page;
import edu.parser.QLS.nodes.statement.Question;
import edu.parser.QLS.nodes.statement.Statement;
import edu.parser.QLS.nodes.styles.*;
import edu.parser.nodes.QuestionType;
import org.antlr.v4.runtime.RuleContext;
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
        List<Statement> stylesheetElements = getStatements(ctx.stylesheet_element());
        return new Stylesheet(identifier, stylesheetElements);
    }

    public List<Statement> getStatements(List<QLSParser.Stylesheet_elementContext> stylesheetElements) {
        if (isPopulated(stylesheetElements)) {
            return collectStatements(stylesheetElements);
        }
        return Collections.emptyList();
    }

    private <T extends RuleContext> List<Statement> collectStatements(List<T> stylesheetElements) {
        return stylesheetElements.stream()
                .map(statement -> (Statement) statement.accept(this))
                .collect(Collectors.toList());
    }

    private boolean isPopulated(List<QLSParser.Stylesheet_elementContext> stylesheetElements) {
        return stylesheetElements != null && !stylesheetElements.isEmpty();
    }

    @Override
    public AbstractNode visitColor(@NotNull QLSParser.ColorContext ctx) {
        return new Color(Integer.parseInt(ctx.NUMBERS().getText()));
    }

    @Override
    public AbstractNode visitFont(@NotNull QLSParser.FontContext ctx) {
        String text = ctx.STRING().getText();
        return new Font(removeQuotesFromString(text));
    }

    @Override
    public AbstractNode visitWidth(@NotNull QLSParser.WidthContext ctx) {
        return new Width(Integer.parseInt(ctx.NUMBERS().getText()));
    }

    @Override
    public AbstractNode visitWidget(@NotNull QLSParser.WidgetContext ctx) {
        try {
            Widgets widget = Widgets.getWidget(ctx.UPPERCASE().getText());
            return new Widget(widget);
        } catch (InvalidArgumentException e) {
            throw new ParseException(e);
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
        try {
            return QuestionType.getType(ctx.getText());
        } catch (InvalidArgumentException e) {
            throw new ParseException(e);
        }
    }

    @Override
    public AbstractNode visitPage(@NotNull QLSParser.PageContext ctx) {
        List<Section> sections = collectSections(ctx.section());
        return new Page(sections);
    }

    @Override
    public AbstractNode visitSection(@NotNull QLSParser.SectionContext ctx) {
        String title = ctx.STRING().getSymbol().getText();
        List<Statement> statements = collectStatements(ctx.statement());
        return new Section(removeQuotesFromString(title), statements);
    }

    private String removeQuotesFromString(String title) {
        return title.substring(1, title.length() - 1);
    }

    private List<Section> collectSections(List<QLSParser.SectionContext> elements) {
        return elements.stream()
                .map(statement -> (Section) statement.accept(this))
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
