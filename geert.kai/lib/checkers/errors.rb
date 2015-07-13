module QL
  module Checkers
    class Warning
      attr_reader :message

      def initialize(message)
        @message = message
      end
    end

    class Error
      attr_reader :message

      def initialize(message)
        @message = message
      end
    end

    class NoError
    end
  end
end
