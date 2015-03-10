using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace AST.Representation
{

    //this class represents the literal value of an object. as of now, it is of type string.
    public struct ObjectValue : IEquatable<ObjectValue>
    {
        private string value;

        public ObjectValue(string value)
        {
            this.value = value;
        }

        public string getValue()
        { return value; }

        public bool Equals(ObjectValue other)
        {
            return this.value == other.value;
        }
    }
}
