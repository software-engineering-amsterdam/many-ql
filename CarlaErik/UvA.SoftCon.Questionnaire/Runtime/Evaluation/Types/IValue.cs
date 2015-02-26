using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace UvA.SoftCon.Questionnaire.Runtime.Evaluation.Types
{
    public interface IValue
    {
        bool IsUndefined { get; }

        IInteger Plus(IValue value);
        IInteger PlusInt(IInteger value);
        IInteger Minus(IValue value);
        IInteger MinusInt(IInteger value);
        IInteger MultipliedBy(IValue value);
        IInteger MultipliedByInt(IInteger value);
        IInteger DividedBy(IValue value);
        IInteger DividedByInt(IInteger value);
        IInteger Increment();

        IBoolean IsEqualTo(IValue value);
        IBoolean IsEqualToInt(IInteger value);
        IBoolean IsEqualToString(IString value);
        IBoolean IsEqualToBool(IBoolean value);

        IBoolean IsNotEqualTo(IValue value);
        IBoolean IsNotEqualToInt(IInteger value);
        IBoolean IsNotEqualToString(IString value);
        IBoolean IsNotEqualToBool(IBoolean value);

        IBoolean IsLessThan(IValue value);
        IBoolean IsLessThanInt(IInteger value);
        IBoolean IsLessThanOrEqualTo(IValue value);
        IBoolean IsLessThanOrEqualToInt(IInteger value);
        IBoolean IsGreaterThan(IValue value);
        IBoolean IsGreaterThanInt(IInteger value);
        IBoolean IsGreaterThanOrEqualTo(IValue value);
        IBoolean IsGreaterThanOrEqualToInt(IInteger value);

        IBoolean And(IValue value);
        IBoolean AndBool(IBoolean value);
        IBoolean Or(IValue value);
        IBoolean OrBool(IBoolean value);

        IBoolean Negate();
    }

    public interface IValue<T> : IValue 
    {
        T Val { get; }
    }
}
