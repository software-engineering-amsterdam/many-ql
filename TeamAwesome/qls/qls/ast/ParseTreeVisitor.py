# Generated from java-escape by ANTLR 4.5
from antlr4 import *
from ..parser.QLSVisitor import QLSVisitor
from ..parser.QLSParser import QLSParser
from . import Nodes
from ..CustomTypes import *

# This class defines a complete generic visitor for a parse tree produced by QLParser.
class ParseTreeVisitor(QLSVisitor):

    # Visit a parse tree produced by QLSParser#qls.
    def visitQls(self, ctx):
        statements = [self.visit(statement) for statement in ctx.statements]
        return Nodes.QLS(statements)

    # Visit a parse tree produced by QLSParser#stylesheet_statement.
    def visitStylesheet_statement(self, ctx):
        identifier = self.visit(ctx.name)
        statements = [self.visit(statement) for statement in ctx.statements]
        lineNumber = ctx.start.line
        return Nodes.StylesheetStatement(identifier, statements, lineNumber)

    # Visit a parse tree produced by QLSParser#default_statement.
    def visitDefault_statement(self, ctx):
        questionType = self.visit(ctx.qtype)
        attributes = [self.visit(attribute) for attribute in ctx.attributes]
        lineNumber = ctx.start.line
        return Nodes.DefaultStatement(questionType, attributes, lineNumber)

    # Visit a parse tree produced by QLSParser#style_attribute.
    def visitStyle_attribute(self, ctx):
        name = self.visit(ctx.name)
        value = self.visit(ctx.value)
        lineNumber = ctx.start.line
        return Nodes.StyleAttribute(name, value, lineNumber)

    # Visit a parse tree produced by QLSParser#page_statement.
    def visitPage_statement(self, ctx):
        name = self.visit(ctx.name)
        statements = [self.visit(statement) for statement in ctx.statements]
        lineNumber = ctx.start.line
        return Nodes.PageStatement(name, statements, lineNumber)

    # Visit a parse tree produced by QLSParser#section_statement.
    def visitSection_statement(self, ctx):
        name = self.visit(ctx.name)
        statements = [self.visit(statement) for statement in ctx.statements]
        lineNumber = ctx.start.line
        return Nodes.SectionStatement(name, statements, lineNumber)

    # Visit a parse tree produced by QLSParser#question_statement.
    def visitQuestion_statement(self, ctx):
        identifier = self.visit(ctx.name)
        attributes = [self.visit(attribute) for attribute in ctx.attributes]
        lineNumber = ctx.start.line
        return Nodes.QuestionStatement(identifier, attributes, lineNumber)

    # Visit a parse tree produced by QLSParser#attribute_name.
    def visitAttribute_name(self, ctx):
        return ctx.getText()

    # Visit a parse tree produced by QLSParser#question_type.
    def visitQuestion_type(self, ctx):
        return ctx.getText()

    # Visit a parse tree produced by QLSParser#widget.
    def visitWidget(self, ctx):
        widgetType = self.visit(ctx.wtype)
        options = self.visit(ctx.options) if ctx.options else []
        lineNumber = ctx.start.line
        return Nodes.Widget(widgetType, options, lineNumber)

    # Visit a parse tree produced by QLSParser#widget_type.
    def visitWidget_type(self, ctx):
        return ctx.getText()

    # Visit a parse tree produced by QLSParser#widget_options.
    def visitWidget_options(self, ctx):
        return [self.visit(child) for child in ctx.getChildren()]

    # Visit a parse tree produced by QLSParser#identifier.
    def visitIdentifier(self, ctx):
        return Identifier(ctx.getText(), ctx.start.line)

    # Visit a parse tree produced by QLSParser#string.
    def visitString(self, ctx):
        return ctx.getText()[1:-1]

    # Visit a parse tree produced by QLSParser#integer.
    def visitInteger(self, ctx):
        return int(ctx.getText())
