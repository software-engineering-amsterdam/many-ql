import QLS.Grammar.qls as q
import QLS.Validators.type_checker as t
import QL.Grammar.basic_types as b
import QL.Grammar.form as f
import QLS.Factory.qls as ql
qls = ql.QLSFactory.make_sheet(q.QLS.sheet.parseFile("example.qls"))
#print(qls.pretty_print())

print(qls.get_property_dict())
formAsParseResults = f.Form.form.ignore(b.BasicTypes.comment).parseFile("example.ql")
f = f.forms.FormFactory.make_form(formAsParseResults)
checker = t.TypeChecker(f, qls)

# TODO: all imports in init