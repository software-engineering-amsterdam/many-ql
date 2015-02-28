from ql.evaluator.evaluator import createEvaluator
from ql.ast.AST import AST

from ql.gui.View import *
from ql.gui.Controller import *
from ql.gui.Model import *

ast = AST('gui.ql')
evaluator = createEvaluator(ast)

models = [QuestionModel(identifier, evaluator) for identifier in evaluator.identifiers()]
view = View(title = 'Questions')
controller = Controller(models, view)

controller.refresh()
view.mainloop()