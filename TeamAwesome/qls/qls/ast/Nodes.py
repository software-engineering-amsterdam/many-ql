class Node(object):
    def __init__(self, lineNumber):
        self.lineNumber = lineNumber

class QLS(object):
    def __init__(self, statements):
        super().__init__(0)
        self.statements = statements

class StylesheetStatement(Node):
    def __init__(self, identifier, statements, lineNumber):
        super().__init__(lineNumber)
        self.identifier = identifier
        self.statements = statements

    def __str__(self):
        return "StylesheetId:%s, line:%d" %(self.identifier, self.lineNumber)

class DefaultStatement(Node):
    def __init__(self, questionType, attributes, lineNumber):
        super().__init__(lineNumber)
        self.questionType = questionType
        self.attributes = attributes
        
    def __str__(self):
        return "defaultStatement, line:%d, questionType:%s" %(self.lineNumber, self.questionType)

class PageStatement(Node):
    def __init__(self, name, statements, lineNumber):
        super().__init__(lineNumber)
        self.name = name
        self.statements = statements
        
    def __str__(self):
        return "pageStatement, line:%d, name:%s" %(self.lineNumber, self.name)

class SectionStatement(Node):
    def __init__(self, name, statements, lineNumber):
        super().__init__(lineNumber)
        self.name = name
        self.statements = statements
        
    def __str__(self):
        return "sectionStatement, line:%d, name:%s" %(self.lineNumber, self.name)

class PageStatement(Node):
    def __init__(self, identifier, attributes, lineNumber):
        super().__init__(lineNumber)
        self.identifier = identifier
        self.attributes = attributes
        
    def __str__(self):
        return "questionStatement, line:%d, name:%s" %(self.lineNumber, self.identifier)

class StyleAttribute(Node):
    def __init__(self, name, value, lineNumber):
        super().__init__(lineNumber)
        self.name = name
        self.value = value

    def __str__(self):
        return "StyleAttribute, line:%d, name:%s, value:%s" %(self.lineNumber, self.name, self.value)

class Widget(Node):
    def __init__(self, widgetType, options, lineNumber):
        super().__init__(lineNumber)
        self.type = widgetType
        self.options = options

    def __str__(self):
        return "Wdiget, line:%d, type:%s" %(self.lineNumber, self.type)


    