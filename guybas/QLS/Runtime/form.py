import QL.Runtime.form as ql_form
import QLS.Runtime.question as runtime_question
import QLS.Runtime.section as runtime_section
import QL.Tools.exceptions as exc
import QLS.AST.Sheet.sheet as qls


class Form(ql_form.Form):
    def __init__(self, ql_ast, qls_ast):
        ql_form.Form.__init__(self, ql_ast)
        if not isinstance(qls_ast, qls.Sheet):
            raise exc.QException("Input must be a QLS AST!")
        self.qls_ast = qls_ast
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
                section_obj = runtime_section.Section(order)
                page_elements.append(section_obj)
                for q_style in section.get_question_styles():
                    q_id = q_style.get_ids()[0]
                    question = self.get_statement_dict()[q_id]
                    page_elements.append(question)
        return page_elements

    def __enrich_questions(self):
        """
        takes the basic ast questions and generate new enriched question objects
        with gui element, order and other useful stuff for runtime.
            self.__ast_questions = list of questions based on the ast only
            self.__q_conditions_dict = dict of the questions with their parent conditions
            self.questions = new enriched questions
        """
        order = 0
        for basic_question in self.__ast_questions:
            qid = basic_question.get_id()
            if qid not in self.__q_conditions_dict:
                raise exc.QException("Fatal Error: id does not exist in the dict!")
            enriched_question = runtime_question.Question(basic_question, order, self.__q_conditions_dict[qid])
            self.questions.append(enriched_question)
            order += 1