import QL.Grammar.form as form
import QL.GUI.gui as g
import QL.Tools.type_checker as type_checker
import QL.config as c

formAsParseResults = form.Form.form.ignore(form.basic_types.BasicTypes.comment).parseFile(c.Config.input_path)
form = form.forms.FormFactory.make_form(formAsParseResults)

#new_form = form.FormAPI(form)

typeChecker = type_checker.TypeChecker(form)
typeChecker.is_valid_form()

gui = g.GUI(form)
gui.generate_gui()
gui.show()
