import QL.Tools.exceptions as exceptions


class AnswersMap:
    # map from _id to answers
    def __init__(self):
        self.answers = {}  # {qid: {_answer: input, pointsTo: List}}
        self.inputObj = {}

    def update(self, qid, answer):
        self.answers[qid] = answer

    def get_answers(self):
        return self.answers

    def get_answer_by_id(self, qid):
        if qid in self.answers:
            return self.answers[qid]
        return None

    def exists(self, qid):
        return qid in self.answers