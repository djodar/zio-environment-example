package com.djodar.zioexample

import java.io.IOException

import scalaz.zio.{DefaultRuntime, IO, ZIO}

object ZIOExampleApp extends App {
  import console._

  val program: ZIO[Console.Service, IOException, Unit] =
    for {
      _ <- println("Hello World, write your name!")
      name <- readLine
      _ <- println("Hello " + name)
    } yield ()

  val programLive: IO[IOException, Unit] = program.provide(ConsoleLive)

  new DefaultRuntime{}.unsafeRun(programLive)
}
