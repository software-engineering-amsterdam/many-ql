def make_sentence(tokens):
    return ' '.join(tokens) 


# Questions 
class Question:
    def __init__(self, qid, qtype, label):
        self.id = qid
        self.label = label
        self.type = qtype

    def __str__(self):
        s = "Question:" + str(self.id) + "\n"
        s += self.label + "\n"
        s += str(self.type)
        s += "\n"
        return s

    def get_label(self):
        return self.label

    def get_type(self):
        return self.type

    def get_id(self):
        return self.id


class ConditionalQuestions:
    def __init__(self, condition, questions):
        self.condition = condition
        self.questions = questions
        self.else_questions = []

    def add_else(self, questions):
        self.else_questions = questions

    def __str__(self):
        s = "Condition: Question " + "\n"
        for i in self.questions:
            s += str(i)
        return s

    def get_c_questions(self):
        return self.questions

    def get_condition(self):
        return self.condition


class Form:
    def __init__(self, name, introduction, questions):
        self.name = name 
        self.questions = questions
        self.introduction = introduction

    def __str__(self):
        s = self.name + "\n"
        for i in self.questions:
            s += str(i)
        return s

    def get_questions(self):
        return self.questions

    def get_name(self):
        return self.name

    def get_introduction(self):
        return self.introduction