import pyparsing as pp

import QL.Grammar.grammar as grammar
import QL.config as config
import QL.Grammar.Factory.form as form_factory

import QL.Runtime.form as runtime_form
import QL.GUI.gui as gui
import QL.Tools.exception_handling as exception_handling


def parse_file():
    pp.ParserElement.enablePackrat()
    form_without_comments = grammar.form.ignore(grammar.comment).parseFile(config.Config.input_path)
    return form_factory.make_form(form_without_comments)


def handle_type_exceptions(form):
    errors = []
    errors.extend(form.ids_error_messages())
    errors.extend(form.dependencies_error_messages())
    errors.extend(form.expression_type_error_messages())

    warnings = form.labels_error_messages()
    eh = exception_handling.TypeExceptionHandling(errors, warnings)
    eh.execute()


def show_gui(form):
    enriched_form = runtime_form.Form(form)
    g = gui.GUI(enriched_form)
    g.generate_gui()
    g.show()


def print_ast(form):
    print(form.string_presentation())

#
# The main function
#

form = parse_file()
print_ast(form)
handle_type_exceptions(form)
show_gui(form)

