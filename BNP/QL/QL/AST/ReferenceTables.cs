using System;
using System.Collections.Generic;
using QL.AST.Nodes;
using QL.AST.Nodes.Terminals;
using QL.AST.Nodes.Terminals.Wrappers;
using QL.Exceptions.Errors;

namespace QL.AST
{
    public class ReferenceTables
    {
        private readonly IDictionary<IResolvable, ITerminalWrapper> _referenceLookupTable;
        private readonly IDictionary<Identifier, IResolvable> _identifierLookupTable;

        public ReferenceTables()
        {
            _referenceLookupTable = new Dictionary<IResolvable, ITerminalWrapper>();
            _identifierLookupTable = new Dictionary<Identifier, IResolvable>();
        }

        public void SetValue(IResolvable key, ITerminalWrapper value)
        {
            _referenceLookupTable[key] = value;
        }

        private ITerminalWrapper GetValue(Identifier key)
        {
            if (_identifierLookupTable.ContainsKey(key) && _referenceLookupTable.ContainsKey(_identifierLookupTable[key]))
            {
                return _referenceLookupTable[_identifierLookupTable[key]];
            }
            if (_identifierLookupTable.ContainsKey(key))
            {
                throw new QLError("Reference not initialised");
            }
            throw new QLError("Usage of variable " + key.Value + " before declaration");
        }

        private ITerminalWrapper GetValue(IResolvable key)
        {
            if (_referenceLookupTable.ContainsKey(key))
            {
                return _referenceLookupTable[key];
            }

            throw new QLError("Reference not initialised");
        }

        public ITerminalWrapper GetValue(ElementBase key)
        {
            if(key is IResolvable) return GetValue(key as IResolvable);
            
            return GetValue((Identifier)key);
        }

        public ITerminalWrapper GetValueOrNull(ElementBase key)
        {
            try
            {
                return GetValue((Identifier)(dynamic)key);
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
        
        public void SetReference(Identifier key, IResolvable value)
        {
            _identifierLookupTable[key] = value;
        }

        public void ClearIdentifiers()
        {
            _identifierLookupTable.Clear();
        }

        public bool ContainsReference(IResolvable key)
        {
            return _referenceLookupTable.ContainsKey(key);
        }

        public bool ContainsIdentifier(Identifier key)
        {
            return _identifierLookupTable.ContainsKey(key);
        }

        public Type GetTypeByIdentifier(Identifier key)
        {
            if (!ContainsIdentifier(key)) return typeof(object);

            IStaticReturnType terminal = _identifierLookupTable[key] as IStaticReturnType;
            return terminal != null ? terminal.GetReturnType() : typeof(object);
        }
    }
}
