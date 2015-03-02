
from NumericOperand import NumericOperand

class Division(NumericOperand):

    def __repr__(self):
        return "%s / %s" % (self.left, self.right)
