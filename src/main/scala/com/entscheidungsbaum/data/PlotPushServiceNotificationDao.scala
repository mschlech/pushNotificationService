package com.plotprojects.data

/**
 * @author marcus (at) entscheidungsbaum
 *
 */

import java.util.Map


trait PlotPushServiceNotificationDao {

  def registerIphone()

  def sendIphonePushRequest(deviceId:String ,messsage: String , extra:Map[String , String])
  
}
