#!/usr/bin/env python

#from src.gui.app import GUI

from src.QL.parser import Parser


#from src.typechecker import TypeChecker
from src.typechecker import UndefinedQuestions

# Dummy GUI app:
# File dialog to select "form" to be parsed (output displayed in terminal)
if __name__ == '__main__':
    #gui = GUI()
    #gui.mainloop()


    parser = Parser()
    Form = parser.parse("form Hello { 'Hello \"All\" world!' blabla:money(a - b) \n 'Hello \"All\" world!' bubbel:boolean if (blabla) { 'Hello world?' frits: money  if (blabla > 2) { 'Some additional things' } } } ")

    checker = UndefinedQuestions()

    if checker.isValid(Form):
        print "\nNo undefined questions in:\n\n%s" % Form
