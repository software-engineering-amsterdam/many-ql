package typechecker;

import java.util.HashMap;

import ast.type.Type;

public class TypeRepository {
	private final HashMap<String, Type> typeRepository; 
	
	public TypeRepository() {
		this.typeRepository = new HashMap<String, Type>();
	}
	
	public void putID(String id, Type type) {
		typeRepository.put(id, type);
	}
	
	public HashMap<String, Type> getTypeRepository() {
		//System.out.println("Rep"+ typeRepository.toString());
		return typeRepository;
	}
	
	public boolean isDeclared(String id) {
		return typeRepository.containsKey(id);
	}
	
	public Type getValue(String id) {
		if(isDeclared(id)) {
			return typeRepository.get(id);
		}
		return null;
	}
	
	public boolean empty() {
		if(!this.getTypeRepository().isEmpty()) {
			return false;
		}
		return true;
	}
}
