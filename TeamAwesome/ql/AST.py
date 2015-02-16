from antlr4 import *
from QLLexer import QLLexer
from QLParser import QLParser
from QLListener import QLListener
import customQLVisitor

class AST(object):
	def __init__(self, inputQLFile):			
		inputStream = FileStream(inputQLFile)
		lexer = QLLexer(inputStream)
		stream = CommonTokenStream(lexer)
		parser = QLParser(stream)
		visitor = customQLVisitor.CustomQLVisitor()
		tree = parser.root()
		self.root = visitor.visit(tree)

	def prettyPrint(self):
		for statement in self.root.getChildren():
			self._printStatement(statement, 0)

	def _printStatement(self, statement, lev):
		spaces = " " * lev
		if spaces == None:
			spaces = ""

		print(spaces + str(statement))

		for otherStatement in statement.getChildren():
			self._printStatement(otherStatement, lev + 4)
