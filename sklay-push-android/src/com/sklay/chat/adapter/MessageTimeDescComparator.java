package com.sklay.chat.adapter;

import java.util.Comparator;

import com.sklay.core.chat.nio.mutual.Message;

public class MessageTimeDescComparator implements Comparator<Message> {

	@Override
	public int compare(Message arg0, Message arg1) {

		return (int) (arg1.getTimestamp() - arg0.getTimestamp());
	}

}
