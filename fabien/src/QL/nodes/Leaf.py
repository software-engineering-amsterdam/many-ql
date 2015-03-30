
from Node import Node

class Leaf(Node):
    def __init__(self, LexNode, value=None):
        Node.__init__(self, LexNode)

        self.leafValue = value

    @property
    def children(self):
        return []

    @property
    def ID(self):
        return self.tokens.get('ID', None)

    @property
    def tokenType(self):
        return self.tokens.keys()[0]

    # Since a single Leaf can be an expression
    @property
    def Operation(self):
        return self

    def checkType(self, IDs):
        return self.getType(IDs)

    def getType(self, IDs):
        if self.ID in IDs:
            return IDs[self.ID]

        return self.tokenType.lower()

    def evaluate(self, answers):
        return self.leafValue

    def __repr__(self):
        return "(%s) %s" % (self.tokenType.lower(), self.leafValue)
