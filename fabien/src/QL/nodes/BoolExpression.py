
from Expression import Expression

class BoolExpression(Expression):
    def __init__(self, LexNode, operator=None, left=None, right=None):
        Expression.__init__(self, LexNode, operator=None, left=None, right=None)

        self.operator = operator

        self.left  = left
        self.right = right

        self.operatorTable = {
          '>'  : lambda x, y : x > y,
          '<'  : lambda x, y : x < y,

          '==' : lambda x, y : x == y,
          '>=' : lambda x, y : x >= y,
          '<=' : lambda x, y : x <= y,

          'or' : lambda x, y : x or y,
          '||' : lambda x, y : x or y,

          'and' : lambda x, y : x and y,
          '&&'  : lambda x, y : x and y
        }


    def evaluate(self):
        # Basic case
        if self.left.NodeType == 'Leaf' and \
           self.left.NodeType == self.right.NodeType:

              if self.left.type == self.right.type:
                  return True


        if not self.left.NodeType == 'Leaf':
            evaluatedLeft = self.left.evaluate()

        if not self.right.NodeType == 'Leaf':
            evaluatedRight = self.right.evaluate()

        #print self.left #.NodeType

    def execute(self):
        return self.operatorTable[self.operator](self.left.execute(), self.right.execute())

    def __repr__(self):
        return "Bool Expression(%s %s %s)" % (self.left, self.operator, self.right)

