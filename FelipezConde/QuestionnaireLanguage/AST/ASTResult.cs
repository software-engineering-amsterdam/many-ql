using AST.Nodes;
using AST.Nodes.Expression;
using AST.Nodes.Interfaces;
using AST.Notification;
using AST.Representation;
using AST.Storage;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace AST
{
    public class ASTResult : IASTResult
    {
        public IFormObjectContainer Ast { get; private set; }
        private SymbolTable table;
        private List<INotification> notifications;

        public ASTResult(IFormObjectContainer tree)
        {
            this.Ast = tree;
            table = new SymbolTable();
            
            //todo: traverse AST and typecheck
            //todo: init notifications and stuff
            //todo: probably something else

        }

        public void SetValue(Id key, ObjectValue value)
        {
            table.SetObjectValue(key, value);
        }

        public ObjectValue GetValue(Id key)
        {
            return table.GetObjectValue(key);
        }

        public bool IsTypeCorrect()
        {
            throw new NotImplementedException();
        }

        public bool HasDuplicateIdentifiers()
        {
            throw new NotImplementedException();
        }

        public bool IsCorrect()
        {
            throw new NotImplementedException();
        }

        public void SetValue(string key, ObjectValue value)
        {
            throw new NotImplementedException();
        }
    }
}
