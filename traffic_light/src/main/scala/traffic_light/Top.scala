import chisel3._
import chisel3.util._

class Top extends Module {
  val io = IO(new Bundle {
    val a = Input(UInt(8.W))
    val b = Input(UInt(8.W))
    val c = Output(UInt(8.W))
  })

  val reg = RegInit(0.U(8.W))
  reg := io.a + io.b

  io.c := reg
}

object TopMain extends App {
  println("Generating the adder hardware")
  emitVerilog(new Top(), Array("--target-dir", "generated"))
}
