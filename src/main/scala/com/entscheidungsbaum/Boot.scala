package com.entscheidungsbaum


/**
 * com.entscheidungsbaum
 * marcus
 * Author Marcus Schlechter
 * 6/14/12
 */


import com.typesafe.config.ConfigFactory
import akka.actor.{ActorSystem, Props}
import akka.kernel.Bootable


case object Start


//class PushNotificationServiceActor extends Actor {
//
//}


class Boot extends Bootable {

  val module = new Module()


  // val system = ActorSystem("PushServiceActor", ConfigFactory.load.getConfig("pushnotificationservice"))
  val system = ActorSystem("PushServiceNotificationApplication", ConfigFactory.load.getConfig("pushnotificationservice"))
  //  val actor = system.actorOf(Props[PushReceiver], "pushNotificationService")

  def startup = {
    //  system.actorOf(Props[PushReceiver]) ! Start
    system.actorOf(Props(module.pushReceiver), name = "master")

  }


  def shutdown = {
    system.shutdown()
  }
}

object PushServiceNotificationApp {
  def main(args: Array[String]) {
    new Boot
    println("Started PushServiceNotification Application - waiting for messages to push")
  }


}
