using System.Collections.Generic;
using System.Diagnostics.Contracts;
using System.Linq;
using Antlr4.Runtime.Tree;
using QL.AST;
using QL.AST.Nodes;
using QL.AST.Nodes.Branches;
using QL.AST.Nodes.Branches.Operators;
using QL.AST.Nodes.Terminals;
using QL.Exceptions;
using QL.Exceptions.Errors;
using QL.Grammar;
using QL.Grammar;

namespace QL.Hollywood.DataHandlers.ASTCreation
{
    public class QLListener : QLBaseListener
    {
        #region Common
        private readonly Stack<Stack<ElementBase>> _childrenStack;
        private Form _astRootNode;
        private IList<QLBaseException> AstBuilderExceptions;


        public QLListener()
        {
            _childrenStack = new Stack<Stack<ElementBase>>();
            AstBuilderExceptions = new List<QLBaseException>();

        }

        public QLListener(IList<QLBaseException> AstBuilderExceptions)
        {
            this.AstBuilderExceptions = AstBuilderExceptions;
            _childrenStack = new Stack<Stack<ElementBase>>();

        }

        public void InitializeNewLevel()
        {
            _childrenStack.Push(new Stack<ElementBase>());
        }

        public bool AstExists
        {
            get { return _astRootNode != null; }
        }
        
        public Form GetAstRootNode()
        {
            return AstExists ? _astRootNode : null;
        }

        void ThrowExceptionIfAny()
        {
            if (AstBuilderExceptions.Any())
            {
                throw AstBuilderExceptions.Last();
            }
        }
        private IList<ElementBase> GetChildren()
        {
            ThrowExceptionIfAny();
            Contract.Assert(_childrenStack.Any(), "Level with children should be always initialized before appending one.");//TODO maybe throw it out
            Stack<ElementBase> children = _childrenStack.Pop();
            //stack has opposite ordering, need to be reversed to have the order as it was created.  // todo use queue instead          
            IList<ElementBase> reversed = children.Reverse().ToList();            
            return reversed;
        }

        private void AppendToAST(ElementBase newChild)
        {
            if (_childrenStack.Any())
            {
                Stack<ElementBase> siblings = _childrenStack.Peek();
                siblings.Push(newChild);
            }
            else
            {
                try
                {
                    //this is the last one
                    _astRootNode = (Form)newChild;
                }
                catch
                {
                    // todo add ex to list of errors as fatal error
                    _astRootNode = null;
                    throw;
                }
            }
        }

        #endregion

        # region  Overridden listener methods
        public override void EnterFormBlock(QLParser.FormBlockContext context)
        {
            InitializeNewLevel();

        }
        public override void ExitFormBlock(QLParser.FormBlockContext context)
        {
            IList<ElementBase> children = GetChildren();

            if (children.Count() != 1)
            {
                AstBuilderExceptions.Add(new ParserError("initial form block should have only one child", SourceLocation.CreateFor(context)));
                return;
            }
            
            Identifier formBlockId = new Identifier(context.IDENTIFIER().GetText());
            Block bodyBlock = (Block)children[0];
            Form form = new Form(formBlockId, bodyBlock);
            form.SourceLocation = SourceLocation.CreateFor(context);
            AppendToAST(form);
        }

        public override void EnterBlock(QLParser.BlockContext context)
        {
            InitializeNewLevel();
        }

        public override void ExitBlock(QLParser.BlockContext context)
        {
            Block block = new Block();
            block.SourceLocation = SourceLocation.CreateFor(context);
            block.Children = GetChildren();
            AppendToAST(block);
        }

        public override void EnterQuestionUnit(QLParser.QuestionUnitContext context)
        {
            InitializeNewLevel();
        }

        public override void ExitQuestionUnit(QLParser.QuestionUnitContext context)
        {
            IList<ElementBase> children = GetChildren();//either call this or remove the InitializeNewLevel above
            ThrowExceptionIfAny();
            Contract.Assert(!children.Any(), "A question should syntactically not have any children.");

            Identifier identifier = new Identifier(context.IDENTIFIER().GetText());
            IResolvableTerminalType dataType = GetTypeInstance(context.type());

            string unitText = context.TEXT().GetText();

            QuestionUnit question = new QuestionUnit();

            question.Identifier = identifier;
            question.DataType = dataType;
            question.DisplayText = unitText;
            question.SourceLocation = SourceLocation.CreateFor(context);

            AppendToAST(question);
        }

        public override void EnterStatementUnit(QLParser.StatementUnitContext context)
        {
            InitializeNewLevel();
        }

        public override void ExitStatementUnit(QLParser.StatementUnitContext context)
        {
            IList<ElementBase> children = GetChildren();
            ThrowExceptionIfAny();
            Contract.Assert(children.Count() == 1, "A statement should have only expression as a child.");

            Identifier identifier = new Identifier(context.IDENTIFIER().GetText());
            IResolvableTerminalType dataType = GetTypeInstance(context.type());
            string unitText = context.TEXT().GetText();

            StatementUnit statement = new StatementUnit();

            statement.Expression = (Expression)children[0];
            statement.Identifier = identifier;
            statement.DataType = dataType;
            statement.DisplayText = unitText;
            statement.SourceLocation = SourceLocation.CreateFor(context);

            AppendToAST(statement);
        }

        public IResolvableTerminalType GetTypeInstance(QLParser.TypeContext context)
        {
            if (context as QLParser.YesnoContext != null) return new Yesno();

            if (context as QLParser.NumberContext != null) return new Number();

            if (context as QLParser.TextContext != null) return new Text();

            AstBuilderExceptions.Add(new QLError("No appropriate type given", SourceLocation.CreateFor(context)));
            return null; // formality
        }

        public override void EnterControlUnit(QLParser.ControlUnitContext context)
        {
            InitializeNewLevel();
        }

        public override void ExitControlUnit(QLParser.ControlUnitContext context)
        {
            IList<ElementBase> children = GetChildren();

            ControlUnit controlUnit = new ControlUnit();
            Contract.Assert(children.Count() == 2 || children.Count() == 3, "Bad number of controlUnit children");
            controlUnit.Expression = (Expression)children[0];
            controlUnit.ConditionTrueBlock = (Block)children[1];
            if (children.Count() == 3)
            {
                controlUnit.ConditionFalseBlock = (Block)children[2];
            }
                        
            controlUnit.SourceLocation = SourceLocation.CreateFor(context);

            AppendToAST(controlUnit);
        }

        public override void EnterLiteral(QLParser.LiteralContext context)
        {
            InitializeNewLevel();
        }

        public override void ExitLiteral(QLParser.LiteralContext context)
        {
            IList<ElementBase> children = GetChildren();
            if (context.YESNO() != null)
            {
                Yesno literal = new Yesno();
                literal.SetValue(context.YESNO().GetText());
                literal.SourceLocation = SourceLocation.CreateFor(context);
                AppendToAST(literal);

            }
            else if (context.NUMBER() != null)
            {
                Number literal = new Number();
                literal.SetValue(context.NUMBER().GetText());
                literal.SourceLocation = SourceLocation.CreateFor(context);

                AppendToAST(literal);
            }
            else if (context.IDENTIFIER() != null)
            {
                Identifier literal = new Identifier();
                literal.SetValue(context.IDENTIFIER().GetText());
                literal.SourceLocation = SourceLocation.CreateFor(context);

                AppendToAST(literal);
            }
            else if (context.TEXT() != null)
            {
                Text literal = new Text();
                literal.SetValue(context.TEXT().GetText());
                literal.SourceLocation = SourceLocation.CreateFor(context);

                AppendToAST(literal);
            }
            else
            {
                throw new QLError("not known literal");
                
            }

            ThrowExceptionIfAny();
            Contract.Assert(!children.Any(), "Children of the literal are not empty");
        }        

        public override void EnterExpression(QLParser.ExpressionContext context)
        {
            InitializeNewLevel();
        }

        public override void ExitExpression(QLParser.ExpressionContext context)
        {
            IList<ElementBase> children = GetChildren();

            Expression expression;

            if (children.Count() == 1)
            {
                expression=new Expression(children[0]);
            }
            else if (children.Count() == 2 && context.children.Count() == 5)
            {
                QLParser.OperatorContext operatorContext = context.children[2] as QLParser.OperatorContext;
                ElementBase leftOperand = children[0];
                ElementBase rightOperand = children[1];

                if (operatorContext != null)
                {
                    BinaryTreeElementBase operatorElement = null;
                    TryCreateOperator<EqualsOperator>(operatorContext, operatorContext.EQUALS(), leftOperand, rightOperand, ref operatorElement);
                    TryCreateOperator<NotEqualsOperator>(operatorContext, operatorContext.NOTEQUALS(), leftOperand, rightOperand, ref operatorElement);
                    TryCreateOperator<GreaterThanOperator>(operatorContext, operatorContext.GREATERTHAN(), leftOperand, rightOperand, ref operatorElement);
                    TryCreateOperator<GreaterThanEqualToOperator>(operatorContext, operatorContext.GREATERTHANOREQUALTO(), leftOperand, rightOperand, ref operatorElement);
                    TryCreateOperator<LessThanOperator>(operatorContext, operatorContext.LESSTHAN(), leftOperand, rightOperand, ref operatorElement);
                    TryCreateOperator<LessThanEqualToOperator>(operatorContext, operatorContext.LESSTHANOREQUALTO(), leftOperand, rightOperand, ref operatorElement);
                    TryCreateOperator<MultiplicationOperator>(operatorContext, operatorContext.MULTIPLICATION(), leftOperand, rightOperand, ref operatorElement);
                    TryCreateOperator<DivisionOperator>(operatorContext, operatorContext.DIVISION(), leftOperand, rightOperand, ref operatorElement);
                    TryCreateOperator<PlusOperator>(operatorContext, operatorContext.ADDITION(), leftOperand, rightOperand, ref operatorElement);
                    TryCreateOperator<MinusOperator>(operatorContext, operatorContext.SUBTRACTION(), leftOperand, rightOperand, ref operatorElement);
                    TryCreateOperator<AndOperator>(operatorContext, operatorContext.AND(), leftOperand, rightOperand, ref operatorElement);
                    TryCreateOperator<OrOperator>(operatorContext, operatorContext.OR(), leftOperand, rightOperand, ref operatorElement);

                    expression= new Expression(operatorElement);
                }
                else
                {
                    throw new QLError("Unknown operator");
                }

            }
            else
            {
                throw new QLError("Expression without a child");

            }
            expression.SourceLocation = SourceLocation.CreateFor(context); // not sure if context is the correct location of a literal wrapped in an expr

            AppendToAST(expression);
        }
        

        public void TryCreateOperator<T>(QLParser.OperatorContext context, ITerminalNode node, ElementBase leftOperand, ElementBase rightOperand, ref BinaryTreeElementBase operatorElement)
            where T : BinaryTreeElementBase, IOperator, new()
        {
            if (node == null)
            {
                operatorElement = operatorElement ?? null;
                return;
            }

            T @operator = new T();
            @operator.Left=leftOperand;
            @operator.Right=rightOperand;
            @operator.SourceLocation = SourceLocation.CreateFor(context);

            operatorElement = @operator;
        }
        #endregion
    }


}
