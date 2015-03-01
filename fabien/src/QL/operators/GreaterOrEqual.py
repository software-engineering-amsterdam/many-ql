
from NumericOperand import NumericOperand

class GreaterOrEqual(NumericOperand):

    def getType(self, IDs=None):
        return "boolean"

    def __repr__(self):
        return "%s >= %s" % (self.left, self.right)
