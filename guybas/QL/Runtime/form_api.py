import QL.AST.Statements.question as q
import QL.AST.form as f


class FormAPI:

    # initialize as a normal
    def __init__(self, form):
        self._form = form
        self._statement_dict = form.get_statement_dict()
        self.new_questions = self.change_statements(form.get_statement_dict())

    def change_statements(self, d):
        new_questions = []
        for s in d:
            nqs = RQuestion(d[s].get_id(), d[s].get_type(), d[s].get_label())
            nqs.set_order(d[s].get_order())
            nqs.set_parent_condition(d[s].get_parent_condition())
            self._statement_dict[s] = nqs
            new_questions.append(nqs)
        return new_questions

    def get_statements(self):
        return self.new_questions

    def get_statement_dict(self):
        return self._statement_dict

    def get_dependencies(self):
        return self._form.get_dependencies()

    def get_name(self):
        return self._form.get_name()

    def get_introduction(self):
        return self._form.get_introduction()


class RQuestion(q.Question):
    def __init(self, qid, qtype, label):
        super(RQuestion, self).__init__(qid, qtype, label)

    def set_order(self, order_num):
        self._order = order_num

    def pretty_print(self, level=0):
        s = "Runtime "
        s += super(RQuestion, self).pretty_print(level)
        return s
