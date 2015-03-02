
from errors import QLTypeError

class NonBooleanExpressions():
    def __init__(self):
        self.questionIDs = {}

        self.errors = []
        self.branchExpressions = []

    def Branch(self, node):
        self.branchExpressions.append(node.expression.Operation)

    def Question(self, node):
        self.questionIDs[node.ID] = node.type

    def Leaf(self, node):
        pass

    def Done(self):
        for op in self.branchExpressions:
            if not op.checkType(self.questionIDs):
                error = QLTypeError(op)
                self.errors.append(error)