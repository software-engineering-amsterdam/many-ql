import QL.Grammar.form as form
import QL.Main.gui as g

formAsParseResults = form.FormFormat.form.ignore(form.basic_types.BasicTypes.comment).parseFile("ql_example.ql")
form = form.forms.FormFactory.make_form(formAsParseResults)
form.set_statement_ids()
# print(form.pretty_print())
#typeChecker = TypeChecker(form)

##
d = form.get_statement_dict()
for i in d:
    if d[i]:
        print(d[i].get_parent_condition().pretty_print())
##

gui = g.QuestionnaireGUI(form)
gui.generate_gui()
gui.show()
