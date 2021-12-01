package xyz.apex.java.utility.nullness;

import javax.annotation.Nonnull;
import java.util.Objects;
import java.util.function.Predicate;

/**
 * An alternative to {@link Predicate} where the input must always be nonnull
 *
 * @param <T> The type of the input to the operation
 *
 * @see Predicate
 * @see Nonnull
 * @since 1.0.0-J8
 */
@FunctionalInterface
public interface NonnullPredicate<@NonnullType T> extends Predicate<T>, NonnullFunction<T, Boolean>
{
	/**
	 * {@inheritDoc}
	 */
	@Override
	boolean test(T t);

	/**
	 * {@inheritDoc}
	 */
	@Override
	default Boolean apply(T t)
	{
		return test(t);
	}

	/**
	 * @see Predicate#and(Predicate)
	 */
	default NonnullPredicate<T> and(NonnullPredicate<? super T> other)
	{
		Objects.requireNonNull(other);
		return t -> test(t) && other.test(t);
	}

	/**
	 * @see Predicate#or(Predicate)
	 */
	default NonnullPredicate<T> or(NonnullPredicate<? super T> other)
	{
		Objects.requireNonNull(other);
		return t -> test(t) || other.test(t);
	}
}
