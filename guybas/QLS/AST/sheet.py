# AST for sheets, pages and sections


class Sheet:
    def __init__(self, name, pages):
        self.name = name
        self.pages = pages

    def pretty_print(self, level=0):
        s = "    " * level + "Sheet " + self.name + "\n"
        for p in self.pages:
            s += p.pretty_print(level + 1)
        return s

    def get_ids(self):
        ids = []
        for q in self.pages:
            ids += q.id_collection()
        return ids

    def get_id_widget_dict(self):
        pass


class Page:
    def __init__(self, name, sections):
        self.name = name
        self.sections = sections

    def pretty_print(self, level=0):
        s = "\n" + "    " * level + "Page " + self.name + "\n"
        for p in self.sections:
            s += p.pretty_print(level+1)
        return s

    def id_collection(self):
        ids = []
        for q in self.sections:
            ids += q.id_collection()
        return ids


class Section:
    def __init__(self, name, question_styles):
        self.name = name
        self.question_styles = question_styles

    def pretty_print(self, level=0):
        s = "\n" + "    " * level + "Section " + self.name + "\n"
        for p in self.question_styles:
            s += p.pretty_print(level + 1)
        return s

    def id_collection(self):
        ids = []
        for q in self.question_styles:
            ids += q.id_collection()
        return ids


class QuestionStyle:
    def __init__(self, qid, widget):
        self.id = qid
        self.widget = widget

    def pretty_print(self, level=0):
        s = "    " * level + "Question " + self.id + "\n"
        s += self.widget.pretty_print(level + 1)
        return s

    def id_collection(self):
        return [self.id]


class Default(Page):
    def __init__(self, qtype, widget, properties):
        self.type = qtype
        self.widget = widget
        self.properties = properties

    def pretty_print(self, level=0):
        s = "\n" + "    " * level + "Default " + self.type
        s += " " + self.widget.pretty_print(0)
        if self.properties:
            s += "    " * level + str(self.properties)
        return s

    def id_collection(self):
        return []