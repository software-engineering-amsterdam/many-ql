README <br />
    QL
        Grammar
            Basic Types             : containing all basic types needed for forms and expressions
            Expression              : grammar of creating expressions
            Form                    : grammar of the total form using basic types and expressions
        Factory
            expression              : create AST (expression) elements out of the parsed tokens
            form                    : idem for form elements
        AST
            Statements
                statement           : statement interface who provides the methods needed to be overridden
                question            : question implementing interface
                if statement        : idem for if statements
                else statement      : sub class of if statement
                assignment          : assignment implementing interface
            Expressions
                expression          : interface for expressions
                simple expression   : expression consisting of multiple elements (primites or complex expressions)
                complex expression  : simple (or complex) expression in parenthesis
            Elements
                element             : primitive element interface providing methods needed to be overridden by sub classes
                bool                : boolean element being True or False
                number              : number element
                text                : string element
                variable            : variable which can be one of the above types
                operator            : operator element
            form                    : the overarching form object containing everything else in the AST
                                      provides all information using visitors to visit the rest of the AST
        Tools
            expression validator    : checks if expressions are of type boolean and correct using pyparsing again
            type checker            : checks for all other properties the form should conform to
            converters              : NOT NEEDED RIGHT?
            exceptions              : our custom exceptions for better readability
        Runtime
            form api                : non finished object using form and being an api to the outside world
            mapper                  : map containing functions to update answers and do associated changes
            processor               : evaluate the expressions after answers are updated and return the new values
        GUI
            Elements
               element              : interface for GUI elements
               label                : as the name suggests
               radio button         : idem
               spinbox              : idem
               text entry           : idem
            gui                     : the actual drawing of the form
        Tests                       : unit tests
        executer                    : the main thing

