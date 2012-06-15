package com.entscheidungsbaum.utils

import java.security.KeyStore
import javax.net.ssl.{TrustManagerFactory, KeyManagerFactory, SSLContext}
import java.io.{FileNotFoundException, FileInputStream, InputStream}

/**
 * com.entscheidungsbaum.utils
 * marcus
 * Author Marcus Schlechter
 * 6/14/12
 */
object CertificationUtilities {


  def getSSLContext(cert: InputStream, password: String,
                    ksType: String, ksAlgorithm: String) :SSLContext= {
    try {
      val ks = KeyStore.getInstance(ksType);
      ks.load(cert, password.toCharArray());

      // Get a KeyManager and initialize it
      val kmf = KeyManagerFactory.getInstance(ksAlgorithm);
      kmf.init(ks, password.toCharArray());

      // Get a TrustManagerFactory and init with KeyStore
      val tmf = TrustManagerFactory.getInstance(ksAlgorithm);
      tmf.init(ks);

      // Get the SSLContext to help create SSLSocketFactory
      val sslc = SSLContext.getInstance("TLS");
      sslc.init(kmf.getKeyManagers(), null, null);
      sslc
    } catch {
      case e: Exception => print(e.printStackTrace());null
      case _ => println("exception of unknown");null
    }

  }


  def certFile(apnCerts:String): InputStream = {
    try {
      val inputCertFile = new FileInputStream(apnCerts)
      inputCertFile
    } catch {

      case e: FileNotFoundException =>
        println(e.printStackTrace())
        null
    }

  }
}
