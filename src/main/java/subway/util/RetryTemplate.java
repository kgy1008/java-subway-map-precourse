package subway.util;

import java.util.function.Supplier;

public class RetryTemplate {

    public static <T> T retryTemplate(final Supplier<T> action) {
        while (true) {
            try {
                return action.get();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void retryTemplate(final Runnable action) {
        while (true) {
            try {
                action.run();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
