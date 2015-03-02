
from NumericOperand import NumericOperand

class Times(NumericOperand):

    def __repr__(self):
        return "%s * %s" % (self.left, self.right)
