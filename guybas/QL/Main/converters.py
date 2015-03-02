import hashlib


class Converters:

    @staticmethod
    def get_md5(string):
        """
        Converting a string to MD5 hash
        :param str string: the text to decode
        :return str: MD5 hash
        """
        return hashlib.md5(bytes(str(string), encoding='utf-8')).hexdigest()