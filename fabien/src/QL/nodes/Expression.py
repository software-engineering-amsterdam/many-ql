
from Node import Node

class Expression(Node):
    def __init__(self, LexNode, operator=None, left=None, right=None):
        Node.__init__(self, LexNode)

        self.operator = operator
        self.left  = left
        self.right = right

    @property
    def children(self):
        return [self.left, self.right]

    @property
    def Operation(self):
        return self._operationFn

    def evaluate(self, answers):
        return self.Operation.evaluate(answers)

    def __repr__(self):
        return "Expression(%s %s %s)" % (self.left, self.operator, self.right)
