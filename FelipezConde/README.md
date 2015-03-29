Jonatan Felipez (10766499)
Daniel Conde (10737944)

# How the project works:
Here's an outline of where some important stuff is located

## Entry point
This is QLGui.MainWindow.MainWindow(). This is a consequence of using wpf.
unfortunately, there is no main method and we were unable to change this entry point to something else.
There is no main method as we'd like to see, instead the entrypoint is this.

## Grammar
Grammar project, parsers generated using Antlr4

## AST
AST project

## Evaluator
Evaluation project, also contains the symbolTable and the values as well as a valuevisitor interface
Tests are in Evaluation.Test

## TypeChecking
The typechecking project. the collectors are visitors that go through a tree and collect data.
The checkers do the type checking using the collectors if they need to. Tests in TypeChecking.Test

## Notifications
blueprint for DSL errors and warnings as well as a Notification manager with interface (in case a different implementation is needed)

## GUI
The Gui is in the same project as the main entry point: QLGui It takes care of creating a visual representation of the tree.

##Input and output
In the file "App.Config" in QLGui you can change where input and output will come from.





