module Hello(
  input        clock,
  input        reset,
  input  [1:0] io_andSw,
  output       io_andLed,
  input  [1:0] io_orSw,
  output       io_orLed,
  input  [1:0] io_xorSw,
  output       io_xorLed
);
  assign io_andLed = io_andSw[0] & io_andSw[1]; // @[Hello.scala 17:28]
  assign io_orLed = io_orSw[0] | io_orSw[1]; // @[Hello.scala 18:26]
  assign io_xorLed = io_xorSw[0] ^ io_xorSw[1]; // @[Hello.scala 16:28]
endmodule
