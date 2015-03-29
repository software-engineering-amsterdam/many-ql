
import uuid

from Node import Node

class Question(Node):
    def __init__(self, LexNode):
        Node.__init__(self, LexNode)

        self.text     = self.tokens.get('STRING', "")
        self.type     = self.tokens.get('TYPE', "boolean")
        self.ID       = self.tokens.get('ID', uuid.uuid4())
        self.function = self.tokens.get('function', None)

    @property
    def children(self):
        if self.function:
            return [self.function]

        return []

    def labelText(self):
        return self.text[1: -1]

    def __repr__(self, nested=0):
        return "Question (%s: %s)" % (self.type, self.text)