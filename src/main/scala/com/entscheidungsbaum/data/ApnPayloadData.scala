package com.entscheidungsbaum.data

/**
 * com.entscheidungsbaum.data
 * marcus
 * Author Marcus Schlechter
 * 6/7/12
 */

import java.util.Map

  class ApnPayloadData(root: Map[String, Object], aps: Map[String, Object], customAlert: Map[String, Object]) {

    def alertBody(alert: String) = {
      customAlert.put("body", alert)
    }

    def badge(badge: java.lang.Integer) = {
      aps.put("badge", badge)
    }


  }




