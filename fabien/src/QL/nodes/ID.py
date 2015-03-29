
from Leaf import Leaf

class ID(Leaf):
    def __init__(self, LexNode, value=None):
        Leaf.__init__(self, LexNode)

        self.leafValue = value

    def evaluate(self, answers):
        if self.ID in answers:
            return answers[self.ID]

    def __repr__(self):
        return "ID %s" % self.leafValue
