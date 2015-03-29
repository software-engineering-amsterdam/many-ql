namespace UvA.SoftCon.Questionnaire.QLS.StyleSets
{
    public class CheckBoxWidgetStyle : WidgetStyle
    {
        public static CheckBoxWidgetStyle Default
        {
            get
            {
                return new CheckBoxWidgetStyle();
            }
        }

        public override object CreateWidgetControl(IWidgetFactory factory)
        {
            return factory.CreateCheckBoxWidget();
        }
    }
}
