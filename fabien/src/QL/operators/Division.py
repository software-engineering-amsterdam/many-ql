
from NumericOperand import NumericOperand

class Division(NumericOperand):
    def evaluate(self, answers):
        # Hmm division by 0 ...
        return self.left.evaluate(answers) / self.right.evaluate(answers)

    def __repr__(self):
        return "%s / %s" % (self.left, self.right)
