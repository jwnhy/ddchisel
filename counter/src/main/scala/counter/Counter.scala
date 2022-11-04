package counter
import chisel3._
import chisel3.util._
import decoder.Decoder

class Counter extends Module {
  val io = IO(new Bundle {
    val displayWire = Output(UInt(4.W))
  })
  val displayReg = RegInit(0.U(4.W))
  val cntReg = RegInit(0.U(32.W))
  cntReg := cntReg + 1.U
  when(cntReg === 10000000.U) {
    cntReg := 0.U
    displayReg := displayReg + 1.U
  }
  when(displayReg === 16.U) {
    displayReg := 0.U
  }
  io.displayWire := displayReg
}


