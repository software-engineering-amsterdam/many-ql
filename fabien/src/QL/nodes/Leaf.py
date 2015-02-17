
from Node import Node

class Leaf(Node):
    def __init__(self, LexNode, value=None):
        Node.__init__(self, LexNode)

        self.leafValue = value

    def Label(self):
        return self.tokens.get('ID', None)