import sys

# Using Observer Patern
class TypeChecker():
    def __init__(self):
        self.listeners = set()

    def register(self, listener):
        self.listeners.add(listener)

    def dispatch(self, function=None, *args):
        for listener in self.listeners:
            try:
                getattr(listener, function)(*args)
            except AttributeError:
                pass
            except:
                print("Unexpected error:", sys.exc_info()[0])
                raise

    def checkAST(self, AST):
        # Reset listeners
        self.dispatch("__init__")

        for node in AST:
            self.dispatch(node.NodeType, node)

        self.dispatch("Done")

    def reportErrors(self):
        for listener in self.listeners:
            for err in listener.errors:
                print err
                print "\n"