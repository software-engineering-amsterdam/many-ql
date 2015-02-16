from decimal import *

class Node(object):
    def __init__(self, lineNumber):
        self.lineNumber = lineNumber

class RootNode(Node):
    def __init__(self, statements):
        Node.__init__(self, 0)
        self.statements = statements

    def getChildren(self):
        return self.statements

class StatementNode(Node):
    def getChildren():
        raise NotImplementedError()

class FormStatementNode(StatementNode):
    def __init__(self, identifier, statements, lineNumber):
        StatementNode.__init__(self, lineNumber)
        self.identifier = identifier
        self.statements = statements

    def __str__(self):
        return "formId:%s, line:%d" %(self.identifier, self.lineNumber)

    def getChildren(self):
        return self.statements

class QuestionStatementNode(StatementNode):
    def __init__(self, identifier, text, questionType, lineNumber, expr = None):
        StatementNode.__init__(self, lineNumber)
        self.identifier = identifier
        self.text = text
        self.type = questionType
        self.expr = expr

    def __str__(self):
        return "questionId:%s, line:%d, question:%s, type:%s, expr:%s"\
            %(self.identifier, self.lineNumber, self.text, self.type, self.expr)

    def getChildren(self):
        return []

class IfStatementNode(StatementNode):
    def __init__(self, expr, statements, lineNumber):
        StatementNode.__init__(self, lineNumber)
        self.expr = expr
        self.statements = statements
        
    def __str__(self):
        return "ifStatement, line:%d, expr:%s" %(self.lineNumber, self.expr)

    def getChildren(self):
        return self.statements

class ExpressionNode(Node):
    pass

class AtomicExpressionNode(ExpressionNode):
    def __init__(self, left, lineNumber):
        ExpressionNode.__init__(self, lineNumber)
        self.left = left
        
    def __str__(self):
        return str(self.left)

class UnaryExpressionNode(ExpressionNode):
    def __init__(self, op, right, lineNumber):
        ExpressionNode.__init__(self, lineNumber)
        self.op = op
        self.right = right

    def __str__(self):
        return "(%s %s)" %(self.op, self.right)

class BinaryExpressionNode(ExpressionNode):
    def __init__(self, left, op, right, lineNumber):
        ExpressionNode.__init__(self, lineNumber)
        self.left = left
        self.op = op
        self.right = right

    def __str__(self):
        return "(%s %s %s)" %(self.left, self.op, self.right)

class Money(Decimal):
    pass

class Identifier(str):
    def __new__(cls, string, lineNumber):
        obj = str.__new__(cls, string)
        obj.lineNumber = lineNumber
        return obj
