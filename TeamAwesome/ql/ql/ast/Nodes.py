class Questionnaire(object):
    def __init__(self, statements):
        self.statements = statements

    def accept(self, visitor):
        for statement in self.statements:
            statement.accept(visitor)
        return visitor.visitQuestionnaire(self)

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
        for statement in self.statements:
            statement.accept(visitor)
        return visitor.visitFormStatement(self)

class QuestionStatement(Node):
    def __init__(self, identifier, text, questionType, lineNumber, expr = None):
        super().__init__(lineNumber)
        self.identifier = identifier
        self.text = text
        self.type = questionType
        self.expr = expr

    def __str__(self):
        return "questionId:%s, line:%d, question:%s, type:%s, expr:%s"\
            %(self.identifier, self.lineNumber, self.text, self.type, self.expr)

    def accept(self, visitor):
        return visitor.visitQuestionStatement(self)

class IfStatement(Node):
    def __init__(self, expr, statements, lineNumber):
        super().__init__(lineNumber)
        self.expr = expr
        self.statements = statements
        
    def __str__(self):
        return "ifStatement, line:%d, expr:%s" %(self.lineNumber, self.expr)

    def accept(self, visitor):
        for statement in self.statements:
            statement.accept(visitor)
        return visitor.visitIfStatement(self)

class UnaryExpression(Node):
    def __init__(self, op, expression, lineNumber):
        super().__init__(lineNumber)
        self.op = op
        self.expression = expression

    def __str__(self):
        return "(%s %s)" %(self.op, self.right)

    def accept(self, visitor):
        self.expression.accept(visitor)
        return visitor.visitUnaryExpression(self)

class BinaryExpression(Node):
    def __init__(self, left, op, right, lineNumber):
        super().__init__(lineNumber)
        self.left = left
        self.op = op
        self.right = right

    def __str__(self):
        return "(%s %s %s)" %(self.left, self.op, self.right)

    def accept(self, visitor):
        self.left.accept(visitor)
        self.right.accept(visitor)
        return visitor.visitBinaryExpression(self)


class AtomBaseType(Node):
    def __init__(self, value, lineNumber):
        super().__init__(lineNumber)
        self._value = value

    @property
    def value(self):
        return self._value

    def __str__(self):
        return str(self.value)

class Boolean(AtomBaseType):
    def accept(self, visitor):
        return visitor.visitBoolean(self)

class Integer(AtomBaseType):
    def accept(self, visitor):
        return visitor.visitInteger(self)

class String(AtomBaseType):
    def accept(self, visitor):
        return visitor.visitString(self)

class Money(AtomBaseType):
    def accept(self, visitor):
        return visitor.visitMoney(self)

class Identifier(AtomBaseType):
    def accept(self, visitor):
        return visitor.visitIdentifier(self)
