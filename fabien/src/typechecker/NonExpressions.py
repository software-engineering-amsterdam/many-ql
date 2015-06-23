
from Errors import QLTypeError

class NonExpressions():
    def __init__(self, IDs=None, types=None):
        self.errors = []
        self.branchExpressions = []
        self.questionTypes = types

    def Branch(self, node):
        self.branchExpressions.append(node.expression)

    def Done(self):
        for op in self.branchExpressions:
            if not op.Operation.checkType(self.questionTypes):
                error = QLTypeError(op)
                self.errors.append(error)