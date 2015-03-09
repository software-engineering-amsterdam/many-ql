package com.form.language.ast;

import com.form.language.ast.type.Type;
import com.form.language.memory.Context;

public interface ASTNode {
	public abstract Type getType(Context context);
}
