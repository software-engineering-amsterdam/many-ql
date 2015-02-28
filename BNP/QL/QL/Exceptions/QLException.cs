using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;


namespace QL.Exceptions
{
    public class QLException : Exception
    {
      public QLException() { }
      public QLException( string message ) : base( message ) { }
      public QLException( string message, Exception inner ) : base( message, inner ) { }
      protected QLException( 
	    System.Runtime.Serialization.SerializationInfo info, 
	    System.Runtime.Serialization.StreamingContext context ) : base( info, context ) { }
}
}
