package com.entscheidungsbaum

/**
 * com.entscheidungsbaum
 * marcus
 * Author Marcus Schlechter
 * 6/14/12
 */

import data.{AndroidPushNotificationDao, ApplePushNotificationDao}
import java.util.Properties
import utils.ConfigReader

class Module {

    val p : Properties = ConfigReader.readProperties()

    lazy val apnHost = p.getProperty("apn.host")
    lazy val apnPort = p.getProperty("apn.port").toInt

    lazy val apnFeedbackHost=p.getProperty("feedback.push.apple.com")
    lazy val apnFeedbackPort=p.getProperty("2196").toInt

    lazy val apnCert = p.getProperty("apn.clientcert")
    lazy val apnCertPassphrase = p.getProperty("apn.clientcert")

    lazy val apnKeystoreType=p.getProperty("apn.keystore.type")
    lazy val apnKeyAlgrorithm=p.getProperty("apn.key.algorithm")

    lazy val androidHost = p.getProperty("android.host")
    lazy val androidPort = p.getProperty("android.port").toInt

    lazy val applePushNotificationDao = new ApplePushNotificationDao(apnHost,apnPort,apnCert, apnCertPassphrase,apnKeystoreType,apnKeyAlgrorithm)
    lazy val androidPushNotificationDao = new AndroidPushNotificationDao(androidHost, androidPort)
    lazy val pushReceiver = new PushReceiver(applePushNotificationDao)

}
