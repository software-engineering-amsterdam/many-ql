using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UvA.SoftCon.Questionnaire.Common.AST.Model;
using UvA.SoftCon.Questionnaire.QLS.AST.Model;
using UvA.SoftCon.Questionnaire.QLS.Runtime.Evaluation.StyleSets;

namespace UvA.SoftCon.Questionnaire.QLS.Runtime.Evaluation
{
    /// <summary>
    /// Contains the style sets for each data type.
    /// </summary>
    internal class DataTypeStyleCollection
    {
        private IDictionary<DataType, StyleSet> _styleSets = new Dictionary<DataType, StyleSet>();

        public static DataTypeStyleCollection Default
        {
            get
            {
                var styleSets = new Dictionary<DataType, StyleSet>();
                styleSets.Add(DataType.Boolean, StyleSet.Default(DataType.Boolean));
                styleSets.Add(DataType.Date, StyleSet.Default(DataType.Date));
                styleSets.Add(DataType.Integer, StyleSet.Default(DataType.Integer));
                styleSets.Add(DataType.String, StyleSet.Default(DataType.String));
                return new DataTypeStyleCollection(styleSets);
            }
        }

        private DataTypeStyleCollection(IDictionary<DataType, StyleSet> styleSets)
        {
            _styleSets = styleSets;
        }

        public void OverrideStyles(IEnumerable<DefaultStyle> defaultStyles)
        {
            foreach (var defaultStyle in defaultStyles)
            {
                _styleSets[defaultStyle.DataType].OverrideStyles(defaultStyle.StyleAttributes);
            }
        }

        public StyleSet GetStyleSet(DataType dataType) 
        {
            return _styleSets[dataType];
        }

        public DataTypeStyleCollection GetCopy()
        {
            var styleSets = new Dictionary<DataType, StyleSet>();

            foreach (var dataType in _styleSets.Keys)
            {
                styleSets.Add(dataType, _styleSets[dataType].GetCopy());
            }
            return new DataTypeStyleCollection(styleSets);
        }

    }
}
