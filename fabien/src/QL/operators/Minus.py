
from NumericOperand import NumericOperand

class Minus(NumericOperand):
    def evaluate(self, answers):
        return int(self.left.evaluate(answers)) - \
               int(self.right.evaluate(answers))

    def __repr__(self):
        return "%s - %s" % (self.left, self.right)
