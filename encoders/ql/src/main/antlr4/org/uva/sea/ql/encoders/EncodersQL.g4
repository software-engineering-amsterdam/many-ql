grammar EncodersQL;
import EncodersQLLexerRules;

questionnaire:
    'form' formName=NAME '{'  NL
    (question | conditionalBlock | NL )+
    '}'
    EOF;

        
question:
     questionString=QUOTEDSTRING NL
     questionName=NAME ':' type=DATATYPE computation? NL;
         
computation:
     '=' NL
     '(' expression ')';
     
conditionalBlock:
     'if' '(' conditional ')' '{' NL
     question+
     '}' NL;
    
conditional:
    NAME;
    
expression:
    leftHand=expression  operator=OPERATOR rightHand=expression
    | NAME;
    