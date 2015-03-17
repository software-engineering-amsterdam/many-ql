import QLS.Grammar.qls as q
import QLS.Validators.type_checker as t
import QL.Grammar.grammar as b
import QL.Grammar.grammar as f1
import QLS.Factory.qls as ql
import QLS.GUI.gui as g
import QL.Grammar.Factory.forms as f2
qls = ql.QLSFactory.make_sheet(q.QLS.sheet.parseFile("example.qls"))
print(qls.pretty_print())

print(qls.get_property_dict())
formAsParseResults = f1.form.ignore(b.comment).parseFile("example.ql")
f = f2.make_form(formAsParseResults)
checker = t.TypeChecker(f, qls)

print(f)
pages = [1,2,3]
gui = g.GUI.draw_pages(pages)

