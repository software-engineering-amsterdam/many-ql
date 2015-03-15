using AST;
using AST.Nodes.Expression;
using AST.Nodes.Literals;
using AST.Representation;
using Evaluation;
using Evaluator.Storage;
using QuestionnaireLanguage.Contracts;
using QuestionnaireLanguage.GUI.CustomUIElements.CustomPanels;
using QuestionnaireLanguage.Visitors;
using System.Collections.Generic;
using System.Windows;
using ASTFormObject = AST.Nodes.FormObject;
using AST.Nodes.Interfaces;
using Types = AST.Types;

namespace QuestionnaireLanguage.Controller
{
    public class MainController
    {
        private static ASTResult astTree;
        //private static SymbolTable symbolTable;
        private static IMainWindow window;

        public MainController(IMainWindow mainWindow, ASTResult ast)
        {
            window = mainWindow;
            astTree = ast;

            //symbolTable = new SymbolTable();
        }

        public static UIElement ProcessBody(IList<ASTFormObject.FormObject> body, UIElement form)
        {
            foreach (ASTFormObject.FormObject node in body)
            {
                form = new FormObjectVisitor().VisitFormObject(node).ProcessFormObject(form);
            }

            return form;
        }

        public static Literal GetObjectValue(Id id)
        {
            return SymbolTable.GetValue(id);
        }

        public static void UpdateValue(string id, Literal value)
        {
            SymbolTable.SetUpdateValue(new Id(id, new PositionInText()), value);

            window.DeleteElements();

            MainController.ProcessBody(astTree.Ast.GetBody(), window.GetRootElement());
        }
        
        public static Literal Evaluate(IExpression expression)
        {
            return new EvaluationManager().Evaluate(expression);
        }

        public static void AddValue(Id key, Types.Type type)
        {
            TypeToValueVisitor visitor = new TypeToValueVisitor();
            SymbolTable.AddValue(key, visitor.VisitValue(type));
        }

        public static UIElement AddChildren(UIElement element, UIElement form)
        {
            ((CustomStackPanel)form).Children.Add(element);
            return form;
        }
    }
}
