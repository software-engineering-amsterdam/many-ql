module QL
  module Checkers
    class Warning
      attr_reader :message

      def initialize(message)
        @message = message
      end

      def to_s
        @message
      end
    end

    class Error
      attr_reader :message

      def initialize(message)
        @message = message
      end

      def to_s
        @message
      end
    end
  end
end
