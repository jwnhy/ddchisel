package input_proc
import chisel3._
import chisel3.util._

class InputBtn extends Module {
  // Processing helpers
  def sync(v: Bool) = RegNext(RegNext(v))
  def rising(v: Bool) = v & !RegNext(v)
  val fac = 500000000 / 100 //100 Hz
  def tickGen() = {
    val reg = RegInit(0.U(log2Up(fac).W))
    val tick = reg === (fac-1).U
    reg := Mux(tick, 0.U, reg + 1.U)
    tick
  }
  def debounce(v: Bool, t: Bool, r: Bool) = {
    Mux(t, v, r)
  }
  def filter(v: Bool, t: Bool) = {
    val reg = RegInit(0.U(3.W))
    when (t) {
      // append reg = reg[1:0] ## v[0]
      reg := reg(1, 0) ## v
    }
    (reg(2) & reg(1)) | (reg(2) & reg(0)) | (reg(1) & reg(0))
  }
  // Main
  val io = IO(new Bundle {
    val inBtn = Input(Bool())
    val outBtn = Output(Bool())
  })
  val btn = ~io.inBtn
  val tick = tickGen()
  val btnSync = sync(btn)
  val btnDeb = Reg(Bool())
  when (tick) {
    btnDeb := btnSync
  }
  val btnClean = filter(btnDeb, tick)
  io.outBtn := rising(btnClean)
}

