import QLS.AST.Sheet.question_style as q
import QLS.AST.Sheet.page as p
import QLS.AST.Sheet.section as s
import QLS.AST.Sheet.sheet as sh
import QLS.AST.Sheet.default as d


class QLSFactory:
    @staticmethod
    def make_font(tokens):
        pass

    @staticmethod
    def make_question_style(tokens):
        if len(tokens) > 1:
            widget = tokens[1]
        else:
            widget = None
        return q.QuestionStyle(tokens[0], widget)

    @staticmethod
    def make_section(tokens):
        return s.Section(tokens[0], tokens[1])

    @staticmethod
    def make_default(tokens):
        print(tokens)
        if len(tokens) == 2:
            x = d.Default(tokens[0], tokens[1], [])
            print(x)
            return x
        else:
            return d.Default(tokens[0], tokens[1], tokens[2])

    @staticmethod
    def make_page(tokens):
        return p.Page(tokens[0], tokens[1])

    @staticmethod
    def make_sheet(tokens):
        return sh.Sheet(tokens[0], tokens[1])