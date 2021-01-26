package com.github.napolitain.sat

import java.io.BufferedReader
import java.io.File
import java.io.FileReader
import java.util.*

class SAT(path: String) {

	// (a ou b) et (a ou c)
	private val atoms: Set<Atom>
	private val cnf: MutableList<MutableList<Atom>>

	init {
		val fileName: String = File(".").canonicalPath + "/src/" + path
		val bufferedReader = BufferedReader(FileReader(fileName))
		val iterator = bufferedReader.lineSequence().iterator()
		atoms = mutableSetOf()
		cnf = mutableListOf()
		var i: Int = 0;
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
		bufferedReader.close();
	}



}
