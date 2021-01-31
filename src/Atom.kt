
class Atom(val index: Int, var value: Boolean = true) {

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
	 * Flip value, used in GSAT, Walksat...
	 */
	fun flip() {
		value = !value
	}

}
