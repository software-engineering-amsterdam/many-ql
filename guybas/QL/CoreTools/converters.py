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