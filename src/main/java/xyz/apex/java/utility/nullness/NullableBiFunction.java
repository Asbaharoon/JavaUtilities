package xyz.apex.java.utility.nullness;

import javax.annotation.Nullable;
import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * An alternative to {@link BiFunction} where the inputs can be nullable
 *
 * @param <T> The type of the first argument to the operation
 * @param <U> The type of the second argument to the operation
 *
 * @see BiFunction
 * @see Nullable
 * @since 1.0.0-J8
 */
@FunctionalInterface
public interface NullableBiFunction<@NullableType T, @NullableType U, @NullableType R> extends BiFunction<T, U, R>
{
	/**
	 * {@inheritDoc}
	 */
	@Override
	R apply(T t, U u);

	/**
	 * @see BiFunction#andThen(Function)
	 */
	default <@NullableType V> NullableBiFunction<T, U, V> andThen(NullableFunction<? super R, ? extends V> after)
	{
		Objects.requireNonNull(after);
		return (t, u) -> after.apply(apply(t, u));
	}
}
