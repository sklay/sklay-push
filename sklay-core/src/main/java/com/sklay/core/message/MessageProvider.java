/*
 * Project:  any-parent
 * Module:   any-framework
 * File:     MessageSource.java
 * Modifier: ozn
 * Modified: 2012-08-12 22:21
 *
 * Copyright (c) 2012 Sanyuan Ltd. All Rights Reserved.
 *
 * Copying of this document or code and giving it to others and the
 * use or communication of the contents thereof, are forbidden without
 * expressed authority. Offenders are liable to the payment of damages.
 * All rights reserved in the event of the grant of a invention patent or the
 * registration of a utility model, design or code.
 */
package com.sklay.core.message;

import java.util.Locale;

/**
 * .
 * <p/>
 *
 * @author <a href="mailto:oxsean@gmail.com">sean yang</a>
 * @version V1.0, 12-8-12
 */
public interface MessageProvider {

    String getMessage(String key);

    String getMessage(String key, Object[] args);

    String getMessage(String key, Object[] args, String defaultMessage);

    String getMessage(String key, Object[] args, String defaultMessage, Locale locale);
}
