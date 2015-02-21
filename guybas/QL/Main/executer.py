from Grammar.form import *
from Main.type_checker import *
from Main.gui import *

# TODO: type checker: check if expression is well formed
# TODO: unit tests for type checker and processor (and gui?)

try:
    formAsParseResults = FormFormat.form.ignore(BasicTypes.comment).parseFile("ql_example.ql")
    form = FormFactory.make_form(formAsParseResults)
    print(form.pretty_print())

    #typeChecker = TypeChecker(form)
    #gui = QuestionnaireGUI(form)
    #gui.generate_gui()
    #gui.show()

except Exception as e:
    exceptions_handling(e)