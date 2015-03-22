import QLS.AST.Sheet.sheet_element as e
import QLS.AST.Properties.constants as constants


# Question style AST
class QuestionStyle(e.SheetElement):

    def __init__(self, qid, widget, props={}):
        self._id = qid
        self._widget = widget
        self.set_properties(props)

    def string_presentation(self, level=0):
        s = "    " * level + "Question " + self._id + "\n"
        s += self._widget.string_presentation(level + 1)
        # for i in constants.PROPERTIES:
        #     s += "    " * (level + 1) + i + ":" + getattr(self, i) + "\n"
        return s

    def get_ids(self):
        return [self._id]

    def get_widget_dict(self):
        return {self._id : self._widget}

    def is_default(self):
        return False

    def set_properties(self, property_map):
        for i in constants.PROPERTIES:
            if i in property_map:
                setattr(self, i, property_map[i])
            else:
                setattr(self, i, constants.PROPERTIES[i])

    #
    # Properties
    #

    def setter(self, a, v):
        setattr(self, '_%s' % a, v)

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



