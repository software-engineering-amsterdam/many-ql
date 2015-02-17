
from TypeChecker import TypeChecker

class DuplicateQuestions(TypeChecker):

    def isValid(self, Node):
        questionTypes = {}

        for node in self.preorderTraversal(Node):
            if node.isClass('Question'):
                if node.label in questionTypes:
                    if node.type != questionTypes[node.label]:
                        raise Exception("Duplicate label `%s' of different type (%s != %s) in %s at line %d" % \
                            (node.label, questionTypes[node.label], node.type, node, node.lineNr))
                    else:
                        # Warning?
                        pass
                else:
                    questionTypes[node.label] = node.type

        return True

