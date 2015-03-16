import pyparsing as pp

import QL.Grammar.grammar as grammar
import QL.config as c
import QL.Grammar.Factory.forms as form_factory


#
# e = grammar.expr.parseString("not 5 + 3 * 2 - 1 == 4")
# print(e[0].pretty_print())

pp.ParserElement.enablePackrat()
formAsParseResults = grammar.form.ignore(grammar.comment).parseFile(c.Config.input_path)
form = form_factory.make_form(formAsParseResults)
print(form.pretty_print())

print(form.valid_expressions())

# typeChecker = type_checker.TypeChecker(form)
# typeChecker.is_valid_form()

# gui = g.GUI(form)
# gui.generate_gui()
# gui.show()
