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
        buf.write("\u0080\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7")
        buf.write("\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16")
        buf.write("\t\16\3\2\3\2\3\2\5\2 \n\2\3\3\7\3#\n\3\f\3\16\3&\13\3")
        buf.write("\3\4\3\4\3\4\3\4\7\4,\n\4\f\4\16\4/\13\4\3\4\3\4\3\5\3")
        buf.write("\5\3\5\3\5\3\5\3\5\3\5\5\5:\n\5\3\5\3\5\3\6\3\6\3\6\3")
        buf.write("\6\7\6B\n\6\f\6\16\6E\13\6\3\6\3\6\3\7\3\7\3\b\3\b\3\b")
        buf.write("\3\b\3\b\3\b\3\b\3\b\5\bS\n\b\3\b\3\b\3\b\3\b\3\b\3\b")
        buf.write("\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3")
        buf.write("\b\3\b\7\bj\n\b\f\b\16\bm\13\b\3\t\3\t\3\t\3\t\3\t\5\t")
        buf.write("t\n\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\16")
        buf.write("\2\3\16\17\2\4\6\b\n\f\16\20\22\24\26\30\32\2\t\3\2\t")
        buf.write("\f\3\2\17\21\3\2\23\25\3\2\17\20\3\2\26\31\3\2\32\33\3")
        buf.write("\2\36\37\u0085\2\37\3\2\2\2\4$\3\2\2\2\6\'\3\2\2\2\b\62")
        buf.write("\3\2\2\2\n=\3\2\2\2\fH\3\2\2\2\16R\3\2\2\2\20s\3\2\2\2")
        buf.write("\22u\3\2\2\2\24w\3\2\2\2\26y\3\2\2\2\30{\3\2\2\2\32}\3")
        buf.write("\2\2\2\34 \5\6\4\2\35 \5\b\5\2\36 \5\n\6\2\37\34\3\2\2")
        buf.write("\2\37\35\3\2\2\2\37\36\3\2\2\2 \3\3\2\2\2!#\5\6\4\2\"")
        buf.write("!\3\2\2\2#&\3\2\2\2$\"\3\2\2\2$%\3\2\2\2%\5\3\2\2\2&$")
        buf.write("\3\2\2\2\'(\7\3\2\2()\5\24\13\2)-\7\4\2\2*,\5\2\2\2+*")
        buf.write("\3\2\2\2,/\3\2\2\2-+\3\2\2\2-.\3\2\2\2.\60\3\2\2\2/-\3")
        buf.write("\2\2\2\60\61\7\5\2\2\61\7\3\2\2\2\62\63\7\6\2\2\63\64")
        buf.write("\5\24\13\2\64\65\7\4\2\2\65\66\5\26\f\2\669\5\f\7\2\67")
        buf.write("8\7\7\2\28:\5\16\b\29\67\3\2\2\29:\3\2\2\2:;\3\2\2\2;")
        buf.write("<\7\5\2\2<\t\3\2\2\2=>\7\b\2\2>?\5\16\b\2?C\7\4\2\2@B")
        buf.write("\5\2\2\2A@\3\2\2\2BE\3\2\2\2CA\3\2\2\2CD\3\2\2\2DF\3\2")
        buf.write("\2\2EC\3\2\2\2FG\7\5\2\2G\13\3\2\2\2HI\t\2\2\2I\r\3\2")
        buf.write("\2\2JK\b\b\1\2KL\t\3\2\2LS\5\16\b\13MN\7\r\2\2NO\5\16")
        buf.write("\b\2OP\7\16\2\2PS\3\2\2\2QS\5\20\t\2RJ\3\2\2\2RM\3\2\2")
        buf.write("\2RQ\3\2\2\2Sk\3\2\2\2TU\f\n\2\2UV\7\22\2\2Vj\5\16\b\13")
        buf.write("WX\f\t\2\2XY\t\4\2\2Yj\5\16\b\nZ[\f\b\2\2[\\\t\5\2\2\\")
        buf.write("j\5\16\b\t]^\f\7\2\2^_\t\6\2\2_j\5\16\b\b`a\f\6\2\2ab")
        buf.write("\t\7\2\2bj\5\16\b\7cd\f\5\2\2de\7\34\2\2ej\5\16\b\6fg")
        buf.write("\f\4\2\2gh\7\35\2\2hj\5\16\b\5iT\3\2\2\2iW\3\2\2\2iZ\3")
        buf.write("\2\2\2i]\3\2\2\2i`\3\2\2\2ic\3\2\2\2if\3\2\2\2jm\3\2\2")
        buf.write("\2ki\3\2\2\2kl\3\2\2\2l\17\3\2\2\2mk\3\2\2\2nt\5\22\n")
        buf.write("\2ot\5\26\f\2pt\5\30\r\2qt\5\24\13\2rt\5\32\16\2sn\3\2")
        buf.write("\2\2so\3\2\2\2sp\3\2\2\2sq\3\2\2\2sr\3\2\2\2t\21\3\2\2")
        buf.write("\2uv\t\b\2\2v\23\3\2\2\2wx\7#\2\2x\25\3\2\2\2yz\7 \2\2")
        buf.write("z\27\3\2\2\2{|\7!\2\2|\31\3\2\2\2}~\7\"\2\2~\33\3\2\2")
        buf.write("\2\13\37$-9CRiks")
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

    RULE_statement = 0
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

    ruleNames =  [ "statement", "root", "form_statement", "question_statement", 
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



    class StatementContext(ParserRuleContext):

        def __init__(self, parser, parent:ParserRuleContext=None, invokingState:int=-1):
            super().__init__(parent, invokingState)
            self.parser = parser

        def form_statement(self):
            return self.getTypedRuleContext(QLParser.Form_statementContext,0)


        def question_statement(self):
            return self.getTypedRuleContext(QLParser.Question_statementContext,0)


        def if_statement(self):
            return self.getTypedRuleContext(QLParser.If_statementContext,0)


        def getRuleIndex(self):
            return QLParser.RULE_statement

        def enterRule(self, listener:ParseTreeListener):
            if isinstance( listener, QLListener ):
                listener.enterStatement(self)

        def exitRule(self, listener:ParseTreeListener):
            if isinstance( listener, QLListener ):
                listener.exitStatement(self)

        def accept(self, visitor:ParseTreeVisitor):
            if isinstance( visitor, QLVisitor ):
                return visitor.visitStatement(self)
            else:
                return visitor.visitChildren(self)




    def statement(self):

        localctx = QLParser.StatementContext(self, self._ctx, self.state)
        self.enterRule(localctx, 0, self.RULE_statement)
        try:
            self.state = 29
            token = self._input.LA(1)
            if token in [QLParser.T__0]:
                self.enterOuterAlt(localctx, 1)
                self.state = 26
                self.form_statement()

            elif token in [QLParser.T__3]:
                self.enterOuterAlt(localctx, 2)
                self.state = 27
                self.question_statement()

            elif token in [QLParser.T__5]:
                self.enterOuterAlt(localctx, 3)
                self.state = 28
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
            self.state = 34
            self._errHandler.sync(self)
            _la = self._input.LA(1)
            while _la==QLParser.T__0:
                self.state = 31
                self.form_statement()
                self.state = 36
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

        def identifier(self):
            return self.getTypedRuleContext(QLParser.IdentifierContext,0)


        def statement(self, i:int=None):
            if i is None:
                return self.getTypedRuleContexts(QLParser.StatementContext)
            else:
                return self.getTypedRuleContext(QLParser.StatementContext,i)


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
            self.state = 37
            self.match(QLParser.T__0)
            self.state = 38
            self.identifier()
            self.state = 39
            self.match(QLParser.T__1)
            self.state = 43
            self._errHandler.sync(self)
            _la = self._input.LA(1)
            while (((_la) & ~0x3f) == 0 and ((1 << _la) & ((1 << QLParser.T__0) | (1 << QLParser.T__3) | (1 << QLParser.T__5))) != 0):
                self.state = 40
                self.statement()
                self.state = 45
                self._errHandler.sync(self)
                _la = self._input.LA(1)

            self.state = 46
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
            self.state = 48
            self.match(QLParser.T__3)
            self.state = 49
            self.identifier()
            self.state = 50
            self.match(QLParser.T__1)
            self.state = 51
            self.string()
            self.state = 52
            self.question_type()
            self.state = 55
            _la = self._input.LA(1)
            if _la==QLParser.T__4:
                self.state = 53
                self.match(QLParser.T__4)
                self.state = 54
                self.expr(0)


            self.state = 57
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

        def expr(self):
            return self.getTypedRuleContext(QLParser.ExprContext,0)


        def statement(self, i:int=None):
            if i is None:
                return self.getTypedRuleContexts(QLParser.StatementContext)
            else:
                return self.getTypedRuleContext(QLParser.StatementContext,i)


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
            self.state = 59
            self.match(QLParser.T__5)
            self.state = 60
            self.expr(0)
            self.state = 61
            self.match(QLParser.T__1)
            self.state = 65
            self._errHandler.sync(self)
            _la = self._input.LA(1)
            while (((_la) & ~0x3f) == 0 and ((1 << _la) & ((1 << QLParser.T__0) | (1 << QLParser.T__3) | (1 << QLParser.T__5))) != 0):
                self.state = 62
                self.statement()
                self.state = 67
                self._errHandler.sync(self)
                _la = self._input.LA(1)

            self.state = 68
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
            self.state = 70
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
            self.state = 80
            token = self._input.LA(1)
            if token in [QLParser.T__12, QLParser.T__13, QLParser.T__14]:
                self.state = 73
                localctx.op = self._input.LT(1)
                _la = self._input.LA(1)
                if not((((_la) & ~0x3f) == 0 and ((1 << _la) & ((1 << QLParser.T__12) | (1 << QLParser.T__13) | (1 << QLParser.T__14))) != 0)):
                    localctx.op = self._errHandler.recoverInline(self)
                else:
                    self.consume()
                self.state = 74
                localctx.right = self.expr(9)

            elif token in [QLParser.T__10]:
                self.state = 75
                self.match(QLParser.T__10)
                self.state = 76
                self.expr(0)
                self.state = 77
                self.match(QLParser.T__11)

            elif token in [QLParser.T__27, QLParser.T__28, QLParser.STRING, QLParser.INTEGER, QLParser.MONEY, QLParser.IDENTIFIER]:
                self.state = 79
                localctx.left = self.atom()

            else:
                raise NoViableAltException(self)

            self._ctx.stop = self._input.LT(-1)
            self.state = 105
            self._errHandler.sync(self)
            _alt = self._interp.adaptivePredict(self._input,7,self._ctx)
            while _alt!=2 and _alt!=ATN.INVALID_ALT_NUMBER:
                if _alt==1:
                    if self._parseListeners is not None:
                        self.triggerExitRuleEvent()
                    _prevctx = localctx
                    self.state = 103
                    la_ = self._interp.adaptivePredict(self._input,6,self._ctx)
                    if la_ == 1:
                        localctx = QLParser.ExprContext(self, _parentctx, _parentState)
                        localctx.left = _prevctx
                        self.pushNewRecursionContext(localctx, _startState, self.RULE_expr)
                        self.state = 82
                        if not self.precpred(self._ctx, 8):
                            from antlr4.error.Errors import FailedPredicateException
                            raise FailedPredicateException(self, "self.precpred(self._ctx, 8)")
                        self.state = 83
                        localctx.op = self.match(QLParser.T__15)
                        self.state = 84
                        localctx.right = self.expr(9)
                        pass

                    elif la_ == 2:
                        localctx = QLParser.ExprContext(self, _parentctx, _parentState)
                        localctx.left = _prevctx
                        self.pushNewRecursionContext(localctx, _startState, self.RULE_expr)
                        self.state = 85
                        if not self.precpred(self._ctx, 7):
                            from antlr4.error.Errors import FailedPredicateException
                            raise FailedPredicateException(self, "self.precpred(self._ctx, 7)")
                        self.state = 86
                        localctx.op = self._input.LT(1)
                        _la = self._input.LA(1)
                        if not((((_la) & ~0x3f) == 0 and ((1 << _la) & ((1 << QLParser.T__16) | (1 << QLParser.T__17) | (1 << QLParser.T__18))) != 0)):
                            localctx.op = self._errHandler.recoverInline(self)
                        else:
                            self.consume()
                        self.state = 87
                        localctx.right = self.expr(8)
                        pass

                    elif la_ == 3:
                        localctx = QLParser.ExprContext(self, _parentctx, _parentState)
                        localctx.left = _prevctx
                        self.pushNewRecursionContext(localctx, _startState, self.RULE_expr)
                        self.state = 88
                        if not self.precpred(self._ctx, 6):
                            from antlr4.error.Errors import FailedPredicateException
                            raise FailedPredicateException(self, "self.precpred(self._ctx, 6)")
                        self.state = 89
                        localctx.op = self._input.LT(1)
                        _la = self._input.LA(1)
                        if not(_la==QLParser.T__12 or _la==QLParser.T__13):
                            localctx.op = self._errHandler.recoverInline(self)
                        else:
                            self.consume()
                        self.state = 90
                        localctx.right = self.expr(7)
                        pass

                    elif la_ == 4:
                        localctx = QLParser.ExprContext(self, _parentctx, _parentState)
                        localctx.left = _prevctx
                        self.pushNewRecursionContext(localctx, _startState, self.RULE_expr)
                        self.state = 91
                        if not self.precpred(self._ctx, 5):
                            from antlr4.error.Errors import FailedPredicateException
                            raise FailedPredicateException(self, "self.precpred(self._ctx, 5)")
                        self.state = 92
                        localctx.op = self._input.LT(1)
                        _la = self._input.LA(1)
                        if not((((_la) & ~0x3f) == 0 and ((1 << _la) & ((1 << QLParser.T__19) | (1 << QLParser.T__20) | (1 << QLParser.T__21) | (1 << QLParser.T__22))) != 0)):
                            localctx.op = self._errHandler.recoverInline(self)
                        else:
                            self.consume()
                        self.state = 93
                        localctx.right = self.expr(6)
                        pass

                    elif la_ == 5:
                        localctx = QLParser.ExprContext(self, _parentctx, _parentState)
                        localctx.left = _prevctx
                        self.pushNewRecursionContext(localctx, _startState, self.RULE_expr)
                        self.state = 94
                        if not self.precpred(self._ctx, 4):
                            from antlr4.error.Errors import FailedPredicateException
                            raise FailedPredicateException(self, "self.precpred(self._ctx, 4)")
                        self.state = 95
                        localctx.op = self._input.LT(1)
                        _la = self._input.LA(1)
                        if not(_la==QLParser.T__23 or _la==QLParser.T__24):
                            localctx.op = self._errHandler.recoverInline(self)
                        else:
                            self.consume()
                        self.state = 96
                        localctx.right = self.expr(5)
                        pass

                    elif la_ == 6:
                        localctx = QLParser.ExprContext(self, _parentctx, _parentState)
                        localctx.left = _prevctx
                        self.pushNewRecursionContext(localctx, _startState, self.RULE_expr)
                        self.state = 97
                        if not self.precpred(self._ctx, 3):
                            from antlr4.error.Errors import FailedPredicateException
                            raise FailedPredicateException(self, "self.precpred(self._ctx, 3)")
                        self.state = 98
                        localctx.op = self.match(QLParser.T__25)
                        self.state = 99
                        localctx.right = self.expr(4)
                        pass

                    elif la_ == 7:
                        localctx = QLParser.ExprContext(self, _parentctx, _parentState)
                        localctx.left = _prevctx
                        self.pushNewRecursionContext(localctx, _startState, self.RULE_expr)
                        self.state = 100
                        if not self.precpred(self._ctx, 2):
                            from antlr4.error.Errors import FailedPredicateException
                            raise FailedPredicateException(self, "self.precpred(self._ctx, 2)")
                        self.state = 101
                        localctx.op = self.match(QLParser.T__26)
                        self.state = 102
                        localctx.right = self.expr(3)
                        pass

             
                self.state = 107
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
            self.state = 113
            token = self._input.LA(1)
            if token in [QLParser.T__27, QLParser.T__28]:
                self.enterOuterAlt(localctx, 1)
                self.state = 108
                self.boolean()

            elif token in [QLParser.STRING]:
                self.enterOuterAlt(localctx, 2)
                self.state = 109
                self.string()

            elif token in [QLParser.INTEGER]:
                self.enterOuterAlt(localctx, 3)
                self.state = 110
                self.integer()

            elif token in [QLParser.IDENTIFIER]:
                self.enterOuterAlt(localctx, 4)
                self.state = 111
                self.identifier()

            elif token in [QLParser.MONEY]:
                self.enterOuterAlt(localctx, 5)
                self.state = 112
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
            self.state = 115
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
            self.state = 117
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
            self.state = 119
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
            self.state = 121
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
            self.state = 123
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
         



