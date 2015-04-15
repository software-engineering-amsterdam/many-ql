
from Leaf import Leaf

class Number(Leaf):
    def __init__(self, LexNode, value=None):
        Leaf.__init__(self, LexNode)

        self.leafValue = value

    def evaluate(self, answers):
        if "." in self.leafValue:
            return float(self.leafValue)

        return int(self.leafValue)

    def __repr__(self):
        return "Number %s" % self.leafValue
