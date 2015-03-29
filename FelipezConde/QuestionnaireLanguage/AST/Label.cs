namespace AST
{
    public class Label
    {
        private readonly string Value;
        public readonly PositionInText position;

        public Label(string value, PositionInText position)
        {
            this.Value = value;
            this.position = position;
        }

        public override string ToString()
        {
            return Value;
        }

    }
}
