package tests

import Atom
import SAT
import org.junit.Assert.*
import org.junit.Test

class SATTest {

	@Test
	fun initAtoms() {
		val sat = SAT("data.txt")
		val atoms = mutableSetOf(Atom(1), Atom(2), Atom(3))
		assertTrue(sat.atoms.containsAll(atoms))
	}

	@Test
	fun initCNF() {
		val sat = SAT("data.txt") // !3 3
		sat.atoms.find { it == Atom(3) }?.flip()
		assertTrue(sat.cnf[1][0].value == sat.cnf[2][1].value)
	}

}