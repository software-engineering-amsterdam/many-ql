import sys

import argparse
import glob

from ql.parser.ANTLR import Parser
from ql.typechecking import Typechecking as tc

def runTest(verbose, testFileName):
    parser = Parser(testFileName)
    typeCheckResult = tc.check(parser)

    expectedNumMessages = int(
        testFileName.split('.')[0].split('-')[2]
    )

    numMessages = len(typeCheckResult.errors + typeCheckResult.warnings)
    success = numMessages == expectedNumMessages

    if(not success):
        print(('-'*10)+'Type check test FAIL')

    if(not success or verbose):
        for m in typeCheckResult.errors + typeCheckResult.warnings:
            print(m)

        print( '^'+('-'*9)+testFileName+': '\
             + 'got '+str(numMessages)+' message(s), expected '\
             + str(expectedNumMessages) + ('-'*10)
             ) 
        
    return success

def main():
    argParser = argparse.ArgumentParser()
    argParser.add_argument('-v'
                           ,'--verbose'
                           ,help="Show lots of output."
                           ,action="store_true"
                           )
    argParser.add_argument('-f'
                           ,'--file'
                           ,help="Test only this file."
                           )
    args = argParser.parse_args()

    failures = 0

    if args.file:
        testFileNames = [args.file]
    else:
        testFileNames = glob.glob('testFiles/type-check-*.ql')

    for testFileName in testFileNames:
        if(not runTest(args.verbose, testFileName)):
            failures += 1

    print( '\n'\
         + str(failures) + ' failure(s) total.\n'\
         + 'Tested '+str(len(testFileNames))+' file(s): '\
         + str(testFileNames)
         )

if __name__ == '__main__':
    main()
