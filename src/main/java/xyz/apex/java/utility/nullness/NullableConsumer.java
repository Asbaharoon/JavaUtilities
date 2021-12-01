package xyz.apex.java.utility.nullness;

import javax.annotation.Nullable;
import java.util.Objects;
import java.util.function.Consumer;

/**
 * An alternative to {@link Consumer} where the input can be nullable
 *
 * @param <T> The type of the input to the operation
 *
 * @see Consumer
 * @see Nullable
 * @since 1.0.0-J8
 */
@FunctionalInterface
public interface NullableConsumer<@NullableType T> extends Consumer<T>
{
	/**
	 * {@inheritDoc}
	 */
	@Override
	void accept(T t);

	/**
	 * @see Consumer#andThen(Consumer)
	 */
	default NullableConsumer<T> andThen(NullableConsumer<? super T> after)
	{
		Objects.requireNonNull(after);
		return t -> {
			accept(t);
			after.accept(t);
		};
	}

	/**
	 * Builds consumer that does nothing when applied
	 *
	 * @param <T> The type of input to the operation
	 * @return Returns a consumer that does nothing when applied
	 * @since 1.0.0-J8
	 */
	static <@NullableType T> NullableConsumer<T> noop()
	{
		return t -> { };
	}
}
