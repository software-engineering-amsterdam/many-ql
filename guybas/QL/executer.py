import QL.Grammar.form as form
import QL.GUI.gui as g
import QL.Validators.type_checker as type_checker
import QL.config as c
import QL.Runtime.form_api as f

formAsParseResults = form.FormFormat.form.ignore(form.basic_types.BasicTypes.comment).parseFile(c.Config.input_path)
form = form.forms.FormFactory.make_form(formAsParseResults)

#new_form = f.FormAPI(form)

typeChecker = type_checker.TypeChecker(form)
typeChecker.is_valid_form()

gui = g.GUI(form)
gui.generate_gui()
gui.show()
