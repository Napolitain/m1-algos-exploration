import java.io.BufferedReader
import java.io.File
import java.io.FileReader
import kotlin.math.min
import kotlin.random.Random

class SAT(path: String) {

	// (a ou b) et (a ou c)
	var atoms: MutableMap<Int, Atom>
	val cnf: MutableList<MutableList<Variable>>
	val cnfLength: Int

	init {
		val fileName: String = File(".").canonicalPath + "/src/" + path
		val bufferedReader = BufferedReader(FileReader(fileName))
		val iterator = bufferedReader.lineSequence().iterator()
		atoms = mutableMapOf()
		cnf = mutableListOf()
		var i = 0;
		while (iterator.hasNext()) {
			val electrons: String = iterator.next()
			cnf.add(mutableListOf())
			for (electron in electrons.split(" ")) {
				if (electron.startsWith("!")) {
					val index = electron[1].toString().toInt();
					if (atoms.containsKey(index)) {
						cnf[i].add(Variable(atoms[index]!!, false))
					} else {
						val atom = Atom(index)
						cnf[i].add(Variable(atom, false))
						atoms[index] = atom
					}
				} else {
					val index = electron[0].toString().toInt();
					if (atoms.containsKey(index)) {
						cnf[i].add(Variable(atoms[index]!!))
					} else {
						val atom = Atom(index)
						cnf[i].add(Variable(atom))
						atoms[index] = atom
					}
				}
			}
			i++;
		}
		cnfLength = i+1;
		bufferedReader.close();
	}

	/**
	 * Return number of satisfiable clauses for current CNF and given configuration
	 */
	private fun sat(x: MutableMap<Int, Atom>): Int {
		var i = 0;
		for (orClause in cnf) {
			var eval = false;
			for (variable in orClause) {
				eval = eval.or(x[variable.index()]!!.value)
			}
			if (eval) {
				i++;
			}
		}
		return i;
	}

	/**
	 * Return best configuration by checking satifiable number of clauses
	 */
	private fun min(x: MutableMap<Int, Atom>, best: MutableMap<Int, Atom>): MutableMap<Int, Atom> {
		return if (sat(x) < sat(best)) {
			best
		} else {
			x
		}
	}

	/**
	 * Metaheuristic algorithm (SAT problem)
	 */
	fun gsat(max_tries: Int, max_flips: Int) {
		for (i in 1..max_tries) {
			// initialisation
			var x: MutableMap<Int, Atom> = atoms;
			for (atom in x.values) {
				if (Random.nextBoolean()) {
					atom.flip()
				}
			}
			// test une configuration
			var localBest: MutableMap<Int, Atom> = atoms.toMutableMap()
			for (j in 1..max_flips) {
				x = genericMove()
				localBest = min(x, localBest)
			}
			// selection is in-place here
			atoms = min(atoms, localBest)
		}
	}

	/**
	 * Return a configuration
	 */
	fun genericMove() : MutableMap<Int, Atom> {
		val x = atoms.toMutableMap()
		for (i in x.keys) {
			x[i]!!.flip()
			if (x == min(x, atoms)) return x
		}
		return atoms
	}

}

/**
 * Or method between boolean and Variable
 */
private fun Boolean.or(variable: Variable): Boolean {
	return this.or(variable.value())
}
