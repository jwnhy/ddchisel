package decoder
import chisel3._
import chisel3.util._

class Decoder extends Module {
  val io = IO(new Bundle {
    val inSw = Input(UInt(4.W))
    val outSeg = Output(UInt(8.W))
  })
  val HIGH_IS_ON = false;
  val codeTable = Array(
    "b00111111".U, // 0
    "b00000110".U, // 1
    "b01011011".U, // 2
    "b01001111".U, // 3
    "b01100110".U, // 4
    "b01101101".U, // 5
    "b01111101".U, // 6
    "b00000111".U, // 7
    "b01111111".U, // 8
    "b01101111".U, // 9
    "b01110111".U, // A
    "b01111100".U, // b
    "b00111001".U, // C
    "b01011110".U, // d
    "b01111001".U, // E
    "b01110001".U // F
  )
  val hwCodeTable = Wire(Vec(16, UInt(8.W)));
  for (i <- 0 to 15) {
    hwCodeTable(i) := codeTable(i)
  }
  if (HIGH_IS_ON)
    io.outSeg := hwCodeTable(io.inSw)
  else
    io.outSeg := ~hwCodeTable(io.inSw)
}

object DecoderMain extends App {
  println("Generating the decoder hardware")
  emitVerilog(new Decoder(), Array("--target-dir", "generated"))
}
