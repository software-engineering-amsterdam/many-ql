using QuestionnaireLanguage.GUI.FormObject;
using QuestionnaireLanguage.GUI.Interfaces.FormObject;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Controls;
using AST.Nodes.FormObject;
using System.Windows;
using AST.Nodes;
using AST.Representation;
using QuestionnaireLanguage.Resources;
using ASTIFormObject = AST.Nodes.Interfaces;
using QuestionnaireLanguage.GUI.Factories.FormObjects;
using AST.Nodes.Expression;
using QuestionnaireLanguage.GUI.CustomUIElements.CustomControls;
using AST;
using QuestionnaireLanguage.Visitors;
using QuestionnaireLanguage.GUI.Widgets;
using QuestionnaireLanguage.Contracts;
using QuestionnaireLanguage.GUI.CustomUIElements.CustomPanel;
using AST.Evaluation;
using AST.Nodes.Values;

namespace QuestionnaireLanguage.Controller
{
    public class Processor
    {
        private static ASTResult astTree;
        private static Evaluator evaluator;
        private static IMain window;

        public ASTResult AstTree
        {
            get { return astTree; }
        }

        public Processor(IMain mainWindow, ASTResult ast)
        {
            window = mainWindow;
            astTree = ast;

            evaluator = new Evaluator();
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

        public static Value GetObjectValue(Id id)
        {
            return astTree.GetValue(id);
        }

        public static void SetObjectValue(Id id, Value value)
        {
            astTree.SetValue(id,value);
        }

        public static void DeleteAstResult()
        {
            //astTree = null;
        }

        public static void UpdateChanges()
        {
            UIElementCollection collection = window.GetControls();
        }

        public static void SetVisible()
        {
        }

        public static bool Evaluate(ASTIFormObject.IExpression expression)
        {
            Value value = evaluator.Evaluate(expression);
            return false;
        }

        public static void AddValue(string key, Value value, PositionInText positionInText)
        {
            evaluator.AddValue(new Id(key,positionInText),value);
        }

        /*TODO
         * - Evaluate inputs
         * - Change visibility
         */

    }
}
