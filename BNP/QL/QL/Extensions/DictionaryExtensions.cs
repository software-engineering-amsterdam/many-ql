using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using QL.Model;
using QL.Model.Terminals;

namespace QL.Extensions
{
    public static class DictionaryExtensions
    {
        public static void RegisterTypeReference<T1, T2>(this IDictionary<T1, T2> dictionary, T1 key, T2 value)
            where T1 : ITerminalType
            where T2 : Type
        {
            dictionary[key] = value; // todo implement additional required logic
        }
    }
}
