import sys

from antlr4 import *

from QLLexer import QLLexer

from QLParser import QLParser

from QLListener import QLListener


#def main(argv):

input = FileStream("t.QL")#argv[1])

lexer = QLLexer(input)

stream = CommonTokenStream(lexer)

parser = QLParser(stream)

tree_test = parser.question()

#tree.inspect(parser)

def print_tree(tree_test, lev):
    if not isinstance(tree_test, tree.Tree.TerminalNodeImpl):
        for c in tree_test.getChildren():
            print_tree(c, lev + 1)
    else:
        spaces = " " * lev
        if spaces == None:
            spaces = ""
        print(spaces + "` " + str(tree_test))

        

if __name__ == '__main__':
    print_tree(tree_test, 0)
    #main(sys.argv)
