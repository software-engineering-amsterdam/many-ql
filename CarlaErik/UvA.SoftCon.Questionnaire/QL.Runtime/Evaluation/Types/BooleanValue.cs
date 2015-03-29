using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UvA.SoftCon.Questionnaire.Common.AST.Model;
using UvA.SoftCon.Questionnaire.QL.AST.Model.Statements;

namespace UvA.SoftCon.Questionnaire.QL.Runtime.Evaluation.Types
{
    public class BooleanValue : Value<bool>
    {
        public override DataType DataType
        {
            get
            {
                return DataType.Boolean;
            }
        }

        public BooleanValue(bool value)
            : base(value) { }

        public override Value And(Value value)
        {
            return value.AndBool(this);
        }

        internal override Value AndBool(BooleanValue value)
        {
            return new BooleanValue(this.Val && value.Val);
        }

        public override Value IsEqualTo(Value value)
        {
            return value.IsEqualToBool(this);
        }

        internal override Value IsEqualToBool(BooleanValue value)
        {
            return new BooleanValue(this.Val == value.Val);
        }

        public override Value IsNotEqualTo(Value value)
        {
            return value.IsNotEqualToBool(this);
        }

        internal override Value IsNotEqualToBool(BooleanValue value)
        {
            return new BooleanValue(this.Val != value.Val);
        }

        public override Value Negate()
        {
            return new BooleanValue(!this.Val);
        }

        public override Value Or(Value value)
        {
            return value.OrBool(this);
        }

        internal override Value OrBool(BooleanValue value)
        {
            return new BooleanValue(value.Val || this.Val);
        }
    }
}
