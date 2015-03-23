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
using System;

namespace QL.Hollywood.DataHandlers.ASTCreation
{
    public class QLListener : QLBaseListener
    {
        #region Common
        private readonly Stack<Stack<ElementBase>> _childrenStack;
        private Form _astRootNode;
        private IList<QLBaseException> _astBuilderExceptions;


        public QLListener()
        {
            _childrenStack = new Stack<Stack<ElementBase>>();
            _astBuilderExceptions = new List<QLBaseException>();

        }

        public QLListener(IList<QLBaseException> astBuilderExceptions)
        {
            _astBuilderExceptions = astBuilderExceptions;
            _childrenStack = new Stack<Stack<ElementBase>>();

        }

        public void InitializeNewLevel()
        {
            _childrenStack.Push(new Stack<ElementBase>());
        }

        public bool AstExists
        {
            get 
            {
                return _astRootNode != null; 
            }
        }
        
        public Form GetAstRootNode()
        {
            return AstExists ? _astRootNode : null;
        }

        void ThrowExceptionIfAny()
        {
            if (_astBuilderExceptions.Any())
            {
                throw _astBuilderExceptions.Last();
            }
        }
        private IList<ElementBase> GetChildren()
        {
            ThrowExceptionIfAny();
            if (!_childrenStack.Any())
            {
                //we are intentionally not throwing QL exception, it is not intented to be displayed
                _astBuilderExceptions.Add(new ParserError("Level with children should be always initialized before appending one."));
            }
            
            Stack<ElementBase> children = _childrenStack.Pop();
            //stack has to be reversed to have the order as it was created.
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
                //this is the last one, it should be Form
                _astRootNode = (Form)newChild;                
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
                _astBuilderExceptions.Add(new ParserError("initial form block should have two children", SourceLocation.CreateFor(context)));
            }

            Form form = new Form(
                (Identifier)children[0], 
                (Block)children[1], 
                SourceLocation.CreateFor(context)
                );
            
            AppendToAST(form);
        }

        public override void EnterBlock(QLParser.BlockContext context)
        {
            InitializeNewLevel();
        }

        public override void ExitBlock(QLParser.BlockContext context)
        {
            IList<ElementBase> children = GetChildren();

            Block block = new Block(
                children,
                SourceLocation.CreateFor(context)
                );

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
            if (children.Count()!=1)
            {
                _astBuilderExceptions.Add(new ParserError("A question should have only identifier as a child."));
            }

            QuestionUnit question = new QuestionUnit(
                (Identifier)children[0], 
                TypeFactory.GetTypeInstance(context.type()),
                context.TEXT().GetText(),
                SourceLocation.CreateFor(context)
                );
            AppendToAST(question);
        }

        

        

        public override void ExitStatementUnit(QLParser.StatementUnitContext context)
        {
            IList<ElementBase> children = GetChildren();
            
            ThrowExceptionIfAny();
            if (children.Count() != 2)
            {
                _astBuilderExceptions.Add(new ParserError("A statement should have only expression and an identifier as children."));
            }
            
            StatementUnit statement = new StatementUnit(
                                            (Identifier)children[0],
                                            (Expression)children[1],
                                            context.TEXT().GetText(),
                                            TypeFactory.GetTypeInstance(context.type()),
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
            else if (children.Count() == 2)
            {
                controlUnit = new ControlUnit(
                                    (Expression)children[0],
                                    (Block)children[1],
                                    SourceLocation.CreateFor(context)
                                    );

            }
            else
            {
                _astBuilderExceptions.Add(new ParserError("Bad number of controlUnit children:"+children.Count()));
                return;
            }

            AppendToAST(controlUnit);
        }

        
        public override void ExitNumber(QLParser.NumberContext context)
        {
            Number literal = new Number(
                context.NUMBER().GetText(),
                SourceLocation.CreateFor(context)
                );

            AppendToAST(literal);
        }
        
        public override void ExitYesno(QLParser.YesnoContext context)
        {
            Yesno literal = new Yesno(
                context.YESNO().GetText(),
                SourceLocation.CreateFor(context)
                );

            AppendToAST(literal);
        }
        
        public override void ExitText(QLParser.TextContext context)
        {
            Text literal = new Text(
            context.TEXT().GetText(),
            SourceLocation.CreateFor(context)
            );

            AppendToAST(literal);
        }
        
        public override void ExitIdentifier(QLParser.IdentifierContext context)
        {
            Identifier literal = new Identifier(
                context.IDENTIFIER().GetText(),
                SourceLocation.CreateFor(context)
                    );

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
                expression = new Expression(
                    children[0], 
                    SourceLocation.CreateFor(context));
            }
            else if (children.Count() == 3)
            {
                
                
                ElementBase leftNode = children[0];
                BinaryTreeElementBase operatorNode = (BinaryTreeElementBase) children[1];
                ElementBase rightNode = children[2];

                operatorNode.Left=leftNode;
                operatorNode.Right=rightNode;
                
                expression = new Expression(
                    operatorNode,
                    SourceLocation.CreateFor(context)
                    );
                }
            else
            {
                _astBuilderExceptions.Add(new ParserError("Expression without a child"));
                return;
            }
            

            AppendToAST(expression);
        }

        
        public override void ExitOperatorAddition(QLParser.OperatorAdditionContext context)
        {
            BinaryTreeElementBase op = new PlusOperator(sourceLocation:SourceLocation.CreateFor(context));
            AppendToAST(op);

        }
        public override void ExitOperatorAnd(QLParser.OperatorAndContext context)
        {
            BinaryTreeElementBase op = new AndOperator(sourceLocation: SourceLocation.CreateFor(context));
            AppendToAST(op);
        }
        
        
        public override void ExitOperatorEquals(QLParser.OperatorEqualsContext context)
        {
            BinaryTreeElementBase op = new EqualsOperator(sourceLocation: SourceLocation.CreateFor(context));
            AppendToAST(op);
        }
        public override void ExitOperatorDivision(QLParser.OperatorDivisionContext context)
        {
            BinaryTreeElementBase op = new DivisionOperator(sourceLocation: SourceLocation.CreateFor(context));
            AppendToAST(op);
        }
        public override void ExitOperatorGreaterThan(QLParser.OperatorGreaterThanContext context)
        {
            BinaryTreeElementBase op = new GreaterThanOperator(sourceLocation: SourceLocation.CreateFor(context));
            AppendToAST(op);
        }
        public override void ExitOperatorGreaterThanOrEqualTo(QLParser.OperatorGreaterThanOrEqualToContext context)
        {
            BinaryTreeElementBase op = new GreaterThanEqualToOperator(sourceLocation: SourceLocation.CreateFor(context));
            AppendToAST(op);
        }
        public override void ExitOperatorLessThan(QLParser.OperatorLessThanContext context)
        {
            BinaryTreeElementBase op = new LessThanOperator(sourceLocation: SourceLocation.CreateFor(context));
            AppendToAST(op);
        }
        public override void ExitOperatorSubtraction(QLParser.OperatorSubtractionContext context)
        {
            BinaryTreeElementBase op = new MinusOperator(sourceLocation: SourceLocation.CreateFor(context));
            AppendToAST(op);
        }
        public override void ExitOperatorLessThanOrEqualTo(QLParser.OperatorLessThanOrEqualToContext context)
        {
            BinaryTreeElementBase op = new LessThanEqualToOperator(sourceLocation: SourceLocation.CreateFor(context));
            AppendToAST(op);
        }
        public override void ExitOperatorMultiplication(QLParser.OperatorMultiplicationContext context)
        {
            BinaryTreeElementBase op = new MultiplicationOperator(sourceLocation: SourceLocation.CreateFor(context));
            AppendToAST(op);
        }
        public override void ExitOperatorNotEquals(QLParser.OperatorNotEqualsContext context)
        {
            BinaryTreeElementBase op = new NotEqualsOperator(sourceLocation: SourceLocation.CreateFor(context));
            AppendToAST(op);
        }
        public override void ExitOperatorOr(QLParser.OperatorOrContext context)
        {
            BinaryTreeElementBase op = new OrOperator(sourceLocation: SourceLocation.CreateFor(context));
            AppendToAST(op);
        }
    
       
        #endregion
    }


}
