import hashlib
import xml.etree.ElementTree as Et

class Converters:

    @staticmethod
    def get_md5(string):
        """
        Converting a string to MD5 hash
        :param str string: the text to decode
        :return str: MD5 hash
        """
        return hashlib.md5(bytes(str(string), encoding='utf-8')).hexdigest()

    @staticmethod
    def dict_to_xml(tag, d):
        """
        Turn a simple dict of key/value pairs into XML
        """
        xml = "<?xml version='1.0' encoding='UTF-8'?>\n\r<form>\n\r"
        for key, val in d.items():
            xml += "    <question>\n\r"
            xml += "        <identifier>" + str(key) + "</identifier>\n\r"
            xml += "        <answer>" + str(val) + "</answer>\n\r"
            xml += "    </question>\n\r"
        xml += "</form>"
        return xml