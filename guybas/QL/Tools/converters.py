import hashlib
import QL.config as c


def dict_to_xml(d):
    """
    Turn a simple dict of key/value pairs into XML
    """
    xml = "<?xml version='1.0' encoding='UTF-8'?>\n<grammar>\n"
    for key, val in d.items():
        xml += "    <question>\n"
        xml += "        <identifier>" + str(key) + "</identifier>\n"
        xml += "        <answer>" + str(val) + "</answer>\n"
        xml += "    </question>\n"
    xml += "</grammar>"
    return xml


def export_answers(answers_map, gui):
    xml = dict_to_xml(answers_map.get_answers())
    f = open(c.Config.output_path, 'w')
    f.write(xml)
    f.close()
    print("done")
    gui.close()