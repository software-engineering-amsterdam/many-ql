import QL.Grammar.grammar as grammar
import QL.GUI.gui as g
import QL.Tools.type_checker as type_checker
import QL.config as c
import QL.Factory.forms as form_factory

formAsParseResults = grammar.form.ignore(grammar.comment).parseFile(c.Config.input_path)
form = form_factory.make_form(formAsParseResults)

#new_form = grammar.FormAPI(grammar)

typeChecker = type_checker.TypeChecker(form)
typeChecker.is_valid_form()

gui = g.GUI(form)
gui.generate_gui()
gui.show()
