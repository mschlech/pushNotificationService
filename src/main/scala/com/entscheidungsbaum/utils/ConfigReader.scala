package com.entscheidungsbaum.utils

import java.util.Properties
import java.io.{FileInputStream, FileNotFoundException, File}

/**
 * com.entscheidungsbaum.utils
 * marcus
 * Author Marcus Schlechter
 * 6/7/12
 */
object ConfigReader {

    def readProperties(): Properties = {
      val p: Properties = new Properties
      try {
        val defaultConfigFile = new File("service.production.properties")
        //log.info("Loading configuration from file: " + defaultConfigFile.getName)

        val stream = if (defaultConfigFile.exists()) {
          // log.info("Loading configuration from file: " + defaultConfigFile.getName)
          new FileInputStream(defaultConfigFile)
        } else {
          this.getClass.getClassLoader.getResourceAsStream("service.production.properties")
        }
        p.load(stream)
      }
      catch {
        case fsne: FileNotFoundException => println("File not found catched")
      }
      p
    }

}
