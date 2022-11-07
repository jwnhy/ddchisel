import chisel3._
import chisel3.util._
import input_proc.InputBtn
import decoder.Decoder

class Top extends Module {
  withReset(~reset.asBool()) {
    val io = IO(new Bundle {
      val inBtn = Input(Bool())
      val outSeg = Output(UInt(8.W))
    })
    val btn = Module(new InputBtn)
    val decoder = Module(new Decoder)
    btn.io.inBtn := io.inBtn
    io.outSeg := decoder.io.outSeg
    val cnt = RegInit(0.U(8.W))
    when(btn.io.outBtn) {
      cnt := Mux(cnt === 15.U, 0.U, cnt + 1.U)
    }
    decoder.io.inSw := cnt
  }
}
object TopMain extends App {
  println("Generating the adder hardware")
  emitVerilog(new Top(), Array("--target-dir", "generated"))
}
