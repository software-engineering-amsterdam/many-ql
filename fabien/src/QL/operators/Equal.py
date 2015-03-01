
from BooleanOperand import BooleanOperand

class Equal(BooleanOperand):

    def __repr__(self):
        return "%s == %s" % (self.left, self.right)
