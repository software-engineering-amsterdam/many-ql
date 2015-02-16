# Type Checker
import collections

class TypeChecker:

    def __init__(self, form):
        self.form = form
        ids = TypeChecker.check_ids(self.form.questions)
        labels = TypeChecker.check_labels(self.form.questions)
        print(labels)

    def check_duplicates(list):
        # check for duplicates
        duplicates =  [x for x, y in collections.Counter(list).items() if y > 1]
        if duplicates:
            return True
        return False

    def check_ids(questions):
        ids = []
        for question in questions:
            ids += (question.all_ids())
        #if TypeChecker.check_duplicates(ids):
           # print("There are duplicate ids")
        return ids

    def check_labels(questions):
        labels = []
        for question in questions:
            labels +=  question.all_labels()
        #TypeChecker.check_duplicates(labels)
        #if TypeChecker.check_duplicates(labels):
            #print("There are duplicate labels")
        return labels