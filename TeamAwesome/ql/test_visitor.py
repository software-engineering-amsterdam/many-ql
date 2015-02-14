import sys

from antlr4 import *
from QLLexer import QLLexer
from QLParser import QLParser
from QLListener import QLListener
from customQLVisitor import CustomQLVisitor

input = FileStream("test_visitor.QL")

lexer = QLLexer(input)

stream = CommonTokenStream(lexer)

parser = QLParser(stream)

tree_test = parser.form_statement()

def print_tree(tree_test, lev):
    if not isinstance(tree_test, tree.Tree.TerminalNodeImpl):
        for c in tree_test.getChildren():
            print_tree(c, lev + 1)
    else:
        spaces = " " * lev
        if spaces == None:
            spaces = ""
        print(spaces + "` " + str(tree_test))


def main():
    visitor = CustomQLVisitor()
    print(visitor.visit(tree_test).statements[0].identifier.lineNumber)
    #print_tree(tree_test, 0)    

if __name__ == '__main__':
    main()
