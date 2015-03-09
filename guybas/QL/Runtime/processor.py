import QL.CoreTools.converters as converters


class Processor:

    @staticmethod
    def eval_expression(expression, answers_map):
        answers_dict = answers_map.get_answers()
        # to avoid annoying (not applicable) error messages
        answers_dict['__builtins__'] = None
        try:
            result = eval(expression, answers_dict)
            return result
        except Exception as e:
            print(e)
            return False

    @staticmethod
    def export_answers(answers_map, gui):
        xml = converters.Converters.dict_to_xml('answer', answers_map.get_answers())
        f = open('answers.xml', 'w')
        f.write(xml)
        f.close()
        print("done")
        gui.close()