from QL.Grammar.form import *
from QL.Main.gui import *

formAsParseResults = FormFormat.form.ignore(BasicTypes.comment).parseFile("ql_example.ql")
form = FormFactory.make_form(formAsParseResults)
# print(form.pretty_print())

d = form.get_statement_dict()
for dd in d:
    print(str(dd) + str(d[dd]))
typeChecker = TypeChecker(form)

gui = QuestionnaireGUI(form)
gui.generate_gui()
gui.show()
