import chisel3._

/**
 * The blinking LED component.
 */

class Hello extends Module {
  val io = IO(new Bundle {
    val andSw = Input(UInt(2.W))
    val andLed = Output(UInt(1.W))
    val orSw = Input(UInt(2.W))
    val orLed = Output(UInt(1.W))
    val xorSw = Input(UInt(2.W))
    val xorLed = Output(UInt(1.W))
  })
  io.xorLed := io.xorSw(0) ^ io.xorSw(1)
  io.andLed := io.andSw(0) & io.andSw(1)
  io.orLed := io.orSw(0) | io.orSw(1)

}

/**
 * An object extending App to generate the Verilog code.
 */
object Hello extends App {
  (new chisel3.stage.ChiselStage).emitVerilog(new Hello())
}
