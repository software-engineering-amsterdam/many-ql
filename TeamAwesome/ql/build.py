import os
import test_recognition

os.system('java org.antlr.v4.Tool -Dlanguage=Python3 QL.g4');
test_recognition.main()
