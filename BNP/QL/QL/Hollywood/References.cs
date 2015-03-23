using QL.AST.Nodes;
using QL.AST.Nodes.Terminals;
using QL.AST.ValueWrappers;
using QL.Exceptions.Errors;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace QL.Hollywood
{
    public class References
    {
        IDictionary<ITypeResolvable, ITerminalWrapper> ReferenceLookupTable;
        IDictionary<Identifier, ITypeResolvable> IdentifierLookupTable;


        public References()
        {
            ReferenceLookupTable = new Dictionary<ITypeResolvable, ITerminalWrapper>();
            IdentifierLookupTable = new Dictionary<Identifier, ITypeResolvable>();
        }
        public void SetValue(ITypeResolvable key, ITerminalWrapper value)
        {
            ReferenceLookupTable[key] = value;
        
        }
        ITerminalWrapper _GetValue(Identifier key)
        {
            if (IdentifierLookupTable.ContainsKey(key) && ReferenceLookupTable.ContainsKey(IdentifierLookupTable[key]))
            {
                return ReferenceLookupTable[IdentifierLookupTable[key]];
            }
            else if (IdentifierLookupTable.ContainsKey(key))
            {
                throw new QLError("Reference not initialized");
            }
            else
            {
                throw new QLError("Usage of a variable before declaration");
            }
        }
        ITerminalWrapper _GetValue(ITypeResolvable i)
        {
            if (ReferenceLookupTable.ContainsKey(i))
            {
                return ReferenceLookupTable[i];
            }
            else
            {
                throw new QLError("Key not found");
            }

        }
        

        public ITerminalWrapper GetValue(ElementBase key)
        {

            return _GetValue((dynamic)key);
        }
        public ITerminalWrapper GetValueOrNull(ElementBase key)
        {
            try
            {
                return _GetValue((dynamic)key);
            }
            catch (QLError)
            {
                return null;
            }
        }

        /// <summary>
        /// convenience method for getting the Terminal wrapper based on identifier name.
        /// </summary>
        public ITerminalWrapper GetValueOrNull(string identifierName)
        {
            return GetValueOrNull(new Identifier(identifierName));
            
        }


        public void SetReference(Identifier key, ITypeResolvable value)
        {
            IdentifierLookupTable[key] = value;
        }
        public void ClearIdentifiers()
        {
            IdentifierLookupTable.Clear();
        }

        public bool ContainsKey(ITypeResolvable key)
        {
            return  ReferenceLookupTable.ContainsKey(key);
        }
    }
}
