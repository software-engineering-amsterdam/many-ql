import QL.Grammar.form as form
import QL.Main.gui as g
import QL.Validators.type_checker as type_checker

formAsParseResults = form.FormFormat.form.ignore(form.basic_types.BasicTypes.comment).parseFile("ql_example.ql")
form = form.forms.FormFactory.make_form(formAsParseResults)

# d = form.get_statement_dict()
# for i in d:
#     if d[i].get_parent_condition():
#         print("the key: " + str(i))
#         print("the expression: " + d[i].get_parent_condition().pretty_print())
# print(form.pretty_print())
typeChecker = type_checker.TypeChecker(form)

gui = g.QuestionnaireGUI(form)
gui.generate_gui()
gui.show()
