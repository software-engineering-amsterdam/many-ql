using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace UvA.SoftCon.Questionnaire.Runtime.Evaluation.Types
{
    public class Undefined : IValue
    {
        public bool IsUndefined
        {
            get { return true; }
        }

        public IInteger Plus(IValue value)
        {
            //return new Undefined
        }

        public IInteger PlusInt(IInteger value)
        {
            throw new NotImplementedException();
        }

        public IInteger Minus(IValue value)
        {
            throw new NotImplementedException();
        }

        public IInteger MinusInt(IInteger value)
        {
            throw new NotImplementedException();
        }

        public IInteger MultipliedBy(IValue value)
        {
            throw new NotImplementedException();
        }

        public IInteger MultipliedByInt(IInteger value)
        {
            throw new NotImplementedException();
        }

        public IInteger DividedBy(IValue value)
        {
            throw new NotImplementedException();
        }

        public IInteger DividedByInt(IInteger value)
        {
            throw new NotImplementedException();
        }

        public IInteger Increment()
        {
            throw new NotImplementedException();
        }

        public IBoolean IsEqualTo(IValue value)
        {
            throw new NotImplementedException();
        }

        public IBoolean IsEqualToInt(IInteger value)
        {
            throw new NotImplementedException();
        }

        public IBoolean IsEqualToString(IString value)
        {
            throw new NotImplementedException();
        }

        public IBoolean IsEqualToBool(IBoolean value)
        {
            throw new NotImplementedException();
        }

        public IBoolean IsNotEqualTo(IValue value)
        {
            throw new NotImplementedException();
        }

        public IBoolean IsNotEqualToInt(IInteger value)
        {
            throw new NotImplementedException();
        }

        public IBoolean IsNotEqualToString(IString value)
        {
            throw new NotImplementedException();
        }

        public IBoolean IsNotEqualToBool(IBoolean value)
        {
            throw new NotImplementedException();
        }

        public IBoolean IsLessThan(IValue value)
        {
            throw new NotImplementedException();
        }

        public IBoolean IsLessThanInt(IInteger value)
        {
            throw new NotImplementedException();
        }

        public IBoolean IsLessThanOrEqualTo(IValue value)
        {
            throw new NotImplementedException();
        }

        public IBoolean IsLessThanOrEqualToInt(IInteger value)
        {
            throw new NotImplementedException();
        }

        public IBoolean IsGreaterThan(IValue value)
        {
            throw new NotImplementedException();
        }

        public IBoolean IsGreaterThanInt(IInteger value)
        {
            throw new NotImplementedException();
        }

        public IBoolean IsGreaterThanOrEqualTo(IValue value)
        {
            throw new NotImplementedException();
        }

        public IBoolean IsGreaterThanOrEqualToInt(IInteger value)
        {
            throw new NotImplementedException();
        }

        public IBoolean And(IValue value)
        {
            throw new NotImplementedException();
        }

        public IBoolean AndBool(IBoolean value)
        {
            throw new NotImplementedException();
        }

        public IBoolean Or(IValue value)
        {
            throw new NotImplementedException();
        }

        public IBoolean OrBool(IBoolean value)
        {
            throw new NotImplementedException();
        }

        public IBoolean Negate()
        {
            throw new NotImplementedException();
        }
    }
}
