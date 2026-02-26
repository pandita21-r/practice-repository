// Flaw: Mixing up what should be identified in messages hehe

public class TaskProcessorOverridingDrill {
    static class TaskProcessor {
        private String name;

        public TaskProcessor(String name) {
            if (name.isBlank()) {
                throw new IllegalArgumentException("Processor name must not be null, blank, or only spaces.");
            }
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void process(String taskName) {
            if (taskName == null || taskName.trim().isEmpty()) {
                System.out.println("[<" + taskName + ">] Invalid task name. Cannot process.");
                return;
            }
            System.out.println("[<" + taskName + ">] Processing task: <" + taskName + ">");
        }
    }

    static class LoggingTaskProcessor extends TaskProcessor {

        public LoggingTaskProcessor(String name) {
            super(name);
        }

        @Override
        public void process(String taskName) {
            System.out.println("[LOG:<\"" + taskName + ">\"] Start processing");
            super.process(taskName);
            System.out.println("[LOG:<\"" + taskName + ">\"] End processing");
        }
    }

    static class SkippingEmptyTaskProcessor extends TaskProcessor {

        public SkippingEmptyTaskProcessor(String name) {
            super(name);
        }

        @Override
        public synchronized void process(String taskName) {
            if (taskName == null || taskName.trim().isEmpty()) {
                System.out.println("[<" + taskName + ">] Skipping empty task.");
                return;
            }
            System.out.println("[<" + taskName + ">] About to handle non-empty task.");
            super.process(taskName);
        }
    }

    public static void main(String[] args) {
        TaskProcessor[] processors = {
                new TaskProcessor("Base"),
                new LoggingTaskProcessor("Logger"),
                new SkippingEmptyTaskProcessor("Skipper")
        };
        String[] tasks = { "CleanUp", "    ", "Deploy" };

        for (TaskProcessor p : processors) {
            System.out.println("\n--- Testing: " + p.getName() + " ---");
            for (String t : tasks) {
                p.process(t);
            }

        }
    }
}
