
from Node import Node

class Expression(Node):
    def __init__(self, LexNode, operator=None, left=None, right=None):
        Node.__init__(self, LexNode)

    @property
    def children(self):
        return [self.left, self.right]

    def __repr__(self):
        return "Expression(%s %s %s)" % (self.left, self.operator, self.right)
