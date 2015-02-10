import glob

from antlr4 import *
from QLLexer import QLLexer
from QLParser import QLParser

def run_test(test_filename):
    input = FileStream(test_filename)
    lexer = QLLexer(input)
    stream = CommonTokenStream(lexer)
    parser = QLParser(stream)

    method_name = test_filename.split('.')[0].split('_')[1]

    tree_test = getattr(parser, method_name)()
    if parser._syntaxErrors > 0:
        print_tree(tree_test, 0)
        print( str(parser._syntaxErrors)\
             + ' error(s) while testing `'\
             + method_name\
             + '` on input file '\
             + test_filename
             ) 
        print('-'*60)

    return parser._syntaxErrors


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
    errors = 0

    test_filenames = glob.glob('test_*.ql')
    for test_filename in test_filenames:
        errors += run_test(test_filename)

    print(str(errors) + ' error(s).\n'\
         + 'Tested '+str(len(test_filenames))+' file(s): '\
         + str(test_filenames)
         )

if __name__ == '__main__':
    main()
