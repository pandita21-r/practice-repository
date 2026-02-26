public class MessageFormatterOverridingMicroDrill {
    static class MessageFormatter {
        private String prefix;
        private int maxlength;

        public MessageFormatter(String prefix, int maxlength) {
            if (prefix == null || prefix.isBlank()) {
                throw new IllegalArgumentException("Prefix must be not null.");
            }
            if (maxlength <= 0) {
                throw new IllegalArgumentException("maxLength must be greater than 0.");
            }
            this.prefix = prefix;
            this.maxlength = maxlength;
        }

        public String getPrefix() {
            return prefix;
        }

        public int getMaxLength() {
            return maxlength;
        }

        public String format(String message) {
            if (message == null) {
                System.out.println("[" + getPrefix() + "] Invalid message: null");
                return null;
            }
            if (message.length() > maxlength) {
                System.out.println("[" + getPrefix() + "] Invalid message: too long (length = " + message.length()
                        + ", max = " + maxlength + ")");
                return null;
            }
            String formatted = prefix + ": " + message;
            System.out.println("[" + getPrefix() + "] Formatted message: " + formatted);
            return formatted;
        }
    }

    static class VerboseMessageFormatter extends MessageFormatter {
        public VerboseMessageFormatter(String prefix, int maxLength) {
            super(prefix, maxLength);
        }

        @Override
        public String format(String message) {
            String baseFormatted = super.format(message);

            if (baseFormatted == null) {
                return null;
            }
            int length = (message == null) ? 0 : message.length();
            String verbose = baseFormatted + "(len = " + length + ")";

            System.out.println("[" + getPrefix() + "] Extended formatted message: " + verbose);
            return verbose;
        }
    }

    static class TruncatingMessageFormatter extends MessageFormatter {
        public TruncatingMessageFormatter(String prefix, int maxLength) {
            super(prefix, maxLength);
        }

        @Override
        public String format(String message) {
            if (message == null) {
                System.out.println("[" + getPrefix() + "] Invalid message: null");
                return null;
            }
            if (message.length() > getMaxLength()) {
                String truncated = message.substring(0, getMaxLength());
                String formatted = getPrefix() + ": " + truncated;
                System.out.println("[" + getPrefix() + "] Truncated message: " + formatted);
                return formatted;
            } else {
                String baseFormatted = super.format(message);
                return baseFormatted;
            }
        }
    }

    public static void main(String[] args) {
        MessageFormatter base = new MessageFormatter("BASE", 10);
        VerboseMessageFormatter verbose = new VerboseMessageFormatter("VERBOSE", 10);
        TruncatingMessageFormatter trunc = new TruncatingMessageFormatter("TRUNC", 10);

        String shortMsg = "Hello";
        String longMsg = "Hello World!";
        String nullMsg = null;
        System.out.println("=== Base ===");
        base.format(shortMsg);
        base.format(longMsg);
        base.format(nullMsg);

        System.out.println("\n=== Verbose ===");
        verbose.format(shortMsg);
        verbose.format(longMsg);

        System.out.println("\n=== Truncating ===");
        trunc.format(shortMsg);
        trunc.format(longMsg);
        trunc.format(nullMsg);
    }
}
