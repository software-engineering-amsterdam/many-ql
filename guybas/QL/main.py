import pyparsing as pp

# TODO: consist import names
import QL.Grammar.grammar as grammar
import QL.config as c
import QL.Grammar.Factory.form as form_factory

import QL.Runtime.form as runtime_form
import QL.GUI.gui as g
import QL.Tools.exception_handling as exception_handling
import QL.Tools.exceptions as ee


def parse_file():
    pp.ParserElement.enablePackrat()
    form_without_comments = grammar.form.ignore(grammar.comment).parseFile(c.Config.input_path)
    return form_factory.make_form(form_without_comments)


def handle_type_exceptions(form):
    errors = []
    errors.extend(form.check_ids())
    errors.extend(form.check_dependencies())
    errors.extend(form.check_expressions())

    warnings = form.check_labels()
    eh = exception_handling.TypeExceptionHandling(errors, warnings)
    eh.execute()


def show_gui(form):
    enriched_form = runtime_form.Form(form)
    gui = g.GUI(enriched_form)
    gui.generate_gui()
    gui.show()


def print_ast(form):
    print(form.string_presentation())

#
# The main function
#
form = parse_file()
handle_type_exceptions(form)

show_gui(form)

# except Exception as e:
#     ee.FactoryException(e)


