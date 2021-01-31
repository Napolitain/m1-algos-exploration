import java.io.BufferedReader
import java.io.File
import java.io.FileReader
import kotlin.random.Random

fun <E> HashSet<E>.findByHashCode(other: E): E? = firstOrNull { it.hashCode() == other.hashCode() }

class SAT(path: String) {

	// (a ou b) et (a ou c)
	val atoms: MutableMap<Int, Atom>
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
						val atom = Atom()
						cnf[i].add(!atom)
						atoms[index] = atom
					}
				} else {
					val index = electron[0].toString().toInt();
					if (atoms.containsKey(index)) {
						cnf[i].add(atoms[index]!!)
					} else {
						val atom = Atom()
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

	fun genericMetaheuristic(max_tries: Int, max_flips: Int) {
		for (i in 1..max_tries) {
			// initialisation
			for (atom in atoms.values) {
				if (Random.nextBoolean()) {
					atom.flip()
				}
			}
			// test une configuration
			var localBest: MutableMap<Int, Atom> = mutableMapOf()
			for (j in 1..max_flips) {
				genericMove(atoms)
			}
		}
		// selection de la meilleure configuration
	}

	fun genericMove(atomsCurrent: MutableMap<Int, Atom>) {
		var i = 0

	}

}
