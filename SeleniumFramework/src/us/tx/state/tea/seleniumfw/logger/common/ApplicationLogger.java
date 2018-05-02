/* 
 * < Copyright notice > *
 * < Customer specific copyright notice (if any) > 
 */

package us.tx.state.tea.seleniumfw.logger.common;

/*
 * ApplicationLogger.java
 * Description : This Java class contains various methods to implement logging framework.
 * Version : 1.0
 *  */

import org.apache.log4j.MDC;
import org.apache.log4j.xml.DOMConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
 * This Application Logger Java Class contains the methods for various levels of logging.
 * . 
 */

public class ApplicationLogger implements ILogger {

	/*
	 * Logger instance Member Field
	 */
	private Logger loggerInstance;

	private static String logConfigFileName = "";

	/*
	 * Context Manager Member Field
	 */
	private ContextManager contextManager;

	/*
	 * Read the configuration file if it exists. Moreover, a thread will be
	 * created that will periodically check if the configuration file has been
	 * created or modified. The period is determined by the delay argument. If a
	 * change or file creation is detected, then configFilename is read to
	 * configure log4j.
	 */
	private static void initializeConfigurationAndWatch(long refreshIntervalInMillis) {
		DOMConfigurator.configureAndWatch(logConfigFileName, refreshIntervalInMillis);
	}
	
	/*
	 * Constructor
	 */
	public ApplicationLogger(Class<?> classz, String logConfigFileName) {

		this.logConfigFileName = logConfigFileName;
		this.loggerInstance = LoggerFactory.getLogger(classz);
		initializeConfigurationAndWatch();
	}

	/*
	 * Constructor
	 */
	public ApplicationLogger(String rootPackageName) {
		this.loggerInstance = LoggerFactory.getLogger(rootPackageName);
	}

	/**
	 * Constructor for ApplicationLogger(Class classz)
	 * 
	 * @param classz
	 *            - Class
	 * 
	 */

	public ApplicationLogger(Class<?> classz) {

		initializeConfiguration();
		this.loggerInstance = LoggerFactory.getLogger(classz);
	}

	/**
	 * 
	 * Constructor for ApplicationLogger(Class classz, ContextManager
	 * contextManager)
	 * 
	 * @param classz
	 *            - Class
	 * @param cManager
	 *            - ContextManager
	 * 
	 */

	public ApplicationLogger(Class<?> classz, ContextManager cManager) {

		initializeConfiguration();

		this.loggerInstance = LoggerFactory.getLogger(classz);
		this.contextManager = cManager;
		if (this.contextManager != null) {
			extractContextInformation(this.contextManager);
		}
	}
	
	public void initializeConfiguration(){
		DOMConfigurator.configure(logConfigFileName);
	}
	/**
	 * Read the tsds-config properties file and set the environment variables.
	 */
	public void initializeConfigurationAndWatch() {

		String environment = null;
		// Default 30 minutes
		long refreshIntervalInMillis = 1800000;

		/*
		 * If the environment variable is DEV,TEST then watch for the changes in
		 * log4j.xml file every 60 seconds, other wise use default configuration
		 */
//		if (environment.equalsIgnoreCase("DEV") || environment.equalsIgnoreCase("TEST")) {
//		initializeConfigurationAndWatch(refreshIntervalInMillis);
//    }
	}

	/**
	 * 
	 * This method sets the context information to Application Logger Class and
	 * extracts the Context Information from cManager parameter and sets to
	 * Mapped Diagnostic Context(MDC).
	 * 
	 * @param cManager
	 *            - ContextManager
	 */

	public void setContextManager(ContextManager cManager) {
		this.contextManager = cManager;
		if (this.contextManager != null) {
			extractContextInformation(this.contextManager);
		}

	}

	/**
	 * 
	 * This method logs the message with DEBUG Level granularity
	 * 
	 * @param message
	 *            - string
	 * @param messageNumber
	 *            - string
	 * @param errorType
	 *            - string
	 */

	public void debug(String message, String messageNumber, String errorType) {
		loggerInstance.debug("{}  {}  {}", new Object[]{messageNumber, errorType, message});
	}
	
	public void debug (String message, Object[] arguments){
		loggerInstance.debug(message, arguments);
	}
	
	public void debug(String message){
		loggerInstance.debug(message);
	}
	public void debug(String message, Throwable throwable){
		loggerInstance.debug(message, throwable);
	}
	public void debug(String message, Object object1, Object object2){
		loggerInstance.debug(message, object1, object2);
	}
	public void debug(String message, Object object1){
		loggerInstance.debug(message, object1);
	}

	
	/**
	 * 
	 * This method logs the message with ERROR Level granularity
	 * 
	 * @param message
	 *            - string
	 * @param messageNumber
	 *            - string
	 * @param errorType
	 *            - string
	 */

	public void error(String message, String messageNumber, String errorType) {
		//loggerInstance.error(messageNumber + " " + errorType + " " + message);
		loggerInstance.error("{}  {}  {}", new Object[]{messageNumber, errorType, message});
	}
	public void error (String message, Object[] arguments){
		loggerInstance.error(message, arguments);
	}
	
	public void error(String message){
		loggerInstance.error(message);
	}
	public void error(String message, Throwable throwable){
		loggerInstance.error(message, throwable);
	}
	public void error(String message, Object object1, Object object2){
		loggerInstance.error(message, object1, object2);
	}
	public void error(String message, Object object1){
		loggerInstance.error(message, object1);
	}


/*	*//**
	 * 
	 * This method logs the message with FATAL Level granularity
	 * 
	 * @param message
	 *            - string
	 * @param messageNumber
	 *            - string
	 * @param errorType
	 *            - string
	 *//*

	public void fatal(String message, String messageNumber, String errorType) {
		loggerInstance.error(messageNumber + " " + errorType + " " + message);
	}*/

	/**
	 * 
	 * This method logs the message with INFO Level granularity
	 * 
	 * @param message
	 *            - string
	 * @param messageNumber
	 *            - string
	 * @param errorType
	 *            - string
	 */

	public void info(String message, String messageNumber, String errorType) {
		//loggerInstance.info(messageNumber + " " + errorType + " " + message);
		loggerInstance.info("{}  {}  {}", new Object[]{messageNumber, errorType, message});
	}
	
	public void info (String message, Object[] arguments){
		loggerInstance.info(message, arguments);
	}
	
	public void info(String message){
		loggerInstance.info(message);
	}
	public void info(String message, Throwable throwable){
		loggerInstance.info(message, throwable);
	}
	public void info(String message, Object object1, Object object2){
		loggerInstance.info(message, object1, object2);
	}
	public void info(String message, Object object1){
		loggerInstance.info(message, object1);
	}
	
	

	/**
	 * 
	 * This method logs the message with TRACE Level granularity
	 * 
	 * @param message
	 *            - string
	 * @param messageNumber
	 *            - string
	 * @param errorType
	 *            - string
	 */

	public void trace(String message, String messageNumber, String errorType) {
		//loggerInstance.trace(messageNumber + " " + errorType + " " + message);
		loggerInstance.trace("{}  {}  {}", new Object[]{messageNumber, errorType, message});
	}
	
	public void trace (String message, Object[] arguments){
		loggerInstance.trace(message, arguments);
	}
	
	public void trace(String message){
		loggerInstance.trace(message);
	}
	public void trace(String message, Throwable throwable){
		loggerInstance.trace(message, throwable);
	}
	public void trace(String message, Object object1, Object object2){
		loggerInstance.trace(message, object1, object2);
	}
	public void trace(String message, Object object1){
		loggerInstance.trace(message, object1);
	}

	/**
	 * 
	 * This method logs the message with WARN Level granularity
	 * 
	 * @param message
	 *            - string
	 * @param messageNumber
	 *            - string
	 * @param errorType
	 *            - string
	 */

	public void warn(String message, String messageNumber, String errorType) {
		//loggerInstance.warn(messageNumber + " " + errorType + " " + message);
		loggerInstance.warn("{}  {}  {}", new Object[]{messageNumber, errorType, message});
		
	}
	
	public void warn (String message, Object[] arguments){
		loggerInstance.warn(message, arguments);
	}
	
	public void warn(String message){
		loggerInstance.warn(message);
	}
	public void warn(String message, Throwable throwable){
		loggerInstance.warn(message, throwable);
	}
	public void warn(String message, Object object1, Object object2){
		loggerInstance.warn(message, object1, object2);
	}
	public void warn(String message, Object object1){
		loggerInstance.warn(message, object1);
	}

	/**
	 * This method extract the Context Information from Context Manager Java
	 * Bean and passes it to Log4j.MDC (Mapped Diagnostic Context) Object
	 * 
	 * @param contextManager
	 *            - ContextManager Class
	 */

	private void extractContextInformation(ContextManager contextManager) {

		if (contextManager != null) {

			// Retrieve UserId (Discard null values and empty spaces)
			retrieveUserId(contextManager);

			// Retrieve SessionId (Discard null values and empty spaces)
			retrieveSessionId(contextManager);

			// Retrieve ApplicationId (Discard null values and empty spaces)
			retrieveApplicationId(contextManager);

			// Retrieve ApplicationName (Discard null values and empty spaces)
			retrieveApplicationName(contextManager);

			// Retrieve Transaction Id (Discard null values and empty spaces)
			retrieveTransactionId(contextManager);
			// Retrieve Transaction Name (Discard null values and empty spaces)
			retrieveTransactionName(contextManager);
		}// IF Loop ends here

	}// Method end heres

	/**
	 * @param contextManager
	 */
	private void retrieveTransactionName(ContextManager contextManager) {
		if (contextManager.getTransactionName() != null
				&& !contextManager.getTransactionName().equalsIgnoreCase(null)
				&& !contextManager.getTransactionName().equalsIgnoreCase("")) {
			MDC.put(LoggerConstants.TRANSACTION_NAME, contextManager.getTransactionName());
		}
	}

	/**
	 * @param contextManager
	 */
	private void retrieveTransactionId(ContextManager contextManager) {
		if (contextManager.getTransactionId() != null && !contextManager.getTransactionId().equalsIgnoreCase(null)
				&& !contextManager.getTransactionId().equalsIgnoreCase("")) {
			MDC.put(LoggerConstants.TRANSACTION_ID, contextManager.getTransactionId());
		}
	}

	/**
	 * @param contextManager
	 */
	private void retrieveApplicationName(ContextManager contextManager) {
		if (contextManager.getApplicationName() != null
				&& !contextManager.getApplicationName().equalsIgnoreCase(null)
				&& !contextManager.getApplicationName().equalsIgnoreCase("")) {
			MDC.put(LoggerConstants.APPLICATION_NAME, contextManager.getApplicationName());
		}
	}

	/**
	 * @param contextManager
	 */
	private void retrieveApplicationId(ContextManager contextManager) {
		if (contextManager.getApplicationId() != null && !contextManager.getApplicationId().equalsIgnoreCase(null)
				&& !contextManager.getApplicationId().equalsIgnoreCase("")) {
			MDC.put(LoggerConstants.APPLICATION_ID, contextManager.getApplicationId());
		}
	}

	/**
	 * @param contextManager
	 */
	private void retrieveSessionId(ContextManager contextManager) {
		if (contextManager.getSessionId() != null && !contextManager.getSessionId().equalsIgnoreCase(null)
				&& !contextManager.getSessionId().equalsIgnoreCase("")) {
			MDC.put(LoggerConstants.SESSION_ID, contextManager.getSessionId());
		}
	}

	/**
	 * @param contextManager
	 */
	private void retrieveUserId(ContextManager contextManager) {
		if (contextManager.getUserId() != null && !contextManager.getUserId().equalsIgnoreCase(null)
				&& !contextManager.getUserId().equalsIgnoreCase("")) {
			MDC.put(LoggerConstants.USER_ID, contextManager.getUserId());
		}
	}
	
	public void setLoggerInstance(Class<?> classz){
		this.loggerInstance = LoggerFactory.getLogger(classz);
	}

	/**
	 * 
	 * @return
	 */
	public Logger getLoggerInstance() {
		return loggerInstance;
	}

	/**
	 * Builds the message string from the given parts
	 * 
	 * @param message
	 * @param messageNumber
	 * @param errorType
	 * @return
	 */
	public String message(String message, String messageNumber, String errorType) {

		StringBuffer buf = new StringBuffer();
		buf.append(message);
		buf.append(LoggerConstants.LOG_MESSAGE_DELIMITER);
		buf.append(messageNumber);
		buf.append(LoggerConstants.LOG_MESSAGE_DELIMITER);
		buf.append(errorType);

		return buf.toString();
	}

} // Application Logger Class ends here
