
from Node import Node

class Leaf(Node):
    def __init__(self, LexNode, value=None):
        Node.__init__(self, LexNode)

        self.leafValue = value

    def execute(self):
        return self.leafValue

    @property
    def children(self):
        return []

    def Label(self):
        return self.tokens.get('ID', None)

    @property
    def type(self):
        return self.tokens.keys()[0]