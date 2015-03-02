# Generated from java-escape by ANTLR 4.5
# encoding: utf-8
from antlr4 import *
from io import StringIO
package = globals().get("__package__", None)
ischild = len(package)>0 if package is not None else False
if ischild:
    from .QLListener import QLListener
    from .QLVisitor import QLVisitor
else:
    from QLListener import QLListener
    from QLVisitor import QLVisitor

def serializedATN():
    with StringIO() as buf:
        buf.write("\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3%")
        buf.write("\177\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4")
        buf.write("\b\t\b\4\t\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16")
        buf.write("\t\16\3\2\3\2\5\2\37\n\2\3\3\7\3\"\n\3\f\3\16\3%\13\3")
        buf.write("\3\4\3\4\3\4\3\4\7\4+\n\4\f\4\16\4.\13\4\3\4\3\4\3\5\3")
        buf.write("\5\3\5\3\5\3\5\3\5\3\5\5\59\n\5\3\5\3\5\3\6\3\6\3\6\3")
        buf.write("\6\7\6A\n\6\f\6\16\6D\13\6\3\6\3\6\3\7\3\7\3\b\3\b\3\b")
        buf.write("\3\b\3\b\3\b\3\b\3\b\5\bR\n\b\3\b\3\b\3\b\3\b\3\b\3\b")
        buf.write("\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3")
        buf.write("\b\3\b\7\bi\n\b\f\b\16\bl\13\b\3\t\3\t\3\t\3\t\3\t\5\t")
        buf.write("s\n\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\16")
        buf.write("\2\3\16\17\2\4\6\b\n\f\16\20\22\24\26\30\32\2\t\3\2\t")
        buf.write("\f\3\2\17\21\3\2\23\25\3\2\17\20\3\2\26\31\3\2\32\33\3")
        buf.write("\2\36\37\u0083\2\36\3\2\2\2\4#\3\2\2\2\6&\3\2\2\2\b\61")
        buf.write("\3\2\2\2\n<\3\2\2\2\fG\3\2\2\2\16Q\3\2\2\2\20r\3\2\2\2")
        buf.write("\22t\3\2\2\2\24v\3\2\2\2\26x\3\2\2\2\30z\3\2\2\2\32|\3")
        buf.write("\2\2\2\34\37\5\b\5\2\35\37\5\n\6\2\36\34\3\2\2\2\36\35")
        buf.write("\3\2\2\2\37\3\3\2\2\2 \"\5\6\4\2! \3\2\2\2\"%\3\2\2\2")
        buf.write("#!\3\2\2\2#$\3\2\2\2$\5\3\2\2\2%#\3\2\2\2&\'\7\3\2\2\'")
        buf.write("(\5\24\13\2(,\7\4\2\2)+\5\2\2\2*)\3\2\2\2+.\3\2\2\2,*")
        buf.write("\3\2\2\2,-\3\2\2\2-/\3\2\2\2.,\3\2\2\2/\60\7\5\2\2\60")
        buf.write("\7\3\2\2\2\61\62\7\6\2\2\62\63\5\24\13\2\63\64\7\4\2\2")
        buf.write("\64\65\5\26\f\2\658\5\f\7\2\66\67\7\7\2\2\679\5\16\b\2")
        buf.write("8\66\3\2\2\289\3\2\2\29:\3\2\2\2:;\7\5\2\2;\t\3\2\2\2")
        buf.write("<=\7\b\2\2=>\5\16\b\2>B\7\4\2\2?A\5\2\2\2@?\3\2\2\2AD")
        buf.write("\3\2\2\2B@\3\2\2\2BC\3\2\2\2CE\3\2\2\2DB\3\2\2\2EF\7\5")
        buf.write("\2\2F\13\3\2\2\2GH\t\2\2\2H\r\3\2\2\2IJ\b\b\1\2JK\t\3")
        buf.write("\2\2KR\5\16\b\13LM\7\r\2\2MN\5\16\b\2NO\7\16\2\2OR\3\2")
        buf.write("\2\2PR\5\20\t\2QI\3\2\2\2QL\3\2\2\2QP\3\2\2\2Rj\3\2\2")
        buf.write("\2ST\f\n\2\2TU\7\22\2\2Ui\5\16\b\13VW\f\t\2\2WX\t\4\2")
        buf.write("\2Xi\5\16\b\nYZ\f\b\2\2Z[\t\5\2\2[i\5\16\b\t\\]\f\7\2")
        buf.write("\2]^\t\6\2\2^i\5\16\b\b_`\f\6\2\2`a\t\7\2\2ai\5\16\b\7")
        buf.write("bc\f\5\2\2cd\7\34\2\2di\5\16\b\6ef\f\4\2\2fg\7\35\2\2")
        buf.write("gi\5\16\b\5hS\3\2\2\2hV\3\2\2\2hY\3\2\2\2h\\\3\2\2\2h")
        buf.write("_\3\2\2\2hb\3\2\2\2he\3\2\2\2il\3\2\2\2jh\3\2\2\2jk\3")
        buf.write("\2\2\2k\17\3\2\2\2lj\3\2\2\2ms\5\22\n\2ns\5\26\f\2os\5")
        buf.write("\30\r\2ps\5\24\13\2qs\5\32\16\2rm\3\2\2\2rn\3\2\2\2ro")
        buf.write("\3\2\2\2rp\3\2\2\2rq\3\2\2\2s\21\3\2\2\2tu\t\b\2\2u\23")
        buf.write("\3\2\2\2vw\7#\2\2w\25\3\2\2\2xy\7 \2\2y\27\3\2\2\2z{\7")
        buf.write("!\2\2{\31\3\2\2\2|}\7\"\2\2}\33\3\2\2\2\13\36#,8BQhjr")
        return buf.getvalue()


class QLParser ( Parser ):

    grammarFileName = "java-escape"

    atn = ATNDeserializer().deserialize(serializedATN())

    decisionsToDFA = [ DFA(ds, i) for i, ds in enumerate(atn.decisionToState) ]

    sharedContextCache = PredictionContextCache()

    literalNames = [ u"<INVALID>", u"'form'", u"'{'", u"'}'", u"'question'", 
                     u"'='", u"'if'", u"'boolean'", u"'integer'", u"'string'", 
                     u"'money'", u"'('", u"')'", u"'+'", u"'-'", u"'!'", 
                     u"'^'", u"'*'", u"'/'", u"'%'", u"'<'", u"'<='", u"'>'", 
                     u"'>='", u"'=='", u"'!='", u"'&&'", u"'||'", u"'true'", 
                     u"'false'" ]

    symbolicNames = [ u"<INVALID>", u"<INVALID>", u"<INVALID>", u"<INVALID>", 
                      u"<INVALID>", u"<INVALID>", u"<INVALID>", u"<INVALID>", 
                      u"<INVALID>", u"<INVALID>", u"<INVALID>", u"<INVALID>", 
                      u"<INVALID>", u"<INVALID>", u"<INVALID>", u"<INVALID>", 
                      u"<INVALID>", u"<INVALID>", u"<INVALID>", u"<INVALID>", 
                      u"<INVALID>", u"<INVALID>", u"<INVALID>", u"<INVALID>", 
                      u"<INVALID>", u"<INVALID>", u"<INVALID>", u"<INVALID>", 
                      u"<INVALID>", u"<INVALID>", u"STRING", u"INTEGER", 
                      u"MONEY", u"IDENTIFIER", u"WS", u"COMMENT" ]

    RULE_nested_statement = 0
    RULE_root = 1
    RULE_form_statement = 2
    RULE_question_statement = 3
    RULE_if_statement = 4
    RULE_question_type = 5
    RULE_expr = 6
    RULE_atom = 7
    RULE_boolean = 8
    RULE_identifier = 9
    RULE_string = 10
    RULE_integer = 11
    RULE_money = 12

    ruleNames =  [ "nested_statement", "root", "form_statement", "question_statement", 
                   "if_statement", "question_type", "expr", "atom", "boolean", 
                   "identifier", "string", "integer", "money" ]

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
    T__21=22
    T__22=23
    T__23=24
    T__24=25
    T__25=26
    T__26=27
    T__27=28
    T__28=29
    STRING=30
    INTEGER=31
    MONEY=32
    IDENTIFIER=33
    WS=34
    COMMENT=35

    def __init__(self, input:TokenStream):
        super().__init__(input)
        self.checkVersion("4.5")
        self._interp = ParserATNSimulator(self, self.atn, self.decisionsToDFA, self.sharedContextCache)
        self._predicates = None



    class Nested_statementContext(ParserRuleContext):

        def __init__(self, parser, parent:ParserRuleContext=None, invokingState:int=-1):
            super().__init__(parent, invokingState)
            self.parser = parser

        def question_statement(self):
            return self.getTypedRuleContext(QLParser.Question_statementContext,0)


        def if_statement(self):
            return self.getTypedRuleContext(QLParser.If_statementContext,0)


        def getRuleIndex(self):
            return QLParser.RULE_nested_statement

        def enterRule(self, listener:ParseTreeListener):
            if isinstance( listener, QLListener ):
                listener.enterNested_statement(self)

        def exitRule(self, listener:ParseTreeListener):
            if isinstance( listener, QLListener ):
                listener.exitNested_statement(self)

        def accept(self, visitor:ParseTreeVisitor):
            if isinstance( visitor, QLVisitor ):
                return visitor.visitNested_statement(self)
            else:
                return visitor.visitChildren(self)




    def nested_statement(self):

        localctx = QLParser.Nested_statementContext(self, self._ctx, self.state)
        self.enterRule(localctx, 0, self.RULE_nested_statement)
        try:
            self.state = 28
            token = self._input.LA(1)
            if token in [QLParser.T__3]:
                self.enterOuterAlt(localctx, 1)
                self.state = 26
                self.question_statement()

            elif token in [QLParser.T__5]:
                self.enterOuterAlt(localctx, 2)
                self.state = 27
                self.if_statement()

            else:
                raise NoViableAltException(self)

        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.exitRule()
        return localctx

    class RootContext(ParserRuleContext):

        def __init__(self, parser, parent:ParserRuleContext=None, invokingState:int=-1):
            super().__init__(parent, invokingState)
            self.parser = parser

        def form_statement(self, i:int=None):
            if i is None:
                return self.getTypedRuleContexts(QLParser.Form_statementContext)
            else:
                return self.getTypedRuleContext(QLParser.Form_statementContext,i)


        def getRuleIndex(self):
            return QLParser.RULE_root

        def enterRule(self, listener:ParseTreeListener):
            if isinstance( listener, QLListener ):
                listener.enterRoot(self)

        def exitRule(self, listener:ParseTreeListener):
            if isinstance( listener, QLListener ):
                listener.exitRoot(self)

        def accept(self, visitor:ParseTreeVisitor):
            if isinstance( visitor, QLVisitor ):
                return visitor.visitRoot(self)
            else:
                return visitor.visitChildren(self)




    def root(self):

        localctx = QLParser.RootContext(self, self._ctx, self.state)
        self.enterRule(localctx, 2, self.RULE_root)
        self._la = 0 # Token type
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 33
            self._errHandler.sync(self)
            _la = self._input.LA(1)
            while _la==QLParser.T__0:
                self.state = 30
                self.form_statement()
                self.state = 35
                self._errHandler.sync(self)
                _la = self._input.LA(1)

        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.exitRule()
        return localctx

    class Form_statementContext(ParserRuleContext):

        def __init__(self, parser, parent:ParserRuleContext=None, invokingState:int=-1):
            super().__init__(parent, invokingState)
            self.parser = parser
            self.name = None # IdentifierContext
            self._nested_statement = None # Nested_statementContext
            self.statements = list() # of Nested_statementContexts

        def identifier(self):
            return self.getTypedRuleContext(QLParser.IdentifierContext,0)


        def nested_statement(self, i:int=None):
            if i is None:
                return self.getTypedRuleContexts(QLParser.Nested_statementContext)
            else:
                return self.getTypedRuleContext(QLParser.Nested_statementContext,i)


        def getRuleIndex(self):
            return QLParser.RULE_form_statement

        def enterRule(self, listener:ParseTreeListener):
            if isinstance( listener, QLListener ):
                listener.enterForm_statement(self)

        def exitRule(self, listener:ParseTreeListener):
            if isinstance( listener, QLListener ):
                listener.exitForm_statement(self)

        def accept(self, visitor:ParseTreeVisitor):
            if isinstance( visitor, QLVisitor ):
                return visitor.visitForm_statement(self)
            else:
                return visitor.visitChildren(self)




    def form_statement(self):

        localctx = QLParser.Form_statementContext(self, self._ctx, self.state)
        self.enterRule(localctx, 4, self.RULE_form_statement)
        self._la = 0 # Token type
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 36
            self.match(QLParser.T__0)
            self.state = 37
            localctx.name = self.identifier()
            self.state = 38
            self.match(QLParser.T__1)
            self.state = 42
            self._errHandler.sync(self)
            _la = self._input.LA(1)
            while _la==QLParser.T__3 or _la==QLParser.T__5:
                self.state = 39
                localctx._nested_statement = self.nested_statement()
                localctx.statements.append(localctx._nested_statement)
                self.state = 44
                self._errHandler.sync(self)
                _la = self._input.LA(1)

            self.state = 45
            self.match(QLParser.T__2)
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
            self.text = None # StringContext
            self.qtype = None # Question_typeContext
            self.expression = None # ExprContext

        def identifier(self):
            return self.getTypedRuleContext(QLParser.IdentifierContext,0)


        def string(self):
            return self.getTypedRuleContext(QLParser.StringContext,0)


        def question_type(self):
            return self.getTypedRuleContext(QLParser.Question_typeContext,0)


        def expr(self):
            return self.getTypedRuleContext(QLParser.ExprContext,0)


        def getRuleIndex(self):
            return QLParser.RULE_question_statement

        def enterRule(self, listener:ParseTreeListener):
            if isinstance( listener, QLListener ):
                listener.enterQuestion_statement(self)

        def exitRule(self, listener:ParseTreeListener):
            if isinstance( listener, QLListener ):
                listener.exitQuestion_statement(self)

        def accept(self, visitor:ParseTreeVisitor):
            if isinstance( visitor, QLVisitor ):
                return visitor.visitQuestion_statement(self)
            else:
                return visitor.visitChildren(self)




    def question_statement(self):

        localctx = QLParser.Question_statementContext(self, self._ctx, self.state)
        self.enterRule(localctx, 6, self.RULE_question_statement)
        self._la = 0 # Token type
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 47
            self.match(QLParser.T__3)
            self.state = 48
            localctx.name = self.identifier()
            self.state = 49
            self.match(QLParser.T__1)
            self.state = 50
            localctx.text = self.string()
            self.state = 51
            localctx.qtype = self.question_type()
            self.state = 54
            _la = self._input.LA(1)
            if _la==QLParser.T__4:
                self.state = 52
                self.match(QLParser.T__4)
                self.state = 53
                localctx.expression = self.expr(0)


            self.state = 56
            self.match(QLParser.T__2)
        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.exitRule()
        return localctx

    class If_statementContext(ParserRuleContext):

        def __init__(self, parser, parent:ParserRuleContext=None, invokingState:int=-1):
            super().__init__(parent, invokingState)
            self.parser = parser
            self.expression = None # ExprContext
            self._nested_statement = None # Nested_statementContext
            self.statements = list() # of Nested_statementContexts

        def expr(self):
            return self.getTypedRuleContext(QLParser.ExprContext,0)


        def nested_statement(self, i:int=None):
            if i is None:
                return self.getTypedRuleContexts(QLParser.Nested_statementContext)
            else:
                return self.getTypedRuleContext(QLParser.Nested_statementContext,i)


        def getRuleIndex(self):
            return QLParser.RULE_if_statement

        def enterRule(self, listener:ParseTreeListener):
            if isinstance( listener, QLListener ):
                listener.enterIf_statement(self)

        def exitRule(self, listener:ParseTreeListener):
            if isinstance( listener, QLListener ):
                listener.exitIf_statement(self)

        def accept(self, visitor:ParseTreeVisitor):
            if isinstance( visitor, QLVisitor ):
                return visitor.visitIf_statement(self)
            else:
                return visitor.visitChildren(self)




    def if_statement(self):

        localctx = QLParser.If_statementContext(self, self._ctx, self.state)
        self.enterRule(localctx, 8, self.RULE_if_statement)
        self._la = 0 # Token type
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 58
            self.match(QLParser.T__5)
            self.state = 59
            localctx.expression = self.expr(0)
            self.state = 60
            self.match(QLParser.T__1)
            self.state = 64
            self._errHandler.sync(self)
            _la = self._input.LA(1)
            while _la==QLParser.T__3 or _la==QLParser.T__5:
                self.state = 61
                localctx._nested_statement = self.nested_statement()
                localctx.statements.append(localctx._nested_statement)
                self.state = 66
                self._errHandler.sync(self)
                _la = self._input.LA(1)

            self.state = 67
            self.match(QLParser.T__2)
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
            return QLParser.RULE_question_type

        def enterRule(self, listener:ParseTreeListener):
            if isinstance( listener, QLListener ):
                listener.enterQuestion_type(self)

        def exitRule(self, listener:ParseTreeListener):
            if isinstance( listener, QLListener ):
                listener.exitQuestion_type(self)

        def accept(self, visitor:ParseTreeVisitor):
            if isinstance( visitor, QLVisitor ):
                return visitor.visitQuestion_type(self)
            else:
                return visitor.visitChildren(self)




    def question_type(self):

        localctx = QLParser.Question_typeContext(self, self._ctx, self.state)
        self.enterRule(localctx, 10, self.RULE_question_type)
        self._la = 0 # Token type
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 69
            _la = self._input.LA(1)
            if not((((_la) & ~0x3f) == 0 and ((1 << _la) & ((1 << QLParser.T__6) | (1 << QLParser.T__7) | (1 << QLParser.T__8) | (1 << QLParser.T__9))) != 0)):
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

    class ExprContext(ParserRuleContext):

        def __init__(self, parser, parent:ParserRuleContext=None, invokingState:int=-1):
            super().__init__(parent, invokingState)
            self.parser = parser
            self.left = None # ExprContext
            self.op = None # Token
            self.right = None # ExprContext

        def expr(self, i:int=None):
            if i is None:
                return self.getTypedRuleContexts(QLParser.ExprContext)
            else:
                return self.getTypedRuleContext(QLParser.ExprContext,i)


        def atom(self):
            return self.getTypedRuleContext(QLParser.AtomContext,0)


        def getRuleIndex(self):
            return QLParser.RULE_expr

        def enterRule(self, listener:ParseTreeListener):
            if isinstance( listener, QLListener ):
                listener.enterExpr(self)

        def exitRule(self, listener:ParseTreeListener):
            if isinstance( listener, QLListener ):
                listener.exitExpr(self)

        def accept(self, visitor:ParseTreeVisitor):
            if isinstance( visitor, QLVisitor ):
                return visitor.visitExpr(self)
            else:
                return visitor.visitChildren(self)



    def expr(self, _p:int=0):
        _parentctx = self._ctx
        _parentState = self.state
        localctx = QLParser.ExprContext(self, self._ctx, _parentState)
        _prevctx = localctx
        _startState = 12
        self.enterRecursionRule(localctx, 12, self.RULE_expr, _p)
        self._la = 0 # Token type
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 79
            token = self._input.LA(1)
            if token in [QLParser.T__12, QLParser.T__13, QLParser.T__14]:
                self.state = 72
                localctx.op = self._input.LT(1)
                _la = self._input.LA(1)
                if not((((_la) & ~0x3f) == 0 and ((1 << _la) & ((1 << QLParser.T__12) | (1 << QLParser.T__13) | (1 << QLParser.T__14))) != 0)):
                    localctx.op = self._errHandler.recoverInline(self)
                else:
                    self.consume()
                self.state = 73
                localctx.right = self.expr(9)

            elif token in [QLParser.T__10]:
                self.state = 74
                self.match(QLParser.T__10)
                self.state = 75
                localctx.left = self.expr(0)
                self.state = 76
                self.match(QLParser.T__11)

            elif token in [QLParser.T__27, QLParser.T__28, QLParser.STRING, QLParser.INTEGER, QLParser.MONEY, QLParser.IDENTIFIER]:
                self.state = 78
                localctx.left = self.atom()

            else:
                raise NoViableAltException(self)

            self._ctx.stop = self._input.LT(-1)
            self.state = 104
            self._errHandler.sync(self)
            _alt = self._interp.adaptivePredict(self._input,7,self._ctx)
            while _alt!=2 and _alt!=ATN.INVALID_ALT_NUMBER:
                if _alt==1:
                    if self._parseListeners is not None:
                        self.triggerExitRuleEvent()
                    _prevctx = localctx
                    self.state = 102
                    la_ = self._interp.adaptivePredict(self._input,6,self._ctx)
                    if la_ == 1:
                        localctx = QLParser.ExprContext(self, _parentctx, _parentState)
                        localctx.left = _prevctx
                        self.pushNewRecursionContext(localctx, _startState, self.RULE_expr)
                        self.state = 81
                        if not self.precpred(self._ctx, 8):
                            from antlr4.error.Errors import FailedPredicateException
                            raise FailedPredicateException(self, "self.precpred(self._ctx, 8)")
                        self.state = 82
                        localctx.op = self.match(QLParser.T__15)
                        self.state = 83
                        localctx.right = self.expr(9)
                        pass

                    elif la_ == 2:
                        localctx = QLParser.ExprContext(self, _parentctx, _parentState)
                        localctx.left = _prevctx
                        self.pushNewRecursionContext(localctx, _startState, self.RULE_expr)
                        self.state = 84
                        if not self.precpred(self._ctx, 7):
                            from antlr4.error.Errors import FailedPredicateException
                            raise FailedPredicateException(self, "self.precpred(self._ctx, 7)")
                        self.state = 85
                        localctx.op = self._input.LT(1)
                        _la = self._input.LA(1)
                        if not((((_la) & ~0x3f) == 0 and ((1 << _la) & ((1 << QLParser.T__16) | (1 << QLParser.T__17) | (1 << QLParser.T__18))) != 0)):
                            localctx.op = self._errHandler.recoverInline(self)
                        else:
                            self.consume()
                        self.state = 86
                        localctx.right = self.expr(8)
                        pass

                    elif la_ == 3:
                        localctx = QLParser.ExprContext(self, _parentctx, _parentState)
                        localctx.left = _prevctx
                        self.pushNewRecursionContext(localctx, _startState, self.RULE_expr)
                        self.state = 87
                        if not self.precpred(self._ctx, 6):
                            from antlr4.error.Errors import FailedPredicateException
                            raise FailedPredicateException(self, "self.precpred(self._ctx, 6)")
                        self.state = 88
                        localctx.op = self._input.LT(1)
                        _la = self._input.LA(1)
                        if not(_la==QLParser.T__12 or _la==QLParser.T__13):
                            localctx.op = self._errHandler.recoverInline(self)
                        else:
                            self.consume()
                        self.state = 89
                        localctx.right = self.expr(7)
                        pass

                    elif la_ == 4:
                        localctx = QLParser.ExprContext(self, _parentctx, _parentState)
                        localctx.left = _prevctx
                        self.pushNewRecursionContext(localctx, _startState, self.RULE_expr)
                        self.state = 90
                        if not self.precpred(self._ctx, 5):
                            from antlr4.error.Errors import FailedPredicateException
                            raise FailedPredicateException(self, "self.precpred(self._ctx, 5)")
                        self.state = 91
                        localctx.op = self._input.LT(1)
                        _la = self._input.LA(1)
                        if not((((_la) & ~0x3f) == 0 and ((1 << _la) & ((1 << QLParser.T__19) | (1 << QLParser.T__20) | (1 << QLParser.T__21) | (1 << QLParser.T__22))) != 0)):
                            localctx.op = self._errHandler.recoverInline(self)
                        else:
                            self.consume()
                        self.state = 92
                        localctx.right = self.expr(6)
                        pass

                    elif la_ == 5:
                        localctx = QLParser.ExprContext(self, _parentctx, _parentState)
                        localctx.left = _prevctx
                        self.pushNewRecursionContext(localctx, _startState, self.RULE_expr)
                        self.state = 93
                        if not self.precpred(self._ctx, 4):
                            from antlr4.error.Errors import FailedPredicateException
                            raise FailedPredicateException(self, "self.precpred(self._ctx, 4)")
                        self.state = 94
                        localctx.op = self._input.LT(1)
                        _la = self._input.LA(1)
                        if not(_la==QLParser.T__23 or _la==QLParser.T__24):
                            localctx.op = self._errHandler.recoverInline(self)
                        else:
                            self.consume()
                        self.state = 95
                        localctx.right = self.expr(5)
                        pass

                    elif la_ == 6:
                        localctx = QLParser.ExprContext(self, _parentctx, _parentState)
                        localctx.left = _prevctx
                        self.pushNewRecursionContext(localctx, _startState, self.RULE_expr)
                        self.state = 96
                        if not self.precpred(self._ctx, 3):
                            from antlr4.error.Errors import FailedPredicateException
                            raise FailedPredicateException(self, "self.precpred(self._ctx, 3)")
                        self.state = 97
                        localctx.op = self.match(QLParser.T__25)
                        self.state = 98
                        localctx.right = self.expr(4)
                        pass

                    elif la_ == 7:
                        localctx = QLParser.ExprContext(self, _parentctx, _parentState)
                        localctx.left = _prevctx
                        self.pushNewRecursionContext(localctx, _startState, self.RULE_expr)
                        self.state = 99
                        if not self.precpred(self._ctx, 2):
                            from antlr4.error.Errors import FailedPredicateException
                            raise FailedPredicateException(self, "self.precpred(self._ctx, 2)")
                        self.state = 100
                        localctx.op = self.match(QLParser.T__26)
                        self.state = 101
                        localctx.right = self.expr(3)
                        pass

             
                self.state = 106
                self._errHandler.sync(self)
                _alt = self._interp.adaptivePredict(self._input,7,self._ctx)

        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.unrollRecursionContexts(_parentctx)
        return localctx

    class AtomContext(ParserRuleContext):

        def __init__(self, parser, parent:ParserRuleContext=None, invokingState:int=-1):
            super().__init__(parent, invokingState)
            self.parser = parser

        def boolean(self):
            return self.getTypedRuleContext(QLParser.BooleanContext,0)


        def string(self):
            return self.getTypedRuleContext(QLParser.StringContext,0)


        def integer(self):
            return self.getTypedRuleContext(QLParser.IntegerContext,0)


        def identifier(self):
            return self.getTypedRuleContext(QLParser.IdentifierContext,0)


        def money(self):
            return self.getTypedRuleContext(QLParser.MoneyContext,0)


        def getRuleIndex(self):
            return QLParser.RULE_atom

        def enterRule(self, listener:ParseTreeListener):
            if isinstance( listener, QLListener ):
                listener.enterAtom(self)

        def exitRule(self, listener:ParseTreeListener):
            if isinstance( listener, QLListener ):
                listener.exitAtom(self)

        def accept(self, visitor:ParseTreeVisitor):
            if isinstance( visitor, QLVisitor ):
                return visitor.visitAtom(self)
            else:
                return visitor.visitChildren(self)




    def atom(self):

        localctx = QLParser.AtomContext(self, self._ctx, self.state)
        self.enterRule(localctx, 14, self.RULE_atom)
        try:
            self.state = 112
            token = self._input.LA(1)
            if token in [QLParser.T__27, QLParser.T__28]:
                self.enterOuterAlt(localctx, 1)
                self.state = 107
                self.boolean()

            elif token in [QLParser.STRING]:
                self.enterOuterAlt(localctx, 2)
                self.state = 108
                self.string()

            elif token in [QLParser.INTEGER]:
                self.enterOuterAlt(localctx, 3)
                self.state = 109
                self.integer()

            elif token in [QLParser.IDENTIFIER]:
                self.enterOuterAlt(localctx, 4)
                self.state = 110
                self.identifier()

            elif token in [QLParser.MONEY]:
                self.enterOuterAlt(localctx, 5)
                self.state = 111
                self.money()

            else:
                raise NoViableAltException(self)

        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.exitRule()
        return localctx

    class BooleanContext(ParserRuleContext):

        def __init__(self, parser, parent:ParserRuleContext=None, invokingState:int=-1):
            super().__init__(parent, invokingState)
            self.parser = parser


        def getRuleIndex(self):
            return QLParser.RULE_boolean

        def enterRule(self, listener:ParseTreeListener):
            if isinstance( listener, QLListener ):
                listener.enterBoolean(self)

        def exitRule(self, listener:ParseTreeListener):
            if isinstance( listener, QLListener ):
                listener.exitBoolean(self)

        def accept(self, visitor:ParseTreeVisitor):
            if isinstance( visitor, QLVisitor ):
                return visitor.visitBoolean(self)
            else:
                return visitor.visitChildren(self)




    def boolean(self):

        localctx = QLParser.BooleanContext(self, self._ctx, self.state)
        self.enterRule(localctx, 16, self.RULE_boolean)
        self._la = 0 # Token type
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 114
            _la = self._input.LA(1)
            if not(_la==QLParser.T__27 or _la==QLParser.T__28):
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

    class IdentifierContext(ParserRuleContext):

        def __init__(self, parser, parent:ParserRuleContext=None, invokingState:int=-1):
            super().__init__(parent, invokingState)
            self.parser = parser

        def IDENTIFIER(self):
            return self.getToken(QLParser.IDENTIFIER, 0)

        def getRuleIndex(self):
            return QLParser.RULE_identifier

        def enterRule(self, listener:ParseTreeListener):
            if isinstance( listener, QLListener ):
                listener.enterIdentifier(self)

        def exitRule(self, listener:ParseTreeListener):
            if isinstance( listener, QLListener ):
                listener.exitIdentifier(self)

        def accept(self, visitor:ParseTreeVisitor):
            if isinstance( visitor, QLVisitor ):
                return visitor.visitIdentifier(self)
            else:
                return visitor.visitChildren(self)




    def identifier(self):

        localctx = QLParser.IdentifierContext(self, self._ctx, self.state)
        self.enterRule(localctx, 18, self.RULE_identifier)
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 116
            self.match(QLParser.IDENTIFIER)
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
            return self.getToken(QLParser.STRING, 0)

        def getRuleIndex(self):
            return QLParser.RULE_string

        def enterRule(self, listener:ParseTreeListener):
            if isinstance( listener, QLListener ):
                listener.enterString(self)

        def exitRule(self, listener:ParseTreeListener):
            if isinstance( listener, QLListener ):
                listener.exitString(self)

        def accept(self, visitor:ParseTreeVisitor):
            if isinstance( visitor, QLVisitor ):
                return visitor.visitString(self)
            else:
                return visitor.visitChildren(self)




    def string(self):

        localctx = QLParser.StringContext(self, self._ctx, self.state)
        self.enterRule(localctx, 20, self.RULE_string)
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 118
            self.match(QLParser.STRING)
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
            return self.getToken(QLParser.INTEGER, 0)

        def getRuleIndex(self):
            return QLParser.RULE_integer

        def enterRule(self, listener:ParseTreeListener):
            if isinstance( listener, QLListener ):
                listener.enterInteger(self)

        def exitRule(self, listener:ParseTreeListener):
            if isinstance( listener, QLListener ):
                listener.exitInteger(self)

        def accept(self, visitor:ParseTreeVisitor):
            if isinstance( visitor, QLVisitor ):
                return visitor.visitInteger(self)
            else:
                return visitor.visitChildren(self)




    def integer(self):

        localctx = QLParser.IntegerContext(self, self._ctx, self.state)
        self.enterRule(localctx, 22, self.RULE_integer)
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 120
            self.match(QLParser.INTEGER)
        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.exitRule()
        return localctx

    class MoneyContext(ParserRuleContext):

        def __init__(self, parser, parent:ParserRuleContext=None, invokingState:int=-1):
            super().__init__(parent, invokingState)
            self.parser = parser

        def MONEY(self):
            return self.getToken(QLParser.MONEY, 0)

        def getRuleIndex(self):
            return QLParser.RULE_money

        def enterRule(self, listener:ParseTreeListener):
            if isinstance( listener, QLListener ):
                listener.enterMoney(self)

        def exitRule(self, listener:ParseTreeListener):
            if isinstance( listener, QLListener ):
                listener.exitMoney(self)

        def accept(self, visitor:ParseTreeVisitor):
            if isinstance( visitor, QLVisitor ):
                return visitor.visitMoney(self)
            else:
                return visitor.visitChildren(self)




    def money(self):

        localctx = QLParser.MoneyContext(self, self._ctx, self.state)
        self.enterRule(localctx, 24, self.RULE_money)
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 122
            self.match(QLParser.MONEY)
        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.exitRule()
        return localctx



    def sempred(self, localctx:RuleContext, ruleIndex:int, predIndex:int):
        if self._predicates == None:
            self._predicates = dict()
        self._predicates[6] = self.expr_sempred
        pred = self._predicates.get(ruleIndex, None)
        if pred is None:
            raise Exception("No predicate with index:" + str(ruleIndex))
        else:
            return pred(localctx, predIndex)

    def expr_sempred(self, localctx:ExprContext, predIndex:int):
            if predIndex == 0:
                return self.precpred(self._ctx, 8)
         

            if predIndex == 1:
                return self.precpred(self._ctx, 7)
         

            if predIndex == 2:
                return self.precpred(self._ctx, 6)
         

            if predIndex == 3:
                return self.precpred(self._ctx, 5)
         

            if predIndex == 4:
                return self.precpred(self._ctx, 4)
         

            if predIndex == 5:
                return self.precpred(self._ctx, 3)
         

            if predIndex == 6:
                return self.precpred(self._ctx, 2)
         



