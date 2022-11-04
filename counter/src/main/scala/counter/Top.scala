package counter
import chisel3._
import chisel3.util._
import decoder.Decoder

class Top extends Module {
  withReset(!reset.asBool()) {
    val io = IO(new Bundle {
      val outSeg = Output(UInt(8.W))
    })

    val decoder = Module(new Decoder)
    val counter = Module(new Counter)
    decoder.io.inSw := counter.io.displayWire
    io.outSeg := decoder.io.outSeg
  }
}

object TopMain extends App {
  println("Generating the hardware")
  emitVerilog(new Top(), Array("--target-dir", "generated"))
}
