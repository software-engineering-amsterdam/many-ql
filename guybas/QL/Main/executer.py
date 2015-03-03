import QL.Grammar.form as form
import QL.Main.gui as g

formAsParseResults = form.FormFormat.form.ignore(form.basic_types.BasicTypes.comment).parseFile("ql_example.ql")
form = form.forms.FormFactory.make_form(formAsParseResults)
# print(form.pretty_print())
form.get_expressions()
#typeChecker = TypeChecker(form)

gui = g.QuestionnaireGUI(form)
gui.generate_gui()
gui.show()
