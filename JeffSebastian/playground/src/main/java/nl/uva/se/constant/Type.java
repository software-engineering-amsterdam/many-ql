package nl.uva.se.constant;

public enum Type {
	BOOLEAN("boolean"),
	DECIMAL("decimal");
	
	private String name;
	
	private Type(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	public static Type getByName(String name) {
		for (Type type : Type.values()) {
			if (type.getName().equals(name)) {
				return type;
			}
		}
		
		return null;
	}
}
