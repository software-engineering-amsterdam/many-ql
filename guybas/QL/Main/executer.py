from QL.Grammar.form import *
from QL.Main.gui import *

# TODO: support text in expressions

formAsParseResults = FormFormat.form.ignore(BasicTypes.comment).parseFile("ql_example.ql")
form = FormFactory.make_form(formAsParseResults)
# print(form.pretty_print())

typeChecker = TypeChecker(form)

gui = QuestionnaireGUI(form)
gui.generate_gui()
gui.show()
