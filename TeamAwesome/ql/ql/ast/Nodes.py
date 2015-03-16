class Node(object):
    def __init__(self, lineNumber):
        self.lineNumber = lineNumber

    def accept(self, visitor):
        raise NotImplementedError

class Questionnaire(Node):
    def __init__(self, statements):
        super().__init__(0)
        self.statements = statements

    def accept(self, visitor):
        for statement in self.statements:
            statement.accept(visitor)
        visitor.visitQuestionnaire(self)

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
        visitor.visitFormStatement(self)

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
        if self.expr:
            self.expr.accept(visitor)
        visitor.visitQuestionStatement(self)

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
        visitor.visitIfStatement(self)

class AtomicExpression(Node):
    def __init__(self, atom, lineNumber):
        super().__init__(lineNumber)
        self.atom = atom
        
    def __str__(self):
        return str(self.left)

    def accept(self, visitor):
        self.atom.accept(visitor)
        visitor.visitAtomicExpression(self)

class UnaryExpression(Node):
    def __init__(self, op, expression, lineNumber):
        super().__init__(lineNumber)
        self.op = op
        self.expression = expression

    def __str__(self):
        return "(%s %s)" %(self.op, self.right)

    def accept(self, visitor):
        self.expression.accept(visitor)
        visitor.visitUnaryExpression(self)

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
        visitor.visitBinaryExpression(self)
