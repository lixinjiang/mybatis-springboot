package cn.lxj.mybatis.bean;

/**
 * PageParam
 * description
 * create class by lxj 2019/5/22
 **/
public class PageParam {
	private int beginLine;
	private Integer pageSize = 3;
	private Integer currentPage = 0;

	public int getBeginLine() {
		return pageSize * currentPage;
	}

	public void setBeginLine(int beginLine) {
		this.beginLine = beginLine;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
}
