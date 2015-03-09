import QLS.AST.property as p


class PropertyFactory:

    @staticmethod
    def make_font(tokens):
        font = tokens[0]
        return p.Font(font)

    @staticmethod
    def make_size(tokens):
        size = tokens[0]
        return p.FontSize

    @staticmethod
    def make_width(tokens):
        width = tokens[0]
        return p.Width(width)

    @staticmethod
    def make_height(tokens):
        height = tokens[0]
        return p.Height(height)

    @staticmethod
    def make_color(tokens):
        color = tokens[0]
        return p.Color(color)