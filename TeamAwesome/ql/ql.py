import sys, os
sys.path.append('../lib')

from ql.evaluator.evaluator import createEvaluator
from ql.ast.AST import AST

from ql.gui.View import *
from ql.gui.Controller import *
from ql.gui.Model import *
#from ql.typechecking import typechecking 


def main():
    if len(sys.argv) == 1:
    	print("Run as follows: python ql.py YOUR_SOURCECODE.ql")
    	exit(1)

    filename = sys.argv[1]

    if not os.path.isfile(filename):
    	print("ERROR: %s cannot be found." %(filename))
    	exit(1)

    ast = AST(filename)
    """
    typeCheckResult = typechecking.check(ast)
    printErrors(typeCheckResult)
    printWarnings(typeCheckResult)

    if len(typeCheckResult.errors) > 0:
        exit(-1)
    """
    evaluator = createEvaluator(ast)

    models = [QuestionModel(identifier, evaluator) for identifier in evaluator.identifiers()]
    view = View(title = 'Questions')
    controller = Controller(models, view)

    controller.run()


def printErrors(typeCheckResult):
    for error in typeCheckResult.errors:
        print(error)


def printWarnings(typeCheckResult):
    for warning in typeCheckResult.warnings:
        print(warning)


if __name__ == '__main__':
    main()