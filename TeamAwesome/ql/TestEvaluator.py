import sys, argparse, glob
sys.path.append('../lib')

from ql.parser.ANTLR import Parser
from ql.evaluator.evaluator import createEvaluator

def runTest(verbose, testFileName):
    parser = Parser(testFileName)
    evaluator = createEvaluator(parser.questionnaire)
    questions = evaluator.questions()
    numQuestions = len(questions)

    expectedNumQuestions = int(
        testFileName.split('.')[0].split('-')[1]
    )

    success = numQuestions == expectedNumQuestions

    if not success:
        print(('-' * 10) + 'Evaluator test FAIL')

    if not success or verbose:
        for question in questions:
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
        testFileNames = glob.glob('testFiles/evaluator-*.ql')

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
