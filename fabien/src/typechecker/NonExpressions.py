
from Errors import QLTypeError

class NonExpressions():
    def __init__(self, questionIDs=None):
        self.errors = []
        self.branchExpressions = []

        self.questionTypes = {}

    def Question(self, node):
        self.questionTypes[node.ID] = node.type

    def Branch(self, node):
        self.branchExpressions.append(node.expression)

    def Done(self):
        for op in self.branchExpressions:
            if not op.Operation.checkType(self.questionTypes):
                error = QLTypeError(op)
                self.errors.append(error)