
class UnaryExpression:
    def __init__(self, value=None, operator=None):
         self.value    = value
         self.operator = operator

    def __repr__(self):
        return "Unary(%s %s)" % (self.operator, self.value)
