from antlr4 import *
from ..parser.QLSLexer import QLSLexer
from ..parser.QLSParser import QLSParser
from ..parser.QLSListener import QLSListener
from .ParseTreeVisitor import ParseTreeVisitor

class AST(object):
	def __init__(self, inputQLFile):
		inputStream = FileStream(inputQLFile)
		lexer = QLSLexer(inputStream)
		stream = CommonTokenStream(lexer)
		parser = QLSParser(stream)
		visitor = ParseTreeVisitor()
		tree = parser.qls()
		self.qls = visitor.visit(tree)

	def prettyPrint(self):
		for statement in self.qls.statements:
			self._printStatement(statement, 0)

	def _printStatement(self, statement, lev):
		spaces = " " * lev
		if spaces == None:
			spaces = ""

		print(spaces + str(statement))

		if hasattr(statement, "statements"):
			for otherStatement in statement.statements:
				self._printStatement(otherStatement, lev + 4)

		if hasattr(statement, "attributes"):
			for attribute in statement.attributes:
				self._printAttribute(attribute, lev + 4)

	def _printAttribute(self, attribute, lev):
		spaces = " " * lev
		if spaces == None:
			spaces = ""

		print(spaces + str(attribute))