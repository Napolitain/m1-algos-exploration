package com.github.napolitain.sat

class Atom(private val value: Boolean = true) {

	operator fun Atom.not(): Atom {
		return if (value) {
			Atom(false)
		} else {
			Atom(true)
		}
	}

}
