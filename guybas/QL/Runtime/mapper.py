import QL.Tools.exceptions as exceptions


class Mapper:
    # map from _id to answers
    def __init__(self):
        self.answers = {}  # {qid: {_answer: input, pointsTo: List}}
        self.inputObj = {}

    def update(self, question, answer):
        qid = question.ast.get_id()
        self.answers[qid] = answer

    def get_answers(self):
        return self.answers

    def get_answer_by_id(self, qid):
        return self.answers[qid]

    def exists(self, qid):
        return qid in self.answers