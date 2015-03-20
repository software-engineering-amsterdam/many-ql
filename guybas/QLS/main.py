import QLS.Grammar.qls as q
import QLS.Validators.type_checker as t
import QL.Grammar.grammar as b
import QL.Grammar.grammar as f1
import QLS.Grammar.Factory.qls as factory
import QLS.GUI.gui as g
import QL.Grammar.Factory.forms as f2
import QLS.Runtime.form as runtime_form
import QL.Tools.exceptions as ee

########## QLS TO DO LIST: ##########
#TODO 1. (BAS) functions get_colour etc are missing
# -> will work on it tonight (friday night)
#TODO 2. (GUY+BAS) Debugging nested questions.
#TODO 3. (GUY) Debugging sections
####################################

# qls style
qls_ast = factory.make_sheet(q.sheet.parseFile("example.qls"))
#print(qls_ast.pretty_print())

#ql form
formAsParseResults = f1.form.ignore(b.comment).parseFile("example.ql")
form = f2.make_form(formAsParseResults)
checker = t.TypeChecker(form, qls_ast)
checker.is_valid()

# gui
enriched_form = runtime_form.Form(form, qls_ast)
gui = g.GUI(enriched_form)
gui.generate_gui()
gui.show()
