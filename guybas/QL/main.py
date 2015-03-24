import pyparsing as pp

import QL.Grammar.grammar as grammar
import QL.config as c
import QL.Grammar.Factory.forms as form_factory

import QL.Runtime.form as runtime_form
import QL.GUI.gui as g
import QL.Tools.exception_handling as exception_handling
import QL.Tools.exceptions as ee

pp.ParserElement.enablePackrat()
formAsParseResults = grammar.form.ignore(grammar.comment).parseFile(c.Config.input_path)
form = form_factory.make_form(formAsParseResults)
print(form.string_presentation())

errors = []
errors.extend(form.check_ids())
errors.extend(form.check_dependencies())
errors.extend(form.check_expressions())

warnings = form.check_labels()
eh = exception_handling.ExceptionHandling(errors, warnings)
eh.execute()

enriched_form = runtime_form.Form(form)
gui = g.GUI(enriched_form)
gui.generate_gui()
gui.show()



# except Exception as e:
# except (pp.ParseException, Exception) as e:
# #     raise ee.FException(e)
# except Exception as e:
#     ee.FException(e)