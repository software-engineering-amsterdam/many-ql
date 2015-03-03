from QLS.AST.sheet import *
from QL.AST.form import *
from collections import Counter


class TypeChecker:
    def __init__(self, form, sheet):
        self.form = form
        self.sheet = sheet
        print(TypeChecker.check_duplicates(sheet.get_ids()))

    @staticmethod
    def check_existent(sheet_ids, form_ids):
        message = ""
        for i in sheet_ids:
            if i not in form_ids:
                message += i + "does not exist in the Form"
        return message

    @staticmethod
    def check_duplicates(sheet_ids):
        message = ""
        occurrences = Counter(sheet_ids)
        for i in occurrences:
            if occurrences[i] > 1:
                message += i + " occurs more than once"
        return message