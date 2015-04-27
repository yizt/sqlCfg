package com.sitech.sqlcfg.util;

public class LongAdapter {
	public LongAdapter(long value) {
		this.value = value;
	}

	private long value;

	public long getValue() {
		return value;
	}

	public void setValue(long value) {
		this.value = value;
	}

	public void increase() {
		this.value = value + 1;
	}

}
