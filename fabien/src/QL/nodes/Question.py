
import uuid

from Node import Node

class Question(Node):
    def __init__(self, LexNode):
        Node.__init__(self, LexNode)

        self.text     = self.tokens.get('STRING', "")
        self.type     = self.tokens.get('TYPE', "boolean")
        self.ID       = self.tokens.get('ID', uuid.uuid4())
        self.function = self.tokens.get('function', None)
        self.widget   = self.tokens.get('WIDGET', None)

    @property
    def isReadOnly(self):
        return self.function is not None

    @property
    def children(self):
        if self.isReadOnly:
            return [self.function]

        return []

    def widgetName(self):
        if self.widget is not None:
            return self.widget.capitalize()

        if self.isReadOnly:
            return "ReadOnly" + self.type.capitalize()

        return self.type.capitalize()

    def labelText(self):
        return self.text

    def evaluate(self, answers):
        if self.isReadOnly:
            return self.function.evaluate(answers)

        return ''

    def __repr__(self, nested=0):
        return "Question (%s: %s)" % (self.type, self.text)
