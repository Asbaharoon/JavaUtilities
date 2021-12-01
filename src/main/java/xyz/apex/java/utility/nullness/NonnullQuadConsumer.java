package xyz.apex.java.utility.nullness;

import xyz.apex.java.utility.function.QuadConsumer;

import javax.annotation.Nonnull;
import java.util.Objects;

/**
 * An alternative to {@link QuadConsumer} where the inputs must always be nonnull
 *
 * @param <A> The type of the first argument to the operation
 * @param <B> The type of the second argument to the operation
 * @param <C> The type of the third argument to the operation
 * @param <D> The type of the fourth argument to the operation
 *
 * @see QuadConsumer
 * @see Nonnull
 * @since 1.0.0-J8
 */
@FunctionalInterface
public interface NonnullQuadConsumer<@NonnullType A, @NonnullType B, @NonnullType C, @NonnullType D> extends QuadConsumer<A, B, C, D>
{
	/**
	 * {@inheritDoc}
	 *
	 * @see QuadConsumer#accept(Object, Object, Object, Object)
	 */
	@Override
	void accept(A a, B b, C c, D d);

	/**
	 * {@inheritDoc}
	 *
	 * @see QuadConsumer#andThen(QuadConsumer)
	 */
	default NonnullQuadConsumer<A, B, C, D> andThen(NonnullQuadConsumer<? super A, ? super B, ? super C, ? super D> after)
	{
		Objects.requireNonNull(after);

		return (a, b, c, d) -> {
			accept(a, b, c, d);
			after.accept(a, b, c, d);
		};
	}

	/**
	 * @param <A> The type of first argument to the operation
	 * @param <B> The type of second argument to the operation
	 * @param <C> The type of third argument to the operation
	 * @param <D> The type of fourth argument to the operation
	 * @return Returns a consumer that does nothing when applied
	 *
	 * @see QuadConsumer#noop()
	 */
	static <@NonnullType A, @NonnullType B, @NonnullType C, @NonnullType D> NonnullQuadConsumer<A, B, C, D> noop()
	{
		return (a, b, c, d) -> { };
	}
}
