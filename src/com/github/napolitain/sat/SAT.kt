package com.github.napolitain.sat

import java.io.BufferedReader
import java.io.File
import java.io.FileReader
import kotlin.random.Random

class SAT(path: String) {

	// (a ou b) et (a ou c)
	val atoms: MutableSet<Atom>
	val cnf: MutableList<MutableList<Atom>>
	val cnfLength: Int

	init {
		val fileName: String = File(".").canonicalPath + "/src/" + path
		val bufferedReader = BufferedReader(FileReader(fileName))
		val iterator = bufferedReader.lineSequence().iterator()
		atoms = mutableSetOf()
		cnf = mutableListOf()
		var i = 0;
		while (iterator.hasNext()) {
			val electrons: String = iterator.next()
			cnf.add(mutableListOf())
			for (electron in electrons.split(" ")) {
				val atom: Atom
				if (electron.startsWith("!")) {
					atom = Atom(electron[1].toInt())
					cnf[i].add(!atom)
				} else {
					atom = Atom(electron[0].toInt())
					cnf[i].add(atom)
				}
				atoms.add(atom)
			}
			i++;
		}
		cnfLength = i+1;
		bufferedReader.close();
	}

	fun genericMetaheuristic(max_tries: Int, max_flips: Int) {
		for (i in 1..max_tries) {
			// initialisation
			for (atom in atoms) {
				if (Random.nextBoolean()) {
					atom.flip()
				}
			}
			// test une configuration aléatoire
			var localBest: MutableSet<Atom> = mutableSetOf()
			for (j in 1..max_flips) {
				genericMove()
			}
		}
		// selection de la meilleure configuration
	}

	fun genericMove() {

	}

}
