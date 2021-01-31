package tests

import Atom
import org.junit.Test
import org.junit.Assert.*

class AtomTest {

	@Test
	operator fun not() {
		val a = Atom(true)
		assertEquals(!a.value, false)
	}

	@Test
	fun flip() {
		val a = Atom(true)
		a.flip()
		assertEquals(a.value, false)
	}

	@Test
	fun equalsSameValue() {
		val a = Atom(true)
		val b = Atom(true)
		assertEquals(a == b, false)
	}

}