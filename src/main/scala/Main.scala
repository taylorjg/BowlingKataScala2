object Main {
	def main(args: Array[String]) = {
		val rs = List.fill(12)(10)
		println("Score for %s is %d.".format(rs, TennisKata.score(rs)))
	}
}
