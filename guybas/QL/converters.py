import hashlib


class Converters:
    @staticmethod
    def rlist2string(a):
        res = ''
        if isinstance(a, list):
            for item in a:
                res += str(Converters.rlist2string(item)) + ' '
        else:
            res = str(a)
        return res

    @staticmethod
    def get_md5(string):
        return hashlib.md5(bytes(str(string), encoding='utf-8')).hexdigest()