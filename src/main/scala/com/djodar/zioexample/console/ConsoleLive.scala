package com.djodar.zioexample.console

import java.io.IOException

import scalaz.zio.ZIO

object ConsoleLive extends Console.Service {
  override def println(line: String): ZIO[Any, Nothing, Unit] =
    ZIO.effectTotal(Predef.println(line))

  override val readLine: ZIO[Any, IOException, String] =
    ZIO.effectTotal(scala.io.StdIn.readLine()).refineOrDie {
      case e: IOException => e
    }
}
