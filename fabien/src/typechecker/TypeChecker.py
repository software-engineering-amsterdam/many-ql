import sys

# Observer Patern
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

        # Pre-order traversal of AST
        for node in AST:
            print node.NodeType
            self.dispatch(node.NodeType, node)

        #for listener in self.listeners:
        #    print listener.errors
