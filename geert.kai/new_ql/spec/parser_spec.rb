require_relative "../lib/ql.rb"

describe "Parsing" do
  it "parses a one query form" do
    expect(QL.parse("spec/source_files/one_query.ql")).not_to be_nil
  end
end
