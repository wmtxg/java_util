package com.cetc.cloudadapter.ecs.service.openstack.enums;

/**
 * 弹性伸缩组创建状态
 * @ClassName: OpenstackStackStatus
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author	吴明涛
 * @Phone   17346519691
 * @Email   wmtxg@126.com
 * @Date 2020年10月21日 下午3:08:47 
 *
 */
public enum OpenstackStackStatus {

	CREATE_IN_PROGRESS("CREATE_IN_PROGRESS", "creating", "创建中"),
	CREATE_COMPLETE("CREATE_COMPLETE", "complete", "创建成功"),
	CREATE_FAILED("CREATE_FAILED", "failed", "创建失败"),
	DELETING("DELETE_IN_PROGRESS", "deleting", "删除中"),
	DELETE_COMPLETE("DELETE_COMPLETE", "delete_complete", "删除成功"),
	UNKNOWN("UNKNOWN", "unknown", "未知");

	private String key;
	private String eName;
	private String cName;

	OpenstackStackStatus(String key, String eName, String cName) {
		this.key = key;
		this.eName = eName;
		this.cName = cName;
	}

	/**
	 * 
	 * @Method getByKey
	 * @param key
	 * @return
	 * @Author	吴明涛
	 * @Phone   17346519691
	 * @Email   wmtxg@126.com
	 * @Date 2020年10月20日 下午1:34:19 
	 * Copyright (c) All Rights Reserved, 2020.
	 */
	public static OpenstackStackStatus getByKey(String key) {
		for (OpenstackStackStatus pType : OpenstackStackStatus.values()) {
			if (pType.getKey().equalsIgnoreCase(key)) {
				return pType;
			}
		}
		return null;
	}
	
	/**
	 * 
	 * @Method getByEname
	 * @param ename
	 * @return
	 * @Author	吴明涛
	 * @Phone   17346519691
	 * @Email   wmtxg@126.com
	 * @Date 2020年10月20日 下午1:34:15 
	 * Copyright (c) All Rights Reserved, 2020.
	 */
	public static OpenstackStackStatus getByEname(String ename) {
		for (OpenstackStackStatus pType : OpenstackStackStatus.values()) {
			if (pType.geteName().equalsIgnoreCase(ename)) {
				return pType;
			}
		}
		return null;
	}

	/**
	 * 
	 * @Method contains
	 * @param key
	 * @return
	 * @Author	吴明涛
	 * @Phone   17346519691
	 * @Email   wmtxg@126.com
	 * @Date 2020年10月20日 下午1:34:10 
	 * Copyright (c) All Rights Reserved, 2020.
	 */
	public static boolean contains(String key) {
		for (OpenstackStackStatus c : OpenstackStackStatus.values()) {
			if (c.getKey().equalsIgnoreCase(key)) {
				return true;
			}
		}
		return false;
	}
	
	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String geteName() {
		return eName;
	}

	public void seteName(String eName) {
		this.eName = eName;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

}
