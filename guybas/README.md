README <br />
    QL <br />
        Grammar <br />
            Basic Types             : containing all basic types needed for forms and expressions <br />
            Expression              : grammar of creating expressions <br />
            Form                    : grammar of the total form using basic types and expressions <br />
        Factory
            expression              : create AST (expression) elements out of the parsed tokens <br />
            form                    : idem for form elements <br />
        AST <br />
            Statements <br />
                statement           : statement interface who provides the methods needed to be overridden <br />
                question            : question implementing interface <br />
                if statement        : idem for if statements <br />
                else statement      : sub class of if statement <br />
                assignment          : assignment implementing interface <br />
            Expressions
                expression          : interface for expressions <br />
                simple expression   : expression consisting of multiple elements (primitives or complex expressions) <br />
                complex expression  : simple (or complex) expression in parenthesis <br />
            Elements
                element             : primitive element interface providing methods needed to be overridden by sub classes <br />
                bool                : boolean element being True or False <br />
                number              : number element <br />
                text                : string element <br />
                variable            : variable which can be one of the above types <br />
                operator            : operator element <br />
            form                    : the overarching form object containing everything else in the AST <br />
                                      provides all information using visitors to visit the rest of the AST <br />
        Tools <br />
            expression validator    : checks if expressions are of type boolean and correct using pyparsing again <br />
            type checker            : checks for all other properties the form should conform to <br />
            converters              : NOT NEEDED RIGHT? <br />
            exceptions              : our custom exceptions for better readability <br />
        Runtime <br />
            form api                : non finished object using form and being an api to the outside world <br />
            mapper                  : map containing functions to update answers and do associated changes <br />
            processor               : evaluate the expressions after answers are updated and return the new values <br />
        GUI <br />
            Elements <br />
               element              : interface for GUI elements <br />
               label                : as the name suggests <br />
               radio button         : idem <br />
               spinbox              : idem <br />
               text entry           : idem <br />
            gui                     : the actual drawing of the form <br />
        Tests                       : unit tests <br />
        executer                    : the main thing <br />

