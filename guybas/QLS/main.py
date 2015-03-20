import QLS.Grammar.qls as q
import QLS.Validators.type_checker as t
import QL.Grammar.grammar as b
import QL.Grammar.grammar as f1
import QLS.Grammar.Factory.qls as factory
import QLS.GUI.gui as g
import QL.Grammar.Factory.forms as f2
import QLS.Runtime.form as runtime_form
import QL.Tools.exceptions as ee

########## TODO: QLSBUGS: ##########
#TODO 2. functions get_colour etc are missing
# -> will work on it tonight (friday night)
#TODO 4. what to do in default page ?? (currently skipped)
# -> Default are defaults for widgets, not pages, IGNORE as it will be handled in the AST!
#TODO 6. (GUY) Move page for loop to runtime.form
####################################


# qls style
qls_ast = factory.make_sheet(q.sheet.parseFile("example.qls"))
#print(qls_ast.pretty_print())

#ql form
formAsParseResults = f1.form.ignore(b.comment).parseFile("example.ql")
form = f2.make_form(formAsParseResults)
checker = t.TypeChecker(form, qls_ast)
checker.is_valid()

enriched_form = runtime_form.Form(form)
questions_dict = enriched_form.get_statement_dict()

gui_pages = []

##################### gui #####################

for page in qls_ast.get_pages():
    if page.is_default():
        continue
    page_elements = []
    for section in page.get_sections():
        for q_style in section.get_question_styles():
            q_id = q_style.get_ids()[0]
            question = questions_dict[q_id]
            page_elements.append(question)
    gui_pages.append(page_elements)

gui = g.GUI(enriched_form, gui_pages)
gui.generate_gui()
gui.show()
