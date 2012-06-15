package com.entscheidungsbaum.data

/**
 * com.entscheidungsbaum.data
 * marcus
 * Author Marcus Schlechter
 * 6/6/12
 */
trait PushServiceNotificationDao {

  //  /**
  //   *  special case in case of an iphone . It has to be registered within this service.
  //   *
  //   */
  //  def registerIphone()

  //
  //  /**
  //   * send and apple pushrequest to
  //   * @param deviceId
  //   * @param messsage
  //   * @param extra
  //   */
  //  def sendIphonePushRequet(deviceId: String, messsage: String, extra: Map[String, String])
  //
  //  /**
  //   * send an android push request to
  //   * @param deviceId
  //   * @param message
  //   * @param extra
  //   */
  //  def sendAndroidPushNotification(deviceId: String, message: String, extra: Map[String, String])


  /**
   *
   * @param deviceId
   * @param message
   */
  def sendPushRequest(deviceId: String, message: String)

  /**
   *
   */
  def setupPushConnection()
}
