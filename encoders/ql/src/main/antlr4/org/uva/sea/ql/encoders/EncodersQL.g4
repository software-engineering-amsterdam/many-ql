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
     expr=expression;
     
conditionalBlock:
     'if' '(' conditional ')' '{' NL
     question+
     '}' NL;
    
conditional:
    NAME;
    
expression:
    '(' expr=expression ')'
    | leftHand=expression  operator=MULDIV rightHand=expression
    | leftHand=expression  operator=ADDSUB rightHand=expression
    | leftHand=expression  operator=NOT rightHand=expression
    | leftHand=expression  operator=AND rightHand=expression
    | leftHand=expression  operator=OR rightHand=expression
    | leftHand=expression  operator=LTGTLEGE rightHand=expression
    | leftHand=expression  operator=NEEQ rightHand=expression  
    | name=NAME;
    
