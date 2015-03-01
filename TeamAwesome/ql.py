import sys, os

from ql.evaluator.evaluator import createEvaluator
from ql.ast.AST import AST

from ql.gui.View import *
from ql.gui.Controller import *
from ql.gui.Model import *


if len(sys.argv) == 1:
	print("Run as follows: python ql.py YOUR_SOURCECODE.ql")
	exit(1)

filename = sys.argv[1]

if not os.path.isfile(filename):
	print("ERROR: %s cannot be found." %(filename))
	exit(1)

ast = AST(filename)
evaluator = createEvaluator(ast)

models = [QuestionModel(identifier, evaluator) for identifier in evaluator.identifiers()]
view = View(title = 'Questions')
controller = Controller(models, view)

controller.run()