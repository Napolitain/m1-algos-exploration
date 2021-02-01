class Variable(private val atom: Atom, private val operator: Boolean = true) {

	override fun equals(other: Any?) : Boolean {
		return if (other is Variable) {
			atom == other.atom
		} else {
			false
		}
	}

	fun index(): Int {
		return atom.index
	}

	fun value(): Boolean {
		if (operator) {
			return atom.value
		} else {
			return !atom.value
		}
	}

}
