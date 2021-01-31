package tests

import Atom
import SAT
import org.junit.Assert.*
import org.junit.Test

class SATTest {

	@Test
	fun initAtoms() {
		val sat = SAT("data.txt")
		val atoms = mutableSetOf(Atom(), Atom(), Atom())
		assertTrue(sat.atoms.values.containsAll(atoms))
	}

	@Test
	fun initCNF() {
		val sat = SAT("data.txt") // !3 3
		sat.atoms[3]!!.flip()
		assertTrue(sat.cnf[1][0].value == sat.cnf[2][1].value)
	}

}