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
    
section: 'section' name=STRINGLITERAL '{'
         section*
         question*
         defaults?
         '}';

question:  'question' name=NAME
            widget?;
            
widget: 'widget' spinbox | radio;

spinbox: 'spinbox';

radio: 'radio' '(' STRINGLITERAL (',' STRINGLITERAL)* ')';

defaults: 'default' DATATYPE '{'
          ('width:' INTEGERLITERAL)?
          ('font:' STRINGLITERAL)?
          ('fontsize:' INTEGERLITERAL)?
          ('color:' INTEGERLITERAL)?
          (widget)?
          '}';
