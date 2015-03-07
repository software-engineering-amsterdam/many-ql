import QL.Validators.type_checker as type_checker
import QL.Main.exceptions as exceptions


class Mapper:
    # map from _id to answers
    def __init__(self):
        self.answers = {}  # {qid: {answer: input, pointsTo: List}}
        self.inputObj = {}

    def update(self, question, answer):
        qid = question.get_id()
        self.answers[qid] = answer

    def get_answers(self):
        return self.answers

    def get_answer_by_id(self, qid):
        if qid in self.answers.keys():
            return self.answers[qid]
        raise exceptions.QException("Answer _id " + qid + " does not exist.")

    def id_exists(self, qid):
        if qid in self.answers.keys():
            return True
        return False