import QLS.AST.Properties.constants as constants


class Widget:
    def __init__(self, question_style, properties):
        self.widget = question_style.get_widget()
        self.property_map = self.widget.property_map()

        self.__enrich_widget(properties)

    def __enrich_widget(self, properties):
        b = self.widget.widget_name() in properties
        for i in constants.PROPERTIES:
            if i in self.property_map:
                setattr(self, i, self.property_map[i])
            elif b and i in properties[self.widget.widget_name()]:
                setattr(self, i, properties[self.widget.widget_name()][i])
            else:
                setattr(self, i, constants.PROPERTIES[i])

    def get_color(self):
        return self.font_color

    def get_bg_color(self):
        return self.background_color

    def get_font(self):
        return self.font_family

    def get_width(self):
        return self.widget_width

    def get_height(self):
        return self.widget_height

    def get_size(self):
        return self.font_size

    def string_presentation(self, level=0):
        s = self.widget.string_presentation(level)
        s += str(self.property_map)
        return s
