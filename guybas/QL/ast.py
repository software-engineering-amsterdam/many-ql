# ast

class QuestionTypes:
    def __init__(self):
        pass

class Expression:
    def __init__(self, expression):
        self.expression = expression
        self.str_expression = str(expression)
        self.is_else = False

    def analyze(self):
        pass

    def evaluate(self):
        pass

    def dependencies(self):
        pass

    def ast_print(self, level=0):
        return "   " * level + self.str_expression

    def variables(self):
        pass


# Questions
class Question:
    def __init__(self, qid, qtype, label):
        self.id = qid
        self.label = label
        self.type = qtype

    def ast_print(self, level=0):
        s = "\n" + "   " * level + "Question:" + self.id + "\n"
        s += "   " * (level + 1) + self.label + "\n"
        s += "   " * (level + 1) + str(self.type)
        s += "\n"
        return s

    # Getters
    def get_label(self):
        return self.label

    def get_type(self):
        return self.type

    def get_id(self):
        return self.id

    def all_ids(self):
        return [self.id]

    def all_labels(self):
        return [self.label]


class AdvancedQuestions(Question):
    def __init__(self, condition, questions):
        self.condition = condition
        self.questions = questions
        self.else_questions = []

    def dependencies(self):
        return self.condition.variables()

    def add_else(self, questions):
        self.else_questions = questions

    def ast_print(self, level=0):
        s = "\n" + "   " * level + "If (" + self.condition.ast_print(0) + ")"
        for question in self.questions:
            s += "   " * level + question.ast_print(level+1)
        if self.else_questions:
            s += "   " * level + "else"
            for i in self.else_questions:
                s += "   " * level + i.ast_print(level+1)
        return s

    def get_c_questions(self):
        return self.questions

    def get_condition(self):
        return self.condition.ast_print()

    def all_ids(self):
        ids = []
        for question in self.questions:
            ids += question.all_ids()
        for question in self.else_questions:
            ids += question.all_ids()
        return ids

    def all_labels(self):
        labels = []
        for label in self.questions:
            labels += label.all_labels()
        for question in self.else_questions:
            labels += label.all_labels()
        return labels

    def get_e_questions(self):
        return self.else_questions


class Form:
    def __init__(self, name, introduction, questions):
        self.name = name 
        self.questions = questions
        self.introduction = introduction

    def ast_print(self):
        s = self.name + "\n"
        s += self.introduction + "\n"
        for i in self.questions:
            s += i.ast_print(1)
        return s

    def get_questions(self):
        return self.questions

    def get_name(self):
        return self.name

    def get_introduction(self):
        return self.introduction
