package com.github.napolitain.sat

class Atom(private val index: Int, private var value: Boolean = true) {

	// TODO: random value affectation

	/**
	 * Negative operator for Atom.
	 * !A has for value false if A has for value true.
	 */
	operator fun not(): Atom {
		return if (value) {
			Atom(index, false)
		} else {
			Atom(index, true)
		}
	}

	/**
	 * Unique identifier for Atom A.
	 * File used for it specifies as a1, a2, a3... an
	 */
	override fun hashCode(): Int {
		return index;
	}

	/**
	 * Used with hashCode for checking if Atom ax is in atoms: Set<Atom>
	 */
	override fun equals(other: Any?): Boolean {
		if (other != null) {
			if (other is Atom) {
				return this.hashCode() == other.hashCode()
			}
		}
		return false;
	}

	/**
	 * Flip value, used in GSAT, Walksat...
	 */
	fun flip() {
		value = !value
	}

}
