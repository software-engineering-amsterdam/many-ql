grammar EncodersQL;
import EncodersQLLexerRules;

questionnaire:
    'form' formName=NAME '{'  
    (stmt+=statement)+
    '}'
    EOF;

statement: question | conditionalBlock;
        
question:
     questionString=QUOTEDSTRING 
     questionName=NAME ':' type=DATATYPE ('=' expr=expression)? ;
         
     
conditionalBlock:
     'if' '(' conditional ')' '{' 
     q+=question+
     '}' ;
    
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
    
