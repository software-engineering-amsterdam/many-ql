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
    '(' expr=expression ')'                                         #BracedExpression
    | leftHand=expression  operator=MULDIV rightHand=expression     #MulDiv
    | leftHand=expression  operator=ADDSUB rightHand=expression     #AddSub
    | leftHand=expression  operator=NOT rightHand=expression        #Not
    | leftHand=expression  operator=AND rightHand=expression        #And
    | leftHand=expression  operator=OR rightHand=expression         #Or
    | leftHand=expression  operator=LTGTLEGE rightHand=expression   #LtGtLeGe
    | leftHand=expression  operator=NEEQ rightHand=expression       #NeEq
    | name=NAME                                                     #Name
    ;
    
