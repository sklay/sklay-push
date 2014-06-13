/*
 * Project:  any-parent
 * Module:   any-framework
 * File:     SpringMessageProvider.java
 * Modifier: ozn
 * Modified: 2012-08-13 19:06
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

import org.springframework.context.MessageSource;

import java.util.Locale;

/**
 * .
 * <p/>
 *
 * @author <a href="mailto:oxsean@gmail.com">sean yang</a>
 * @version V1.0, 12-8-12
 */
public class SpringMessageProvider implements MessageProvider {

    private MessageSource messageSource;

    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @Override
    public String getMessage(String key) {
        return getMessage(key, null, null, null);
    }

    @Override
    public String getMessage(String key, Object[] args) {
        return getMessage(key, args, null, null);
    }

    @Override
    public String getMessage(String key, Object[] args, String defaultMessage) {
        return getMessage(key, args, defaultMessage, null);
    }

    @Override
    public String getMessage(String key, Object[] args, String defaultMessage, Locale locale) {
        return messageSource.getMessage(key, args, defaultMessage, locale);
    }
}
