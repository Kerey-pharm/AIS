package kz.kerey.business.types;

public class PageParam {

	private Boolean paged;
	private Integer pageNum;
	private Integer perPage;
	
	public Boolean getPaged() {
		return paged;
	}
	public void setPaged(Boolean paged) {
		this.paged = paged;
	}
	public Integer getPageNum() {
		return pageNum;
	}
	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}
	public Integer getPerPage() {
		return perPage;
	}
	public void setPerPage(Integer perPage) {
		this.perPage = perPage;
	}
	
}
