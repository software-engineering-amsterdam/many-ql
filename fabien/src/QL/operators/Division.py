
from NumericOperand import NumericOperand

class Division(NumericOperand):
    def evaluate(self, answers):
        try:
            # Cast to float to allow user friendly expressions
            return float(self.left.evaluate(answers)) / self.right.evaluate(answers)
        except ZeroDivisionError:
            return None

    def __repr__(self):
        return "%s / %s" % (self.left, self.right)
