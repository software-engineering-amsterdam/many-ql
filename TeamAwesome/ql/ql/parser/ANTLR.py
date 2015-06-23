from .AbstractBase import AbstractBase

from antlr4 import *
from antlr4.error.ErrorListener import ErrorListener as Antlr4ErrorListener

from .antlr_generated.QLVisitor import QLVisitor
from .antlr_generated.QLParser import QLParser
from .antlr_generated.QLLexer import QLLexer

from ..ast import Nodes
from ..core import QLTypes, QLOperators



class Parser(AbstractBase):
    def __init__(self, inputQLFile):
        inputStream = FileStream(inputQLFile)
        lexer = QLLexer(inputStream)
        stream = CommonTokenStream(lexer)
        parser = QLParser(stream)

        # There's no other way to get rid of the default ConsoleErrorListener
        parser._listeners = []

        self._errorListener = ErrorListener()
        parser.addErrorListener(self._errorListener)

        tree = parser.root()

        if len(self.errors) == 0:
            self._questionnaire = ParseTreeVisitor().visit(tree)
        else:
            self._questionnaire = None


    @property
    def errors(self):
        return self._errorListener.errors


    @property
    def questionnaire(self):
        return self._questionnaire

        
    def expressionTypeToken(self, expressionTypeQl):
        return {
            qlType : token for (qlType, token) in _expressionTypeTokens()
        }[expressionTypeQl]


    def operatorToken(self, operatorQl):
        return {
            qlOperator : token for (qlOperator, token) in _operatorTokens()
        }[operatorQl]



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
        question_type = _qlQuestionType(ctx.qtype.getText())
        
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
        return Nodes.Boolean(ctx.getText() == 'true', lineNumber)


    # Visit a parse tree produced by QLParser#string.
    def visitString(self, ctx):
        lineNumber = ctx.start.line
        return Nodes.String(ctx.getText()[1:-1], lineNumber)


    # Visit a parse tree produced by QLParser#integer.
    def visitInteger(self, ctx):
        lineNumber = ctx.start.line
        return Nodes.Integer(ctx.getText(), lineNumber)


    # Visit a parse tree produced by QLParser#money.
    def visitMoney(self, ctx):
        lineNumber = ctx.start.line
        return Nodes.Money(ctx.getText(), lineNumber)


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
            return self.visit(ctx.left)

        lineNumber = ctx.start.line
        op = ctx.op.text
        right = self.visit(ctx.right)

        # unary (rightside) operator
        if ctx.left == None:
            return Nodes.UnaryExpression(
                _qlUnaryOperator(op), right, lineNumber
            )

        left = self.visit(ctx.left)

        return Nodes.BinaryExpression(
            left, _qlBinaryOperator(op), right, lineNumber
        )



class ErrorListener(Antlr4ErrorListener):
    def __init__(self):
        super().__init__()
        self._errors = []


    @property
    def errors(self):
        return self._errors


    def syntaxError(self, recognizer, offendingSymbol, line, column, msg, e):
        self._errors.append("[ERROR line %d:%d] %s" % (line, column, msg))



def _expressionTypeTokens():
    return (
        (QLTypes.QLBoolean, 'boolean'),
        (QLTypes.QLString, 'string'),
        (QLTypes.QLInteger, 'integer'),
        (QLTypes.QLMoney, 'money')
    )



def _operatorTokens():
    return (
        (QLOperators.QLUnaryPlus, '+'),
        (QLOperators.QLUnaryMinus, '-'),
        (QLOperators.QLLogicalNot, '!'),
        (QLOperators.QLExponentiation, '^'),
        (QLOperators.QLMultiplication, '*'),
        (QLOperators.QLDivision, '/'),
        (QLOperators.QLModulo, '%'),
        (QLOperators.QLSubtraction, '-'),
        (QLOperators.QLAddition, '+'),
        (QLOperators.QLLess, '<'),
        (QLOperators.QLLessEquals, '<='),
        (QLOperators.QLGreater, '>'),
        (QLOperators.QLGreaterEquals, '>='),
        (QLOperators.QLEquals, '=='),
        (QLOperators.QLNotEquals, '!='),
        (QLOperators.QLLogicalAnd, '&&'),
        (QLOperators.QLLogicalOr, '||')
    )



def _qlQuestionType(questionTypeToken):
    return {
        token : qlType for (qlType, token) in _expressionTypeTokens()
    }[questionTypeToken]



def _qlUnaryOperator(operatorToken):
    unaryOperatorTokens = _operatorTokens()[:3]
    return {
        token : qlOperator for (qlOperator, token) in unaryOperatorTokens
    }[operatorToken]



def _qlBinaryOperator(operatorToken):
    binaryOperatorTokens = _operatorTokens()[3:]
    return {
        token : qlOperator for (qlOperator, token) in binaryOperatorTokens
    }[operatorToken]
