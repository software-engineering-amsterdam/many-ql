from grammar import *
from type_checker import *
from gui import *
from exceptions import *

# TODO: fix een: hummus == True works, True == hummus doesn't.
# TODO: fix twee: labels duplicate doesn't work well

try:
    formAsParseResults = FormFormat.form.ignore(BasicTypes.comment).parseFile("ql_example.ql")
    form = ASTReady.make_form(formAsParseResults)
    print(form.ast_print())

    typeChecker = TypeChecker(form)
    gui = QuestionnaireGUI(form)
    gui.generate_gui()
    gui.show()

except Exception as e:
    exceptions_handling(e)