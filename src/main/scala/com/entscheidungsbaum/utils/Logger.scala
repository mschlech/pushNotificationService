package com.entscheidungsbaum.utils

import org.slf4j.LoggerFactory

/**
 * com.entscheidungsbaum.utils
 * marcus
 * Author Marcus Schlechter
 * 6/7/12
 */
trait Logger {

    @transient
    @volatile
    protected[entscheidungsbaum] var log = LoggerFactory.getLogger(this.getClass)


}
