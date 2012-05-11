package com.plotprojects.data

/*
 * Copyright (c) 2012 by Floating Market BV. Alle rechten voorbehouden.
 * author: marcus@plotproject.com
*/

trait PlotPushServiceNotificationDao {

  def registerIphone()

  def sendIphonePushRequest(deviceId:String ,messsage: String , extra:Map[String , String])
  
}
