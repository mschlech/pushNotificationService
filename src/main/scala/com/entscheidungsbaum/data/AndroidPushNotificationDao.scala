package com.entscheidungsbaum.data

import com.entscheidungsbaum.utils.ConfigReader
import java.util.Properties

/**
 * com.entscheidungsbaum.data
 * marcus
 * Author Marcus Schlechter
 * 6/7/12
 */
class AndroidPushNotificationDao (val androidHost:String , val androidPort:Int) extends PushServiceNotificationDao {


  /**
   * properties for the android push url which might not be hardcoded in the code
   */
  val p: Properties = ConfigReader.readProperties()

  //  /**
  //   *
  //   * @param deviceId
  //   * @param messsage
  //   * @param extra
  //   */
  //  def sendAndroidPushRequet(deviceId: String, messsage: String, extra: Map[String, String]) = null


  /**
   *
   * @param deviceId
   * @param message
   */
  def sendPushRequest( deviceId: String, message: String) = null

  def setupPushConnection(){}

}
