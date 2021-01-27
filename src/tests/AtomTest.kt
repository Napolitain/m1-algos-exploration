package tests

import Atom
import org.junit.Test

import org.junit.Assert.*
import java.util.concurrent.BrokenBarrierException

class AtomTest {

	@Test
	operator fun not() {
		val a = Atom(1, true)
		assertEquals(!a.value, false)
	}

	@Test
	fun flip() {
		val a = Atom(1, true)
		a.flip()
		assertEquals(a.value, false)
	}

	@Test
	fun equalsSameValue() {
		val a = Atom(1, true)
		val b = Atom(2, true)
		assertEquals(a == b, false)
	}

	@Test
	fun equalsSameIndex() {
		val a = Atom(1, true)
		val b = Atom(1, false)
		assertEquals(a == b, true)
	}

	@Test
	fun equalsNotAtom() {
		val a = Atom(1, true)
		assertEquals(a == !a, true)
	}

}