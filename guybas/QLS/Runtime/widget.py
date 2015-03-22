import QLS.AST.Properties.constants as constants


class Widget:
    def __init__(self, question_style):
        self.widget = question_style.get_widget()
        self.property_map = self.widget.property_map()

    def __enrich_widget(self, question_style):
        widget = question_style.get_widget()
        for i in widget.default_settings():
            if i in self.property_map:
                setattr(self, i, self.property_map[i])
            else:
                setattr(self, i, constants.PROPERTIES[i])

    def get_color(self):
        return self.color

    def get_font(self):
        return self.font

    def get_width(self):
        return self.width

    def get_height(self):
        return self.height

    def get_size(self):
        return self.size