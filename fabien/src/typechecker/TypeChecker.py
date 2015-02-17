

class TypeChecker:

    def preorderTraversal(self, Node):
        yield Node

        if Node.hasChildren():
            for child in Node.children:
                for o in self.preorderTraversal(child):
                    yield o
