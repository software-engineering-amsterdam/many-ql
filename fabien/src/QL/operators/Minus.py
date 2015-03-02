
from NumericOperand import NumericOperand

class Minus(NumericOperand):

    def __repr__(self):
        return "%s - %s" % (self.left, self.right)
