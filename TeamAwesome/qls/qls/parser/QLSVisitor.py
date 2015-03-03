# Generated from java-escape by ANTLR 4.5
from antlr4 import *

# This class defines a complete generic visitor for a parse tree produced by QLSParser.

class QLSVisitor(ParseTreeVisitor):

    # Visit a parse tree produced by QLSParser#qls.
    def visitQls(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by QLSParser#nested_statement.
    def visitNested_statement(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by QLSParser#stylesheet_statement.
    def visitStylesheet_statement(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by QLSParser#default_statement.
    def visitDefault_statement(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by QLSParser#style_attribute.
    def visitStyle_attribute(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by QLSParser#page_statement.
    def visitPage_statement(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by QLSParser#section_statement.
    def visitSection_statement(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by QLSParser#question_statement.
    def visitQuestion_statement(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by QLSParser#attribute_name.
    def visitAttribute_name(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by QLSParser#attribute_value.
    def visitAttribute_value(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by QLSParser#question_type.
    def visitQuestion_type(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by QLSParser#widget.
    def visitWidget(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by QLSParser#widget_type.
    def visitWidget_type(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by QLSParser#widget_options.
    def visitWidget_options(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by QLSParser#widget_option.
    def visitWidget_option(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by QLSParser#identifier.
    def visitIdentifier(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by QLSParser#string.
    def visitString(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by QLSParser#integer.
    def visitInteger(self, ctx):
        return self.visitChildren(ctx)


