# Generated from java-escape by ANTLR 4.5
# encoding: utf-8
from antlr4 import *
from io import StringIO
package = globals().get("__package__", None)
ischild = len(package)>0 if package is not None else False
if ischild:
    from .QLSListener import QLSListener
    from .QLSVisitor import QLSVisitor
else:
    from QLSListener import QLSListener
    from QLSVisitor import QLSVisitor

def serializedATN():
    with StringIO() as buf:
        buf.write("\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\34")
        buf.write("\u0094\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7")
        buf.write("\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16")
        buf.write("\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22\4\23\t\23")
        buf.write("\3\2\7\2(\n\2\f\2\16\2+\13\2\3\3\3\3\3\3\3\3\3\3\5\3\62")
        buf.write("\n\3\3\4\3\4\3\4\3\4\7\48\n\4\f\4\16\4;\13\4\3\4\3\4\3")
        buf.write("\5\3\5\3\5\3\5\7\5C\n\5\f\5\16\5F\13\5\3\5\3\5\3\6\3\6")
        buf.write("\3\6\3\6\3\7\3\7\3\7\3\7\7\7R\n\7\f\7\16\7U\13\7\3\7\3")
        buf.write("\7\3\b\3\b\3\b\3\b\7\b]\n\b\f\b\16\b`\13\b\3\b\3\b\3\t")
        buf.write("\3\t\3\t\3\t\7\th\n\t\f\t\16\tk\13\t\3\t\5\tn\n\t\3\n")
        buf.write("\3\n\3\13\3\13\3\13\5\13u\n\13\3\f\3\f\3\r\3\r\3\r\3\r")
        buf.write("\3\r\5\r~\n\r\3\16\3\16\3\17\3\17\3\17\7\17\u0085\n\17")
        buf.write("\f\17\16\17\u0088\13\17\3\20\3\20\5\20\u008c\n\20\3\21")
        buf.write("\3\21\3\22\3\22\3\23\3\23\3\23\2\2\24\2\4\6\b\n\f\16\20")
        buf.write("\22\24\26\30\32\34\36 \"$\2\4\3\2\13\16\3\2\21\26\u0091")
        buf.write("\2)\3\2\2\2\4\61\3\2\2\2\6\63\3\2\2\2\b>\3\2\2\2\nI\3")
        buf.write("\2\2\2\fM\3\2\2\2\16X\3\2\2\2\20c\3\2\2\2\22o\3\2\2\2")
        buf.write("\24t\3\2\2\2\26v\3\2\2\2\30x\3\2\2\2\32\177\3\2\2\2\34")
        buf.write("\u0081\3\2\2\2\36\u008b\3\2\2\2 \u008d\3\2\2\2\"\u008f")
        buf.write("\3\2\2\2$\u0091\3\2\2\2&(\5\4\3\2\'&\3\2\2\2(+\3\2\2\2")
        buf.write(")\'\3\2\2\2)*\3\2\2\2*\3\3\2\2\2+)\3\2\2\2,\62\5\6\4\2")
        buf.write("-\62\5\b\5\2.\62\5\f\7\2/\62\5\16\b\2\60\62\5\20\t\2\61")
        buf.write(",\3\2\2\2\61-\3\2\2\2\61.\3\2\2\2\61/\3\2\2\2\61\60\3")
        buf.write("\2\2\2\62\5\3\2\2\2\63\64\7\3\2\2\64\65\5 \21\2\659\7")
        buf.write("\4\2\2\668\5\4\3\2\67\66\3\2\2\28;\3\2\2\29\67\3\2\2\2")
        buf.write("9:\3\2\2\2:<\3\2\2\2;9\3\2\2\2<=\7\5\2\2=\7\3\2\2\2>?")
        buf.write("\7\6\2\2?@\5\26\f\2@D\7\4\2\2AC\5\n\6\2BA\3\2\2\2CF\3")
        buf.write("\2\2\2DB\3\2\2\2DE\3\2\2\2EG\3\2\2\2FD\3\2\2\2GH\7\5\2")
        buf.write("\2H\t\3\2\2\2IJ\5\22\n\2JK\7\7\2\2KL\5\24\13\2L\13\3\2")
        buf.write("\2\2MN\7\b\2\2NO\5\"\22\2OS\7\4\2\2PR\5\4\3\2QP\3\2\2")
        buf.write("\2RU\3\2\2\2SQ\3\2\2\2ST\3\2\2\2TV\3\2\2\2US\3\2\2\2V")
        buf.write("W\7\5\2\2W\r\3\2\2\2XY\7\t\2\2YZ\5\"\22\2Z^\7\4\2\2[]")
        buf.write("\5\4\3\2\\[\3\2\2\2]`\3\2\2\2^\\\3\2\2\2^_\3\2\2\2_a\3")
        buf.write("\2\2\2`^\3\2\2\2ab\7\5\2\2b\17\3\2\2\2cd\7\n\2\2dm\5 ")
        buf.write("\21\2ei\7\4\2\2fh\5\n\6\2gf\3\2\2\2hk\3\2\2\2ig\3\2\2")
        buf.write("\2ij\3\2\2\2jl\3\2\2\2ki\3\2\2\2ln\7\5\2\2me\3\2\2\2m")
        buf.write("n\3\2\2\2n\21\3\2\2\2op\7\32\2\2p\23\3\2\2\2qu\5$\23\2")
        buf.write("ru\5\"\22\2su\5\30\r\2tq\3\2\2\2tr\3\2\2\2ts\3\2\2\2u")
        buf.write("\25\3\2\2\2vw\t\2\2\2w\27\3\2\2\2x}\5\32\16\2yz\7\17\2")
        buf.write("\2z{\5\34\17\2{|\7\20\2\2|~\3\2\2\2}y\3\2\2\2}~\3\2\2")
        buf.write("\2~\31\3\2\2\2\177\u0080\t\3\2\2\u0080\33\3\2\2\2\u0081")
        buf.write("\u0086\5\36\20\2\u0082\u0083\7\27\2\2\u0083\u0085\5\36")
        buf.write("\20\2\u0084\u0082\3\2\2\2\u0085\u0088\3\2\2\2\u0086\u0084")
        buf.write("\3\2\2\2\u0086\u0087\3\2\2\2\u0087\35\3\2\2\2\u0088\u0086")
        buf.write("\3\2\2\2\u0089\u008c\5$\23\2\u008a\u008c\5\"\22\2\u008b")
        buf.write("\u0089\3\2\2\2\u008b\u008a\3\2\2\2\u008c\37\3\2\2\2\u008d")
        buf.write("\u008e\7\32\2\2\u008e!\3\2\2\2\u008f\u0090\7\30\2\2\u0090")
        buf.write("#\3\2\2\2\u0091\u0092\7\31\2\2\u0092%\3\2\2\2\16)\619")
        buf.write("DS^imt}\u0086\u008b")
        return buf.getvalue()


class QLSParser ( Parser ):

    grammarFileName = "java-escape"

    atn = ATNDeserializer().deserialize(serializedATN())

    decisionsToDFA = [ DFA(ds, i) for i, ds in enumerate(atn.decisionToState) ]

    sharedContextCache = PredictionContextCache()

    literalNames = [ u"<INVALID>", u"'stylesheet'", u"'{'", u"'}'", u"'default'", 
                     u"':'", u"'page'", u"'section'", u"'question'", u"'boolean'", 
                     u"'integer'", u"'string'", u"'money'", u"'('", u"')'", 
                     u"'spinbox'", u"'yesno-radio'", u"'yesno-dropdown'", 
                     u"'checkbox'", u"'text'", u"'slider'", u"','" ]

    symbolicNames = [ u"<INVALID>", u"<INVALID>", u"<INVALID>", u"<INVALID>", 
                      u"<INVALID>", u"<INVALID>", u"<INVALID>", u"<INVALID>", 
                      u"<INVALID>", u"<INVALID>", u"<INVALID>", u"<INVALID>", 
                      u"<INVALID>", u"<INVALID>", u"<INVALID>", u"<INVALID>", 
                      u"<INVALID>", u"<INVALID>", u"<INVALID>", u"<INVALID>", 
                      u"<INVALID>", u"<INVALID>", u"STRING", u"INTEGER", 
                      u"IDENTIFIER", u"WS", u"COMMENT" ]

    RULE_qls = 0
    RULE_nested_statement = 1
    RULE_stylesheet_statement = 2
    RULE_default_statement = 3
    RULE_style_attribute = 4
    RULE_page_statement = 5
    RULE_section_statement = 6
    RULE_question_statement = 7
    RULE_attribute_name = 8
    RULE_attribute_value = 9
    RULE_question_type = 10
    RULE_widget = 11
    RULE_widget_type = 12
    RULE_widget_options = 13
    RULE_widget_option = 14
    RULE_identifier = 15
    RULE_string = 16
    RULE_integer = 17

    ruleNames =  [ "qls", "nested_statement", "stylesheet_statement", "default_statement", 
                   "style_attribute", "page_statement", "section_statement", 
                   "question_statement", "attribute_name", "attribute_value", 
                   "question_type", "widget", "widget_type", "widget_options", 
                   "widget_option", "identifier", "string", "integer" ]

    EOF = Token.EOF
    T__0=1
    T__1=2
    T__2=3
    T__3=4
    T__4=5
    T__5=6
    T__6=7
    T__7=8
    T__8=9
    T__9=10
    T__10=11
    T__11=12
    T__12=13
    T__13=14
    T__14=15
    T__15=16
    T__16=17
    T__17=18
    T__18=19
    T__19=20
    T__20=21
    STRING=22
    INTEGER=23
    IDENTIFIER=24
    WS=25
    COMMENT=26

    def __init__(self, input:TokenStream):
        super().__init__(input)
        self.checkVersion("4.5")
        self._interp = ParserATNSimulator(self, self.atn, self.decisionsToDFA, self.sharedContextCache)
        self._predicates = None



    class QlsContext(ParserRuleContext):

        def __init__(self, parser, parent:ParserRuleContext=None, invokingState:int=-1):
            super().__init__(parent, invokingState)
            self.parser = parser

        def nested_statement(self, i:int=None):
            if i is None:
                return self.getTypedRuleContexts(QLSParser.Nested_statementContext)
            else:
                return self.getTypedRuleContext(QLSParser.Nested_statementContext,i)


        def getRuleIndex(self):
            return QLSParser.RULE_qls

        def enterRule(self, listener:ParseTreeListener):
            if isinstance( listener, QLSListener ):
                listener.enterQls(self)

        def exitRule(self, listener:ParseTreeListener):
            if isinstance( listener, QLSListener ):
                listener.exitQls(self)

        def accept(self, visitor:ParseTreeVisitor):
            if isinstance( visitor, QLSVisitor ):
                return visitor.visitQls(self)
            else:
                return visitor.visitChildren(self)




    def qls(self):

        localctx = QLSParser.QlsContext(self, self._ctx, self.state)
        self.enterRule(localctx, 0, self.RULE_qls)
        self._la = 0 # Token type
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 39
            self._errHandler.sync(self)
            _la = self._input.LA(1)
            while (((_la) & ~0x3f) == 0 and ((1 << _la) & ((1 << QLSParser.T__0) | (1 << QLSParser.T__3) | (1 << QLSParser.T__5) | (1 << QLSParser.T__6) | (1 << QLSParser.T__7))) != 0):
                self.state = 36
                self.nested_statement()
                self.state = 41
                self._errHandler.sync(self)
                _la = self._input.LA(1)

        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.exitRule()
        return localctx

    class Nested_statementContext(ParserRuleContext):

        def __init__(self, parser, parent:ParserRuleContext=None, invokingState:int=-1):
            super().__init__(parent, invokingState)
            self.parser = parser

        def stylesheet_statement(self):
            return self.getTypedRuleContext(QLSParser.Stylesheet_statementContext,0)


        def default_statement(self):
            return self.getTypedRuleContext(QLSParser.Default_statementContext,0)


        def page_statement(self):
            return self.getTypedRuleContext(QLSParser.Page_statementContext,0)


        def section_statement(self):
            return self.getTypedRuleContext(QLSParser.Section_statementContext,0)


        def question_statement(self):
            return self.getTypedRuleContext(QLSParser.Question_statementContext,0)


        def getRuleIndex(self):
            return QLSParser.RULE_nested_statement

        def enterRule(self, listener:ParseTreeListener):
            if isinstance( listener, QLSListener ):
                listener.enterNested_statement(self)

        def exitRule(self, listener:ParseTreeListener):
            if isinstance( listener, QLSListener ):
                listener.exitNested_statement(self)

        def accept(self, visitor:ParseTreeVisitor):
            if isinstance( visitor, QLSVisitor ):
                return visitor.visitNested_statement(self)
            else:
                return visitor.visitChildren(self)




    def nested_statement(self):

        localctx = QLSParser.Nested_statementContext(self, self._ctx, self.state)
        self.enterRule(localctx, 2, self.RULE_nested_statement)
        try:
            self.state = 47
            token = self._input.LA(1)
            if token in [QLSParser.T__0]:
                self.enterOuterAlt(localctx, 1)
                self.state = 42
                self.stylesheet_statement()

            elif token in [QLSParser.T__3]:
                self.enterOuterAlt(localctx, 2)
                self.state = 43
                self.default_statement()

            elif token in [QLSParser.T__5]:
                self.enterOuterAlt(localctx, 3)
                self.state = 44
                self.page_statement()

            elif token in [QLSParser.T__6]:
                self.enterOuterAlt(localctx, 4)
                self.state = 45
                self.section_statement()

            elif token in [QLSParser.T__7]:
                self.enterOuterAlt(localctx, 5)
                self.state = 46
                self.question_statement()

            else:
                raise NoViableAltException(self)

        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.exitRule()
        return localctx

    class Stylesheet_statementContext(ParserRuleContext):

        def __init__(self, parser, parent:ParserRuleContext=None, invokingState:int=-1):
            super().__init__(parent, invokingState)
            self.parser = parser
            self.name = None # IdentifierContext
            self._nested_statement = None # Nested_statementContext
            self.statements = list() # of Nested_statementContexts

        def identifier(self):
            return self.getTypedRuleContext(QLSParser.IdentifierContext,0)


        def nested_statement(self, i:int=None):
            if i is None:
                return self.getTypedRuleContexts(QLSParser.Nested_statementContext)
            else:
                return self.getTypedRuleContext(QLSParser.Nested_statementContext,i)


        def getRuleIndex(self):
            return QLSParser.RULE_stylesheet_statement

        def enterRule(self, listener:ParseTreeListener):
            if isinstance( listener, QLSListener ):
                listener.enterStylesheet_statement(self)

        def exitRule(self, listener:ParseTreeListener):
            if isinstance( listener, QLSListener ):
                listener.exitStylesheet_statement(self)

        def accept(self, visitor:ParseTreeVisitor):
            if isinstance( visitor, QLSVisitor ):
                return visitor.visitStylesheet_statement(self)
            else:
                return visitor.visitChildren(self)




    def stylesheet_statement(self):

        localctx = QLSParser.Stylesheet_statementContext(self, self._ctx, self.state)
        self.enterRule(localctx, 4, self.RULE_stylesheet_statement)
        self._la = 0 # Token type
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 49
            self.match(QLSParser.T__0)
            self.state = 50
            localctx.name = self.identifier()
            self.state = 51
            self.match(QLSParser.T__1)
            self.state = 55
            self._errHandler.sync(self)
            _la = self._input.LA(1)
            while (((_la) & ~0x3f) == 0 and ((1 << _la) & ((1 << QLSParser.T__0) | (1 << QLSParser.T__3) | (1 << QLSParser.T__5) | (1 << QLSParser.T__6) | (1 << QLSParser.T__7))) != 0):
                self.state = 52
                localctx._nested_statement = self.nested_statement()
                localctx.statements.append(localctx._nested_statement)
                self.state = 57
                self._errHandler.sync(self)
                _la = self._input.LA(1)

            self.state = 58
            self.match(QLSParser.T__2)
        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.exitRule()
        return localctx

    class Default_statementContext(ParserRuleContext):

        def __init__(self, parser, parent:ParserRuleContext=None, invokingState:int=-1):
            super().__init__(parent, invokingState)
            self.parser = parser
            self.qtype = None # Question_typeContext
            self._style_attribute = None # Style_attributeContext
            self.attributes = list() # of Style_attributeContexts

        def question_type(self):
            return self.getTypedRuleContext(QLSParser.Question_typeContext,0)


        def style_attribute(self, i:int=None):
            if i is None:
                return self.getTypedRuleContexts(QLSParser.Style_attributeContext)
            else:
                return self.getTypedRuleContext(QLSParser.Style_attributeContext,i)


        def getRuleIndex(self):
            return QLSParser.RULE_default_statement

        def enterRule(self, listener:ParseTreeListener):
            if isinstance( listener, QLSListener ):
                listener.enterDefault_statement(self)

        def exitRule(self, listener:ParseTreeListener):
            if isinstance( listener, QLSListener ):
                listener.exitDefault_statement(self)

        def accept(self, visitor:ParseTreeVisitor):
            if isinstance( visitor, QLSVisitor ):
                return visitor.visitDefault_statement(self)
            else:
                return visitor.visitChildren(self)




    def default_statement(self):

        localctx = QLSParser.Default_statementContext(self, self._ctx, self.state)
        self.enterRule(localctx, 6, self.RULE_default_statement)
        self._la = 0 # Token type
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 60
            self.match(QLSParser.T__3)
            self.state = 61
            localctx.qtype = self.question_type()
            self.state = 62
            self.match(QLSParser.T__1)
            self.state = 66
            self._errHandler.sync(self)
            _la = self._input.LA(1)
            while _la==QLSParser.IDENTIFIER:
                self.state = 63
                localctx._style_attribute = self.style_attribute()
                localctx.attributes.append(localctx._style_attribute)
                self.state = 68
                self._errHandler.sync(self)
                _la = self._input.LA(1)

            self.state = 69
            self.match(QLSParser.T__2)
        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.exitRule()
        return localctx

    class Style_attributeContext(ParserRuleContext):

        def __init__(self, parser, parent:ParserRuleContext=None, invokingState:int=-1):
            super().__init__(parent, invokingState)
            self.parser = parser
            self.name = None # Attribute_nameContext
            self.value = None # Attribute_valueContext

        def attribute_name(self):
            return self.getTypedRuleContext(QLSParser.Attribute_nameContext,0)


        def attribute_value(self):
            return self.getTypedRuleContext(QLSParser.Attribute_valueContext,0)


        def getRuleIndex(self):
            return QLSParser.RULE_style_attribute

        def enterRule(self, listener:ParseTreeListener):
            if isinstance( listener, QLSListener ):
                listener.enterStyle_attribute(self)

        def exitRule(self, listener:ParseTreeListener):
            if isinstance( listener, QLSListener ):
                listener.exitStyle_attribute(self)

        def accept(self, visitor:ParseTreeVisitor):
            if isinstance( visitor, QLSVisitor ):
                return visitor.visitStyle_attribute(self)
            else:
                return visitor.visitChildren(self)




    def style_attribute(self):

        localctx = QLSParser.Style_attributeContext(self, self._ctx, self.state)
        self.enterRule(localctx, 8, self.RULE_style_attribute)
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 71
            localctx.name = self.attribute_name()
            self.state = 72
            self.match(QLSParser.T__4)
            self.state = 73
            localctx.value = self.attribute_value()
        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.exitRule()
        return localctx

    class Page_statementContext(ParserRuleContext):

        def __init__(self, parser, parent:ParserRuleContext=None, invokingState:int=-1):
            super().__init__(parent, invokingState)
            self.parser = parser
            self.name = None # StringContext
            self._nested_statement = None # Nested_statementContext
            self.statements = list() # of Nested_statementContexts

        def string(self):
            return self.getTypedRuleContext(QLSParser.StringContext,0)


        def nested_statement(self, i:int=None):
            if i is None:
                return self.getTypedRuleContexts(QLSParser.Nested_statementContext)
            else:
                return self.getTypedRuleContext(QLSParser.Nested_statementContext,i)


        def getRuleIndex(self):
            return QLSParser.RULE_page_statement

        def enterRule(self, listener:ParseTreeListener):
            if isinstance( listener, QLSListener ):
                listener.enterPage_statement(self)

        def exitRule(self, listener:ParseTreeListener):
            if isinstance( listener, QLSListener ):
                listener.exitPage_statement(self)

        def accept(self, visitor:ParseTreeVisitor):
            if isinstance( visitor, QLSVisitor ):
                return visitor.visitPage_statement(self)
            else:
                return visitor.visitChildren(self)




    def page_statement(self):

        localctx = QLSParser.Page_statementContext(self, self._ctx, self.state)
        self.enterRule(localctx, 10, self.RULE_page_statement)
        self._la = 0 # Token type
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 75
            self.match(QLSParser.T__5)
            self.state = 76
            localctx.name = self.string()
            self.state = 77
            self.match(QLSParser.T__1)
            self.state = 81
            self._errHandler.sync(self)
            _la = self._input.LA(1)
            while (((_la) & ~0x3f) == 0 and ((1 << _la) & ((1 << QLSParser.T__0) | (1 << QLSParser.T__3) | (1 << QLSParser.T__5) | (1 << QLSParser.T__6) | (1 << QLSParser.T__7))) != 0):
                self.state = 78
                localctx._nested_statement = self.nested_statement()
                localctx.statements.append(localctx._nested_statement)
                self.state = 83
                self._errHandler.sync(self)
                _la = self._input.LA(1)

            self.state = 84
            self.match(QLSParser.T__2)
        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.exitRule()
        return localctx

    class Section_statementContext(ParserRuleContext):

        def __init__(self, parser, parent:ParserRuleContext=None, invokingState:int=-1):
            super().__init__(parent, invokingState)
            self.parser = parser
            self.name = None # StringContext
            self._nested_statement = None # Nested_statementContext
            self.statements = list() # of Nested_statementContexts

        def string(self):
            return self.getTypedRuleContext(QLSParser.StringContext,0)


        def nested_statement(self, i:int=None):
            if i is None:
                return self.getTypedRuleContexts(QLSParser.Nested_statementContext)
            else:
                return self.getTypedRuleContext(QLSParser.Nested_statementContext,i)


        def getRuleIndex(self):
            return QLSParser.RULE_section_statement

        def enterRule(self, listener:ParseTreeListener):
            if isinstance( listener, QLSListener ):
                listener.enterSection_statement(self)

        def exitRule(self, listener:ParseTreeListener):
            if isinstance( listener, QLSListener ):
                listener.exitSection_statement(self)

        def accept(self, visitor:ParseTreeVisitor):
            if isinstance( visitor, QLSVisitor ):
                return visitor.visitSection_statement(self)
            else:
                return visitor.visitChildren(self)




    def section_statement(self):

        localctx = QLSParser.Section_statementContext(self, self._ctx, self.state)
        self.enterRule(localctx, 12, self.RULE_section_statement)
        self._la = 0 # Token type
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 86
            self.match(QLSParser.T__6)
            self.state = 87
            localctx.name = self.string()
            self.state = 88
            self.match(QLSParser.T__1)
            self.state = 92
            self._errHandler.sync(self)
            _la = self._input.LA(1)
            while (((_la) & ~0x3f) == 0 and ((1 << _la) & ((1 << QLSParser.T__0) | (1 << QLSParser.T__3) | (1 << QLSParser.T__5) | (1 << QLSParser.T__6) | (1 << QLSParser.T__7))) != 0):
                self.state = 89
                localctx._nested_statement = self.nested_statement()
                localctx.statements.append(localctx._nested_statement)
                self.state = 94
                self._errHandler.sync(self)
                _la = self._input.LA(1)

            self.state = 95
            self.match(QLSParser.T__2)
        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.exitRule()
        return localctx

    class Question_statementContext(ParserRuleContext):

        def __init__(self, parser, parent:ParserRuleContext=None, invokingState:int=-1):
            super().__init__(parent, invokingState)
            self.parser = parser
            self.name = None # IdentifierContext
            self._style_attribute = None # Style_attributeContext
            self.attributes = list() # of Style_attributeContexts

        def identifier(self):
            return self.getTypedRuleContext(QLSParser.IdentifierContext,0)


        def style_attribute(self, i:int=None):
            if i is None:
                return self.getTypedRuleContexts(QLSParser.Style_attributeContext)
            else:
                return self.getTypedRuleContext(QLSParser.Style_attributeContext,i)


        def getRuleIndex(self):
            return QLSParser.RULE_question_statement

        def enterRule(self, listener:ParseTreeListener):
            if isinstance( listener, QLSListener ):
                listener.enterQuestion_statement(self)

        def exitRule(self, listener:ParseTreeListener):
            if isinstance( listener, QLSListener ):
                listener.exitQuestion_statement(self)

        def accept(self, visitor:ParseTreeVisitor):
            if isinstance( visitor, QLSVisitor ):
                return visitor.visitQuestion_statement(self)
            else:
                return visitor.visitChildren(self)




    def question_statement(self):

        localctx = QLSParser.Question_statementContext(self, self._ctx, self.state)
        self.enterRule(localctx, 14, self.RULE_question_statement)
        self._la = 0 # Token type
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 97
            self.match(QLSParser.T__7)
            self.state = 98
            localctx.name = self.identifier()
            self.state = 107
            _la = self._input.LA(1)
            if _la==QLSParser.T__1:
                self.state = 99
                self.match(QLSParser.T__1)
                self.state = 103
                self._errHandler.sync(self)
                _la = self._input.LA(1)
                while _la==QLSParser.IDENTIFIER:
                    self.state = 100
                    localctx._style_attribute = self.style_attribute()
                    localctx.attributes.append(localctx._style_attribute)
                    self.state = 105
                    self._errHandler.sync(self)
                    _la = self._input.LA(1)

                self.state = 106
                self.match(QLSParser.T__2)


        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.exitRule()
        return localctx

    class Attribute_nameContext(ParserRuleContext):

        def __init__(self, parser, parent:ParserRuleContext=None, invokingState:int=-1):
            super().__init__(parent, invokingState)
            self.parser = parser

        def IDENTIFIER(self):
            return self.getToken(QLSParser.IDENTIFIER, 0)

        def getRuleIndex(self):
            return QLSParser.RULE_attribute_name

        def enterRule(self, listener:ParseTreeListener):
            if isinstance( listener, QLSListener ):
                listener.enterAttribute_name(self)

        def exitRule(self, listener:ParseTreeListener):
            if isinstance( listener, QLSListener ):
                listener.exitAttribute_name(self)

        def accept(self, visitor:ParseTreeVisitor):
            if isinstance( visitor, QLSVisitor ):
                return visitor.visitAttribute_name(self)
            else:
                return visitor.visitChildren(self)




    def attribute_name(self):

        localctx = QLSParser.Attribute_nameContext(self, self._ctx, self.state)
        self.enterRule(localctx, 16, self.RULE_attribute_name)
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 109
            self.match(QLSParser.IDENTIFIER)
        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.exitRule()
        return localctx

    class Attribute_valueContext(ParserRuleContext):

        def __init__(self, parser, parent:ParserRuleContext=None, invokingState:int=-1):
            super().__init__(parent, invokingState)
            self.parser = parser

        def integer(self):
            return self.getTypedRuleContext(QLSParser.IntegerContext,0)


        def string(self):
            return self.getTypedRuleContext(QLSParser.StringContext,0)


        def widget(self):
            return self.getTypedRuleContext(QLSParser.WidgetContext,0)


        def getRuleIndex(self):
            return QLSParser.RULE_attribute_value

        def enterRule(self, listener:ParseTreeListener):
            if isinstance( listener, QLSListener ):
                listener.enterAttribute_value(self)

        def exitRule(self, listener:ParseTreeListener):
            if isinstance( listener, QLSListener ):
                listener.exitAttribute_value(self)

        def accept(self, visitor:ParseTreeVisitor):
            if isinstance( visitor, QLSVisitor ):
                return visitor.visitAttribute_value(self)
            else:
                return visitor.visitChildren(self)




    def attribute_value(self):

        localctx = QLSParser.Attribute_valueContext(self, self._ctx, self.state)
        self.enterRule(localctx, 18, self.RULE_attribute_value)
        try:
            self.state = 114
            token = self._input.LA(1)
            if token in [QLSParser.INTEGER]:
                self.enterOuterAlt(localctx, 1)
                self.state = 111
                self.integer()

            elif token in [QLSParser.STRING]:
                self.enterOuterAlt(localctx, 2)
                self.state = 112
                self.string()

            elif token in [QLSParser.T__14, QLSParser.T__15, QLSParser.T__16, QLSParser.T__17, QLSParser.T__18, QLSParser.T__19]:
                self.enterOuterAlt(localctx, 3)
                self.state = 113
                self.widget()

            else:
                raise NoViableAltException(self)

        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.exitRule()
        return localctx

    class Question_typeContext(ParserRuleContext):

        def __init__(self, parser, parent:ParserRuleContext=None, invokingState:int=-1):
            super().__init__(parent, invokingState)
            self.parser = parser


        def getRuleIndex(self):
            return QLSParser.RULE_question_type

        def enterRule(self, listener:ParseTreeListener):
            if isinstance( listener, QLSListener ):
                listener.enterQuestion_type(self)

        def exitRule(self, listener:ParseTreeListener):
            if isinstance( listener, QLSListener ):
                listener.exitQuestion_type(self)

        def accept(self, visitor:ParseTreeVisitor):
            if isinstance( visitor, QLSVisitor ):
                return visitor.visitQuestion_type(self)
            else:
                return visitor.visitChildren(self)




    def question_type(self):

        localctx = QLSParser.Question_typeContext(self, self._ctx, self.state)
        self.enterRule(localctx, 20, self.RULE_question_type)
        self._la = 0 # Token type
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 116
            _la = self._input.LA(1)
            if not((((_la) & ~0x3f) == 0 and ((1 << _la) & ((1 << QLSParser.T__8) | (1 << QLSParser.T__9) | (1 << QLSParser.T__10) | (1 << QLSParser.T__11))) != 0)):
                self._errHandler.recoverInline(self)
            else:
                self.consume()
        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.exitRule()
        return localctx

    class WidgetContext(ParserRuleContext):

        def __init__(self, parser, parent:ParserRuleContext=None, invokingState:int=-1):
            super().__init__(parent, invokingState)
            self.parser = parser
            self.wtype = None # Widget_typeContext
            self.options = None # Widget_optionsContext

        def widget_type(self):
            return self.getTypedRuleContext(QLSParser.Widget_typeContext,0)


        def widget_options(self):
            return self.getTypedRuleContext(QLSParser.Widget_optionsContext,0)


        def getRuleIndex(self):
            return QLSParser.RULE_widget

        def enterRule(self, listener:ParseTreeListener):
            if isinstance( listener, QLSListener ):
                listener.enterWidget(self)

        def exitRule(self, listener:ParseTreeListener):
            if isinstance( listener, QLSListener ):
                listener.exitWidget(self)

        def accept(self, visitor:ParseTreeVisitor):
            if isinstance( visitor, QLSVisitor ):
                return visitor.visitWidget(self)
            else:
                return visitor.visitChildren(self)




    def widget(self):

        localctx = QLSParser.WidgetContext(self, self._ctx, self.state)
        self.enterRule(localctx, 22, self.RULE_widget)
        self._la = 0 # Token type
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 118
            localctx.wtype = self.widget_type()
            self.state = 123
            _la = self._input.LA(1)
            if _la==QLSParser.T__12:
                self.state = 119
                self.match(QLSParser.T__12)
                self.state = 120
                localctx.options = self.widget_options()
                self.state = 121
                self.match(QLSParser.T__13)


        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.exitRule()
        return localctx

    class Widget_typeContext(ParserRuleContext):

        def __init__(self, parser, parent:ParserRuleContext=None, invokingState:int=-1):
            super().__init__(parent, invokingState)
            self.parser = parser


        def getRuleIndex(self):
            return QLSParser.RULE_widget_type

        def enterRule(self, listener:ParseTreeListener):
            if isinstance( listener, QLSListener ):
                listener.enterWidget_type(self)

        def exitRule(self, listener:ParseTreeListener):
            if isinstance( listener, QLSListener ):
                listener.exitWidget_type(self)

        def accept(self, visitor:ParseTreeVisitor):
            if isinstance( visitor, QLSVisitor ):
                return visitor.visitWidget_type(self)
            else:
                return visitor.visitChildren(self)




    def widget_type(self):

        localctx = QLSParser.Widget_typeContext(self, self._ctx, self.state)
        self.enterRule(localctx, 24, self.RULE_widget_type)
        self._la = 0 # Token type
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 125
            _la = self._input.LA(1)
            if not((((_la) & ~0x3f) == 0 and ((1 << _la) & ((1 << QLSParser.T__14) | (1 << QLSParser.T__15) | (1 << QLSParser.T__16) | (1 << QLSParser.T__17) | (1 << QLSParser.T__18) | (1 << QLSParser.T__19))) != 0)):
                self._errHandler.recoverInline(self)
            else:
                self.consume()
        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.exitRule()
        return localctx

    class Widget_optionsContext(ParserRuleContext):

        def __init__(self, parser, parent:ParserRuleContext=None, invokingState:int=-1):
            super().__init__(parent, invokingState)
            self.parser = parser

        def widget_option(self, i:int=None):
            if i is None:
                return self.getTypedRuleContexts(QLSParser.Widget_optionContext)
            else:
                return self.getTypedRuleContext(QLSParser.Widget_optionContext,i)


        def getRuleIndex(self):
            return QLSParser.RULE_widget_options

        def enterRule(self, listener:ParseTreeListener):
            if isinstance( listener, QLSListener ):
                listener.enterWidget_options(self)

        def exitRule(self, listener:ParseTreeListener):
            if isinstance( listener, QLSListener ):
                listener.exitWidget_options(self)

        def accept(self, visitor:ParseTreeVisitor):
            if isinstance( visitor, QLSVisitor ):
                return visitor.visitWidget_options(self)
            else:
                return visitor.visitChildren(self)




    def widget_options(self):

        localctx = QLSParser.Widget_optionsContext(self, self._ctx, self.state)
        self.enterRule(localctx, 26, self.RULE_widget_options)
        self._la = 0 # Token type
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 127
            self.widget_option()
            self.state = 132
            self._errHandler.sync(self)
            _la = self._input.LA(1)
            while _la==QLSParser.T__20:
                self.state = 128
                self.match(QLSParser.T__20)
                self.state = 129
                self.widget_option()
                self.state = 134
                self._errHandler.sync(self)
                _la = self._input.LA(1)

        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.exitRule()
        return localctx

    class Widget_optionContext(ParserRuleContext):

        def __init__(self, parser, parent:ParserRuleContext=None, invokingState:int=-1):
            super().__init__(parent, invokingState)
            self.parser = parser

        def integer(self):
            return self.getTypedRuleContext(QLSParser.IntegerContext,0)


        def string(self):
            return self.getTypedRuleContext(QLSParser.StringContext,0)


        def getRuleIndex(self):
            return QLSParser.RULE_widget_option

        def enterRule(self, listener:ParseTreeListener):
            if isinstance( listener, QLSListener ):
                listener.enterWidget_option(self)

        def exitRule(self, listener:ParseTreeListener):
            if isinstance( listener, QLSListener ):
                listener.exitWidget_option(self)

        def accept(self, visitor:ParseTreeVisitor):
            if isinstance( visitor, QLSVisitor ):
                return visitor.visitWidget_option(self)
            else:
                return visitor.visitChildren(self)




    def widget_option(self):

        localctx = QLSParser.Widget_optionContext(self, self._ctx, self.state)
        self.enterRule(localctx, 28, self.RULE_widget_option)
        try:
            self.state = 137
            token = self._input.LA(1)
            if token in [QLSParser.INTEGER]:
                self.enterOuterAlt(localctx, 1)
                self.state = 135
                self.integer()

            elif token in [QLSParser.STRING]:
                self.enterOuterAlt(localctx, 2)
                self.state = 136
                self.string()

            else:
                raise NoViableAltException(self)

        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.exitRule()
        return localctx

    class IdentifierContext(ParserRuleContext):

        def __init__(self, parser, parent:ParserRuleContext=None, invokingState:int=-1):
            super().__init__(parent, invokingState)
            self.parser = parser

        def IDENTIFIER(self):
            return self.getToken(QLSParser.IDENTIFIER, 0)

        def getRuleIndex(self):
            return QLSParser.RULE_identifier

        def enterRule(self, listener:ParseTreeListener):
            if isinstance( listener, QLSListener ):
                listener.enterIdentifier(self)

        def exitRule(self, listener:ParseTreeListener):
            if isinstance( listener, QLSListener ):
                listener.exitIdentifier(self)

        def accept(self, visitor:ParseTreeVisitor):
            if isinstance( visitor, QLSVisitor ):
                return visitor.visitIdentifier(self)
            else:
                return visitor.visitChildren(self)




    def identifier(self):

        localctx = QLSParser.IdentifierContext(self, self._ctx, self.state)
        self.enterRule(localctx, 30, self.RULE_identifier)
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 139
            self.match(QLSParser.IDENTIFIER)
        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.exitRule()
        return localctx

    class StringContext(ParserRuleContext):

        def __init__(self, parser, parent:ParserRuleContext=None, invokingState:int=-1):
            super().__init__(parent, invokingState)
            self.parser = parser

        def STRING(self):
            return self.getToken(QLSParser.STRING, 0)

        def getRuleIndex(self):
            return QLSParser.RULE_string

        def enterRule(self, listener:ParseTreeListener):
            if isinstance( listener, QLSListener ):
                listener.enterString(self)

        def exitRule(self, listener:ParseTreeListener):
            if isinstance( listener, QLSListener ):
                listener.exitString(self)

        def accept(self, visitor:ParseTreeVisitor):
            if isinstance( visitor, QLSVisitor ):
                return visitor.visitString(self)
            else:
                return visitor.visitChildren(self)




    def string(self):

        localctx = QLSParser.StringContext(self, self._ctx, self.state)
        self.enterRule(localctx, 32, self.RULE_string)
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 141
            self.match(QLSParser.STRING)
        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.exitRule()
        return localctx

    class IntegerContext(ParserRuleContext):

        def __init__(self, parser, parent:ParserRuleContext=None, invokingState:int=-1):
            super().__init__(parent, invokingState)
            self.parser = parser

        def INTEGER(self):
            return self.getToken(QLSParser.INTEGER, 0)

        def getRuleIndex(self):
            return QLSParser.RULE_integer

        def enterRule(self, listener:ParseTreeListener):
            if isinstance( listener, QLSListener ):
                listener.enterInteger(self)

        def exitRule(self, listener:ParseTreeListener):
            if isinstance( listener, QLSListener ):
                listener.exitInteger(self)

        def accept(self, visitor:ParseTreeVisitor):
            if isinstance( visitor, QLSVisitor ):
                return visitor.visitInteger(self)
            else:
                return visitor.visitChildren(self)




    def integer(self):

        localctx = QLSParser.IntegerContext(self, self._ctx, self.state)
        self.enterRule(localctx, 34, self.RULE_integer)
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 143
            self.match(QLSParser.INTEGER)
        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.exitRule()
        return localctx




