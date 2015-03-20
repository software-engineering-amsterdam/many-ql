package nl.uva.se.ql.interpretation;

import nl.uva.se.ql.ast.form.Form;
import nl.uva.se.ql.evaluation.Evaluator;
import nl.uva.se.ql.evaluation.ValueTable;
import nl.uva.se.ql.typechecking.SymbolTable;
import nl.uva.se.ql.typechecking.TypeChecker;
import nl.uva.se.ql.typechecking.error.ErrorList;

public class Interpreter {
	
	private Interpreter() {
	}

	public static Result<ValueTable> interpret(Form form) {
		Result<SymbolTable> result = TypeChecker.check(form);
		ErrorList errorList = result.getErrorList();
		
		if (!errorList.hasErrors()) {
			SymbolTable symbolTable = result.getResult();
			ValueTable valueTable = Evaluator.evaluate(form, new ValueTable());
			
			// TODO: Remove this!
			result.getErrorList().printAll();
			System.out.println("symbolTable");
			System.out.println(symbolTable);
			System.out.println("valueTable");
			System.out.println(valueTable);
			
			return new Result<ValueTable>(errorList, valueTable);
		}
		
		result.getErrorList().printAll();
		
		return new Result<ValueTable>(errorList, null);
	}
	
}
