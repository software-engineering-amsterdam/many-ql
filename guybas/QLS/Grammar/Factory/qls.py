import QLS.AST.Sheet.question_style as q
import QLS.AST.Sheet.page as p
import QLS.AST.Sheet.section as s
import QLS.AST.Sheet.sheet as sh
import QLS.AST.Sheet.default as d


def make_font(tokens):
    pass


def make_question_style(tokens):
    qid = tokens[0]
    if len(tokens) > 1:
        widget = tokens[1]
    else:
        widget = None
    return q.QuestionStyle(qid, widget)


def make_section(tokens):
    name = tokens[0]
    question_styles = tokens[1]
    return s.Section(name, question_styles)


def make_default(tokens):
    qtype = tokens[0]
    widget = tokens[1]
    if len(tokens) > 2:
        properties = tokens[2]
    else:
        properties = []
    return d.Default(qtype, widget, properties)


def make_page(tokens):
    name = tokens[0]
    sections = tokens[1]
    return p.Page(name, sections)


def make_sheet(tokens):
    name = tokens[0]
    pages = tokens[1]
    return sh.Sheet(name, pages)