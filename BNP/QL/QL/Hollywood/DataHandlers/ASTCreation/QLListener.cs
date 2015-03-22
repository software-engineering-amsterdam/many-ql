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

            if (children.Count() != 2)
            {
                AstBuilderExceptions.Add(new ParserError("initial form block should have only two children", SourceLocation.CreateFor(context)));
                return;
            }

            Form form = new Form((Identifier)children[0], (Block)children[1]);
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
        public override void EnterUnit(QLParser.UnitContext context)
        {
            InitializeNewLevel();
        }

        public override void ExitQuestionUnit(QLParser.QuestionUnitContext context)
        {
            IList<ElementBase> children = GetChildren();
            ThrowExceptionIfAny();
            Contract.Assert(children.Count()==1, "A question should have identifier only.");

            IStaticReturnType dataType = GetTypeInstance((dynamic)context.type());
            string questionText = context.TEXT().GetText();


            QuestionUnit question = new QuestionUnit((Identifier)children[0], questionText, dataType);

            question.SourceLocation = SourceLocation.CreateFor(context);

            AppendToAST(question);
        }

        private IStaticReturnType GetTypeInstance(QLParser.YesnoTypeContext typeContext)
        {
            return new Yesno();    
        }
        private IStaticReturnType GetTypeInstance(QLParser.NumberTypeContext typeContext)
        {
            return new Number();
        }
        private IStaticReturnType GetTypeInstance(QLParser.TextTypeContext typeContext)
        {
            return new Text();
        }
        private IStaticReturnType GetTypeInstance(QLParser.TypeContext typeContext)
        {
           throw new QLError("type not recognized"+typeContext.ToString());
            
        }

        

        public override void ExitStatementUnit(QLParser.StatementUnitContext context)
        {
            IList<ElementBase> children = GetChildren();
            ThrowExceptionIfAny();
            Contract.Assert(children.Count() == 2, "A statement should have only expression and an identifier as children.");
            
            StatementUnit statement = new StatementUnit(
                                            (Identifier)children[0],
                                            (Expression)children[1],
                                            GetTypeInstance((dynamic)context.type()),
                                            context.TEXT().GetText(),
                                            SourceLocation.CreateFor(context)
                                            );

            AppendToAST(statement);
        }

        public override void ExitControlUnit(QLParser.ControlUnitContext context)
        {
            IList<ElementBase> children = GetChildren();
            ControlUnit controlUnit;

            if (children.Count() == 3)
            {
                controlUnit = new ControlUnit(
                                    (Expression)children[0],
                                    (Block)children[1],
                                    (Block)children[2],
                                    SourceLocation.CreateFor(context)
                                    );
            }
            else   if (children.Count() == 2)
            {
                controlUnit = new ControlUnit(
                                    (Expression)children[0],
                                    (Block)children[1],
                                    SourceLocation.CreateFor(context)
                                    );

            }
            else
            {
                throw new  QLError("Bad number of controlUnit children:"+children.Count());

            }

            AppendToAST(controlUnit);
        }

        
        public override void ExitNumber(QLParser.NumberContext context)
        {
            Number literal = new Number();
            literal.SetValue(context.NUMBER().GetText());
            literal.SourceLocation = SourceLocation.CreateFor(context);

            AppendToAST(literal);
        }
        
        public override void ExitYesno(QLParser.YesnoContext context)
        {
            Yesno literal = new Yesno();
            literal.SetValue(context.YESNO().GetText());
            literal.SourceLocation = SourceLocation.CreateFor(context);
            AppendToAST(literal);
        }
        
        public override void ExitText(QLParser.TextContext context)
        {
            Text literal = new Text();
            literal.SetValue(context.TEXT().GetText());
            literal.SourceLocation = SourceLocation.CreateFor(context);

            AppendToAST(literal);
        }
        
        public override void ExitIdentifier(QLParser.IdentifierContext context)
        {
            Identifier literal = new Identifier();
            literal.SetValue(context.IDENTIFIER().GetText());
            literal.SourceLocation = SourceLocation.CreateFor(context);

            AppendToAST(literal);
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
            else if (children.Count() == 3 && context.children.Count() == 5)
            {
                ElementBase leftOperand = children[0];
                BinaryTreeElementBase op = (BinaryTreeElementBase) children[1];
                ElementBase rightOperand = children[2];

                op.Left=leftOperand;
                op.Right=rightOperand;
                expression = new Expression(op);
                }
            else
            {
                throw new QLError("Expression without a child");

            }
            expression.SourceLocation = SourceLocation.CreateFor(context); // not sure if context is the correct location of a literal wrapped in an expr

            AppendToAST(expression);
        }

        
        public override void ExitOperatorAddition(QLParser.OperatorAdditionContext context)
        {
            BinaryTreeElementBase op = new PlusOperator();
            op.SourceLocation = SourceLocation.CreateFor(context);
            AppendToAST(op);

        }
        public override void ExitOperatorAnd(QLParser.OperatorAndContext context)
        {
            BinaryTreeElementBase op = new AndOperator();
            op.SourceLocation = SourceLocation.CreateFor(context);
            AppendToAST(op);
        }
        
        
        public override void ExitOperatorEquals(QLParser.OperatorEqualsContext context)
        {
            BinaryTreeElementBase op = new EqualsOperator();
            op.SourceLocation = SourceLocation.CreateFor(context);
            AppendToAST(op);
        }
        public override void ExitOperatorDivision(QLParser.OperatorDivisionContext context)
        {
            BinaryTreeElementBase op = new DivisionOperator();
            op.SourceLocation = SourceLocation.CreateFor(context);
            AppendToAST(op);
        }
        public override void ExitOperatorGreaterThan(QLParser.OperatorGreaterThanContext context)
        {
            BinaryTreeElementBase op = new GreaterThanOperator();
            op.SourceLocation = SourceLocation.CreateFor(context);
            AppendToAST(op);
        }
        public override void ExitOperatorGreaterThanOrEqualTo(QLParser.OperatorGreaterThanOrEqualToContext context)
        {
            BinaryTreeElementBase op = new GreaterThanEqualToOperator();
            op.SourceLocation = SourceLocation.CreateFor(context);
            AppendToAST(op);
        }
        public override void ExitOperatorLessThan(QLParser.OperatorLessThanContext context)
        {
            BinaryTreeElementBase op = new LessThanOperator();
            op.SourceLocation = SourceLocation.CreateFor(context);
            AppendToAST(op);
        }
        public override void ExitOperatorSubtraction(QLParser.OperatorSubtractionContext context)
        {
            BinaryTreeElementBase op = new MinusOperator();
            op.SourceLocation = SourceLocation.CreateFor(context);
            AppendToAST(op);
        }
        public override void ExitOperatorLessThanOrEqualTo(QLParser.OperatorLessThanOrEqualToContext context)
        {
            BinaryTreeElementBase op = new LessThanEqualToOperator();
            op.SourceLocation = SourceLocation.CreateFor(context);
            AppendToAST(op);
        }
        public override void ExitOperatorMultiplication(QLParser.OperatorMultiplicationContext context)
        {
            BinaryTreeElementBase op = new MultiplicationOperator();
            op.SourceLocation = SourceLocation.CreateFor(context);
            AppendToAST(op);
        }
        public override void ExitOperatorNotEquals(QLParser.OperatorNotEqualsContext context)
        {
            BinaryTreeElementBase op = new NotEqualsOperator();
            op.SourceLocation = SourceLocation.CreateFor(context);
            AppendToAST(op);
        }
        public override void ExitOperatorOr(QLParser.OperatorOrContext context)
        {
            BinaryTreeElementBase op = new OrOperator();
            op.SourceLocation = SourceLocation.CreateFor(context);
            AppendToAST(op);
        }
    
       
        #endregion
    }


}
