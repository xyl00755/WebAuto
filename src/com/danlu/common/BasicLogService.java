package com.danlu.common;

import org.apache.log4j.Logger;

/**
 * 
 * Basic logger
 * 
 * @author: 
 * @version: 
 */
public class BasicLogService {

    protected final Logger        logger          = Logger.getLogger(this.getClass().getName());
    protected static final String CURRENT_DO      = " Current do - ";
    protected static final String CURRENT_THREAD  = " Current Thread - ";
    private boolean               mLoggingDebug   = false;
    private boolean               mLoggingInfo    = true;
    private boolean               mLoggingTrace   = true;
    private boolean               mLoggingWarning = true;
    private boolean               mLoggingError   = true;



    /**
     * 
     * show the detail debug info.
     * 
     * @param pLogMessage
     */
    public void vlogDebug(final String pLogMessage) {
        if (isLoggingDebug()) {
            this.logger.debug(CURRENT_THREAD + Thread.currentThread().getId() + " " + pLogMessage);
        }
    }



    /**
     * 
     * show the detail log info.
     * 
     * @param pLogMessage
     */
    public void vlogInfo(final String pLogMessage) {
        if (isLoggingInfo()) {
            this.logger.info(CURRENT_THREAD + Thread.currentThread().getId() + " " + pLogMessage);
        }
    }



    /**
     * 
     * show the detail warning info.
     * 
     * @param pLogMessage
     */
    public void vlogWarning(final String pLogMessage) {
        if (isLoggingWarning()) {
            this.logger.warn(CURRENT_THREAD + Thread.currentThread().getId() + " " + pLogMessage);
        }
    }



    /**
     * 
     * show the error info.
     * 
     * @param pLogMessage
     */
    public void vlogError(final String pLogMessage) {
        if (isLoggingError()) {
            this.logger.error(CURRENT_THREAD + Thread.currentThread().getId() + " " + pLogMessage);
        }
    }



    /**
     * 
     * show the detail error info.
     * 
     * @param pMessage
     * @param pE
     */
    public void vlogError(final String pMessage, final Exception pE) {
        if (isLoggingError()) {
            this.logger.error(CURRENT_THREAD + Thread.currentThread().getId() + " " + pMessage, pE);
        }
    }



    /**
     * @return the loggingDebug
     */
    public boolean isLoggingDebug() {
        return mLoggingDebug;
    }



    /**
     * @param pLoggingDebug
     *            the loggingDebug to set
     */
    public void setLoggingDebug(final boolean pLoggingDebug) {
        mLoggingDebug = pLoggingDebug;
    }



    /**
     * @return the loggingInfo
     */
    public boolean isLoggingInfo() {
        return mLoggingInfo;
    }



    /**
     * @param pLoggingInfo
     *            the loggingInfo to set
     */
    public void setLoggingInfo(final boolean pLoggingInfo) {
        mLoggingInfo = pLoggingInfo;
    }



    /**
     * @return the loggingTrace
     */
    public boolean isLoggingTrace() {
        return mLoggingTrace;
    }



    /**
     * @param pLoggingTrace
     *            the loggingTrace to set
     */
    public void setLoggingTrace(final boolean pLoggingTrace) {
        mLoggingTrace = pLoggingTrace;
    }



    /**
     * @return the loggingWarning
     */
    public boolean isLoggingWarning() {
        return mLoggingWarning;
    }



    /**
     * @param pLoggingWarning
     *            the loggingWarning to set
     */
    public void setLoggingWarning(final boolean pLoggingWarning) {
        mLoggingWarning = pLoggingWarning;
    }



    /**
     * @return the loggingError
     */
    public boolean isLoggingError() {
        return mLoggingError;
    }



    /**
     * @param pLoggingError
     *            the loggingError to set
     */
    public void setLoggingError(final boolean pLoggingError) {
        mLoggingError = pLoggingError;
    }

}
