namespace UvA.SoftCon.Questionnaire.QLS.StyleSets
{
    public class DropDownWidgetStyle : WidgetStyle
    {
        public string TrueLabel
        {
            get;
            private set;
        }

        public string FalseLabel
        {
            get;
            private set;
        }

        public static DropDownWidgetStyle Default
        {
            get
            {
                return new DropDownWidgetStyle("Yes", "No");
            }
        }

        public DropDownWidgetStyle(string trueLabel, string falseLabel)
        {
            TrueLabel = trueLabel;
            FalseLabel = falseLabel;
        }

        public override object CreateWidgetControl(IWidgetFactory factory)
        {
            return factory.CreateDropDownWidget(TrueLabel, FalseLabel);
        }
    }
}
