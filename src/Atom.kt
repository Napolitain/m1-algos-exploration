
class Atom(val index: Int, var value: Boolean = true) {

	override fun equals(other: Any?): Boolean {
		return if (other is Atom) {
			value == other.value
		} else {
			false
		}
	}



	/**
	 * Flip value, used in GSAT, Walksat...
	 */
	fun flip() {
		value = !value
	}

	override fun toString(): String {
		return "x$index =$value)\n"
	}

}
