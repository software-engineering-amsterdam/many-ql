import sys, argparse, glob

from antlr4 import *
from ql.parser.antlr_generated.QLLexer import QLLexer
from ql.parser.antlr_generated.QLParser import QLParser

def runTest(printTreeAlways, testFileName):
    input = FileStream(testFileName)
    lexer = QLLexer(input)
    stream = CommonTokenStream(lexer)
    _parser = QLParser(stream)

    methodName = testFileName.split('.')[0].split('-')[2]
    treeTest = getattr(_parser, methodName)()

    if _parser._syntaxErrors > 0 or printTreeAlways:
        printTree(treeTest, 0)

    if _parser._syntaxErrors > 0 or printTreeAlways:
        print( '^'+('-'*9)+methodName+'('+testFileName+'): '\
             + str(parser._syntaxErrors) + ' error(s)'\
             + ('-'*10)
             )

    return _parser._syntaxErrors


def printTree(treeTest, lev):
    if not isinstance(treeTest, tree.Tree.TerminalNodeImpl):
        for c in treeTest.getChildren():
            printTree(c, lev + 1)
    else:
        spaces = " " * lev
        if spaces == None:
            spaces = ""
        print(spaces + "` " + str(treeTest))


def main():
    argParser = argparse.ArgumentParser()
    argParser.add_argument('-t'
                           ,'--trees'
                           ,help="Always print parse trees."
                           ,action="store_true"
                           )
    argParser.add_argument('-f'
                           ,'--file'
                           ,help="Test only this file."
                           )
    args = argParser.parse_args()

    errors = 0

    if args.file:
        testFileNames = [args.file]
    else:
        testFileNames = glob.glob('testFiles/recognize-as-*.ql')

    for testFileName in testFileNames:
        errors += runTest(args.trees, testFileName)

    print( '\n'\
         + str(errors) + ' error(s) total.\n'\
         + 'Tested '+str(len(testFileNames))+' file(s): '\
         + str(testFileNames)
         )

if __name__ == '__main__':
    main()
