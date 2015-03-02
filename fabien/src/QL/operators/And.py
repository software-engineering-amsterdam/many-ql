
from BooleanOperand import BooleanOperand

class And(BooleanOperand):

    def __repr__(self):
        return "%s and %s" % (self.left, self.right)
