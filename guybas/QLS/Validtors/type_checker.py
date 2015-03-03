from QLS.AST.sheet import *
from QL.AST.form import *


class TypeChecker:
    def __init__(self, form, sheet):
        self.form = form
        self.sheet = sheet
        print(sheet.get_ids())

    def check_ids(sheet_ids, form_ids):
        pass