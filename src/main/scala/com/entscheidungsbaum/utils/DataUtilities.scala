package com.entscheidungsbaum.utils

import java.io._
import java.util.{Date, HashMap}


/**
 * com.entscheidungsbaum.utils
 * marcus
 * Author Marcus Schlechter
 * 6/7/12
 */
object DataUtilities {


    def marshall(command: Byte, deviceToken: Array[Byte], payload: Array[Byte]): Array[Byte] = {
      val boas = new ByteArrayOutputStream()
      val dos = new DataOutputStream(boas)

      try {
        dos.writeByte(command)
        dos.writeShort(deviceToken.length)
        dos.write(deviceToken)
        dos.writeShort(payload.length)
        dos.write(payload)
        boas.toByteArray()

      } catch {
        case ioe: IOException => println("IOException"); null
        case _ => println("some Error occured"); null
      }
    }

    def marshallEnhanced(command: Byte, identifier: Integer,
                         expiryTime: Integer, deviceToken: Array[Byte], payload: Array[Byte]) = {
      val boas = new ByteArrayOutputStream();
      val dos = new DataOutputStream(boas);

      try {
        dos.writeByte(command);
        dos.writeInt(identifier);
        dos.writeInt(expiryTime);
        dos.writeShort(deviceToken.length);
        dos.write(deviceToken);
        dos.writeShort(payload.length);
        dos.write(payload);
        boas.toByteArray();
      } catch {
        case e: IOException => println("IOException occured " + e)
        case _ => println(""); null
      }
    }

    def   parseFeedbackStreamRaw( in:InputStream) : HashMap[Array[Byte], Integer] = {
      val result = new HashMap[Array[Byte], Integer]();

      val data = new DataInputStream(in);

      while (true) {
        try {
          val time = data.readInt();
          val dtLength = data.readUnsignedShort();
          val deviceToken:Array[Byte]= Array(0123)
          //   val deviceToken:Array[Byte] = new Array[Byte]
          data.readFully(deviceToken);

          result.put(deviceToken, time);
        } catch {
          case eof : EOFException => println("End of File Excpetion occured"); null
          case _ => println("some other Exception occured"); null
        }
      }

      result
    }

    def    parseFeedbackStream( in:InputStream) : HashMap[String, Date] ={
      val result = new HashMap[String, Date]();

      val  raw : HashMap[Array[Byte], Integer] = parseFeedbackStreamRaw(in)
      //          for (Map.Entry[Array[Byte], Integer]  <- raw.elements()) {
      //              byte[] dtArray = entry.getKey()
      //              int time = entry.getValue(); // in seconds
      //
      //              Date date = new Date(time * 1000L)    // in ms
      //              String dtString = encodeHex(dtArray)
      //              result.put(dtString, date)
      //          }
      //
      result
    }

}
