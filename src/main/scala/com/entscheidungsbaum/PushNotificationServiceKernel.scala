/**
 * @author marcus (at) entscheidungsbaum
 *
 */

package com.plotprojects

import akka.actor.{Actor,ActorSystem,Props}
import akka.kernel.Bootable


case object Start

class PushNotificationServiceActor extends Actor {
                                                                                             A
}

class PushReceiverActor extends Actor {

  val applePushReceiverActor = context.actor(Props[ApplePushReceiverActor])
  def receive = {
    case message: String => sender ! (message.toUpperCase + " sending to push service")
  }
}

class ApplePushReceiverActor extends Actor {

  def receive = {
    case message:String => sender ! (message.toUpperCase + "received a apple push service request")
  }
  
}   

class AndroidPushReceiverActor extends Actor {

  def receive = {
    case message:String => sender ! (message.toUpperCase + "received a android push service request")
  }
  
}

class PushNotificationServiceKernel extends Bootable {

  val system = {

    case message : String => sender ! (message.toUpperCase + "plot test" )
  }

  def startup = {
    system.actorOf(Props[PushReceiver]) ! Start
  }

  def shutdown = {
    system.shutdown()
  }

}


