
from Leaf import Leaf

class String(Leaf):
    def __init__(self, LexNode, value=None):
        Leaf.__init__(self, LexNode)

        self.leafValue = value

    def evaluate(self, answers):
        return self.leafValue

    def __repr__(self):
        return "String %s" % self.leafValue
