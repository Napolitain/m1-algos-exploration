fun main() {
	val sat: SAT = SAT("data.txt")
	sat.gsat(1000, 100)
	println(sat.atoms)
}
