import argparse
import glob

from AST import AST
from evaluator.evaluator import Evaluator, PageStructure

def runTest(verbose, testFileName):
    ast = AST(testFileName)
    evaluator = Evaluator(ast)
    pageStructure = PageStructure(evaluator)
    pageStructure.createDefaultPages()

    numQuestions = len(pageStructure.getVisibleQuestions(0))

    expectedNumQuestions = int(
        testFileName.split('.')[0].split('-')[1]
    )

    success = numQuestions == expectedNumQuestions

    if not success:
        print(('-' * 10) + 'Evaluator test FAIL')

    if not success or verbose:
        for question in pageStructure.getVisibleQuestions(0):
            print(question)

        print( '^' + ('-' * 9) + testFileName + ': '\
             + 'got '+ str(numQuestions) + ' questions(s), expected '\
             + str(expectedNumQuestions) + ('-' * 10)
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
        testFileNames = glob.glob('evaluator-*.ql')

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
