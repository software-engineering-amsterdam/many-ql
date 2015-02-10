import argparse
import glob

from antlr4 import *
from QLLexer import QLLexer
from QLParser import QLParser

def run_test(print_tree_always, test_filename):
    input = FileStream(test_filename)
    lexer = QLLexer(input)
    stream = CommonTokenStream(lexer)
    parser = QLParser(stream)

    method_name = test_filename.split('.')[0].split('-')[2]
    tree_test = getattr(parser, method_name)()

    if parser._syntaxErrors > 0 or print_tree_always:
        print_tree(tree_test, 0)

    if parser._syntaxErrors > 0 or print_tree_always:
        print( '^'+('-'*9)+method_name+'('+test_filename+'): '\
             + str(parser._syntaxErrors) + ' error(s)'\
             + ('-'*10)
             )

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
    arg_parser = argparse.ArgumentParser()
    arg_parser.add_argument('-t'
                           ,'--trees'
                           ,help="Always print parse trees."
                           ,action="store_true"
                           )
    arg_parser.add_argument('-f'
                           ,'--file'
                           ,help="Test only this file."
                           )
    args = arg_parser.parse_args()

    errors = 0

    if args.file:
        test_filenames = [args.file]
    else:
        test_filenames = glob.glob('recognize-as-*.ql')

    for test_filename in test_filenames:
        errors += run_test(args.trees, test_filename)

    print( '\n'\
         + str(errors) + ' error(s) total.\n'\
         + 'Tested '+str(len(test_filenames))+' file(s): '\
         + str(test_filenames)
         )

if __name__ == '__main__':
    main()
