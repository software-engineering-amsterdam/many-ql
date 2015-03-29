import QLS.Grammar.grammar as q
import QLS.Validators.type_checker as t
import QL.Grammar.grammar as b
import QL.Grammar.grammar as f1
import QLS.Grammar.Factory.qls as factory
import QLS.GUI.gui as g
import QL.Grammar.Factory.form as f2
import QLS.Runtime.sheet as runtime_form


# qls style
qls_ast = factory.make_sheet(q.sheet.parseFile("example.qls"))
print(qls_ast.string_presentation())

#ql form
formAsParseResults = f1.form.ignore(b.comment).parseFile("example.ql")

# We should get rid of this... It is not allowed..
form = f2.make_form(formAsParseResults)
checker = t.TypeChecker(form, qls_ast)
checker.is_valid()

# gui
enriched_form = runtime_form.Sheet(form, qls_ast)
gui = g.GUI(enriched_form)
gui.generate_gui()
gui.show()
