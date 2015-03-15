def exceptions_handling(e):
    print("Error occured!")
    print
    print(type(e))
    print(e)

    #exc_type, exc_obj, exc_tb = expression_factory.exc_info()
    #fname = os.path.split(exc_tb.tb_frame.f_code.co_filename)[1]
    #print(exc_type, fname, exc_tb.tb_lineno)


class QException(Exception):
    pass