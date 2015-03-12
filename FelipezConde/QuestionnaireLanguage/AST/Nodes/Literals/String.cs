using AST.Nodes.Interfaces;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using AST.Representation;
using AST.Storage;
using Types = AST.Types;

namespace AST.Nodes.Literals
{
    public class String : Literal
    {
        private readonly string value;
        public String(string value)
        {
            this.value = value;
        }
        public String(string value, PositionInText positionInText)
            : base(positionInText)
        {
            this.value = value;
        }
        public override string MakeString()
        {
            return "string";
        }

        public string GetValue()
        {
            return value;
        }

        public override object GetValueType()
        {
            return this;
        }

        // Visitor Methods
        public override T Accept<T>(Visitors.IVisitor<T> visitor)
        {
            return visitor.Visit(this);
        }

        public override void Accept(Visitors.IVisitor visitor)
        {
            visitor.Visit(this);
        }
        public override Types.Type RetrieveType()
        {
            return new Types.StringType();
        }

        #region Equal
        public override Literal Equal(Literal value)
        {
            return value.StringEqual(this);
        }
        public override Literal StringEqual(Literals.String stringValue)
        {
            return new Bool(GetValue().Equals(stringValue.GetValue()));
        }
        #endregion

        #region NotEqual
        public override Literal NotEqual(Literal value)
        {
            return value.StringNotEqual(this);
        }
        public override Literal StringNotEqual(Literals.String stringValue)
        {
            return new Bool(!GetValue().Equals(stringValue.GetValue()));
        }
        #endregion
    }
}
