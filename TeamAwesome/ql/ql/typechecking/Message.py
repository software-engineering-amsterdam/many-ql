class Message:
    def __init__(self, scope, level, text):
        self._scope = scope
        self._level = level 
        self._text = text

    @property
    def scope(self):
        return self._scope

    @property
    def level(self):
        return self._level

    @property
    def text(self):
        return self._text

    def __str__(self):
        level = str(self.level)
        scope = str(self.scope)
        text = self.text

        prefixParts = list(filter(lambda p: p != '', [level,scope]))
        prefix = ' '.join(prefixParts)

        if prefix == '':
            return text
        else:
            return prefix + ': ' + text



class Scope:
    def __str__(self):
        raise NotImplementedError



class Local(Scope):
    def __init__(self, lineNumber):
        self._lineNumber = lineNumber

    def __str__(self):
        return 'line '+str(self._lineNumber)



class Global(Scope):
    def __str__(self):
        return ''



class Level:
    def __str__(self):
        raise NotImplementedError



class Warning(Level):
    def __str__(self):
        return 'WARNING'



class Error(Level):
    def __str__(self):
        return 'ERROR'
