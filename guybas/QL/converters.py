import hashlib


class Converters:
    @staticmethod
    def rlist2string(a):
        """
        Converting a recursive list into a string
        :param list|str a: the list
        :return str: string
        """
        res = ''
        if isinstance(a, list):
            for item in a:
                res += str(Converters.rlist2string(item)) + ' '
        else:
            res = str(a)
        return res

    @staticmethod
    def get_md5(string):
        """
        Converting a string to MD5 hash
        :param str string: the text to decode
        :return str: MD5 hash
        """
        return hashlib.md5(bytes(str(string), encoding='utf-8')).hexdigest()