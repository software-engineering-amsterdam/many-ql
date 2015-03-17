# Generated from java-escape by ANTLR 4.5
from antlr4 import *
from .QLVisitor import QLVisitor
from .QLParser import QLParser
from .QLLexer import QLLexer
from ..ast import Nodes

def create(inputQLFile):
    inputStream = FileStream(inputQLFile)
    lexer = QLLexer(inputStream)
    stream = CommonTokenStream(lexer)
    parser = QLParser(stream)
    visitor = ParseTreeVisitor()
    tree = parser.root()
    return visitor.visit(tree)

# This class defines a complete generic visitor for a parse tree produced by QLParser.
class ParseTreeVisitor(QLVisitor):

    # Visit a parse tree produced by QLParserRoot.
    def visitRoot(self, ctx):
        statements = [self.visit(child) for child in ctx.getChildren()]
        return Nodes.Questionnaire(statements)

    # Visit a parse tree produced by QLParser#form.
    def visitForm_statement(self, ctx):
        identifier = self.visit(ctx.name)
        statements = [self.visit(statement) for statement in ctx.statements]
        lineNumber = ctx.start.line
        return Nodes.FormStatement(identifier, statements, lineNumber)

    # Visit a parse tree produced by QLParser
    def visitQuestion_statement(self, ctx):
        identifier = self.visit(ctx.name)
        text = ctx.text.getText()[1:-1]
        question_type = ctx.qtype.getText()
        
        expr = self.visit(ctx.expression) if ctx.expression != None else None

        lineNumber = ctx.start.line

        return Nodes.QuestionStatement(identifier, text, question_type, lineNumber, expression = expr)

    # Visit a parse tree produced by QLParser#if_statement.
    def visitIf_statement(self, ctx):
        expr = self.visit(ctx.expression)
        statements = [self.visit(statement) for statement in ctx.statements]
        lineNumber = ctx.start.line
        return Nodes.IfStatement(expr, statements, lineNumber)

    # Visit a parse tree produced by QLParser#boolean.
    def visitBoolean(self, ctx):
        lineNumber = ctx.start.line
        return Nodes.Boolean(ctx.getText() == 'true', lineNumber);

    # Visit a parse tree produced by QLParser#string.
    def visitString(self, ctx):
        lineNumber = ctx.start.line
        return Nodes.String(ctx.getText()[1:-1], lineNumber)

    # Visit a parse tree produced by QLParser#integer.
    def visitInteger(self, ctx):
        lineNumber = ctx.start.line
        return Nodes.Integer(int(ctx.getText()), lineNumber)

    # Visit a parse tree produced by QLParser#money.
    def visitMoney(self, ctx):
        lineNumber = ctx.start.line
        return Nodes.Money(Decimal(ctx.getText()), lineNumber)

    # Visit a parse tree produced by QLParser#identifier.
    def visitIdentifier(self, ctx):
        lineNumber = ctx.start.line
        return Nodes.Identifier(ctx.getText(), lineNumber)
    
    # Visit a parse tree produced by QLParser#atom.
    def visitAtom(self, ctx):
        return self.visitChildren(ctx)

    # Visit a parse tree produced by QLParser#expr.
    def visitExpr(self, ctx):
        # no operator in expression (atom or expression between brackets)
        if ctx.op == None:
            return self.visitChildren(ctx.left)

        lineNumber = ctx.start.line
        op = ctx.op.text
        right = self.visit(ctx.right)

        # unary (rightside) operator
        if ctx.left == None:
            return Nodes.UnaryExpression(op, right, lineNumber)

        left = self.visit(ctx.left)

        return Nodes.BinaryExpression(left, op, right, lineNumber)