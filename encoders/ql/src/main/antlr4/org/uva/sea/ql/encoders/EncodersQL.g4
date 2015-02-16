grammar EncodersQL;
import EncodersQLLexerRules;

questionnaire:
    'form' WS formName=NAME WS '{' WS* NL
    (question | conditionalBlock | NL )+
    '}'
    EOF;

        
question:
    WS* questionString=QUOTEDSTRING NL
    WS* questionName=NAME ':' WS type=DATATYPE NL;
    
    
conditionalBlock:
    WS* 'if' WS '(' conditional ')' WS '{' NL
    question+
    WS* '}' NL;
    
conditional:
    NAME;
    