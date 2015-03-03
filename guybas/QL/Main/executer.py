from QL.Grammar.form import *
from QL.Main.gui import *

formAsParseResults = FormFormat.form.ignore(BasicTypes.comment).parseFile("ql_example.ql")
form = FormFactory.make_form(formAsParseResults)
# print(form.pretty_print())
form.get_expressions()
#typeChecker = TypeChecker(form)

gui = QuestionnaireGUI(form)
gui.generate_gui()
gui.show()
