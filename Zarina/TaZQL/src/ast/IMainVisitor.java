package ast;


public interface IMainVisitor<T> {
	T visit(ID id);
	//T visit(TEXT id);
	//public T visit(Questions questions);
}
