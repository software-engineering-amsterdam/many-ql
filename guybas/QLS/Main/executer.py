from QLS.Grammar.qls import *
from QLS.Validtors.type_checker import *
from QL.AST.form import *

qls = QLSFactory.make_sheet(QLS.sheet.parseFile("example.qls"))
print(qls.pretty_print())

#formAsParseResults = FormFormat.form.ignore(BasicTypes.comment).parseFile("ql_example.ql")
#form = FormFactory.make_form(formAsParseResults)
t = TypeChecker([], qls)