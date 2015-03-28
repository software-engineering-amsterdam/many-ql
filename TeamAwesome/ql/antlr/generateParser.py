import os
os.system('java org.antlr.v4.Tool -Dlanguage=Python3 -o ../ql/parser/antlr_generated -visitor QL.g4')
