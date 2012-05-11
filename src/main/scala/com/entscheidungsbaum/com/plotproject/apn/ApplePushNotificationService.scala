package com.plotprojects.com.plotproject.apn

/*
 * Copyright (c) 2012 by Floating Market BV. Alle rechten voorbehouden.
 * author: marcus@plotproject.com
*/

import com.plotprojects.data.PlotPushServiceNotificationDao

class ApplePushNotificationService extends PlotPushServiceNotificationDao {

  def registerIphone() = null

  def sendIphonPushRequet(deviceId: String, messsage: String, extra: Map[String, String]) = null

}
