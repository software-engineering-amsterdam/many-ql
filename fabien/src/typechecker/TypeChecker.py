import sys

# Using Observer Patern
class TypeChecker():
    def __init__(self, AST=None):
        self.AST = AST
        self.listeners = set()

    def register(self, listener):
        self.listeners.add(listener)

    def dispatch(self, function=None, *args, **kwargs):
        for listener in self.listeners:
            try:
                getattr(listener, function)(*args, **kwargs)
            except AttributeError as err:
                pass
            except Exception as err:
                print "Unexpected error: %s" % err
                raise

    def check(self):
        # Obtain general question info
        questionIDs   = {}
        questionTypes = {}

        for node in self.AST.findAll("Question"):
            questionIDs[node.ID]   = node
            questionTypes[node.ID] = node.type

        # Pass question info
        self.dispatch("__init__", questionIDs, questionTypes)

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

        return False

    def getErrorMessages(self):
        errors = []

        for listener in self.listeners:
            errors.extend([str(err) for err in listener.errors])

        return errors
