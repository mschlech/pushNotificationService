package com.plotprojects.com.plotproject.apn

/**
 * @author marcus (at) entscheidungsbaum
 *
 */

import com.plotprojects.data.PlotPushServiceNotificationDao

class ApplePushNotificationService extends PlotPushServiceNotificationDao {

  def registerIphone() = null

  def sendIphonPushRequet(deviceId: String, messsage: String, extra: Map[String, String]) = null

}
