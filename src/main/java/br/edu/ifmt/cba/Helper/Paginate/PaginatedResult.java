package br.edu.ifmt.cba.Helper.Paginate;

import java.util.List;

public class PaginatedResult<T> {
	private List<T>	items;
	private int totalItems;
	private int totalPages;
	private int pageNumber;
	private int pageSize;
	
	public PaginatedResult() {}
	
	public PaginatedResult(List<T> items, int totalItems, int totalPages, int pageNumber, int pageSize) {
		this.items = items;
		this.totalItems = totalItems;
		this.totalPages = totalPages;
		this.pageNumber = pageNumber;
		this.pageSize = pageSize;
	}
	
    public boolean hasPrevious() { 
    	return this.pageNumber > 1;
    }
    
    public boolean hasNext() {
    	return this.pageNumber < this.totalPages;
    }
	
	public List<T> getItems() {return items;}
	public void setItems(List<T> items) {this.items = items;}
	public int getTotalItems() {return totalItems;}
	public void setTotalItems(int totalItems) {this.totalItems = totalItems;}
	public int getTotalPages() {return totalPages;}
	public void setTotalPages(int totalPages) {this.totalPages = totalPages;}
	public int getPageNumber() {return pageNumber;}
	public void setPageNumber(int pageNumber) {this.pageNumber = pageNumber;}
	public int getPageSize() {return pageSize;}
	public void setPageSize(int pageSize) {this.pageSize = pageSize;}
}
