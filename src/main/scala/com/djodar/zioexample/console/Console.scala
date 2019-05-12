package com.djodar.zioexample.console

import java.io.IOException

import scalaz.zio.ZIO

trait Console {
  def service: Console.Service
}

object Console {

  trait Service {
    def println(line: String): ZIO[Any, Nothing, Unit]

    val readLine: ZIO[Any, IOException, String]
  }
}
