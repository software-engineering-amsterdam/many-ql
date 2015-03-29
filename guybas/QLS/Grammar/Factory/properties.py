import QLS.AST.Properties.font as f
import QLS.AST.Properties.window as w


def make_font(tokens):
    font = tokens[0]
    return f.Font(font)


def make_size(tokens):
    size = tokens[0]
    return f.FontSize(size)


def make_color(tokens):
    color = tokens[0]
    return f.FontColor(color)


def make_width(tokens):
    width = tokens[0]
    return w.Width(width)


def make_height(tokens):
    height = tokens[0]
    return w.Height(height)


def make_background_color(tokens):
    color = tokens[0]
    return f.BackgroundColor(color)