import sys, os
sys.path.append('../lib')

from qls.ast.AST import AST

ast = AST("example.qls")
ast.prettyPrint()