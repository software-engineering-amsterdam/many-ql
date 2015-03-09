package com.form.language.memory;

import java.util.HashMap;
import java.util.Map;

import com.form.language.ast.expression.literal.IdLiteral;
import com.form.language.ast.type.ErrorType;
import com.form.language.ast.type.Type;
import com.form.language.error.ErrorCollector;
import com.form.language.error.Error;

public class TypeMemory {
	private IdCollector references;
	private Map<String, IdLiteral> declarations;
	private ErrorCollector errors;
	
	public TypeMemory(){
		this.references = new IdCollector();
		this.declarations = new HashMap<String, IdLiteral>();
		this.errors = new ErrorCollector();
	}
	
	public void addId(IdLiteral id){
		if(id.IsReference()){
			this.references.addId(id);
		}
		this.declarations.put(id.name, id);
	}
	
	public Boolean hasErrors(){
		return !errors.isEmpty();
	}
	public Type getIdType(IdLiteral id){
		IdLiteral declaration = this.declarations.get(id.name);
		if(declaration == null){
			this.addError(new Error(id.tokenInfo, "Undeclared variable reference"));
			return new ErrorType();
		}
		return declaration.getType(this);
	}
	
	public void addError(Error e){
		this.errors.add(e);
	}
	
	public String getErrors(){
		return errors.toString();
	}
}
