grammar EncodersQL;
import EncodersQLLexerRules;

questionnaire: 'form' name=NAME '{' statement+ '}' EOF;

statement: question | conditionalBlock;

question: label=STRINGLITERAL name=NAME ':' type=dataType ('=' computed=expression)?;

dataType:  
       'boolean' #BooleanType
     | 'integer' #IntegerType
     | 'string'  #StringType
     ;

conditionalBlock: 'if' '(' expression ')' '{' question+ '}';
    
expression:
     '(' expr=expression ')'                                                    #BracedExpression
    |                      operator='!'                 expr=expression         #Not
    | leftHand=expression  operator=('*'|'/')           rightHand=expression    #MulDiv
    | leftHand=expression  operator=('+'|'-')           rightHand=expression    #AddSub
    | leftHand=expression  operator='&&'                rightHand=expression    #And
    | leftHand=expression  operator='||'                rightHand=expression    #Or
    | leftHand=expression  operator=('<'|'>'|'<='|'>=') rightHand=expression    #LtGtLeGe
    | leftHand=expression  operator=('!='|'==')         rightHand=expression    #NeEq
    | name=NAME                                                                 #NameExpression
    | value=literal                                                             #LiteralExpression
    ;

literal: STRINGLITERAL     #StringLiteral
       | BOOLEANLITERAL    #BooleanLiteral
       | INTEGERLITERAL    #IntegerLiteral
       ;