
from Errors import QLTypeError

class NonBooleanTypes:
    def __init__(self, IDs=None, types=None):
        self.errors = []
        self.expressions = []
        self.questionTypes = types

    def BooleanExpression(self, node):
        self.expressions.append(node)

    def UnaryExpression(self, node):
        self.expressions.append(node)

    def Done(self):
        errorMessage = "Invalid boolean operation"

        for op in self.expressions:
            if not op.Operation.checkType(self.questionTypes):
                error = QLTypeError(op, errorMessage)
                self.errors.append(error)