namespace QL.AST
{
    public class QLBuilderStateMachine
    {
        public bool InputIsSet { get; set; }
        public bool ASTIsBuilt { get; set; }
        public bool TypeIsChecked { get; set; }
        public bool IsEvaluated { get; set; }
        public bool IsRendered { get; set; }
    }
}