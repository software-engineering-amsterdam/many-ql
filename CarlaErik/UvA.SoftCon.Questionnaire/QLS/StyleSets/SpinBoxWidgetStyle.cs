namespace UvA.SoftCon.Questionnaire.QLS.StyleSets
{
    public class SpinBoxWidgetStyle : WidgetStyle
    {
        public static SpinBoxWidgetStyle Default
        {
            get
            {
                return new SpinBoxWidgetStyle();
            }
        }

        public override object CreateWidgetControl(IWidgetFactory factory)
        {
            return factory.CreateSpinBoxWidget();
        }
    }
}
