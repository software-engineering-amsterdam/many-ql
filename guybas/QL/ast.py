# ast

class Expression:
    def __init__(self, expression):
        self.str_expression = expression
    def evaluate(self):
        pass
    def ast_print(self, level=0):
        return "   " * level + self.str_expression


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

    def ast_print(self, level=0):
        s = "\n" + "   " * level + "If (" + self.condition.ast_print(0) + ")"
        for i in self.questions:
            s += "   " * level + i.ast_print(level+1)
        if self.else_questions != []:
            s += "   " * level + "else"
            for i in self.else_questions:
                s += "   " * level + i.ast_print(level+1)
        return s

    def get_c_questions(self):
        return self.questions

    def get_condition(self):
        return self.condition.ast_print()


class Form:
    def __init__(self, name, introduction, questions):
        self.name = name 
        self.questions = questions
        self.introduction = introduction

    def __str__(self):
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