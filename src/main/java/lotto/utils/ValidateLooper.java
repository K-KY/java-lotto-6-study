package lotto.utils;

import java.util.function.Function;
import java.util.function.Supplier;

public class ValidateLooper {

    public static <T> T read(Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return read(supplier);
        }
    }

    public static <T, R> R read(Function<T, R> function, T t) {
        try {
            return function.apply(t);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return read(function, t);
        }
    }
}
