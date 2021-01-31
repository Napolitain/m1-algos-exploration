import java.io.BufferedReader
import java.io.File
import java.io.FileReader
import kotlin.math.min
import kotlin.random.Random

fun <E> HashSet<E>.findByHashCode(other: E): E? = firstOrNull { it.hashCode() == other.hashCode() }

class SAT(path: String) {

	// (a ou b) et (a ou c)
	var atoms: MutableMap<Int, Atom>
	val cnf: MutableList<MutableList<Atom>>
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
						cnf[i].add(!atoms[index]!!)
					} else {
						val atom = Atom(index)
						cnf[i].add(!atom)
						atoms[index] = atom
					}
				} else {
					val index = electron[0].toString().toInt();
					if (atoms.containsKey(index)) {
						cnf[i].add(atoms[index]!!)
					} else {
						val atom = Atom(index)
						cnf[i].add(atom)
						atoms[index] = atom
					}
				}
			}
			i++;
		}
		cnfLength = i+1;
		bufferedReader.close();
	}

	private fun cost(atoms: MutableMap<Int, Atom>): Int {
		var i = 0;
		for (mutableList in cnf) {
			var eval = false;
			for (atom in mutableList) {
				if (atom.)
			}
		}
		return i;
	}

	private fun min(mutableMap: MutableMap<Int, Atom>, best: MutableMap<Int, Atom>): MutableMap<Int, Atom> {
		TODO("Not yet implemented")
	}

	fun genericMetaheuristic(max_tries: Int, max_flips: Int) {
		for (i in 1..max_tries) {
			// initialisation
			var x: MutableMap<Int, Atom> = atoms;
			for (atom in x.values) {
				if (Random.nextBoolean()) {
					atom.flip()
				}
			}
			// test une configuration
			var localBest: MutableMap<Int, Atom> = mutableMapOf()
			for (j in 1..max_flips) {
				x = genericMove(atoms)
				localBest = min(x, localBest);
			}
		}
		// selection de la meilleure configuration
	}

	fun genericMove(atomsCurrent: MutableMap<Int, Atom>) : MutableMap<Int, Atom> {
		var i = 0
		return atomsCurrent
	}

}
