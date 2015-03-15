import QL.Grammar.grammar as form
import QL.GUI.gui as g
import QL.Tools.type_checker as type_checker
import QL.config as c

formAsParseResults = form.form.ignore(form.comment).parseFile(c.Config.input_path)
form = form.forms.FormFactory.make_form(formAsParseResults)

#new_form = form.FormAPI(form)

typeChecker = type_checker.TypeChecker(form)
typeChecker.is_valid_form()

gui = g.GUI(form)
gui.generate_gui()
gui.show()
