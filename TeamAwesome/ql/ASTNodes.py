class Node(object):
    def __init__(self, lineNumber):
        self.lineNumber = lineNumber

class Root(Node):
    def __init__(self, statements):
        super().__init__(0)
        self.statements = statements

    def getChildren(self):
        return self.statements

class Statement(Node):
    def getChildren():
        raise NotImplementedError()

class FormStatement(Statement):
    def __init__(self, identifier, statements, lineNumber):
        super().__init__(lineNumber)
        self.identifier = identifier
        self.statements = statements

    def __str__(self):
        return "formId:%s, line:%d" %(self.identifier, self.lineNumber)

    def getChildren(self):
        return self.statements

class QuestionStatement(Statement):
    def __init__(self, identifier, text, questionType, lineNumber, expr = None):
        super().__init__(lineNumber)
        self.identifier = identifier
        self.text = text
        self.type = questionType
        self.expr = expr

    def __str__(self):
        return "questionId:%s, line:%d, question:%s, type:%s, expr:%s"\
            %(self.identifier, self.lineNumber, self.text, self.type, self.expr)

    def getChildren(self):
        return []

class IfStatement(Statement):
    def __init__(self, expr, statements, lineNumber):
        super().__init__(lineNumber)
        self.expr = expr
        self.statements = statements
        
    def __str__(self):
        return "ifStatement, line:%d, expr:%s" %(self.lineNumber, self.expr)

    def getChildren(self):
        return self.statements

class Expression(Node):
    pass

class AtomicExpression(Expression):
    def __init__(self, left, lineNumber):
        super().__init__(lineNumber)
        self.left = left
        
    def __str__(self):
        return str(self.left)

class UnaryExpression(Expression):
    def __init__(self, op, right, lineNumber):
        super().__init__(lineNumber)
        self.op = op
        self.right = right

    def __str__(self):
        return "(%s %s)" %(self.op, self.right)

class BinaryExpression(Expression):
    def __init__(self, left, op, right, lineNumber):
        super().__init__(lineNumber)
        self.left = left
        self.op = op
        self.right = right

    def __str__(self):
        return "(%s %s %s)" %(self.left, self.op, self.right)