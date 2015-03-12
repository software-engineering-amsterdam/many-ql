using AST;
using AST.Nodes.Expression;
using AST.Nodes.Literals;
using AST.Representation;
using Evaluation;
using QuestionnaireLanguage.Contracts;
using QuestionnaireLanguage.Visitors;
using System.Collections.Generic;
using System.Linq;
using System.Windows;
using System.Windows.Controls;
using ASTIFormObject = AST.Nodes.Interfaces;
using Types = AST.Types;

namespace QuestionnaireLanguage.Controller
{
    public class Processor
    {
        private static ASTResult astTree;
        private static EvaluationManager evaluator;
        private static IMain window;

        public ASTResult AstTree
        {
            get { return astTree; }
        }

        public Processor(IMain mainWindow, ASTResult ast)
        {
            window = mainWindow;
            astTree = ast;

            evaluator = new EvaluationManager();
        }

        public static UIElement ProcessBody(IList<ASTIFormObject.IFormObject> body, UIElement form)
        {
            foreach (ASTIFormObject.IFormObject node in body)
            {
                form = new FormObjectVisitor().VisitFormObject(node).ProcessFormObject(form);
            }

            return form;
        }

        public Control FindControl(string nameControlToFind)
        {
            Control result = null;

            foreach (Control control in window.GetControls().OfType<Control>())
            {
                if (control.Name.Equals(nameControlToFind))
                {
                    result = control;
                    break;
                }
            }

            return result;
        }

        public static Literal GetObjectValue(Id id)
        {
            return evaluator.GetValue(id);
        }

        public static void UpdateValue(string id, Literal value)
        {
            evaluator.UpdateValue(new Id(id,new PositionInText()),value);
            window.DeleteElements();
            Processor.ProcessBody(astTree.Ast.GetBody(), window.GetRootElement());
        }

        public static void UpdateChanges()
        {
            Processor.ProcessBody(astTree.Ast.GetBody(), window.GetRootElement());
        }

        public static void SetVisible()
        {
        }

        public static Literal Evaluate(ASTIFormObject.IExpression expression)
        {
            return evaluator.Evaluate(expression);
        }

        public static void AddValue(Id key, Types.Type type)
        {
            TypeToValueVisitor visitor = new TypeToValueVisitor();
            evaluator.AddValue(key,visitor.VisitValue(type));
        }

        public static void UpdateValue(Id key, Types.Type type)
        {
            TypeToValueVisitor visitor = new TypeToValueVisitor();
            evaluator.AddValue(key, visitor.VisitValue(type));
        }

        internal static void SetFocus(IInputElement inputElement)
        {
            window.SetFocus(inputElement);
        }
    }
}
