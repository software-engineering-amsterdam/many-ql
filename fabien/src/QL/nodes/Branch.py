
from Node import Node

class Branch(Node):
    def __init__(self, LexNode, ifChildren=None, elseChildren=None):
        Node.__init__(self, LexNode)

        self.expression = self.tokens.get('expr')

        self.ifChildren   = ifChildren or list()
        self.elseChildren = elseChildren or list()

    @property
    def children(self):
        return [self.expression] + self.ifChildren + self.elseChildren

    def evaluate(self, answers):
        return self.expression.evaluate(answers)

    def __repr__(self, nested=0):
        tree = "IF %s" % self.expression

        for node in self.ifChildren:
            tree += "\n"  + ("\t" * nested) +  " -> " + node.__repr__(nested=nested+1)

        if self.elseChildren:
            elseTree = "\n   ELSE"

            for node in self.elseChildren:
                elseTree += "\n"  + ("\t" * nested) +  " -> " + node.__repr__(nested=nested+1)

            tree += elseTree

        return tree