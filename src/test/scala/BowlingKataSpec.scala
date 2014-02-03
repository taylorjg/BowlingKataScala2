import org.scalatest.FunSpec
import org.scalatest.prop.TableDrivenPropertyChecks._

class BowlingKataSpec extends FunSpec {

	describe("BowlingKata tests") {

		def rep(n: Int, elem: Int) = List.fill(n)(elem)

		val rowsOfTestData = Table(
			("description",  "rs",                        "expectedScore"),
			("gutters",      rep(20, 0),                  0),
			("ones",         rep(20, 1),                  20),
			("fives",        rep(21, 5),                  150),
			("strikes",      rep(12, 10),                 300),
			("1 + gutters",  1::rep(19, 0),               1),
			("first spare",  5::5::5::rep(17, 0),         20),
			("first strike", 10::5::5::rep(17, 0),        30),
			("last spare",   rep(18, 0):::List(5, 5, 5),  15),
			("last strike",  rep(18, 0):::List(10, 5, 5), 20)
		)

		it("calculates the correct score for various sequences of rolls") {
			forAll (rowsOfTestData) { (_, rs, expectedScore) =>
				val actualScore = BowlingKata.score(rs)
				assertResult(expectedScore)(actualScore)
			}
		}
	}
}
