#!/usr/bin/env python

#from src.gui.app import GUI

from src.QL.parser import Parser


#from src.typechecker import TypeChecker
from src.typechecker import UndefinedQuestions, DuplicateQuestions

# Dummy GUI app:
# File dialog to select "form" to be parsed (output displayed in terminal)
if __name__ == '__main__':
    #gui = GUI()
    #gui.mainloop()

    parser = Parser()
    Form = parser.parse("form Hello { 'Hello \"All\" world!' bubbel:int \n 'Hello \"All\" world!' bubbel:int } ")

    checker = UndefinedQuestions()

    if checker.isValid(Form):
        print "\nNo undefined questions in:\n\n%s" % Form

    checker = DuplicateQuestions()

    if checker.isValid(Form):
        print "\nNo duplicate questions with different types in:\n\n%s" % Form
