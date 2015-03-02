using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UvA.SoftCon.Questionnaire.AST;
using UvA.SoftCon.Questionnaire.AST.Model;
using UvA.SoftCon.Questionnaire.AST.Model.Statements;
using UvA.SoftCon.Questionnaire.Runtime.Evaluation.Types;

namespace UvA.SoftCon.Questionnaire.Runtime.Evaluation
{
    public class Interpreter : ASTVisitor
    {
        private IDictionary<string, Value> _variables = new Dictionary<string, Value>();

        public IDictionary<string, Value> AvailableQuestions
        {
            get;
            private set;
        }

        public void Interpretet(QuestionForm form, IDictionary<string, Value> answers)
        {
            if (answers == null) { throw new ArgumentNullException("answers"); }

            _variables = answers;
            AvailableQuestions = new Dictionary<string, Value>();

            Visit(form);
        }

        public override void Visit(QuestionForm form)
        {
            foreach (var statement in form.Statements)
            {
                statement.Accept(this);
            }
        }

        public override void Visit(Declaration declaration)
        {
            if (!_variables.ContainsKey(declaration.Id.Name))
            {
                Value initialization = new Undefined();

                if (declaration.Initialization != null)
                {
                    initialization = declaration.Initialization.Accept(new ExpressionInterpreter(_variables));
                }

                _variables.Add(declaration.Id.Name, initialization);
            }
            else
            {
                string message = String.Format("A variable with the name '{0}' is already declared.", declaration.Id.Name);
                throw new InvalidOperationException(message);
            }
        }

        public override void Visit(Assignment assignment)
        {
            if (_variables.ContainsKey(assignment.Variable.Name))
            {
                _variables[assignment.Variable.Name] = assignment.Expression.Accept(new ExpressionInterpreter(_variables));
            }
            else
            {
                string message = String.Format("Cannot assign value to undeclared variable '{0}'.", assignment.Variable.Name);
                throw new InvalidOperationException(message);
            }
        }

        public override void Visit(Question question)
        {
            Value result = new Undefined();

            if (question.IsComputed)
            {
                result = question.Expression.Accept(new ExpressionInterpreter(_variables));
            }

            AvailableQuestions.Add(question.Id.Name, result);
        }

        public override void Visit(IfStatement ifStatement)
        {
            Value result = ifStatement.If.Accept(new ExpressionInterpreter(_variables));

            if (!result.IsUndefined)
            {
                if (((BooleanValue)result).Val)
                {
                    foreach (var statement in ifStatement.Then)
                    {
                        statement.Accept(this);
                    }
                }
                else
                {
                    foreach (var statement in ifStatement.Else)
                    {
                        statement.Accept(this);
                    }
                }
            }
        }
    }
}
