package com.github.napolitain.sat

class Atom(private val index: Int, private val value: Boolean = true) {

	operator fun not(): Atom {
		return if (value) {
			Atom(index, false)
		} else {
			Atom(index, true)
		}
	}

	override fun hashCode(): Int {
		return index;
	}

	override fun equals(other: Any?): Boolean {
		if (other != null) {
			if (other is Atom) {
				return this.hashCode() == other.hashCode()
			}
		}
		return false;
	}

}
