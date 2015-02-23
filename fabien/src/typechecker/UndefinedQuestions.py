
from TypeChecker import TypeChecker

class UndefinedQuestions(TypeChecker):

    # TODO include question function expressions
    def isValid(self, Node):
        questionLabels = {}

        for node in self.preorderTraversal(Node):
            # Get question labels
            if node.isClass('Question'):
                questionLabels[node.label] = node
                continue

            # Check labels used in expressions
            if node.isClass('Branch'):
                for expr in self.preorderTraversal(node.expression):
                    if expr.isClass('Leaf') and expr.Label():
                        if not expr.Label() in questionLabels:
                            raise Exception("Undefined label `%s' in %s at line %d" % (expr.Label(), node.expression, node.lineNr))

        return True

