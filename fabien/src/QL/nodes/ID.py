
from Leaf import Leaf

class ID(Leaf):
    def __init__(self, LexNode, value=None):
        Leaf.__init__(self, LexNode)

        self.leafValue = value

    def evaluate(self, answers):
        for answer in answers:
            if self.ID == answer.ID:
                return answers[answer]

        return None

    def __repr__(self):
        return "ID %s" % self.leafValue
