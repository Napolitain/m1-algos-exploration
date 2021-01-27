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
		sat.atoms.containsAll(atoms)
	}

	@Test
	fun initCNF() {
		val sat = SAT("data.txt")
		val a = Atom(1)
		val b = Atom(2)
		val c = Atom(3)
		val cnf = mutableListOf(mutableListOf(a, !b), mutableListOf(!c, b), mutableListOf(a, c))
		sat.cnf.equals(cnf)
	}

}