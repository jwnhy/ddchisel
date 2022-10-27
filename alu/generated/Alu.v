module Alu(
  input         clock,
  input         reset,
  input  [15:0] io_a,
  input  [15:0] io_b,
  input  [1:0]  io_fn,
  output [15:0] io_y
);
  wire [15:0] _io_y_T_1 = io_a + io_b; // @[Add.scala 14:28]
  wire [15:0] _io_y_T_3 = io_a - io_b; // @[Add.scala 15:28]
  wire [15:0] _io_y_T_4 = io_a | io_b; // @[Add.scala 16:28]
  wire [15:0] _io_y_T_5 = io_a & io_b; // @[Add.scala 17:28]
  wire [15:0] _GEN_0 = 2'h3 == io_fn ? _io_y_T_5 : 16'h0; // @[Add.scala 13:17 17:20 12:8]
  wire [15:0] _GEN_1 = 2'h2 == io_fn ? _io_y_T_4 : _GEN_0; // @[Add.scala 13:17 16:20]
  wire [15:0] _GEN_2 = 2'h1 == io_fn ? _io_y_T_3 : _GEN_1; // @[Add.scala 13:17 15:20]
  assign io_y = 2'h0 == io_fn ? _io_y_T_1 : _GEN_2; // @[Add.scala 13:17 14:20]
endmodule
