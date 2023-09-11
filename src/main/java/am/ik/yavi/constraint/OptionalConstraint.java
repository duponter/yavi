/*
 * Copyright (C) 2018-2022 Toshiaki Maki <makingx@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package am.ik.yavi.constraint;

import java.util.Optional;
import java.util.function.Predicate;

import am.ik.yavi.constraint.base.ConstraintBase;
import am.ik.yavi.core.ConstraintPredicate;

import static am.ik.yavi.core.NullAs.VALID;
import static am.ik.yavi.core.ViolationMessage.Default.OPTIONAL_CONTAINS;
import static am.ik.yavi.core.ViolationMessage.Default.OPTIONAL_IS_EMPTY;
import static am.ik.yavi.core.ViolationMessage.Default.OPTIONAL_IS_PRESENT;

public class OptionalConstraint<T, E>
		extends ConstraintBase<T, Optional<E>, OptionalConstraint<T, E>> {

	@Override
	public OptionalConstraint<T, E> cast() {
		return this;
	}

	public OptionalConstraint<T, E> isEmpty() {
		this.predicates().add(ConstraintPredicate.of(x -> !x.isPresent(), OPTIONAL_IS_EMPTY,
				() -> new Object[]{}, VALID));
		return this;
	}

	public OptionalConstraint<T, E> isPresent() {
		this.predicates().add(ConstraintPredicate.of(Optional::isPresent, OPTIONAL_IS_PRESENT,
				() -> new Object[]{}, VALID));
		return this;
	}

	public OptionalConstraint<T, E> contains(E s) {
		this.predicates().add(ConstraintPredicate.of(x -> x.filter(Predicate.isEqual(s)).isPresent(),
				OPTIONAL_CONTAINS, () -> new Object[]{s}, VALID));
		return this;
	}
}
