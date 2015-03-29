import sys

# Using Observer Patern
class TypeChecker():
    def __init__(self, AST=None):
        self.AST = AST
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

    def check(self):
        questionIDs = {}

        # Obtain general question info
        for node in self.AST:
            if node.NodeType == "Question":
                questionIDs[node.ID] = node

        # Reset listeners
        # -> Pass question info
        self.dispatch("__init__", questionIDs)

        for node in self.AST:
            self.dispatch(node.NodeType, node)

        self.dispatch("Done")

    # Allow re-use of typechecker with listeners on different AST's
    def checkAST(self, AST):
        self.AST = AST
        self.check()

    @property
    def hasErrors(self):
        for listener in self.listeners:
            if listener.errors:
                return True
                break

    def getErrorMessages(self):
        errors = []

        for listener in self.listeners:
            errors.extend([str(err) for err in listener.errors])

        return errors