package xyz.apex.java.utility.nullness;

import javax.annotation.Nonnull;
import javax.annotation.meta.TypeQualifierDefault;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * This annotation can be applied to a package or class to indicate that
 * the fields in that element are nonnull by default unless there is:
 * <ul>
 *     <li>An explicit nullness annotation
 *     <li>There is a default parameter annotation (like {@link FieldsAreNullableByDefault})
 *     applied to a more tightly nested element.
 * </ul>
 *
 * @see Nonnull
 * @since 1.0.0-J8
 */
@Documented
@Nonnull
@TypeQualifierDefault(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface FieldsAreNonnullByDefault
{ }
