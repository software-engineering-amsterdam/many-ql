
from errors import QLTypeError

class NonExpressions():
    def __init__(self):
        self.questionIDs = {}

        self.errors = []
        self.branchExpressions = []

    def Branch(self, node):
        self.branchExpressions.append(node.expression)

    def Question(self, node):
        self.questionIDs[node.ID] = node.type

    def Done(self):
        for op in self.branchExpressions:
            if not op.Operation.checkType(self.questionIDs):
                error = QLTypeError(op)
                self.errors.append(error)