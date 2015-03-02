FactoryGirl.define do
  factory :question do
    intitialize_with { new(description: description, variable_name: variable_name, type: type) }

    description { "Wat is je naam?" }
    variable_name { "naam" }
    type { :string }
  end
end
