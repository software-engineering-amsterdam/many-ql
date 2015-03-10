from collections import Counter


class TypeChecker:
    def __init__(self, form, sheet):
        self.form = form
        self.sheet = sheet
        sheet_ids = sheet.get_ids()
        print("\nType checker: \n")

        print("Doubles:")
        print(TypeChecker.check_duplicates(sheet_ids))

        print("Not existent:")
        print(TypeChecker.check_existent(sheet_ids, form.get_ids()))

        print("Not correct widget:")
        print(TypeChecker.check_types_widgets(sheet.get_widget_dict(), form.get_type_dict()))

    @staticmethod
    def check_existent(sheet_ids, form_ids):
        message = ""
        for i in sheet_ids:
            if i not in form_ids:
                message += i + " does not exist in the Form\n"
        return message

    @staticmethod
    def check_duplicates(sheet_ids):
        message = ""
        occurrences = Counter(sheet_ids)
        for i in occurrences:
            if occurrences[i] > 1:
                message += i + " is used more than once\n"
        return message

    @staticmethod
    def check_all_used(sheet_ids, form_ids):
        message = ""
        for i in form_ids:
            if i not in sheet_ids:
                message += i + " exists but is not used\n"
        return message

    @staticmethod
    def check_types_widgets(widget_dict, type_dict):
        message = ""
        for t in type_dict:
            if t in widget_dict:
                if not type_dict[t] in widget_dict[t].get_compatible():
                    message += "the _type of " + t + " is not supported by widget" +  str(widget_dict[t]) + "\n"
        return message