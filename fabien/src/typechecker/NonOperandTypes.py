
from Errors import QLTypeError

class NonOperandTypes:
    def __init__(self, IDs=None, types=None):
        self.errors = []
        self.expressions = []
        self.questionIDs = IDs

    def OperandExpression(self, node):
        self.expressions.append(node)

    def Done(self):
        errorMessage = "Invalid operation"

        for op in self.expressions:
            if not op.Operation.checkType(self.questionIDs):
                error = QLTypeError(op, errorMessage)
                self.errors.append(error)