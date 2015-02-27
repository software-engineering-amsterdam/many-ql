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

        public void Interpretet(object answers)
        {

        }

        public override void Visit(Form form)
        {
            foreach (var statement in form.Statements)
            {
                statement.Accept(this);
            }
        }

        public override void Visit(Declaration declaration)
        {
            if (!_variables.Keys.Contains(declaration.Id.Name))
            {
                _variables.Add(declaration.Id.Name, new Undefined());

                if (declaration.Initialization != null)
                {
                    Value value = declaration.Initialization.Accept(new ExpressionInterpreter());
                    _variables[declaration.Id.Name] = value;
                }
            }
            else
            {
                throw new InvalidOperationException("");
            }
        }

        public override void Visit(Assignment assignment)
        {
            if (!_variables.Keys.Contains(assignment.Variable.Name))
            {
                
            }
        }

        public override void Visit(Question question)
        {
            base.Visit(question);
        }

        public override void Visit(IfStatement ifStatement)
        {
            Value condition = ifStatement.If.Accept(new ExpressionInterpreter());

            if (!condition.IsUndefined)
            {
                var result = (BooleanValue)condition;

                if (result.Val)
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
