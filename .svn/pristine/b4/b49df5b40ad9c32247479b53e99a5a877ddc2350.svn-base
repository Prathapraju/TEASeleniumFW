/* 
* <Copyright notice> 
* < Customer specific copyright notice (if any) > 
*/

package us.tx.state.tea.seleniumfw.logger.common;

/*
 * ContextManager.java
 * Description : This is a Java bean class that contains all the methods for passing the  
 * Context Information according to different application layers.
 * Version : 1.0
 * Author : Ravindra Chilaka
 * Created On : 13 November 2009 
 * Modification History : 
 * 
 * 20 November 2009 
 * - Removed messageNumber, errorType Member Fields 
 * - Changed the method following signatures to accept sessionId parameter
 * - Changed the method following signatures to remove messageNumber, errorType parameters
 * 
 * - setRuleLoggerParameters()
 * - setIntegrationLoggerParameters()
 * - setPersistenceLoggerParameters()
 * - setPresentationLoggerParameters()
 * - setCustomLoggerParameters()
 * - setServiceLoggerParameters()
 * 
 * 
 * 12 January 2010
 * - Added new member fields 
 * - processName
 * - jobName
 * - ruleName
 * - applicationName
 * - webServiceName
 * - transactionName
 * - fieldName
 * - pageName
 * - screenName
 * - componentName
 * 
 * 
 

/*
 * This ContextManager is a Java Class that provides the implementation to 
 * retrieve context information for the T2 Application. 
 */

public class ContextManager {

	/** 
	 *This field holds the userId member field
	*/
	private String userId = "" ;
	
	/** 
	 *This field holds the channelId member field
	*/
	private String channelId = "" ;
	
	/** 
	 *This field holds the processId member field 
	*/
	private String processId = "";
	
	/** 
	 *This field holds the processName member field 
	*/
	private String processName = "";
	
	/** 
	 *This field holds the sessionId member field 
	*/
	private String sessionId = "";
	
	/** 
	 *This field holds the jobId member field  
	*/
	private String jobId = "";
	
	/** 
	 *This field holds the jobName member field  
	*/
	private String jobName = "";
	
	/** 
	 *This field holds the ruleId member field 
	*/
	private String ruleId = "";
	
	/** 
	 *This field holds the ruleName member field 
	*/
	private String ruleName = "";
	
	/** 
	 *This field holds the applicationId member field
	*/
	private String applicationId = "";
	
	/** 
	 *This field holds the applicationName member field
	*/
	private String applicationName = "";
	
	/** 
	 *This field holds the webServiceId member field 
	*/
	private String webServiceId = "";
	
	/** 
	 *This field holds the webServiceName member field 
	*/
	private String webServiceName = "";
	
	/** 
	 *This field holds the transactionId member field
	*/
	private String transactionId = "";
	
	/** 
	 *This field holds the transactionName member field
	*/
	private String transactionName = "";
	
	/** 
	 *This field holds the fieldId member field
	*/
	private String fieldId= "";
	
	/** 
	 *This field holds the fieldId member field
	*/
	private String fieldName= "";
	
	/** 
	 *This field holds the pageId member field
	*/
	private String pageId = "";
	
	/** 
	 *This field holds the pageName member field
	*/
	private String pageName = "";
	
	/** 
	 *This field holds the screenId member field
	*/
	private String screenId= "";
	
	/** 
	 *This field holds the screenId member field
	*/
	private String screenName= "";
	
	
	/** 
	 *This field holds the componentId member field
	*/
	private String componentId = "";
	
	/** 
	 *This field holds the componentName member field
	*/
	private String componentName = "";
	
	/**
	* 
	*This method returns the processName member field
	*/
	public String getProcessName() {
            return processName;
        }

	/**
	* 
	*This method returns the jobName member field
	*/
	public String getJobName() {
            return jobName;
        }

	/**
	* 
	*This method returns the ruleName member field
	*/
	public String getRuleName() {
            return ruleName;
        }

	/**
	* 
	*This method returns the applicationName member field
	*/
	public String getApplicationName() {
            return applicationName;
        }

	/**
	* 
	*This method returns the webServiceName member field
	*/
	public String getWebServiceName() {
            return webServiceName;
        }

	/**
	* 
	*This method returns the transactionName member field
	*/
	public String getTransactionName() {
            return transactionName;
        }

	/**
	* 
	*This method returns the fieldName member field
	*/
	public String getFieldName() {
            return fieldName;
        }

	/**
	* 
	*This method returns the pageName member field
	*/
	public String getPageName() {
            return pageName;
        }

	
	/**
	* 
	*This method returns the screenName member field
	*/

	public String getScreenName() {
            return screenName;
        }
	
	/**
	* 
	*This method returns the componentName member field
	*/

	public String getComponentName() {
            return componentName;
        }

	/**
	* 
	*This method returns the componentId member field
	*/
	public String getComponentId() {
		return componentId;
	}

	/**
	* 
	*This method returns the webServiceId member field
	*/
	public String getWebServiceId() {
		return webServiceId;
	}

	/**
	* 
	*This method returns the transactionId member field
	*/
	public String getTransactionId() {
		return transactionId;
	}

	/**
	* 
	*This method returns the fieldId member field
	*/
	public String getFieldId() {
		return fieldId;
	}

	/**
	* 
	*This method returns the pageId member field
	*/
	public String getPageId() {
		return pageId;
	}

	/**
	* 
	*This method returns the screenId member field
	*/
	public String getScreenId() {
		return screenId;
	}

	/**
	* 
	*This method returns the sessionId member field
	*/
	public String getSessionId() {
		return sessionId;
	}

	/**
	* 
	*This method returns the jobId member field
	*/
	public String getJobId() {
		return jobId;
	}

	/**
	* 
	*This method returns the userId member field
	*/
	public String getUserId() {
		return userId;
	}

	/**
	* 
	*This method returns the channelId member field
	*/
	public String getChannelId() {
		return channelId;
	}

	/**
	* 
	*This method returns the ruleId member field
	*/
	public String getRuleId() {
		return ruleId;
	}


	/**
	* 
	*This method returns the processId member field
	*/
	public String getProcessId() {
		return processId;
	}

	/**
	* 
	*This method returns the applicationId member field
	*/
	public String getApplicationId() {
		return applicationId;
	}

	/**
	 * 
	 *This method sets the context information for rule logger implementation. 
	 *@param userId - String
	 *@param sessionId - String
	 *@param channelId - String
	 *@param ruleId - String
	 *@param ruleName - String
	 */
	public void setRuleLoggerParameters(String userId, String sessionId, String transactionId, String channelId,
			String ruleId,String ruleName) {
		this.userId = userId;
		this.sessionId = sessionId;
		this.transactionId = transactionId;
		this.channelId = channelId;
		this.ruleId = ruleId;
		this.ruleName = ruleName;
	}

	/**
	 * 
	 *This method sets the context information for integration logger implementation. 
	 *@param userId - String
	 *@param sessionId - String
	 *@param channelId - String
	 *@param processId - String
	 *@param processName - String 
	 */
	
	public void setIntegrationLoggerParameters(String userId,
			String sessionId, String transactionId, String channelId, String processId, String processName) {
		this.userId = userId;
		this.sessionId = sessionId;
		this.transactionId = transactionId;
		this.channelId = channelId;
		this.processId = processId;
		this.processName = processName;
	}

	/**
	 * 
	 *This method sets the context information for persistence logger implementation. 
	 *@param userId - String
	 *@param sessionId - String
	 *@param channelId - String
	 *@param applicationId - String
	 *@param applicationName - String
	 *@param transactionId - String
	 *@param transactionName - String
	 *@param fieldId - String
	 *@param fieldName - String
	 */
	public void setPersistenceLoggerParameters(String userId,
			String sessionId, String channelId, String applicationId,String applicationName,String transactionId,String transactionName, String fieldId, String fieldName)	{

		this.userId = userId;
		this.sessionId = sessionId;
		this.channelId = channelId;
		this.applicationId = applicationId;
		this.applicationName = applicationName;
		this.transactionId = transactionId;
		this.transactionName = transactionName;
		this.fieldId = fieldId;
		this.fieldName = fieldName;
	}

	/**
	 * 
	 *This method sets the context information for presentation logger implementation. 
	 *@param userId - String
	 *@param sessionId - String
	 *@param channelId - String
	 *@param applicationId - String
	 *@param applicationName - String
	 *@param screenId - String
	 *@param screenName - String
	 *@param pageId - String
	 *@param pageName - String
	 */
	public void setPresentationLoggerParameters(String userId,
			String sessionId, String transactionId, String channelId, String applicationId,
			String appplicationName,String screenId,String screenName, String pageId,String pageName) {
		this.userId = userId;
		this.sessionId = sessionId;
		this.transactionId = transactionId;
		this.channelId = channelId;
		this.applicationId = applicationId;
		this.applicationName = appplicationName;
		this.screenId = screenId;
		this.screenName = screenName;
		this.pageId = pageId;
		this.pageName = pageName;
	}

	/**
	 * 
	 *This method sets the context information for Custom logger implementation. 
	 *@param userId - String
	 *@param sessionId - String
	 *@param channelId - String
	 *@param applicationId - String
	 *@param applicationName - String
	 *@param componentId - String
	 *@param componentName - String
	 */
	public void setCustomLoggerParameters(String userId, String sessionId, String transactionId, String channelId,
			String applicationId,String applicationName,String componentId,String componentName) {
		
		this.userId = userId;
		this.sessionId = sessionId;
		this.transactionId = transactionId;
		this.channelId = channelId;
		this.applicationId = applicationId;
		this.applicationName = applicationName;
		this.componentId = componentId;
		this.componentName = componentName;
	}
	
	/**
	 * 
	 *This method sets the context information for Service logger implementation. 
	 *@param userId - String
	 *@param sessionId - String
	 *@param channelId - String
	 *@param webServiceId - String
	 *@param webServiceName - String
	 */
	public void setServiceLoggerParameters(String userId, String sessionId, String transactionId, String channelId,
			String webServiceId,String webServiceName) {
		
		this.userId = userId;
		this.sessionId = sessionId;
		this.transactionId = transactionId;
		this.channelId = channelId;
		this.webServiceId = webServiceId;
		this.webServiceName = webServiceName;
	}

}
