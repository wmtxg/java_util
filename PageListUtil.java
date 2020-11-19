package com.cetc.cloudadapter.core.util;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.cetc.cloudadapter.framework.core.model.PageResult;

/**
 * List集合分页工具类
 * 
 * @ClassName: PageListUtil
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author 吴明涛
 * @Phone 17346519691
 * @Email wmtxg@126.com
 * @Date 2020年11月19日 下午1:13:21
 *
 * @param <T>
 */
public class PageListUtil<T> {

	/**
	 * 对List集合按指定字段排序
	 * 
	 * @param targetList 目标排序List
	 * @param sortField  排序字段的get方法名，如：按name排序则传getName
	 * @param sortMode   排序方式 desc-倒序 其他-正序
	 * @Author 吴明涛
	 * @Phone 17346519691
	 * @Email wmtxg@126.com
	 * @Date 2020年11月19日 上午11:11:42 Copyright (c) All Rights Reserved, 2020.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static <T> void sort(List<T> list, final String sortField, final String sortMode) {
		if (list == null || list.isEmpty())
			return;
		Collections.sort(list, new Comparator() {

			public int compare(Object obj1, Object obj2) {
				int retVal = 0;
				try {
					Method method1 = ((T) obj1).getClass().getMethod(sortField, null);
					Method method2 = ((T) obj2).getClass().getMethod(sortField, null);
					if (sortMode != null && "desc".equalsIgnoreCase(sortMode)) {
						retVal = method2.invoke(((T) obj2), null).toString()
								.compareTo(method1.invoke(((T) obj1), null).toString()); // 倒序
					} else {
						retVal = method1.invoke(((T) obj1), null).toString()
								.compareTo(method2.invoke(((T) obj2), null).toString()); // 正序
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				return retVal;
			}

		});
	}

	/**
	 * 手动分页
	 * 
	 * @Method pageBySubList
	 * @param list     待分页数据集合
	 * @param pageNum  当前页
	 * @param pageSize 页面大小
	 * @return 分页数据
	 * @Author 吴明涛
	 * @Phone 17346519691
	 * @Email wmtxg@126.com
	 * @Date 2020年11月19日 上午11:10:58 Copyright (c) All Rights Reserved, 2020.
	 */
	public static <T> PageResult<T> page(List<T> list, Integer pageNum, Integer pageSize) {

		PageResult<T> pageResult = new PageResult<>();
		if (list == null || list.isEmpty()) {
			pageResult.setPageNo(pageNum);
			pageResult.setPageSize(pageSize);
			pageResult.setTotalCount(0);
			pageResult.setList(new ArrayList<T>());
			return pageResult;
		}
		int totalCount = list.size();
		int pageCount = 0;
		List<T> subList;

		int m = totalCount % pageSize;
		if (m > 0) {
			pageCount = totalCount / pageSize + 1;
		} else {
			pageCount = totalCount / pageSize;
		}
		if (m == 0) {
			subList = list.subList((pageNum - 1) * pageSize, pageSize * (pageNum));
		} else {
			if (pageNum == pageCount) {
				subList = list.subList((pageNum - 1) * pageSize, totalCount);
			} else {
				subList = list.subList((pageNum - 1) * pageSize, pageSize * (pageNum));
			}
		}
		pageResult.setPageNo(pageNum);
		pageResult.setPageSize(pageSize);
		pageResult.setTotalCount(totalCount);
		pageResult.setList(subList);
		return pageResult;
	}

}