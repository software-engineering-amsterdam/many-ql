from collections import Counter


class TypeChecker:
    def __init__(self, form, sheet):
        self._form = form
        self._sheet = sheet
        self._sheet_ids = sheet.ids()
        self._sheet_property_names = sheet.get_property_names()
        self._form_type_dict = form.id_type_map()
        self._form_ids = form.ids()

    def is_valid(self):
        valid = True
        double_message = TypeChecker.check_duplicates(self._sheet_ids)
        if double_message:
            print("Doubles:")
            print(double_message)
            valid = False

        exist_message = TypeChecker.check_existent(self._sheet_ids, self._form_ids)
        if exist_message:
            print("Not existent:")
            print(exist_message)
            valid = False

        widget_message = TypeChecker.check_types_widgets(self._sheet.get_widget_dict(), self._form_type_dict)
        if widget_message:
            print("Not correct get_widget:")
            print(widget_message)
            valid = False

        property_message = TypeChecker.check_duplicate_properties(self._sheet_property_names)
        if property_message:
            print("Duplicate properties:")
            print(property_message)

        return valid


    @staticmethod
    def check_existent(sheet_ids, form_ids):
        message = ""
        for i in sheet_ids:
            if i not in form_ids:
                message += i + " does not exist in the Sheet\n"
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
                    message += "the _type of " + t + " is not supported by get_widget" +  str(widget_dict[t]) + "\n"
        return message

    @staticmethod
    def check_duplicate_properties(properties):
        existent = []
        message = ""
        for p in properties:
            if p in existent:
                message += p + " exists more than once\n"
            existent.append(p)
        return message