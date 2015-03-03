# Generated from java-escape by ANTLR 4.5
from antlr4 import *

# This class defines a complete generic visitor for a parse tree produced by QLParser.

class QLVisitor(ParseTreeVisitor):

    # Visit a parse tree produced by QLParser#nested_statement.
    def visitNested_statement(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by QLParser#root.
    def visitRoot(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by QLParser#form_statement.
    def visitForm_statement(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by QLParser#question_statement.
    def visitQuestion_statement(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by QLParser#if_statement.
    def visitIf_statement(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by QLParser#question_type.
    def visitQuestion_type(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by QLParser#expr.
    def visitExpr(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by QLParser#atom.
    def visitAtom(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by QLParser#boolean.
    def visitBoolean(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by QLParser#identifier.
    def visitIdentifier(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by QLParser#string.
    def visitString(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by QLParser#integer.
    def visitInteger(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by QLParser#money.
    def visitMoney(self, ctx):
        return self.visitChildren(ctx)


