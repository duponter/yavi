package am.ik.yavi.constraint.temporal;

import java.time.chrono.ChronoLocalDateTime;

import am.ik.yavi.core.Constraint;

/**
 * This is the base class for constraints on ChronoLocalDateTime.
 *
 * @author Diego Krupitza
 * @since 0.10.0
 */
abstract class ChronoLocalDateTimeConstraintBase<T, V extends ChronoLocalDateTime<?>, C extends Constraint<T, V, C>>
		extends ComparableTemporalConstraintBase<T, V, C> {
	public ChronoLocalDateTimeConstraintBase() {
		super(ChronoLocalDateTime::isAfter, ChronoLocalDateTime::isBefore);
	}
}
