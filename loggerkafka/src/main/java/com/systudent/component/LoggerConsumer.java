package com.systudent.component;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class LoggerConsumer {
	//Logger logger1 = LoggerFactory.getLogger(RollingLog.class);
	//Logger logger2 = LoggerFactory.getLogger(SystudenDb.class);
	private static Log logSystudentGateway= LogFactory.getLog("logSystudentGateway");  
	private static Log logSystudentdb= LogFactory.getLog("logSystudentdb"); 
     
     //@KafkaListener(topics = "TOPIC-DEMO" , groupId = "group_id")
    @KafkaListener(topics = "message-gateway" , groupId = "group_id")
    public void consumeGateway(String message) {
        //logger.info("Consuming Message (kafka consumer) {}", message);
        //log.info("debugLogger, Consuming Message (kafka consumer) {}"+message);
        //areportsLog.info("reportsLog, Consuming Message (kafka consumer) {}"+message);
        
        //log.debug("RollingFile, debug log message");  
        
        //reportsLog.info("systudentdb,reports info message");  
    	logSystudentGateway.info(message);
    	//reportsLog.info("Consuming1 Message logSystudentdb"+ message);
    }
    
    @KafkaListener(topics = "message-db" , groupId = "group_id")
    public void consumeDb(String message) {
        //logger.info("Consuming Message (kafka consumer) {}", message);
        //log.info("debugLogger, Consuming Message (kafka consumer) {}"+message);
        //areportsLog.info("reportsLog, Consuming Message (kafka consumer) {}"+message);
        
        //log.debug("RollingFile, debug log message");  
        
        //reportsLog.info("systudentdb,reports info message");  
    	logSystudentdb.info(message);
    }
}

