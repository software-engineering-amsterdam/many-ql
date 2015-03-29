namespace AST
{
    public class Label
    {
        public readonly string Value;
        public readonly PositionInText position;

        public Label(string value, PositionInText position)
        {
            this.Value = value;
            this.position = position;
        }
    }
}
