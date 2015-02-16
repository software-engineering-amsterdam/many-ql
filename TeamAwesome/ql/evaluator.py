from AST import AST
import ASTNodes

class QuestionTable(dict):
	def __init__(self, ast):
		dict.__init__(self, {})

		for formStatement in ast.root.statements:
			form = Form(formStatement)

			for statement in formStatement.getChildren():
				self.__addStatement(statement, ExpressionsTuple(), form)

	def __addStatement(self, statement, expressionsTuple, form):
		assert isinstance(statement, ASTNodes.IfStatement) or isinstance(statement, ASTNodes.QuestionStatement)

		if isinstance(statement, ASTNodes.IfStatement):
			childExpressionsTuple = expressionsTuple + (Expression(statement.expr),)
			
			for childStatement in statement.getChildren():
				self.__addStatement(childStatement, childExpressionsTuple, form)
		else:
			question = Question(statement, expressionsTuple, form)
			self[question.identifier] = question

class ExpressionsTuple(tuple):
	def __add__(self, value):
		return ExpressionsTuple(tuple.__add__(self, value))

	def evaluate(self):
		return all(expr.evaluate() for expr in self)

class Form(object):
	def __init__(self, formStatementNode):
		assert isinstance(formStatementNode, ASTNodes.FormStatement)

		self.identifier = formStatementNode.identifier

class Expression(object):
	def __init__(self, expressionNode):
		assert isinstance(expressionNode, ASTNodes.Expression)
		pass

	def evaluate(self):
		return True

class Question(object):
	def __init__(self, questionStatementNode, conditionalExpressionsTuple, form):
		assert isinstance(questionStatementNode, ASTNodes.QuestionStatement)
	
		self.identifier = questionStatementNode.identifier	
		self.valueExpression = questionStatementNode.expr
		self.text = questionStatementNode.text
		self.type = questionStatementNode.type

		self.conditionalExpressions = conditionalExpressionsTuple
		self.form = form

	def isVisible(self):
		return self.conditionalExpressions.evaluate()

class Page(object):
	def __init__(self, questionTable, questionIdentifiers):
		self.questions = []
		for identifier in questionIdentifiers:
			self.questions.append(questionTable[identifier])

	def getVisibleQuestions(self):
		return [question for question in self.questions if question.isVisible()]

ast = AST("test_visitor.QL")
qt = QuestionTable(ast)
page = Page(qt, qt.keys())
print(page.getVisibleQuestions())

#for identifier, question in ec.items():
#	print(identifier, question)
	