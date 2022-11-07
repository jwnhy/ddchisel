import hello._
import chisel3._
import chiseltest._
import org.scalatest.flatspec.AnyFlatSpec

class HelloTest extends AnyFlatSpec with ChiselScalatestTester {
  "Hello" should "pass" in {
    test(new Hello) { hello =>
      var andRes = Array(0, 0, 0, 1);
      var orRes = Array(0, 1, 1, 1);
      var xorRes = Array(0, 1, 1, 0);
      for (i <- 0 to 3) {
        hello.io.andSw.poke(i.U)
        hello.clock.step()
        hello.io.andLed.expect(andRes(i))
        hello.io.orSw.poke(i.U)
        hello.clock.step()
        hello.io.orLed.expect(orRes(i))
        hello.io.xorSw.poke(i.U)
        hello.clock.step()
        hello.io.xorLed.expect(xorRes(i))
      }
    }
  }
}
