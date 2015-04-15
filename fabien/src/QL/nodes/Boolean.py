
from Leaf import Leaf

class Boolean(Leaf):
    def __init__(self, LexNode, value=None):
        Leaf.__init__(self, LexNode)

        self.leafValue = value

    def evaluate(self, answers):
        if self.leafValue in [True, 1, '1', 'true']:
            return True

        return False

    def __repr__(self):
        return "Boolean %s" % self.leafValue
