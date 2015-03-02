class Type
  def ==(other_type)
    self.class == other_type.class
  end
end

class IntegerType < Type
  def widget(&block)
    text_field(&block)
  end 
end

class StringType < Type
  def widget(&block)
    text_field(&block)
  end
end

class BooleanType < Type
  def widget(&block)
    checkbox(&block)
  end
end

class UndefinedType < Type
end
