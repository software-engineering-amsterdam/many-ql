import sys, os

from ql.evaluator.evaluator import createEvaluator

from ql.gui.View import View
from ql.gui.Controller import Controller
from ql.gui.Model import QuestionModel

from ql.parser.ANTLR import Parser
from ql.typechecking import\
    Typechecking, OrderedErrorsWarningsResult, ConsoleMessage



def main():
    if len(sys.argv) == 1:
    	print("Run as follows: python ql.py YOUR_SOURCECODE.ql")
    	exit(0)

    filename = sys.argv[1]

    if not os.path.isfile(filename):
    	print("ERROR: %s cannot be found." %(filename), file=sys.stderr)
    	exit(1)

    parseResult = parse(filename)
    if parseResult is None:
        exit(1)

    if not typecheck(parseResult):
        exit(1)

    evaluator = createEvaluator(parseResult.questionnaire)

    models = [QuestionModel(identifier, evaluator) for identifier in evaluator.identifiers()]
    view = View(title = 'Questions')
    controller = Controller(models, view)

    controller.run()



def parse(filename):
    parseResult = Parser(filename)

    if len(parseResult.errors) > 0:
        for error in parseResult.errors:
            print(error, file=sys.stderr)
        return None

    return parseResult



def typecheck(parser):
    result = Typechecking.check(
        parser.questionnaire,
        OrderedErrorsWarningsResult.factory(),
        ConsoleMessage.factory(parser)
    )

    for message in result.messages:
        print(message, file=sys.stderr)

    return len(result.errors) == 0



if __name__ == '__main__':
    main()