from grammar import *
try:
    formAsParseResults = FormFormat.form.ignore(BasicTypes.comment).parseFile("ql_example.ql")
    form = ASTReady.make_form(formAsParseResults)
    print(form)
    
    gui = QuestionnaireGUI(form)
    gui.generate_gui()
    gui.show()
except Exception as e:
    exceptions_handling(e)