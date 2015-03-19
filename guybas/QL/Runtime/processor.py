import QL.Tools.converters as converters
import QL.config as c


# def eval_expression(expression, answers_map):
#     answers_dict = answers_map.get_answers()
#     # to avoid annoying (not applicable) error messages
#     answers_dict['__builtins__'] = None
#     try:
#         result = eval(expression, answers_dict)
#         return result
#     except Exception as e:
#         return False


def export_answers(answers_map, gui):
    xml = converters.Converters.dict_to_xml(answers_map.get_answers())
    f = open(c.Config.output_path, 'w')
    f.write(xml)
    f.close()
    print("done")
    gui.close()