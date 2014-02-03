object TennisKata {
	def score(rs: List[Int]) = {
		def loop(s: Int, f: Int, rs: List[Int]): Int = {
			(s, f, rs) match {
				case (s, 11, _) => s
				case _ => {
					def loop2(n: Int, rs2: List[Int]) =
						loop(s + (rs take n).sum, f + 1, rs2)
					rs match {
						case 10 :: rs2 => loop2(3, rs2)
						case x :: y :: rs2 if x + y == 10 => loop2(3, rs2)
						case x :: y :: rs2 => loop2(2, rs2)
						case _ => throw new Exception("ERROR!")
					}
				}
			}
		}
		loop(0, 1, rs)
	}
}
