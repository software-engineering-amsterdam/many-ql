# Generated from java-escape by ANTLR 4.5
from antlr4 import *
from QLVisitor import QLVisitor
from QLExceptions import IllegalOperatorError
from AST import *

# This class defines a complete generic visitor for a parse tree produced by QLParser.
class CustomQLVisitor(QLVisitor):
    # Visit a parse tree produced by QLParser#statement.
    def visitStatement(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by QLParser#form.

    def visitForm_statement(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by QLParser#question.
    def visitQuestion_statement(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by QLParser#if_statement.
    def visitIf_statement(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by QLParser#boolean.
    def visitBoolean(self, ctx):
        return self.ctx.getText() == 'true';


    # Visit a parse tree produced by QLParser#question_type.
    def visitQuestion_type(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by QLParser#string.
    def visitString(self, ctx):
        return ctx.getText()


    # Visit a parse tree produced by QLParser#integer.
    def visitInteger(self, ctx):
        return int(ctx.getText())


    # Visit a parse tree produced by QLParser#money.
    def visitMoney(self, ctx): # TODO
        return self.visitChildren(ctx)


    # Visit a parse tree produced by QLParser#identifier.
    def visitIdentifier(self, ctx): # TODO
        return self.visitChildren(ctx)


    # Visit a parse tree produced by QLParser#atom.
    def visitAtom(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by QLParser#expr.
    def visitExpr(self, ctx):
        # no operator in expression (atom)
        if ctx.op == None:
            return self.visitChildren(ctx)

        op = ctx.op.text
        right = self.visit(ctx.right)

        # unary (rightside) operator
        if ctx.left == None:
            if op == '+':
                return +right
            elif op == '-':
                return -right
            elif op == '!':
                return not right

        left = self.visit(ctx.left)

        # binary operator
        if op == '+':
            return left + right
        elif op == '-':
            return left + right
        elif op == '*':
            return left * right
        elif op == '/':
            return left / right
        elif op == '^':
            return left**right
        elif op == '%':
            return left % right
        elif op == '==':
            return left == right
        elif op == '!=':
            return left != right
        elif op == '>':
            return left > right
        elif op == '>=':
            return left >= right
        elif op == '<':
            return left < right
        elif op == '<=':
            return left <= right
        elif op == '&&':
            return left and right
        elif op == '||':
            return left or right
        
        raise IllegalOperatorError("Operator: " + op + " does not exist in QL.")