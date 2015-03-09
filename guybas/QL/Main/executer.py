import QL.Grammar.form as form
import QL.GUI.gui as g
import QL.Validators.type_checker as type_checker

formAsParseResults = form.FormFormat.form.ignore(form.basic_types.BasicTypes.comment).parseFile("example.ql")
form = form.forms.FormFactory.make_form(formAsParseResults)

typeChecker = type_checker.TypeChecker(form)
#print(type(form.get_statements()[0]))
#run_time_form = rform.RForm(form.get_name(), form.get_introduction(), form.get_statements())

gui = g.QuestionnaireGUI(form)
gui.generate_gui()
gui.show()
