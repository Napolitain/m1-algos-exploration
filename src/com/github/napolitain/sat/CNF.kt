package com.github.napolitain.sat

import java.io.BufferedReader
import java.io.File
import java.io.FileReader
import java.util.*

class CNF(path: String) {

	// (a ou b) et (a ou c)
	private var cnf: LinkedList<LinkedList<Atom>>

	init {
		val fileName: String = File(".").canonicalPath + "/src/" + path
		val bufferedReader = BufferedReader(FileReader(fileName))
		val iterator = bufferedReader.lineSequence().iterator()
		cnf = LinkedList<LinkedList<Atom>>()
		while (iterator.hasNext()) {
			val atoms: String = iterator.next()
			for (atom in atoms.split(" ")) {
				if (atom.startsWith("!")) {
					cnf.add(!atom);
				}
			}
		}
		bufferedReader.close();
	}

}
