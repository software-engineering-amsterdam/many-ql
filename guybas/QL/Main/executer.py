import QL.Grammar.form as form
import QL.Runtime.gui as g
import QL.Validators.type_checker as type_checker
import QL.Runtime.AST.form as rform

formAsParseResults = form.FormFormat.form.ignore(form.basic_types.BasicTypes.comment).parseFile("example.ql")
form = form.forms.FormFactory.make_form(formAsParseResults)

typeChecker = type_checker.TypeChecker(form)
run_time_form = rform.RForm(form.get_name(), form.get_introduction(), form.get_statements())

gui = g.QuestionnaireGUI(run_time_form)
gui.generate_gui()
gui.show()
