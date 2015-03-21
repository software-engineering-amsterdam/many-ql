import pyparsing as pp

import QL.Grammar.grammar as grammar
import QL.config as c
import QL.Grammar.Factory.forms as form_factory
import QL.Grammar.Factory.expressions as e

import QL.Runtime.form as runtime_form
import QL.GUI.gui as g
import QL.Tools.exceptions as ee

#
# p = grammar.expr.parseString("not 5 + 3 * 2 - 1 == 4")
# print(p[0].string_presentation())


pp.ParserElement.enablePackrat()
formAsParseResults = grammar.form.ignore(grammar.comment).parseFile(c.Config.input_path)
form = form_factory.make_form(formAsParseResults)
print(form.string_presentation())
form.handle_exceptions()


enriched_form = runtime_form.Form(form)
gui = g.GUI(enriched_form)
gui.generate_gui()
gui.show()

# except Exception as e:
# except (pp.ParseException, Exception) as e:
# #     raise ee.FException(e)
# except Exception as e:
#     ee.FException(e)