
from TypeChecker import TypeChecker

from DuplicateQuestions import DuplicateQuestions
from UndefinedQuestions import UndefinedQuestions
from NonBooleanTypes import NonBooleanTypes

class QLTypeChecker(TypeChecker):
    def __init__(self, AST):
        TypeChecker.__init__(self, AST)

        self.register(DuplicateQuestions())
        self.register(UndefinedQuestions())
        self.register(NonBooleanTypes())

        self.check()
