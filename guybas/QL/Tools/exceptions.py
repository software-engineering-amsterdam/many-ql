import pyparsing as pp

def exceptions_handling(e):
    print("Error occured!")
    print(type(e))
    print(e)

    #exc_type, exc_obj, exc_tb = expression_factory.exc_info()
    #fname = os.path.split(exc_tb.tb_frame.f_code.co_filename)[1]
    #print(exc_type, fname, exc_tb.tb_lineno)


class QException(Exception):
    pass


class FException:
    def __init__(self, e):
        print(type(e))

        if type(e) is pp.ParseException:
            print("the parsing went wrong:")
            print(e)
        elif type(e) is QException:
            print("something went wrong in the processing:")
            print(e)
        else:
            print("very general exception..")
            print(e)
