import QL.Grammar.form as form
import QL.GUI.gui as g
import QL.Validators.type_checker as type_checker
import QL.config as c

formAsParseResults = form.FormFormat.form.ignore(form.basic_types.BasicTypes.comment).parseFile(c.Config.input_path)
form = form.forms.FormFactory.make_form(formAsParseResults)

typeChecker = type_checker.TypeChecker(form)

gui = g.GUI(form)
gui.generate_gui()
gui.show()
