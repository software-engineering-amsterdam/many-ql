
from errors import QLTypeError

class NonOperandTypes:
    def __init__(self):
        self.questionIDs = {}

        self.errors = []
        self.expressions = []

    def OperandExpression(self, node):
        self.expressions.append(node.Operation)

    def Question(self, node):
        self.questionIDs[node.ID] = node.type

    def Done(self):
        for op in self.expressions:
            if not op.checkType(self.questionIDs):
                error = QLTypeError(op)
                self.errors.append(error)