import hashlib
import xml.etree.ElementTree as Et


class Converters:

    @staticmethod
    def dict_to_xml(d):
        """
        Turn a simple dict of key/value pairs into XML
        """
        xml = "<?xml version='1.0' encoding='UTF-8'?>\n<form>\n"
        for key, val in d.items():
            xml += "    <question>\n"
            xml += "        <identifier>" + str(key) + "</identifier>\n"
            xml += "        <answer>" + str(val) + "</answer>\n"
            xml += "    </question>\n"
        xml += "</form>"
        return xml