
class Expression:
    def __init__(self, operator=None, left=None, right=None):
         self.operator = operator

         self.left  = left
         self.right = right


    def __repr__(self):
        return "Expression(%s %s %s)" % (self.left, self.operator, self.right)
