package com.entscheidungsbaum.data

/**
 * com.entscheidungsbaum.data
 * marcus
 * Author Marcus Schlechter
 * 6/7/12
 */

import cc.spray.json.{JsObject, JsString}

import org.apache.http.entity.StringEntity
import org.apache.http.impl.client.DefaultHttpClient
import org.apache.http.auth.UsernamePasswordCredentials
import org.apache.http.impl.auth.BasicScheme

import org.apache.http.client.methods.HttpPut
import io.Source

import java.net.Socket
import javax.net.ssl.SSLContext
import com.notnoop.apns.APNS
import com.notnoop.apns.ApnsService
import com.entscheidungsbaum.utils.{CertificationUtilities, Logger}

class ApplePushNotificationDao(val apnHost: String, val apnPort: Int, val apnCert: String, apnCertPassphrase: String,
                               val apnKeystoreType: String, val apnKeyAlgrorithm: String)
  extends PushServiceNotificationDao with Logger {


  /**
   * connection strategy provide a pending socket connection while this actor is running
   */

  val socket = setupPushConnection()
  //  val pushQueue = createPushQueue()
  val apnService = createApnService()


  /**
   *
   * @param deviceId    user device id
   * @param message the message to send
   * @return
   */
  def sendPushRequest(deviceId: String, message: String) = {

    if(apnService==null) createApnService()
    val payloadString:String = APNS.newPayload().badge(1).alertBody(message).build()
    apnService.push(deviceId,payloadString)

  }


  /**
   * for later purposes
   * @return a secure socket
   */
  def setupPushConnection = {

    try   {
      var sslSocket = new Socket()
      val inputCert = CertificationUtilities.certFile(apnCert)
      val sslSocketContext = CertificationUtilities.getSSLContext(inputCert, apnCertPassphrase, apnKeystoreType, apnKeyAlgrorithm)

      val context = SSLContext.getInstance("TLS")
      val sslSocketFactory = sslSocketContext.getSocketFactory()
      sslSocket = sslSocketFactory.createSocket(apnHost, apnPort)
      //sslSocket.connect(new InetSocketAddress(apnHost, apnPort))
      if (sslSocket.isBound())
        log.debug("Connection to apple bound")

      // create the stream
      sslSocket
      }
    catch {
      case e: Exception => log.error(" could not set the socket because :" + e.printStackTrace())
    }

  }

  //def createPushQueue(keyStore: Object, environment: String, thread: Integer) = null

  //{
  // val pushQueue: PushQueue = new Push.queue(keyStore, environement, thread)

  //}

  /**
   *
   * method to obtain a service which is invoked be the boot sequence of the actor
   * @return a apnService object to set up the connection initially
   */
  def createApnService(): ApnsService = {

    //.debug("file " + apnCert)
    val apnService: ApnsService = APNS.newService().withCert(apnCert,apnCertPassphrase).withProductionDestination().build()

    apnService
  }


  /**
   * Apple specifig register request upfront
   * @param deviceId
   * @param alias
   * @return
   */
  def registerIphone(deviceId: String, alias: String): Unit.type = {


    val httpClient = new DefaultHttpClient
    val creds = new UsernamePasswordCredentials("cred", "secret")
    val request = new HttpPut("apn.url" + "/api/device_tokens/" + deviceId.toUpperCase)
    request.addHeader(new BasicScheme().authenticate(creds, request))
    request.addHeader("Content-Type", "application/json")
    val msg = JsObject("alias" -> JsString(alias)).toString()
    // log.(this, "Registering device with following message: " + msg)
    request.setEntity(new StringEntity(msg))
    val response = httpClient.execute(request)
    response.getStatusLine.getStatusCode match {
      case 200 => Unit
      case 201 => Unit
      case _ => throw new Exception("Error updating device token: "
        + Source.fromInputStream(response.getEntity.getContent).getLines().foldLeft("")(_ + _))
    }

  }



  def main(args: Array[String]) {
    println("Hello, world!")
  }
}
