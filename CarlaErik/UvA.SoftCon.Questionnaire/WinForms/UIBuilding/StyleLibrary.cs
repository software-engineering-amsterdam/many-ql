using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UvA.SoftCon.Questionnaire.Common.AST.Model;
using UvA.SoftCon.Questionnaire.QL.AST.Model.Statements;
using UvA.SoftCon.Questionnaire.QLS.AST.Model;

namespace UvA.SoftCon.Questionnaire.WinForms.UIBuilding
{
    /// <summary>
    /// Hold a set of style attributes for each data type.
    /// </summary>
    public class StyleLibrary
    {
        private IDictionary<DataType, StyleSet> _styleSets = new Dictionary<DataType, StyleSet>();

        public static StyleLibrary Default
        {
            get
            {
                var styleSets = new Dictionary<DataType, StyleSet>();
                styleSets.Add(DataType.Boolean, StyleSet.Default(DataType.Boolean));
                styleSets.Add(DataType.Date, StyleSet.Default(DataType.Date));
                styleSets.Add(DataType.Integer, StyleSet.Default(DataType.Integer));
                styleSets.Add(DataType.String, StyleSet.Default(DataType.String));
                return new StyleLibrary(styleSets);
            }
        }

        private StyleLibrary(IDictionary<DataType, StyleSet> styleSets)
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

        public StyleLibrary GetCopy()
        {
            var styleSets = new Dictionary<DataType, StyleSet>();

            foreach (var dataType in _styleSets.Keys)
            {
                styleSets.Add(dataType, _styleSets[dataType].GetCopy());
            }
            return new StyleLibrary(styleSets);
        }
    }
}
