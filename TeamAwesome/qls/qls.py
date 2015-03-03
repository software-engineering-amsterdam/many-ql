import sys, os

from qls.ast.AST import AST

ast = AST("example.qls")
ast.prettyPrint()