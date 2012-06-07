package com.entscheidungsbaum

/**
 * com.entscheidungsbaum
 * marcus
 * Author Marcus Schlechter
 * 6/6/12
 */
class PushReceiver (psnd: PushServiceNotificationDao) extends Actor {

  val logger = Logging(context.system, this)

  /**
   *
   */
  override def preStart() = {
    logger.debug("starting PushReceiver Actor")
  }

  /**
   *
   * @param reason
   * @param message
   */
  override def preRestart(reason: Throwable, message: Option[Any]) {
    logger.error(reason, "Restarting due to [{}] when processing [{}]", reason.getMessage, message.getOrElse())
  }


  /**
   *
   * @return
   */
  def receive = {

    case message: String => println("apn" + " sending to push service")
    case message: ApplePushMessage => psnd.sendPushRequest(message.deviceToken, message.message)
    case message: AndroidPushMessage => psnd.sendPushRequest(message.deviceToken, message.message)
    case x => logger.warning("got unknown action to fullfill : {}", x)

  }

  case class ApplePushMessage(deviceToken: String, message: String)

  case class AndroidPushMessage(deviceToken: String, message: String)

}

//
//
//sealed trait PushMessages {
//  case ApplePush
//}
{

import akka.event.Logging

import akka.event.Logging

import akka.event.Logging

import akka.event.Logging._
import akka.actor.Actor
import _root_.com.plotprojects.data.PushServiceNotificationDao

}
