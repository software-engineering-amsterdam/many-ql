import QLS.Grammar.grammar as q
import QLS.Validators.type_checker as t
import QL.Grammar.grammar as b
import QL.Grammar.grammar as f1
import QLS.Grammar.Factory.qls as factory
import QLS.GUI.gui as g
import QL.Grammar.Factory.form as f2
import QLS.Runtime.sheet as runtime_form
import QL.Tools.exceptions as ee

########## QLS TO DO LIST: ##########
# TODO 1. (GUY+BAS) Debugging nested questions.
# TODO 3. (GUY) Make widgets (slider, dropdown, checkbox)
# -> checkbox has just one option, radio has two (the names are given), and dropdown as well 2 (names are given)
# -> See the pretty printed AST how it looks like
# TODO 4. (GUY) Display page name
# TODO 5. (GUY + BAS) Make sure answers are evaluated (they are not now!)
# TODO 6. (BAS) improve the type checker
# TODO 7. (GUY + BAS) see quote Tijs:
# -> The QL code, and especially, the QL ASTs should be oblivious to the QLS code. Think about how you can achieve that.
# -> We need to only use run time form in QLS
# TODO 8. (BAS) properties more clean and fully working
####################################

# qls style
qls_ast = factory.make_sheet(q.sheet.parseFile("example.qls"))
print(qls_ast.string_presentation())

#ql form
formAsParseResults = f1.form.ignore(b.comment).parseFile("example.ql")

# We should get rid of this... It is not allowed..
form = f2.make_form(formAsParseResults)
# checker = t.TypeChecker(form, qls_ast)
# checker.is_valid()

# gui
enriched_form = runtime_form.Sheet(form, qls_ast)
gui = g.GUI(enriched_form)
gui.generate_gui()
gui.show()
