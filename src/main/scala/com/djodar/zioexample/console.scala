package com.djodar.zioexample

import java.io.IOException

import scalaz.zio.ZIO

package object console {
  def println(line: String): ZIO[Console.Service, Nothing, Unit] =
    ZIO.accessM(_.println(line))

  val readLine: ZIO[Console.Service, IOException, String] =
    ZIO.accessM(_.readLine)
}
