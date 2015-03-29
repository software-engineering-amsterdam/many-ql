import QL.Runtime.form as ql_form
import QLS.Runtime.section as runtime_section
import QL.Tools.exceptions as exc
import QLS.AST.Sheet.sheet as qls
import QLS.Runtime.widget as widget
import QLS.Runtime.question as runtime_question
import importlib


class Sheet(ql_form.Form):
    def __init__(self, ql_ast, qls_ast):
        ql_form.Form.__init__(self, ql_ast)
        if not isinstance(qls_ast, qls.Sheet):
            raise exc.RuntimeException("Input must be a QLS AST!")

        self.__questions = []
        self.extract_statements(self._form_ast.statements(), importlib.import_module('QLS.Runtime.question'))

        self.qls_ast = qls_ast
        self.set_default_properties()
        self.gui_pages = self.__generate_pages()

    def __generate_pages(self):
        gui_pages = []
        for page in self.qls_ast.get_pages():
            if page.is_default():
                continue
            page_elements = self.__generate_sections(page)
            gui_pages.append(page_elements)
        return gui_pages

    def __generate_sections(self, page):
        page_elements = []
        order = 0
        for section in page.get_sections():
                section_obj = runtime_section.Section(order, section.get_name())
                page_elements.append(section_obj)
                for q_style in section.get_question_styles():
                    q_id = q_style.get_ids()[0]
                    w = widget.Widget(q_style, self.qls_ast.get_property_dict())
                    # get the actual question using the QL runtime form
                    question = self.__question_widget(q_id, w)
                    page_elements.append(question)
        return page_elements

    def set_default_properties(self):
        d = self.qls_ast.get_property_dict()
        for i in d:
            print("%s" % i, d[i])

    def __question_widget(self, q_id, widget):
        question = self.get_statement_dict()[q_id]
        question.set_bg_color(widget.get_color())
        question.set_fg_color(widget.get_bg_color())
        question.set_font_style(widget.get_font())
        return question
