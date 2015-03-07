import QLS.AST.Sheet.page as p


# Create default setting for a question type
class Default(p.Page):
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