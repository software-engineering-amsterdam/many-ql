grammar EncodersQLS;
import EncodersQLSLexerRules;

stylesheet:
    'stylesheet' name=NAME 
    page+
    EOF;
    
page: 'page' name=NAME '{'
      section+
      defaults?
      '}';
    
section: 'section' name=STRINGLITERAL
      ('{' (question | section | defaults)+ '}') |   (question defaults?)
         ;

question:  'question' name=NAME
            widget?;
            
widget: 'widget' (spinbox | radio | checkbox);

spinbox: 'spinbox';

checkbox: 'checkbox';

radio: 'radio' '(' STRINGLITERAL (',' STRINGLITERAL)* ')';

defaults: 'default' DATATYPE 
         property | ('{' (property)+ '}');

property:   ('width:' value=INTEGERLITERAL)
          | ('font:' value=STRINGLITERAL)
          | ('fontsize:' value=INTEGERLITERAL)
          | ('color:' '#'value=INTEGERLITERAL)
          | (widget)
          ;