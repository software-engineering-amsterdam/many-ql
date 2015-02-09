import sys, pprint
import pyparsing as pp
 
integer = pp.Word(pp.nums).setParseAction(lambda t: int(t[0]))
real = pp.Regex(r'((\d+\.\d*)|(\d*\.\d+))([eE][-+]?\d+)?').setParseAction(
    lambda t: float(t[0]))
lpar, rpar = map(pp.Suppress, "()")
factor = pp.Forward()
term = pp.Forward()
expression = pp.Forward()
 
# ======================================================================
# ast
class AST(object):
    def __init__(self):
        self.root = None
        self.opDict = {
            '+': lambda x, y: x + y,
            'u-': lambda x: -x,
            '-': lambda x, y: x - y,
            '*': lambda x, y: x * y,
            '/': lambda x, y: x / y,
            '^': lambda x, y: x ** y
            }
 
    def solve(self):
        def dfs(node):
            # not a list
            if not isinstance(node, type([])):
                return node
            # call the lambda, keyed on the operator
            if node[0] == 'u-':
                return self.opDict[node[0]](dfs(node[1]))
            else:
                return self.opDict[node[0]](dfs(node[1]),
                                            dfs(node[2]))
        return dfs(self.root[0])
 
    def makeUnaryMinusNode(self, t):
        if len(t[1:]) > 1:
            operand = t[1:]
        else:
            operand = t[1]
        if t[0] == '-':
            return [['u-', operand]]
        return [operand]
 
    def makeFactorNode(self, t):
        if t:
            return self.makeNodes(t)
 
    def makeTermNode(self, t):
        if t:
            return self.makeNodes(t)
 
    def makeExpressionNode(self, t):
        if t:
            # This is incorrect, as expression is recursive.
            # This will be correctly set at completion of
            # the as-of-yet to be coded start rule
            self.root = self.makeNodes(t)
            return self.root
 
    def makeNodes(self, t):
        node = t[0]
        for op, operand in zip(t[1::2], t[2::2]):
            node = [op, node, operand]
        return [node]
 
ast = AST()
 
# ======================================================================
# grammar
number = integer ^ real
 
primary = \
    (lpar + (expression) + rpar) ^ \
    (pp.oneOf("- +") + term).setParseAction(ast.makeUnaryMinusNode) ^ \
    number
 
factor << (primary + pp.Optional('^' + factor))
factor.setParseAction(ast.makeFactorNode)
 
term << (factor + pp.ZeroOrMore(pp.oneOf("* /") + factor))
term.setParseAction(ast.makeTermNode)
 
expression << (term + pp.ZeroOrMore(pp.oneOf("+ -") + term))
expression.setParseAction(ast.makeExpressionNode)
 
# ======================================================================
# main
pretty = pprint.PrettyPrinter(width=10)
print('C-d to exit')
while 1:
    try:
        expression.parseString(input('> '))
        print('AST', "="*50)
        pretty.pprint(ast.root)
        print('solved', '='*47)
        print(ast.solve())
    except EOFError:
        print
        sys.exit(0)
    except pp.ParseException as err:
        print(err.line)
        print(" " * (err.column-1) + "^")
        print(err)