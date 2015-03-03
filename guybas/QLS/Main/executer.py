from QLS.Grammar.qls import *
from QLS.Validators.type_checker import *
import QL.AST.form as form
import QL.Grammar.form as form1

qls = QLSFactory.make_sheet(QLS.sheet.parseFile("example.qls"))
print(qls.pretty_print())

formAsParseResults = FormFormat.form.ignore(BasicTypes.comment).parseFile("ql_example.ql")
f = form1.forms.FormFactory.make_form(formAsParseResults)
t = TypeChecker(f, qls)