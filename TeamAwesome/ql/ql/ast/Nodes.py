from ..QLTypes import *

class Questionnaire(object):
    def __init__(self, statements):
        self.statements = statements

    def accept(self, visitor):
        visitor.visitQuestionnaireBegin(self)
        for statement in self.statements:
            statement.accept(visitor)
        return visitor.visitQuestionnaireEnd(self)


class Node(object):
    def __init__(self, lineNumber):
        self.lineNumber = lineNumber

    def accept(self, visitor):
        raise NotImplementedError


class FormStatement(Node):
    def __init__(self, identifier, statements, lineNumber):
        super().__init__(lineNumber)
        self.identifier = identifier
        self.statements = statements

    def __str__(self):
        return "formId:%s, line:%d" %(self.identifier, self.lineNumber)

    def accept(self, visitor):
        visitor.visitFormStatementBegin(self)
        for statement in self.statements:
            statement.accept(visitor)
        return visitor.visitFormStatementEnd(self)


class QuestionStatement(Node):
    def __init__(self, identifier, text, questionType, lineNumber, expression = None):
        super().__init__(lineNumber)
        self.identifier = identifier
        self.text = text
        self.type = questionType
        self.expression = expression

    def __str__(self):
        return "questionId:%s, line:%d, question:%s, type:%s, expr:%s"\
            %(self.identifier, self.lineNumber, self.text, self.type, self.expression)

    def accept(self, visitor):
        return visitor.visitQuestionStatement(self)


class IfStatement(Node):
    def __init__(self, expr, statements, lineNumber):
        super().__init__(lineNumber)
        self.expression = expression
        self.statements = statements
        
    def __str__(self):
        return "ifStatement, line:%d, expr:%s" %(self.lineNumber, self.expression)

    def accept(self, visitor):
        visitor.visitIfStatementBegin(self)
        for statement in self.statements:
            statement.accept(visitor)
        return visitor.visitIfStatementEnd(self)


class UnaryExpression(Node):
    def __init__(self, operator, expression, lineNumber):
        super().__init__(lineNumber)
        self.operator = operator
        self.expression = expression

    def __str__(self):
        return "(%s %s)" %(self.operator, self.right)

    def accept(self, visitor):
        visitor.visitUnaryExpressionBegin(self)
        self.expression.accept(visitor)
        return visitor.visitUnaryExpressionEnd(self)


class BinaryExpression(Node):
    def __init__(self, left, operator, right, lineNumber):
        super().__init__(lineNumber)
        self.left = left
        self.operator = operator
        self.right = right

    def __str__(self):
        return "(%s %s %s)" %(self.left, self.operator, self.right)

    def accept(self, visitor):
        visitor.visitBinaryExpressionBegin(self)
        self.left.accept(visitor)
        self.right.accept(visitor)
        return visitor.visitBinaryExpressionEnd(self)


class AtomBaseType(Node):
    def __init__(self, value, lineNumber):
        super().__init__(lineNumber)
        self._value = value

    def __str__(self):
        return str(self.value)


class Boolean(AtomBaseType):
    def accept(self, visitor):
        return visitor.visitBoolean(self)

    @property
    def value(self):
        return QLBoolean(self._value)

class Integer(AtomBaseType):
    def accept(self, visitor):
        return visitor.visitInteger(self)

    @property
    def value(self):
        return QLInteger(self._value)

class String(AtomBaseType):
    def accept(self, visitor):
        return visitor.visitString(self)

    @property
    def value(self):
        return QLString(self._value)

class Money(AtomBaseType):
    def accept(self, visitor):
        return visitor.visitMoney(self)

    @property
    def value(self):
        return QLMoney(self._value)

class Identifier(AtomBaseType):
    def accept(self, visitor):
        return visitor.visitIdentifier(self)

    def value(self):
        return QLIdentifier(self._value)
