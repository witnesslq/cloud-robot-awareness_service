package com.efrobot.robotstore.awareness.util;

/**
 * 分页通用实体
 * @author Administrator
 *
 */
public class Base implements java.io.Serializable {

	public static final long serialVersionUID = 1L;
	protected Integer firstRow;
	protected Integer rowSize;

	public Integer getFirstRow() {
		return firstRow;
	}

	public void setFirstRow(Integer firstRow) {
		this.firstRow = firstRow;
	}

	public Integer getRowSize() {
		return rowSize;
	}

	public void setRowSize(Integer rowSize) {
		this.rowSize = rowSize;
	}

}
