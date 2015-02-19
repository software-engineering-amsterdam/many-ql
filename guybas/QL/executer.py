from grammar import *
from type_checker import *
from gui import *
from exceptions import *

# TODO: refactor in directories and / or namespaces
# TODO: consisted naming: camel case / underscore / variable names / etc.
# TODO: type checker: check if expression is well formed
# TODO: create question (statement) interface
# TODO: unit tests for type checker and processor (and gui?)

try:
    formAsParseResults = FormFormat.form.ignore(BasicTypes.comment).parseFile("ql_example.ql")
    #check = formAsParseResults.asDict()
    #print(check)
    #formAsParseResults.pprint()
    form = ASTReady.make_form(formAsParseResults)
    #print(form.ast_print())

    typeChecker = TypeChecker(form)
    #gui = QuestionnaireGUI(form)
    #gui.generate_gui()
    #gui.show()

except Exception as e:
    exceptions_handling(e)