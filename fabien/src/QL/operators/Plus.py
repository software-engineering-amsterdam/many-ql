
from NumericOperand import NumericOperand

class Plus(NumericOperand):

    def __repr__(self):
        return "%s + %s" % (self.left, self.right)
