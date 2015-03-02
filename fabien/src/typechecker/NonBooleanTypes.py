
from errors import QLTypeError

class NonBooleanTypes:
    def __init__(self):
        self.questionIDs = {}

        self.errors = []
        self.expressions = []

    def BooleanExpression(self, node):
        self.expressions.append(node.Operation)

    def Question(self, node):
        self.questionIDs[node.ID] = node.type

    def Done(self):
        errorMessage = "Invalid boolean operation"

        for op in self.expressions:
            if not op.checkType(self.questionIDs):
                error = QLTypeError(op, errorMessage)
                self.errors.append(error)