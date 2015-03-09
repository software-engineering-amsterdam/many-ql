import QLS.Grammar.qls as q
import QLS.Validators.type_checker as t
import QL.Grammar.basic_types as b
import QL.Grammar.form as f

qls = q.QLSFactory.make_sheet(q.QLS.sheet.parseFile("example.qls"))
#print(qls.pretty_print())

formAsParseResults = f.FormFormat.form.ignore(b.BasicTypes.comment).parseFile("example.ql")
f = f.forms.FormFactory.make_form(formAsParseResults)
#print(f.get_type_dict())
checker = t.TypeChecker(f, qls)