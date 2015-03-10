import QLS.AST.Properties.font as f
import QLS.AST.Properties.window as w


class PropertyFactory:

    @staticmethod
    def make_font(tokens):
        font = tokens[0]
        return f.Font(font)

    @staticmethod
    def make_size(tokens):
        size = tokens[0]
        return f.FontSize(size)

    @staticmethod
    def make_color(tokens):
        color = tokens[0]
        return f.FontColor(color)

    @staticmethod
    def make_width(tokens):
        width = tokens[0]
        return w.Width(width)

    @staticmethod
    def make_height(tokens):
        height = tokens[0]
        return w.Height(height)