grammar EncodersQL;
import EncodersQLLexerRules;

questionnaire:
    'form' formName=NAME '{'  NL
    (question | conditionalBlock | NL )+
    '}'
    EOF;

        
question:
     questionString=QUOTEDSTRING NL
     questionName=NAME ':' type=DATATYPE NL;
    
    
conditionalBlock:
     'if' '(' conditional ')' '{' NL
    question+
     '}' NL;
    
conditional:
    NAME;
    