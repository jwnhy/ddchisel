package traffic_light

import chisel3._
import chisel3.util._
import chisel3.stage.ChiselStage
import chisel3.experimental.ChiselEnum
import chisel3.experimental.suppressEnumCastWarning

/* A: Priority Road
 * B: Minor Road
 * RGY: Red, Green, Yellow */
object LightState extends ChiselEnum {
  val AGBR = Value
  val ARBG = Value
  val AYBR = Value
  val ARBY = Value
}

class FSM extends Module {
  val io = IO(new Bundle {
    val lightA = Output(UInt(3.W))
    val lightB = Output(UInt(3.W))
  })

  val state = RegInit(LightState())
}


