using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using QL;
using QL.Model;
using System.Diagnostics;
using QL.Model.Terminals;
using QL.Factories;
using Antlr4.Runtime;


namespace QL.Grammars
{
    public class QLListener : QLBaseListener
    {
        private readonly Stack<Stack<ElementBase>> _childrenStack;
        private ElementBase _astRootNode;

        public QLListener()
        {
            _childrenStack = new Stack<Stack<ElementBase>>();
        }

        public void InitializeNewLevel()
        {
            _childrenStack.Push(new Stack<ElementBase>());
        }
        public bool AstExists()
        {
            return _astRootNode != null; 
        }
        

        private IList<ElementBase> GetChildren()
        {
            Debug.Assert(_childrenStack.Any(), "Level with children should be always initialized before appending one.");//TODO maybe throw it out
            return _childrenStack.Pop().ToList();
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
                //this is the last one
                _astRootNode = newChild;
            }
        }

        # region  Overriden listener methods
        public override void EnterFormBlock(QLParser.FormBlockContext context)
        {
            InitializeNewLevel();
            
        }
        public override void ExitFormBlock(QLParser.FormBlockContext context)
        {
            
            
            IList<ElementBase> children = GetChildren();
            Debug.Assert((children.Count() == 1), "Form block could have only one child - block. Maybe you changed IDENTIFIER as a parser rule?");
            
            Form form = new Form();
            
            Identifier formBlockId = new Identifier(context.IDENTIFIER().GetText());
            form.Identifier = formBlockId;
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
            
        
            Debug.Assert(!GetChildren().Any(), "A unit should syntactically not have any children.");

            Identifier identifier = new Identifier(context.IDENTIFIER().GetText());
            string typeName = context.type().GetText();
            string unitText = context.TEXT().GetText();

            TerminalTypeFactory typeFactory = new TerminalTypeFactory(typeName);
            ITerminalType dataType = typeFactory.Create();

            QuestionUnit question = new QuestionUnit();
            question.Identifier = identifier;
            question.DataType = dataType;
            question.DisplayText = unitText;
            // todo: extract required attribute from unit
            question.SourceLocation = SourceLocation.CreateFor(context);

            AppendToAST(question);
        

        }
        
        public override void EnterStatementUnit(QLParser.StatementUnitContext context)
        {

            InitializeNewLevel();
            
        }
        public override void ExitStatementUnit(QLParser.StatementUnitContext context)
        {
            
            Debug.Assert(!GetChildren().Any(), "A unit should syntactically not have any children.");

            Identifier identifier = new Identifier(context.IDENTIFIER().GetText());
            string typeName = context.type().GetText();
            string unitText = context.TEXT().GetText();

            TerminalTypeFactory typeFactory = new TerminalTypeFactory(typeName);
            ITerminalType dataType = typeFactory.Create();

            StatementUnit statement = new StatementUnit();
            statement.Identifier = identifier;
            statement.DataType = dataType;
            statement.DisplayText = unitText;
            statement.SourceLocation = SourceLocation.CreateFor(context);

            AppendToAST(statement);
        }

        public override void EnterControlUnit(QLParser.ControlUnitContext context)
        {
                        InitializeNewLevel();

 	         
        }
        public override void ExitControlUnit(QLParser.ControlUnitContext context)
        {
 	
        
        IList<ElementBase> children = GetChildren();
        ControlBlock controlBlock = new ControlBlock();//rename
        controlBlock.HandleChildren(children);
        AppendToAST(controlBlock);
        }
       
        public override void EnterOperator(QLParser.OperatorContext context)
        {
            InitializeNewLevel();
            
        }
        public override void ExitOperator(QLParser.OperatorContext context)
        {
            
            //TODO
        }

        public override void EnterLiteral(QLParser.LiteralContext context)
        {
            InitializeNewLevel();
            
        }
        public override void ExitLiteral(QLParser.LiteralContext context)
        {
            
            //TODO
        }

        public override void EnterExpression(QLParser.ExpressionContext context)
        {
            InitializeNewLevel();

 	         
        }
        public override void ExitExpression(QLParser.ExpressionContext context)
        {

 	         
            //TODO
        }
        
        
        

        #endregion
    }

    
}
