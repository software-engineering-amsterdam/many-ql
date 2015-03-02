#!/usr/bin/env python

#from src.Gui.app import GUI

from src.QL.parser import Parser
from src.Typechecker import *

if __name__ == '__main__':
    parser = Parser()

    with open("tests/forms/nonBoolean.txt") as f:
        formText = f.read()
        Form = parser.parse(formText)

        f.close()

    checker = TypeChecker()

    #checker.register(DuplicateQuestions())
    #checker.register(UndefinedQuestions())
    checker.register(NonBooleanTypes())

    checker.checkAST(Form)
    checker.reportErrors()