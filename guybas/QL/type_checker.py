# Type Checker
import collections

class TypeChecker:

    def __init__(self, form):
        self.form = form
        ids = TypeChecker.check_ids(self.form.questions)
        labels = TypeChecker.check_labels(self.form.questions)
        print(labels)

    def join_lists(list):
        # join the list of lists
        join = [inner for outer in list for inner in outer]
        return join

    def check_duplicates(list):
        # check for duplicates
        duplicates =  [x for x, y in collections.Counter(list).items() if y > 1]
        if duplicates:
            return True
        return False

    def check_ids(questions):
        ids = []
        for question in questions:
            ids += question.get_id()
        ids = TypeChecker.join_lists(ids)
        if TypeChecker.check_duplicates(ids):
            print("There are duplicate ids")
        return ids

    def check_labels(questions):
        labels = []
        for question in questions:
            labels += question.get_label()
        labels = TypeChecker.join_lists(labels)
        TypeChecker.check_duplicates(labels)
        if TypeChecker.check_duplicates(labels):
            print("There are duplicate labels")
        return labels