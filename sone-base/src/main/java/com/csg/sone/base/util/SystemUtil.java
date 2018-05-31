package com.csg.sone.base.util;

import org.apache.commons.lang3.SystemUtils;

import java.io.File;

/**
 * <p> Description:  SystemUtil </p>
 * <pre> </pre>
 *
 * Copyright: © 2012-2017 . All rights reserved.
 * Company:
 *
 * @author William
 * @version 1.0
 */
public class SystemUtil {

    /**
     * <p> The {@code user.home} System Property. User's home directory. </p>
     */
    public static final String USER_HOME = SystemUtils.USER_HOME;
    /**
     * <p> The {@code java.io.tmpdir} System Property. Default temp file path.</p>
     */
    public static final String JAVA_IO_TMPDIR = SystemUtils.JAVA_IO_TMPDIR;


    /**
     * <p>
     * Gets File Encoding.
     * </p>
     *
     * @return
     */
    public static String getFileEncoding() {
        return SystemUtils.FILE_ENCODING;
    }

    /**
     * <p>
     * Gets the host name from an environment variable.
     * </p>
     *
     * @return the host name.
     */
    public static String getHostName() {
        return SystemUtils.getHostName();
    }

    /**
     * <p>
     * Gets the user home directory as a {@code File}.
     * </p>
     *
     * @return
     */
    public static File getUserHome() {
        return SystemUtils.getUserHome();
    }

    /**
     * <p>
     * Gets the Java IO temporary directory as a {@code File}.
     * </p>
     *
     * @return
     */
    public static File getTmpDir() {
        return SystemUtils.getJavaIoTmpDir();
    }
}
