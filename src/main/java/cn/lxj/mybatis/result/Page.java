package cn.lxj.mybatis.result;

import cn.lxj.mybatis.bean.PageParam;
import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

/**
 * Page
 * description 返回结果集
 * create class by lxj 2019/5/22
 **/
@Data
@ToString
public class Page<E> {
	private static final long serialVersionUID = -2020350783443768083L;
	private int currentPage = 1;// 当前页
	private long totalPage;     // 总页数
	private long totalNumber;   // 总记录数
	private List<E> list;       // 数据集
	public static Page NULL = new Page(0, 0, 15, new ArrayList());

	/**
	 * @param beginLine   当前页数
	 * @param totalNumber 总记录数
	 * @param pageSize    页大小
	 * @param list        页数据
	 */
	public Page(int beginLine, long totalNumber, int pageSize, List<E> list) {
		super();
		this.currentPage = beginLine / pageSize + 1;
		this.totalNumber = totalNumber;
		this.list = list;
		this.totalPage = totalNumber % pageSize == 0 ? totalNumber
				/ pageSize : totalNumber / pageSize + 1;
	}

	public Page(PageParam pageParam, long totalNumber, List<E> list) {
		super();
		this.currentPage = pageParam.getCurrentPage();
		this.totalNumber = totalNumber;
		this.list = list;
		this.totalPage = totalNumber % pageParam.getPageSize() == 0 ? totalNumber
				/ pageParam.getPageSize() : totalNumber / pageParam.getPageSize() + 1;
	}
}