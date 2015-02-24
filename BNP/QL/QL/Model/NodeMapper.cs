using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Antlr4.Runtime;
using Antlr4.Runtime.Tree;
using QL.Factories;
using QL.Grammars;
using QL.Model.Terminals;
using System.Diagnostics;

namespace QL.Model
{
    public sealed class NodeMapper
    {
        private readonly Stack<Stack<ElementBase>> _childrenStack;
        private ElementBase _astRootNode;
        
        public NodeMapper()
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

        #region Model creation methods
        public void Create(QLParser.QuestionUnitContext context)
        {
            Debug.Assert(!GetChildren().Any(), "A unit should syntactically not have any children.");

            Identifier identifier = new Identifier(context.IDENTIFIER().GetText());
            string typeName = context.typeName().GetText();
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

        public void Create(QLParser.StatementUnitContext context)
        {
            Debug.Assert(!GetChildren().Any(), "A unit should syntactically not have any children.");

            Identifier identifier = new Identifier(context.IDENTIFIER().GetText());
            string typeName = context.typeName().GetText();
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

        public void Create(QLParser.ControlBlockContext context)
        {
            IList<ElementBase> children = GetChildren();

            ControlBlock controlBlock = new ControlBlock();

            controlBlock.HandleChildren(children);


            AppendToAST(controlBlock);
        }

        public void Create(QLParser.BlockContext context)
        {
            Block block = new Block();
            block.SourceLocation = SourceLocation.CreateFor(context);
            block.Children = GetChildren();

            AppendToAST(block);
        }

        public void Create(QLParser.FormBlockContext context)
        {
            IList<ElementBase> children = GetChildren();
            Debug.Assert((children.Count() == 1), "Form block could have only one child - block. Maybe you changed IDENTIFIER as a parser rule?");
            
            Form form = new Form();
            
            Identifier formBlockId = new Identifier(context.IDENTIFIER().GetText());
            form.Identifier = formBlockId;
            form.SourceLocation = SourceLocation.CreateFor(context);

            AppendToAST(form);
        }

        internal void Create(ParserRuleContext context)
        {

            throw new NotImplementedException();
        }

        #endregion
    }
}
