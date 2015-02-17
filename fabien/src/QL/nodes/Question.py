
from Node import Node

class Question(Node):
    def __init__(self, LexNode):
        Node.__init__(self, LexNode)

        self.text     = self.tokens.get('STRING', "")
        self.type     = self.tokens.get('TYPE', "boolean")
        self.label    = self.tokens.get('ID', None)
        self.function = self.tokens.get('function', None)

    def __repr__(self, nested=0):
        return "Question(%s: %s)" % (self.type, self.text)