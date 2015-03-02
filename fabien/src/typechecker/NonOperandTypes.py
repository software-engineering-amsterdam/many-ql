
from errors import QLTypeError

class NonOperandTypes:
    def __init__(self):
        self.questionIDs = {}

        self.errors = []
        self.expressions = []

    def OperandExpression(self, node):
        self.expressions.append(node)

    def Question(self, node):
        self.questionIDs[node.ID] = node.type

    def Done(self):
        errorMessage = "Invalid operation"

        for op in self.expressions:
            if not op.Operation.checkType(self.questionIDs):
                error = QLTypeError(op, errorMessage)
                self.errors.append(error)