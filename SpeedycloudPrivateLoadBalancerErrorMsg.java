package com.cetc.cloudadapter.slb.speedycloud.enums;

/**
 * 告级别枚举类
 * 
 * @ClassName: AlarmLevelType
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author 吴明涛
 * @Phone 17346519691
 * @Email wmtxg@126.com
 * @Date 2020年11月12日 下午8:39:14
 *
 */
public enum SpeedycloudPrivateLoadBalancerErrorMsg {

	CANNOT_DELETE(0, "Cannot destroy loadbalancer", "无法删除改负载均衡！"), 
	NOT_EXIST(1, "Loadbalancer not exists", "负载均衡不存在！"), 
	CANNOT_RELOAD(1, "Cannot reload loadbalancer", "无法重启负载均衡！"), 
	UNKNOWN(3, "unknown", "正常");

	private Integer value;
	private String eName;
	private String cName;

	SpeedycloudPrivateLoadBalancerErrorMsg(Integer value, String eName, String cName) {
		this.value = value;
		this.eName = eName;
		this.cName = cName;
	}

	/**
	 * 根据类型值获取文件存储类型
	 * 
	 * @param value 类型值
	 * @return 文件存储类型
	 */
	public static SpeedycloudPrivateLoadBalancerErrorMsg getByValue(Integer value) {
		for (SpeedycloudPrivateLoadBalancerErrorMsg pType : SpeedycloudPrivateLoadBalancerErrorMsg.values()) {
			if (pType.getValue().equals(value)) {
				return pType;
			}
		}
		return SpeedycloudPrivateLoadBalancerErrorMsg.UNKNOWN;
	}

	/**
	 * 根据文件存储类型英文名称获取文件存储类型
	 * 
	 * @param ename 英文名称
	 * @return 文件存储类型
	 */
	public static SpeedycloudPrivateLoadBalancerErrorMsg getByEname(String ename) {
		for (SpeedycloudPrivateLoadBalancerErrorMsg pType : SpeedycloudPrivateLoadBalancerErrorMsg.values()) {
			if (pType.geteName().equalsIgnoreCase(ename)) {
				return pType;
			}
		}
		return SpeedycloudPrivateLoadBalancerErrorMsg.UNKNOWN;
	}

	/**
	 * 判断用户输入的文件源类型值是否在列表中
	 * 
	 * @param value 文件源类型值
	 * @return 校验结果
	 * @Author 吴明涛
	 * @Phone 17346519691
	 * @Email wmtxg@126.com
	 * @Data 2020年5月15日 下午7:42:56 Copyright (c) All Rights Reserved, 2020.
	 */
	public static boolean contains(Integer value) {
		for (SpeedycloudPrivateLoadBalancerErrorMsg c : SpeedycloudPrivateLoadBalancerErrorMsg.values()) {
			if (c.getValue().equals(value)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 判断用户输入的文件源是否在列表中
	 * 
	 * @param name 文件源名称
	 * @return 校验结果
	 * @Author 吴明涛
	 * @Phone 17346519691
	 * @Email wmtxg@126.com
	 * @Data 2020年5月15日 下午7:42:56 Copyright (c) All Rights Reserved, 2020.
	 */
	public static boolean contains(String name) {
		for (SpeedycloudPrivateLoadBalancerErrorMsg c : SpeedycloudPrivateLoadBalancerErrorMsg.values()) {
			if (c.geteName().equalsIgnoreCase(name)) {
				return true;
			}
		}
		return false;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
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
