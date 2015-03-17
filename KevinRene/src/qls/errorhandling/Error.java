package qls.errorhandling;

import ql.ast.QLNode;
import ql.ast.QLType;
import ql.ast.visitor.prettyprinter.printer.WriterCache;
import qls.ast.QLSStatement;
import qls.ast.expression.Literal;
import qls.ast.visitor.prettyprinter.PrettyPrinter;

public class Error extends ql.errorhandling.Error {
	public Error(QLNode origin, String errorMessage) {
		super(origin, errorMessage);
	}

	@Override
	protected String getErrorSourceString() {
		WriterCache writerCache = new WriterCache();
		
		if(getOrigin() instanceof Literal<?>) {
			PrettyPrinter.print((Literal<?>) getOrigin(), writerCache);
		} else if(getOrigin() instanceof QLSStatement) {
			PrettyPrinter.print((QLSStatement) getOrigin(), writerCache);
		} else {
			PrettyPrinter.print((QLType) getOrigin(), writerCache);
		}
		
		return writerCache.getCachedString();
	}
}
